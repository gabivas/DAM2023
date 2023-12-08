package ro.ase.grupa1095;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scriereInFisierTxt("fisier.txt", "Hello world din fisier");

        TextView tv = findViewById(R.id.tv);
        tv.setText(citireDinFisierTxt("fisier.txt"));

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);

        //inseram configurari
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("token", "Token1234");
        //editor.remove("token");
        editor.apply();

        //citim configurari
        String token = sharedPreferences
                .getString("token", "Default");
        Toast.makeText(this, token, Toast.LENGTH_SHORT).show();
    }

    private String citireDinFisierTxt(String numeFisier) {
        String text = "";
        InputStream is = null;
        try {
            is = getResources().openRawResource(R.raw.f);
            //is = getApplicationContext().openFileInput(numeFisier);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);
            String linie = "";
            StringBuilder sb = new StringBuilder();
            while((linie = reader.readLine())!=null){
                sb.append("\n").append(linie);
            }
            text = sb.toString();
            reader.close();
            isr.close();
            is.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return text;
    }

    private void scriereInFisierTxt(String numeFisier, String textDeInserat) {
        try {
            OutputStreamWriter writer = new OutputStreamWriter(getApplicationContext()
                    .openFileOutput(numeFisier, MODE_PRIVATE));
            writer.write(textDeInserat);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}