package com.example.firecrudv2.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firecrudv2.R;
import com.example.firecrudv2.model.user;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class adapter extends FirestoreRecyclerAdapter<user,adapter.ViewHolder>{

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public adapter(@NonNull FirestoreRecyclerOptions<user> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull user model) {
        holder.nom.setText(model.getNombre());
        holder.apat.setText(model.getApaterno());
        holder.amat.setText(model.getAmaterno());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);
        return new ViewHolder(v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nom,apat,amat;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nom=itemView.findViewById(R.id.nombre);
            apat=itemView.findViewById(R.id.apaterno);
            amat=itemView.findViewById(R.id.amaterno);
        }
    }
}