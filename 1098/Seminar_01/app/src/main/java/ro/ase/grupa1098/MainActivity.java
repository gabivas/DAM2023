package ro.ase.grupa1098;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e("tagOnCreate", "Am ajuns in metoda onCreate()");

        Toast.makeText(getApplicationContext(), "Am ajuns in metoda onCreate()",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("tagOnStart", "Am ajuns in metoda onStart()");
        Toast.makeText(getApplicationContext(), "Am ajuns in metoda onStart()",Toast.LENGTH_LONG).show();

    }
}