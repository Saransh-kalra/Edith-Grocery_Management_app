package com.example.edith.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.edith.R;
import com.example.edith.model.MeatContents;

import java.util.List;

public class meatcontentsadapter extends RecyclerView.Adapter<meatcontentsadapter.meatcontentsviewholder> {
    Context context;
    List<MeatContents> MeatContentsList;

    public meatcontentsadapter(Context context, List<MeatContents> MeatContentsList){
        this.context = context;
        this.MeatContentsList = MeatContentsList;
    }

    @NonNull
    @Override
    public meatcontentsviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.meat_column_items, parent, false);
        return new meatcontentsviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull meatcontentsviewholder holder, int position) {

        holder.nametext.setText(MeatContentsList.get(position).getname());
        holder.MeatImageView.setImageResource(MeatContentsList.get(position).getImageurl());
        holder.ExpirationImageView.setImageResource(MeatContentsList.get(position).getProgressurl());
    }

    @Override
    public int getItemCount() {
        return MeatContentsList.size();
    }

    public static class meatcontentsviewholder extends RecyclerView.ViewHolder{

        ImageView MeatImageView,ExpirationImageView;
        TextView nametext;

        public meatcontentsviewholder(@NonNull View itemView) {
            super(itemView);
            nametext = itemView.findViewById(R.id.name);
            ExpirationImageView =itemView.findViewById(R.id.ExpirationImage);
            MeatImageView = itemView.findViewById(R.id.MeatImage);
        }
    }
}
