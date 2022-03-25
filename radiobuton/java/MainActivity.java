package com.example.radiobutton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //variables globales
    EditText valor1, valor2;
    RadioButton rbsuma,rbresta,rbmult,rbdiv;
    TextView txtresultado;
    ConstraintLayout cl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //referenciar variables con elementos de interfaz
        valor1 = findViewById(R.id.valor1);
        valor2 = findViewById(R.id.valor2);
        rbsuma = findViewById(R.id.rbsuma);
        rbresta = findViewById(R.id.rbresta);
        rbmult = findViewById(R.id.rbmultiplicacion);
        rbdiv = findViewById(R.id.rbdivision);
        txtresultado = findViewById(R.id.txtresultado);
        cl = findViewById(R.id.ConstrainLayout);

    }

    public void Calcular(View view){
        //convertimos la cadena proveniente  de la caja de texto
        // en un valor utilizable en nuestras operaciones
        int valor1_int = Integer.parseInt(valor1.getText().toString());
        int valor2_int = Integer.parseInt(valor2.getText().toString());

        if(rbsuma.isChecked()){
            int suma = valor1_int + valor2_int;
            String resultado = String.valueOf(suma);
            cl.setBackgroundColor(Color.LTGRAY);
            txtresultado.setText(resultado);
        } else if(rbresta.isChecked()){
            int resta = valor1_int - valor2_int;
            String resultado = String.valueOf(resta);
            cl.setBackgroundResource(R.drawable.back);
            txtresultado.setText(resultado);
        } else if(rbmult.isChecked()){
            int multiplicacion = valor1_int * valor2_int;
            String resultado = String.valueOf(multiplicacion);
            cl.setBackgroundColor(Color.GREEN);
            txtresultado.setText(resultado);
        } else if(rbdiv.isChecked()){
            if(valor2_int != 0){
                double division =  Double.valueOf(valor1_int) / Double.valueOf(valor2_int);
                String resultado = String.valueOf(division);
                cl.setBackgroundResource(R.drawable.fondo2);
                txtresultado.setText(resultado);
            } else {
                Toast.makeText(this, "El segundo valor debe ser diferente de cero", Toast.LENGTH_LONG).show();
            }
        }
    }
}
