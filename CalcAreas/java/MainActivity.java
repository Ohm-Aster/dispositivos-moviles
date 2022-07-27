package com.example.calcareas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton cuadrado, pentagono, triangulo,trapecio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cuadrado = findViewById(R.id.cuadrado);
        pentagono = findViewById(R.id.pentagono);
        triangulo = findViewById(R.id.trinangulo);
        trapecio = findViewById(R.id.trapecio);

        cuadrado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, cuadrado.class);
                startActivity(intent);
            }
        });
        pentagono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, pentagono.class);
                startActivity(intent);
            }
        });
        triangulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, triangulo.class);
                startActivity(intent);
            }
        });
        trapecio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, trapecio.class);
                startActivity(intent);
            }
        });
    }
}