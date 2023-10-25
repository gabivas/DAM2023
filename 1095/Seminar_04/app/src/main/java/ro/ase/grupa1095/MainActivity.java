package ro.ase.grupa1095;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String FILM_ADAUGAT = "filmAdaugat";
    private FloatingActionButton floatingActionButton;
ListView lvFilme;
List<Film> listaFilme = new ArrayList<>();

ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        floatingActionButton = findViewById(R.id.floatingActionButton);
        lvFilme = findViewById(R.id.lvListaFilme);

        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result -> {
            if(result.getResultCode() == RESULT_OK){
                Intent intent = result.getData();
                Film filmAdaugat = (Film) intent.getSerializableExtra(FILM_ADAUGAT);
                if(filmAdaugat != null){
                    listaFilme.add(filmAdaugat);
                    ArrayAdapter<Film> adapter = new ArrayAdapter<>(getApplicationContext(),
                            android.R.layout.simple_list_item_1, listaFilme);
                    lvFilme.setAdapter(adapter);
                }
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AdaugareFilmActivity.class);
                //startActivity(intent);
                launcher.launch(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.meniu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.idOptiune1:
//        }
        if(item.getItemId() == R.id.idOptiune1){
            Toast.makeText(this, R.string.optiune1, Toast.LENGTH_LONG).show();
        }
        return true;
    }
}