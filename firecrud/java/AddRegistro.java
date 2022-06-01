package com.example.firecrud;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddRegistro extends AppCompatActivity {
    Button btnAdd;
    EditText nombre, universidad, materia;
    private FirebaseFirestore mfirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_registro);

        this.setTitle("Agregar registro");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mfirestore = FirebaseFirestore.getInstance();

        nombre = findViewById(R.id.txtNombre);
        universidad = findViewById(R.id.txtUniversidad);
        materia = findViewById(R.id.txtMateria);
        btnAdd = findViewById(R.id.btnAgregar);

        btnAdd.setOnClickListener(view -> {
            String nom = nombre.getText().toString().trim();
            String uni = universidad.getText().toString().trim();
            String mat = materia.getText().toString().trim();
            if (nom.isEmpty() && uni.isEmpty() && mat.isEmpty()) {
                Toast.makeText(getApplicationContext(), "ingrese datos", Toast.LENGTH_SHORT).show();
            } else {
                postAdd(nom, uni, mat); //create method postAdd in activity
            }
        });
    }

    private void postAdd(String nom, String uni, String mat) {
        Map<String, Object> map= new HashMap<>();
        map.put("nombre",nom);
        map.put("universidad",uni);
        map.put("materia",mat);
        mfirestore.collection("usuario").add(map).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(getApplicationContext(),"creado",Toast.LENGTH_SHORT).show();
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(),"Error al crear",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }
}