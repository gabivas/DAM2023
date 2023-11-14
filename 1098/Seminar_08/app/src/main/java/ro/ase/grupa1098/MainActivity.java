package ro.ase.grupa1098;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Produs> listaProduse = new ArrayList<>();
    private ListView lvProduse;
    //ip in loc de domainName
    private static final String adresaJson = "https://138.68.47.227/b/U938";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializareComponente();
        listaProduse.add(new Produs(1, "Corn", 4));
        listaProduse.add(new Produs(2, "Apa", 2));
        listaProduse.add(new Produs(3, "Paine", 6));
        incarcareProduseHttps();
    }

    private void incarcareProduseHttps() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                HttpsManager httpsManager = new HttpsManager(adresaJson);
                String rezultat = httpsManager.process();
                new Handler(getMainLooper()).post(() ->
                        getProduseFromJson(rezultat));
            }
        };
        thread.start();
    }

    private void getProduseFromJson(String rezultat) {
        listaProduse.addAll(ProdusParser.fromJson(rezultat));
        ArrayAdapter<Produs> adapter = (ArrayAdapter<Produs>) lvProduse.getAdapter();
        adapter.notifyDataSetChanged();
    }

    private void initializareComponente() {
        lvProduse = findViewById(R.id.lvProduse);
        ArrayAdapter<Produs> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,
                listaProduse);
        lvProduse.setAdapter(adapter);
    }
}