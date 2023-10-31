package ro.ase.grupa1098;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.List;

public class AnimalAdapter extends ArrayAdapter<Animal> {

    private Context context;
    private int resursa;
    private List<Animal> listaAnimale;
    private LayoutInflater inflater;

    public AnimalAdapter(@NonNull Context context, int resource,
    List<Animal> listaAnimale, LayoutInflater inflater) {
        super(context, resource, listaAnimale);
        this.context = context;
        this.listaAnimale = listaAnimale;
        this.resursa = resource;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = inflater.inflate(resursa, parent,false);
        Animal animal = listaAnimale.get(position);
        if(animal!=null){
            TextView tvSpecie = view.findViewById(R.id.tvSpecie);
            TextView tvGreutate = view.findViewById(R.id.tvGreutate);
            TextView tvDataNastere = view.findViewById(R.id.tvDataNastere);
            TextView tvClasaAnimal = view.findViewById(R.id.tvClasaAnimal);
            TextView tvZona = view.findViewById(R.id.tvZona);

            tvSpecie.setText(animal.getSpecie());
            tvGreutate.setText(String.valueOf(animal.getGreutate()));
            tvDataNastere.setText(new SimpleDateFormat("dd/MM/yyyy")
                    .format(animal.getDataNastere()));
            tvClasaAnimal.setText(String.valueOf(animal.getClasaAnimal()));
            tvZona.setText(String.valueOf(animal.getZona()));
        }

        return view;
    }
}
