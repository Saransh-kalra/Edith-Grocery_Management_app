package com.example.edith;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.example.edith.adapter.InventoryAdapter;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ViewInventory extends Fragment {
    RecyclerView InventoryContentRecyclerView;
    SearchView searchView;
    InventoryAdapter  inventoryadapter;
    ArrayList<Ingredient> InventoryContentsList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_view_inventory, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        InventoryContentRecyclerView = getView().findViewById(R.id.InventoryRecycler);
        searchView = getView().findViewById(R.id.inventorysearch);
        arraylistcontainer newcontainer = new arraylistcontainer();
        InventoryContentsList = newcontainer.Usethisarray;

//       List.add(new Ingredient("Milk", 5, new SimpleDateFormat("MM/dd/yyyy").parse("05/04/2021", new java.text.ParsePosition(0))));
//        InventoryContentsList.add(new Ingredient( "Sirloin Steak", 5, new SimpleDateFormat("MM/dd/yyyy").parse("05/04/2021", new java.text.ParsePosition(0))));
//        InventoryContentsList.add(new Ingredient("Pork Chop", 5, new SimpleDateFormat("MM/dd/yyyy").parse("05/04/2021", new java.text.ParsePosition(0))));
//        InventoryContentsList.add(new Ingredient("Bananas", 5, new SimpleDateFormat("MM/dd/yyyy").parse("05/04/2021", new java.text.ParsePosition(0))));
//        InventoryContentsList.add(new Ingredient( "Apples", 5, new SimpleDateFormat("MM/dd/yyyy").parse("05/04/2021", new java.text.ParsePosition(0))));
//        InventoryContentsList.add(new Ingredient("Broccoli", 5, new SimpleDateFormat("MM/dd/yyyy").parse("05/04/2021", new java.text.ParsePosition(0))));
//        InventoryContentsList.add(new Ingredient("Garlic", 5, new SimpleDateFormat("MM/dd/yyyy").parse("05/04/2021", new java.text.ParsePosition(0))));
//        InventoryContentsList.add(new Ingredient( "Lamb", 5, new SimpleDateFormat("MM/dd/yyyy").parse("05/04/2021", new java.text.ParsePosition(0))));
//        InventoryContentsList.add(new Ingredient("Chicken Thighs", 5, new SimpleDateFormat("MM/dd/yyyy").parse("05/04/2021", new java.text.ParsePosition(0))));
//        InventoryContentsList.add(new Ingredient("Ground Bison", 5, new SimpleDateFormat("MM/dd/yyyy").parse("05/04/2021", new java.text.ParsePosition(0))));
//        InventoryContentsList.add(new Ingredient( "Ground Beef", 5, new SimpleDateFormat("MM/dd/yyyy").parse("05/04/2021", new java.text.ParsePosition(0))));
//        InventoryContentsList.add(new Ingredient("Strawberries", 5, new SimpleDateFormat("MM/dd/yyyy").parse("05/04/2021", new java.text.ParsePosition(0))));
//        InventoryContentsList.add(new Ingredient("Lemonade", 5, new SimpleDateFormat("MM/dd/yyyy").parse("05/04/2021", new java.text.ParsePosition(0))));
//        InventoryContentsList.add(new Ingredient( "Lettuce", 5, new SimpleDateFormat("MM/dd/yyyy").parse("05/04/2021", new java.text.ParsePosition(0))));
        setInventoryContentsRecycler(InventoryContentsList);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                inventoryadapter.getFilter().filter(s);
                return false;
            }
        });




    }

    public void addItem(Ingredient ingredient) {
        InventoryContentsList.add(0,ingredient);
        inventoryadapter.notifyItemInserted(0);
    }

    public void removeItem(int position) {
        InventoryContentsList.remove(position);
        inventoryadapter.completelist.remove(position);
        inventoryadapter.notifyItemRemoved(position);
    }

    private void setInventoryContentsRecycler(ArrayList<Ingredient> datalist) {
        RecyclerView.LayoutManager LayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL , false);
        InventoryContentRecyclerView.setLayoutManager(LayoutManager);
        inventoryadapter = new InventoryAdapter(datalist);
        InventoryContentRecyclerView.setAdapter(inventoryadapter);
        inventoryadapter.setOnItemClickListener(new InventoryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
            }

            @Override
            public void onDeleteClick(int position) {
                removeItem(position);
            }
        });
    }


}