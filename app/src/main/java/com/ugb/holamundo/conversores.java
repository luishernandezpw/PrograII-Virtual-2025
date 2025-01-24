package com.ugb.holamundo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class conversores extends Activity {
    TextView tempVal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversores);

        String num1 = getIntent().getStringExtra("num1");
        tempVal = findViewById(R.id.lblconversores);
        tempVal.setText("Conversores Num1: "+ num1);
    }
}