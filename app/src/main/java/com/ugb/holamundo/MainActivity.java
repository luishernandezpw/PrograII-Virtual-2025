package com.ugb.holamundo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Space;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends Activity {
    TextView tempVal;
    Spinner spn;
    String[][] municipios = new String[][]{
            new String[]{"La Union", "Santa Rosa de Lima", "Anamoros", "Bolivar"}, //La union
            new String[]{"San Francisco Gotera", "Arambala", "Cacaopera", "Chilanga", "Corinto"}, //Morazan
            new String[]{"San Miguel", "Carolina", "Chinameca", "El Transito"}, //San Miguel
            new String[]{"Usulutan", "Santa Maria", "Berlin", "Santiago de Maria", "Santa Elena"}, //Usulutan
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            spn = findViewById(R.id.cboDepto);
            spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    ArrayAdapter<String> aaMun = new ArrayAdapter<>(MainActivity.this,
                            android.R.layout.simple_spinner_item, municipios[position]);
                    spn = findViewById(R.id.cboMun);
                    spn.setAdapter(aaMun);
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }catch (Exception e){
            Toast.makeText(MainActivity.this, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}