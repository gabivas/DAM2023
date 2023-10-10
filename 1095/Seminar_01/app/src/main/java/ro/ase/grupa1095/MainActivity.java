package ro.ase.grupa1095;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("tagOnCreate", "Am ajuns in starea de onCreate()");

        Toast.makeText(getApplicationContext(), "Am ajuns in starea de onCreate()",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("tagOnDestroy", "Am ajuns in starea de onDestroy()");
    }
}