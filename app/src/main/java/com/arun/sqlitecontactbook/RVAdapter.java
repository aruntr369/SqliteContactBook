package com.arun.sqlitecontactbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MyViewHolder> {

    private ArrayList<ContactModel> contactModelArrayList;
    private Context context;

    public RVAdapter(ArrayList<ContactModel> contactModelArrayList, ContactBook contactBookClass) {
        this.contactModelArrayList = contactModelArrayList;
        this.context = contactBookClass;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(parent.getContext()).
                 inflate(R.layout.contact_rv,parent,false);
         return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        ContactModel model = contactModelArrayList.get(position);

        holder.namee.setText(model.getName());
        holder.numberr.setText(model.getNumber());
        holder.emaill.setText(model.getEmail());

    }

    @Override
    public int getItemCount() {
        return contactModelArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView namee,numberr,emaill;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            namee = itemView.findViewById(R.id.tvNameRV);
            numberr = itemView.findViewById(R.id.tvNumberRV);
            emaill = itemView.findViewById(R.id.tvEmailRV);
        }
    }
}
