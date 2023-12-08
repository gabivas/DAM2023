package ro.ase.grupa1098;

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

        scriereInFisierText("fisier.txt", "Hello world from text file!");

        TextView tv = findViewById(R.id.tv);
        tv.setText(citireDinFisierText("fisier.txt"));

        //adaugare configurari
        SharedPreferences sharedPreferences = getSharedPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt("time", 10);
        //editor.remove("time");
        editor.apply();

        //citire configurari din shared pref
        int time = sharedPreferences.getInt("time", 0);
        Toast.makeText(this, String.valueOf(time), Toast.LENGTH_SHORT).show();
    }

    private String citireDinFisierText(String numeFisier) {
        String textCititDinFisier = "";
        try {
            InputStream is = getResources().openRawResource(R.raw.f);
            //InputStream is = getApplicationContext().openFileInput(numeFisier);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String linie = "";
            while ((linie = reader.readLine()) != null) {
                sb.append("\n").append(linie);
            }

            textCititDinFisier = sb.toString();
            reader.close();
            isr.close();
            is.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return textCititDinFisier;
    }

    private void scriereInFisierText(String numeFisier, String text) {
        try {
            OutputStreamWriter writer = new OutputStreamWriter(getApplicationContext()
                    .openFileOutput(numeFisier, MODE_PRIVATE));

            writer.write(text);
            writer.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}