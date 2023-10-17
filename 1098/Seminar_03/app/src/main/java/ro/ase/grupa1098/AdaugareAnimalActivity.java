package ro.ase.grupa1098;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AdaugareAnimalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adaugare_animal);
        final EditText etSpecie = findViewById(R.id.etSpecie);
        final EditText etGreutate = findViewById(R.id.etGreutate);
        final EditText etData = findViewById(R.id.etData);
        Spinner spinner = findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.clasaAnimal, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Button btnSalvare = findViewById(R.id.button);
        btnSalvare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animal animal;
                if(etSpecie.getText().toString().isEmpty()){
                    etSpecie.setError("Ai uitat sa completezi specia");
                }
            }
        });

    }
}