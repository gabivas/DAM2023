package ro.ase.grupa1095;

import static ro.ase.grupa1095.MainActivity.FILM_ADAUGAT;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
                    return;
                }
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date dataLansare = null;
                try {
                    String denumire = etDenumire.getText().toString();
                    int rating = Integer.parseInt(etRating.getText().toString());
                    dataLansare = sdf.parse(etDataLansare.getText().toString());
                    Gen gen = Gen.valueOf(spinner.getSelectedItem().toString());
                    RadioGroup rg = findViewById(R.id.rgStudio);
                    RadioButton rbChecked = findViewById(rg.getCheckedRadioButtonId());
                    Studio studio = Studio.valueOf(rbChecked.getText().toString());

                    Film film = new Film(denumire, rating, dataLansare, gen, studio);
                    Intent intent = getIntent();
                    intent.putExtra(FILM_ADAUGAT, film);

                    setResult(RESULT_OK, intent);

                    finish();

                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}