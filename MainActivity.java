package com.example.calcimc;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calcularIMC(View view) {
        EditText alturaTxt = (EditText) findViewById(R.id.Altura);
        EditText pesoTxt = (EditText) findViewById(R.id.Peso);

        double altura = Double.parseDouble(alturaTxt.getText().toString());
        double peso = Double.parseDouble(pesoTxt.getText().toString());

        double imc = peso / (altura * altura);

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("imc", String.valueOf(imc));
        startActivity(intent);
    }
}