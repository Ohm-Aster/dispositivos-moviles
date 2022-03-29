package com.example.imgrandom;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {
    //variables globales
    ImageView imagen;
    TextView letrero;
    Button btn;
    int val=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //asociando atributos, id, layout
        imagen = (ImageView) findViewById(R.id.imageView);
        letrero = (TextView) findViewById(R.id.texto);
        btn = (Button) findViewById(R.id.button);
    }
    //crear objeto i el cual llevara los datos de imagen y texto.
    imagen i1 = new imagen(R.drawable.uno, "img 1");
    imagen i2 = new imagen(R.drawable.dos, "img 2");
    imagen i3 = new imagen(R.drawable.tres, "img 3");
    imagen i4 = new imagen(R.drawable.cuatro, "img 4");
    imagen i5 = new imagen(R.drawable.cinco, "img 5");
    imagen i6 = new imagen(R.drawable.seis, "img 6");
    imagen i7 = new imagen(R.drawable.siete, "img 7");
    //llenar array con los objetos i, de esta manera cada elemento del array tendra
    imagen[] imgItems = new imagen[]{
            i1, i2, i3, i4, i5, i6, i7
    };
    //mostrar valores de Imagen
    public void mostrarImg(View view) {
        if(val<6) {
            imagen.setImageResource(imgItems[val].getImagen());
            letrero.setText(imgItems[val].getTexto());
            val++;
        }else{
            val=0;
        }
    }

}
