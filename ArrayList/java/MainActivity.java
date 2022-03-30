package com.example.arraylist2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    //variables globales
    ListView listView;
    String titulos[]={"Titulo 1","Titulo 2","Titulo 3","Titulo 4",
                      "Titulo 5","Titulo 6","Titulo 7","Titulo 8" };
    String descripciones[]={"texto texto texto 1","texto texto texto 2",
                            "texto texto texto 3","texto texto texto 4",
                            "texto texto texto 5","texto texto texto 6",
                            "texto texto texto 7","texto texto texto 8"};
    int avatar[]={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,
                  R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //instanciar vista
        listView = findViewById(R.id.lista);
        //instanciar elementos que contiene la lista mediante SetAdapter
        listView.setAdapter(new Datos(this,titulos,descripciones,avatar));

    }
}