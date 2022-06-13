package com.example.firecrudv2.adapter;


import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firecrudv2.R;
import com.example.firecrudv2.addReg;
import com.example.firecrudv2.model.user;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class adapter extends FirestoreRecyclerAdapter<user,adapter.ViewHolder>{

    private FirebaseFirestore mFirestore = FirebaseFirestore.getInstance();
    Activity activity;

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public adapter(@NonNull FirestoreRecyclerOptions<user> options, Activity activity, FragmentManager supportFragmentManager) {
        super(options);
        this.activity  = activity;
    }
    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull user model) {
        DocumentSnapshot documentSnapshot = getSnapshots().getSnapshot(holder.getAdapterPosition());
        final String id = documentSnapshot.getId();

        holder.nom.setText(model.getNombre());
        holder.apat.setText(model.getApaterno());
        holder.amat.setText(model.getAmaterno());

        holder.btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(activity, addReg.class);
                i.putExtra("id_reg",id);
                activity.startActivity(i);
            }
        });

        holder.btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delUser(id);
            }
        });
    }
    //eliminar registro
    private void delUser(String id) {
        mFirestore.collection("usuario").document(id).
                delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(activity,"elimando correctamente",Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(activity,"error al eliminar", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);
        return new ViewHolder(v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nom,apat,amat;
        ImageView btn_del,btn_edit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nom=itemView.findViewById(R.id.nombre);
            apat=itemView.findViewById(R.id.apaterno);
            amat=itemView.findViewById(R.id.amaterno);
            btn_del = itemView.findViewById(R.id.btn_elminar);
            btn_edit = itemView.findViewById(R.id.btn_editar);
        }
    }
}