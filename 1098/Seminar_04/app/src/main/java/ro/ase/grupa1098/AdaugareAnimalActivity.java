package ro.ase.grupa1098;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AdaugareAnimalActivity extends AppCompatActivity {

    private static final String DD_MM_YYYY = "dd/MM/yyyy";
    public static final String ANIMAL_KEY = "animal";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adaugare_animal);
        final EditText etSpecie = findViewById(R.id.etSpecie);
        final EditText etGreutate = findViewById(R.id.etGreutate);
        final EditText etData = findViewById(R.id.etData);
        Spinner spinner = findViewById(R.id.spinner);

        RadioButton checkedButton = findViewById(R.id.rbSud);
        checkedButton.setChecked(true);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.clasaAnimal, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Button btnSalvare = findViewById(R.id.button);
        btnSalvare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etSpecie.getText().toString().isEmpty()){
                    etSpecie.setError(getString(R.string.ERROR_MESSAGE_SPECIA));
                    return;
                }
                if(etData.getText().toString().isEmpty()){
                    etData.setError(getString(R.string.ERROR_MESSAGE_DATA));
                    return;
                }
                if(etGreutate.getText().toString().isEmpty()){
                    etGreutate.setError(getString(R.string.ERROR_MESSAGE_GREUTATE));
                    return;
                }
                SimpleDateFormat sdf = new SimpleDateFormat(DD_MM_YYYY);

                String specia = etSpecie.getText().toString();
                int greutate = Integer.parseInt(etGreutate.getText().toString());

                try {
                    Date dataNastere = sdf.parse(etData.getText().toString());

                    ClasaAnimal clasaAnimal = ClasaAnimal.valueOf(spinner.getSelectedItem().toString());
                    RadioGroup rgZona = findViewById(R.id.rgZona);

                    RadioButton radioButton = findViewById(rgZona.getCheckedRadioButtonId());
                    Zona zona = Zona.valueOf(radioButton.getText().toString());

                    Animal animal = new Animal(specia, greutate, dataNastere, clasaAnimal, zona);
                    Intent intent = getIntent();
                    //Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra(ANIMAL_KEY, animal);
                    setResult(RESULT_OK, intent);

                    finish();
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}