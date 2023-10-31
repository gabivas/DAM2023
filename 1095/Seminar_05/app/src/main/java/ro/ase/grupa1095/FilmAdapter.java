package ro.ase.grupa1095;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.List;

public class FilmAdapter extends ArrayAdapter<Film> {
    private Context context;
    private int resursa;
    private List<Film> listaFilme;
    private LayoutInflater inflater;

    public FilmAdapter(@NonNull Context context, int resource,
                       List<Film> listaFilme, LayoutInflater inflater) {
        super(context, resource, listaFilme);
        this.context= context;
        this.listaFilme= listaFilme;
        this.inflater= inflater;
        this.resursa= resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = inflater.inflate(resursa, parent,false );
        Film film = listaFilme.get(position);
        if(film!=null){
            TextView tvDenumire = view.findViewById(R.id.tvDenumire);
            TextView tvRating = view.findViewById(R.id.tvRating);
            TextView tvDataLansare = view.findViewById(R.id.tvDtaLansare);
            TextView tvGen = view.findViewById(R.id.tvGen);
            TextView tvStudio = view.findViewById(R.id.tvStudio);

            tvDenumire.setText(film.getDenumire());
            tvRating.setText(String.valueOf(film.getRating()));
            if(film.getRating()>7)
            tvRating.setTextColor(Color.GREEN);
            else
                tvRating.setTextColor(Color.RED);
            tvDataLansare.setText(new SimpleDateFormat("dd/MM/yyyy")
                    .format(film.getDataLansare()));
            tvGen.setText(String.valueOf(film.getGen()));
            tvStudio.setText(String.valueOf(film.getStudio()));
        }
        return view;
    }
}
