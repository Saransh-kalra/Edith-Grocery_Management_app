package com.example.edith.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.edith.Ingredient;
import com.example.edith.R;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class InventoryAdapter extends RecyclerView.Adapter<InventoryAdapter.ExampleViewHolder> implements Filterable {
    private ArrayList<Ingredient> mExampleList;
    public ArrayList<Ingredient> completelist;
    private OnItemClickListener mListener;
    public interface OnItemClickListener {
        void onItemClick(int position);
        void onDeleteClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }
    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView1;
        public TextView mTextView2;
        public TextView mQuantity;
        public ImageView mDeleteImage;
        public ExampleViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            mQuantity = itemView.findViewById(R.id.quantityview);
            mTextView1 = itemView.findViewById(R.id.textView);
            mTextView2 = itemView.findViewById(R.id.textView2);
            mDeleteImage = itemView.findViewById(R.id.deletebutton);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
            mDeleteImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onDeleteClick(position);
                        }
                    }
                }
            });
        }
    }
    public InventoryAdapter(ArrayList<Ingredient> exampleList) {
        mExampleList = exampleList;
        completelist = new ArrayList<>(mExampleList);
    }
    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.inventory_items, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v, mListener);
        return evh;
    }
    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        Ingredient currentItem = mExampleList.get(position);
        holder.mTextView1.setText(currentItem.getName());
        holder.mTextView2.setText(currentItem.getExpiryDate());
        holder.mQuantity.setText(currentItem.getQuantity());
    }
    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    @Override
    public Filter getFilter() {
        return inventoryfilter;
    }

    private Filter inventoryfilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Ingredient> filteredlist = new ArrayList<>();

            if (constraint == null || constraint.length() == 0){
                filteredlist.addAll(completelist);
            }   else{
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Ingredient item : completelist){
                    if (item.getName().toLowerCase().contains(filterPattern))
                        filteredlist.add(item);
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredlist;
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            mExampleList.clear();
            mExampleList.addAll((List)filterResults.values);
            notifyDataSetChanged();
        }
    };
}