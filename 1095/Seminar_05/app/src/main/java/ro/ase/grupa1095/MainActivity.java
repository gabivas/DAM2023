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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private int pozitieFilmEditat;
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

        lvFilme.setOnItemClickListener((adapterView, view, position, l) -> {
            pozitieFilmEditat = position;
            Intent intent = new Intent(getApplicationContext(),
                    AdaugareFilmActivity.class);
            intent.putExtra("editFilm", listaFilme.get(position));
            launcher.launch(intent);
        });

        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result -> {
            if(result.getData().hasExtra(FILM_ADAUGAT)){
                Intent intent = result.getData();
                Film filmAdaugat = (Film) intent.getSerializableExtra(FILM_ADAUGAT);
                if(filmAdaugat != null){
                    listaFilme.add(filmAdaugat);
//                    ArrayAdapter<Film> adapter = new ArrayAdapter<>(getApplicationContext(),
//                            android.R.layout.simple_list_item_1, listaFilme);
                    FilmAdapter filmAdapter = new FilmAdapter(getApplicationContext()
                            ,R.layout.view_filme,listaFilme, getLayoutInflater());
                    lvFilme.setAdapter(filmAdapter);
                }
            }
            else if(result.getData().hasExtra("editFilm")){
                //actualizam lista
                Intent intentFilm = result.getData();
                Film film = (Film) intentFilm.getSerializableExtra("editFilm");
                if (film != null) {
                    //update doar pentru denumire
                    //TEMA pentru celelalte valori
                    listaFilme.get(pozitieFilmEditat).setDenumire(film.getDenumire());
                    FilmAdapter animalAdapter = new FilmAdapter(getApplicationContext(),
                            R.layout.view_filme, listaFilme, getLayoutInflater());
                    lvFilme.setAdapter(animalAdapter);
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