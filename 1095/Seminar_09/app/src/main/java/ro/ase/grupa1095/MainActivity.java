package ro.ase.grupa1095;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HorizontalScrollView horizontalScrollView =
                new HorizontalScrollView(this);
        LinearLayout linearLayout =
                new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        ListView listView = new ListView(this);
        TextView textView = new TextView(this);
        textView.setText("Lista masini din DB:");

        Masina masina = new Masina("Volkswagen",
                "Golf6", 70);

        MasinaDB masinaDB = MasinaDB.getInstance(getApplicationContext());
        masinaDB.getMasinaDao().insertMasina(masina);

        List<Masina> listaMasini = masinaDB.getMasinaDao()
                .selectMasini(50);
        ArrayAdapter<Masina> adapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1, listaMasini);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(
                (adapterView, view, position, l) -> {
            Masina masina1 = listaMasini.get(position);
            listaMasini.remove(masina1);
            masinaDB.getMasinaDao().deleteMasina(masina1);
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "A fost stearsa din DB: "
                            +masina1.toString(), Toast.LENGTH_SHORT).show();
        });

        linearLayout.addView(textView);
        linearLayout.addView(listView);
        horizontalScrollView.addView(linearLayout);

        setContentView(horizontalScrollView);
    }
}