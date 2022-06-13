package com.example.firecrudv2;

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
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class addReg extends AppCompatActivity {
    //variables globales
    Button btn_add;
    EditText nombre,apaterno,amaterno;
    private FirebaseFirestore mfirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reg);
        this.setTitle("Crear Registro");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String id = getIntent().getStringExtra("id_reg");
        mfirestore = FirebaseFirestore.getInstance();

        //instanaciar variables con elementos de la interfaz
        nombre = findViewById(R.id.txtNombre);
        apaterno = findViewById(R.id.txtApaterno);
        amaterno = findViewById(R.id.txtAmaterno);
        btn_add = findViewById(R.id.btn_guardar);

        if(id == null || id == ""){
            btn_add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String n = nombre.getText().toString().trim();
                    String ap = apaterno.getText().toString().trim();
                    String am = amaterno.getText().toString().trim();
                    if(n.isEmpty() && ap.isEmpty() && am.isEmpty()){
                        Toast.makeText(getApplicationContext(),"ingresar datos", Toast.LENGTH_SHORT).show();
                    }else{
                        //metodo para capturar los elementos de las cajas de texto
                        postReg(n,ap,am);
                    }
                }
            });
        }else{
            btn_add.setText("update");
            getUser(id);
            btn_add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String n = nombre.getText().toString().trim();
                    String ap = apaterno.getText().toString().trim();
                    String am = amaterno.getText().toString().trim();
                    if(n.isEmpty() && ap.isEmpty() && am.isEmpty()){
                        Toast.makeText(getApplicationContext(),"ingresar datos", Toast.LENGTH_SHORT).show();
                    }else{
                        //metodo para capturar los elementos de las cajas de texto
                        updateReg(n,ap,am,id);
                    }
                }
            });

        }

        //metodo para eviar los datos al presionar el boton
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = nombre.getText().toString().trim();
                String ap = apaterno.getText().toString().trim();
                String am = amaterno.getText().toString().trim();
                if(n.isEmpty() && ap.isEmpty() && am.isEmpty()){
                    Toast.makeText(getApplicationContext(),"ingresar datos", Toast.LENGTH_SHORT).show();
                }else{
                    //metodo para capturar los elementos de las cajas de texto
                    postReg(n,ap,am);
                }
            }
        });
    }
//actualizar registro
    private void updateReg(String n, String ap, String am, String id) {
        Map<String, Object> map = new HashMap<>();
        map.put("Nombre",n);
        map.put("Apaterno",ap);
        map.put("Amaterno",am);

        mfirestore.collection("usuario").document(id).update(map).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(getApplicationContext(),"Actualizado correctamente",Toast.LENGTH_SHORT).show();
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(),"Error al actualizar",Toast.LENGTH_SHORT).show();
            }
        });

    }

    //este metodo obtiene los datos de los textview y envia a la collection en firebase
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

    private void getUser(String id){
        mfirestore.collection("usuario").document(id).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                String n = documentSnapshot.getString("Nombre");
                String ap = documentSnapshot.getString("Apaterno");
                String am = documentSnapshot.getString("Amaterno");
                nombre.setText(n);
                apaterno.setText(ap);
                amaterno.setText(am);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(),"Error al obtener los datos",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }
}