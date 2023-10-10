package ro.ase.grupa1098;

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
    private static final int OPTIUNE_1 = 1;
    private static final int OPTIUNE_2 = 2;
    private EditText etEuro, etUsd, etGbp;

    public enum TipMoneda{
        EURO, USD, GBP
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etEuro = findViewById(R.id.etEUR);
        etUsd = findViewById(R.id.etUSD);
        etGbp = findViewById(R.id.etGBP);

        Spinner spinner = findViewById(R.id.spinner);
        String[] values = new String[TipMoneda.values().length];
        int contor=0;
        for(TipMoneda moneda : TipMoneda.values()){
            values[contor++] = moneda.toString();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,values);
        spinner.setAdapter(adapter);

        Button btnAfiseaza = findViewById(R.id.btnAfiseaza);
        //btnAfiseaza.setOnClickListener(this);
        btnAfiseaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etEuro.setText("4.9752");
                etUsd.setText("4.7387");
                etGbp.setText("5.7500");
            }
        });
    }

    @Override
    public void onClick(View view) {
        etEuro.setText("4.9752");
        etUsd.setText("4.7387");
        etGbp.setText("5.7500");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,OPTIUNE_1,0, R.string.optiune_1);
        menu.add(0,OPTIUNE_2,1, R.string.optiune_2);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case OPTIUNE_1:
            {
                Toast.makeText(getApplicationContext(), "Am apasat pe optiunea 1", Toast.LENGTH_LONG).show();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}