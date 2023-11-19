package ro.ase.grupa1098;

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

        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(this);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        Autobuz autobuz = new Autobuz("Unirii-Romana", "Mercedes", 9);
        AutobuzDB autobuzDB = AutobuzDB.getInstance(getApplicationContext());
        autobuzDB.getAutobuzDao().insertAutobuz(autobuz);

        List<Autobuz> listaAutobuze =  autobuzDB.getAutobuzDao().selectAll(8);
        ArrayAdapter<Autobuz> adapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1, listaAutobuze);
        ListView listView = new ListView(this);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            Autobuz autobuz1 = listaAutobuze.get(i);
            ArrayAdapter adapter1 = (ArrayAdapter) listView.getAdapter();
            listaAutobuze.remove(autobuz1);

            autobuzDB.getAutobuzDao().deleteAutobuz(autobuz1);

            adapter1.notifyDataSetChanged();
            Toast.makeText(this, "S-a sters din db: "+autobuz1.toString(), Toast.LENGTH_SHORT).show();

        });

        TextView textView = new TextView(this);
        textView.setText("Lista autobuze din DB:");
        linearLayout.addView(textView);
        linearLayout.addView(listView);
        horizontalScrollView.addView(linearLayout);

        setContentView(horizontalScrollView);
    }
}