package com.example.calcareas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class cuadrado extends AppCompatActivity {
    EditText l;
    Button calc;
    TextView Area,Perimetro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuadrado);
        this.setTitle("Cuadrado");

        l = findViewById(R.id.lado);
        calc = findViewById(R.id.calcular);
        Area = findViewById(R.id.Rarea);
        Perimetro = findViewById(R.id.Rperimetro);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double aux = Double.valueOf(l.getText().toString());
                double a= aux*aux;
                double p=0;
                for(int i=0;i<4;i++){
                    p= p+aux;
                }
                Area.setText(""+a);
                Perimetro.setText(""+p);
            }
        });
    }
}