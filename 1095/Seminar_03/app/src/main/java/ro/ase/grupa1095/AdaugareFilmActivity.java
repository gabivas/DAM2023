package ro.ase.grupa1095;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AdaugareFilmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adaugare_film);
        final EditText etDenumire = findViewById(R.id.etDenumire);
        final EditText etRating = findViewById(R.id.etRating);
        final EditText etDataLansare = findViewById(R.id.etData);
        Spinner spinner = findViewById(R.id.spinnerGen);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,R.array.genuri, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        Button btnSalveaza = findViewById(R.id.btnSalveaza);
        btnSalveaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etDenumire.getText().toString().isEmpty()){
                    etDenumire.setError("Nu ai introdus denumirea");
                }
            }
        });
    }
}