package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView txtview = (TextView) findViewById(R.id.Result);

        double imc = Double.parseDouble(getIntent().getStringExtra("imc"));


        if (imc < 18.50) {
            //layout.setBackgroundColor(Color.YELLOW);
            txtview.setText("abajo del peso");
        }
        else if (imc < 25.00) {
           // layout.setBackgroundColor(Color.GREEN);
            txtview.setText("normal");
        }
        else if (imc < 30.0) {
          //  layout.setBackgroundColor(Color.YELLOW);
            txtview.setText("sobre peso");
        }
        else {
          //  layout.setBackgroundColor(Color.RED);
            txtview.setText("obesidad");
        }
    }
}