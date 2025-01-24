package com.ugb.holamundo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends Activity {
    Button btn;
    TextView tempVal;
    RadioGroup rgb;
    RadioButton opt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btnCalcular);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    tempVal = findViewById(R.id.txtNum1);
                    Double num1 = Double.parseDouble(tempVal.getText().toString());

                    tempVal = findViewById(R.id.txtNum2);
                    Double num2 = Double.parseDouble(tempVal.getText().toString());
                    double respuesta = 0.0;

                    opt = findViewById(R.id.optSuma);
                    if (opt.isChecked()) {
                        respuesta = num1 + num2;
                    }
                    opt = findViewById(R.id.optResta);
                    if (opt.isChecked()) {
                        respuesta = num1 - num2;
                    }
                    opt = findViewById(R.id.optMultiplicacion);
                    if (opt.isChecked()) {
                        respuesta = num1 * num2;
                    }
                    opt = findViewById(R.id.optDivision);
                    if (opt.isChecked()) {
                        respuesta = num1 / num2;
                    }
                    tempVal = findViewById(R.id.lblRespuesta);
                    tempVal.setText("Respuesta: " + String.format("%.2f", respuesta) );

                }catch (Exception e){
                    tempVal = findViewById(R.id.lblRespuesta);
                    tempVal.setText("error: " + e.getMessage());
                }
            }
        });
        btn = findViewById(R.id.btnConversores);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(MainActivity.this, conversores.class);

                tempVal = findViewById(R.id.txtNum1);
                String num1 = tempVal.getText().toString();

                newIntent.putExtra("num1", num1);
                startActivity(newIntent);
            }
        });
    }
}