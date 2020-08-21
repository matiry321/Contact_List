package com.example.contact_list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Contact_Adapter extends RecyclerView.Adapter<Contact_Adapter.ViewHolder>
{

    private Context context;
    private ArrayList contact_name,contact_phone;
    public Contact_Adapter(Context context, ArrayList contact_name,ArrayList contact_phone)
    {
        this.context = context;
        this.contact_name = contact_name;
        this.contact_phone = contact_phone;

    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_of_contact,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nameofperson.setText(String.valueOf(contact_name.get(position)));
        holder.phonenumber.setText(String.valueOf(contact_phone.get(position)));

    }

    @Override
    public int getItemCount() {
        return contact_name.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView imagecontact;
        private TextView nameofperson,phonenumber;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imagecontact = itemView.findViewById(R.id.imagecontact);
            nameofperson = itemView.findViewById(R.id.nameofperson);
            phonenumber = itemView.findViewById(R.id.phonenumber);
        }
    }
}
