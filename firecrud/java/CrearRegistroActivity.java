package com.example.firecrud;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class CrearRegistroActivity extends AppCompatActivity {
    Button btn_add;
    EditText nombre,apaterno,amaterno;
    private FirebaseFirestore mfirestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_registro);

        this.setTitle("Crear Registro");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mfirestore = FirebaseFirestore.getInstance();

        nombre = findViewById(R.id.txtNombre);
        apaterno = findViewById(R.id.txtApaterno);
        amaterno = findViewById(R.id.txtAmaterno);
        btn_add = findViewById(R.id.btn_guardar);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = nombre.getText().toString().trim();
                String ap = apaterno.getText().toString().trim();
                String am = amaterno.getText().toString().trim();
                if(n.isEmpty() && ap.isEmpty() && am.isEmpty()){
                    Toast.makeText(getApplicationContext(),"ingresar datos",Toast.LENGTH_SHORT).show();
                }else{
                    postReg(n,ap,am);
                }
            }
        });
    }

    private void postReg(String n, String ap, String am) {
        Map<String, Object> map = new HashMap<>();
        map.put("Nombre",n);
        map.put("Apaterno",ap);
        map.put("Amaterno",am);
        mfirestore.collection("usuario").add(map).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(getApplicationContext(),"registro correcto",Toast.LENGTH_SHORT).show();
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(),"error al ingresar",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }
}