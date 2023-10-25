package ro.ase.grupa1098;

import static ro.ase.grupa1098.AdaugareAnimalActivity.ANIMAL_KEY;
import static ro.ase.grupa1098.R.id.idOptiune1;

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
    private FloatingActionButton button;
    ListView lvListaAnimale;
    List<Animal> listaAnimale = new ArrayList<>();

    private ActivityResultLauncher<Intent> launcher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.floatingActionButton);

        lvListaAnimale = findViewById(R.id.lvListaAnimale);

        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if(result.getResultCode() ==RESULT_OK){
                Intent intentAnimal = result.getData();
                Animal animal = (Animal) intentAnimal.getSerializableExtra(ANIMAL_KEY);
                if(animal!=null){
                    listaAnimale.add(animal);
                    ArrayAdapter<Animal> arrayAdapter = new ArrayAdapter<>(getApplicationContext(),
                            android.R.layout.simple_list_item_1, listaAnimale);
                    lvListaAnimale.setAdapter(arrayAdapter);
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AdaugareAnimalActivity.class);
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
        //final int opt1 = R.id.idOptiune1;
        if(R.id.idOptiune1==item.getItemId()){
            Toast.makeText(this, R.string.OPT1, Toast.LENGTH_LONG).show();
        }
//        switch (item.getItemId()){
//            case idOptiune1:
//        }
        return true;
    }
}