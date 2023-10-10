package ro.ase.grupa1095;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public enum ZILE{
        LUNI, MARTI, MIERCURI, JOI, VINERI
    }
    private static final int OPTIUNE_1 = 1;
    private static final int OPTIUNE_2 = 2;
    EditText etEur, etUsd, etGbp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etEur = findViewById(R.id.etEur);
        etUsd = findViewById(R.id.etUsd);
        etGbp = findViewById(R.id.etGbp);

        Spinner spinner = findViewById(R.id.spinner);

        String[] values = new String[ZILE.values().length];
        int contor = 0;
        for(ZILE zi : ZILE.values()){
            values[contor++] = zi.toString();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, values);
        spinner.setAdapter(adapter);

        Button btnAfisare = findViewById(R.id.btnAfisare);
        //btnAfisare.setOnClickListener(this);
        btnAfisare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etEur.setText("4.9752");
                etUsd.setText("4.7387");
                etGbp.setText("5.7500");
            }
        });
    }

    @Override
    public void onClick(View view) {
        etEur.setText("4.9752");
        etUsd.setText("4.7387");
        etGbp.setText("5.7500");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, OPTIUNE_1, 1, R.string.optiune_1);
        menu.add(0, OPTIUNE_2, 2, R.string.optiune_2);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case OPTIUNE_1:
                Toast.makeText(getApplicationContext(), "Am apasat pe Optiunea 1", Toast.LENGTH_LONG).show();
        }
        return true;
    }
}