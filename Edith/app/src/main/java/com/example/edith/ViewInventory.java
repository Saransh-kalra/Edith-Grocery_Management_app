package com.example.edith;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.edith.adapter.meatcontentsadapter;
import com.example.edith.model.MeatContents;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ViewInventory extends Fragment {

    RecyclerView MeatContentRecyclerView;
    meatcontentsadapter MeatContentsAdapter;
    List<MeatContents> meatContentsList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_view_inventory, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        MeatContentRecyclerView = getView().findViewById(R.id.MeatRecycler);

        meatContentsList = new ArrayList<>();
        meatContentsList.add(new MeatContents(1, R.drawable.milk, R.drawable.rotten, "Milk"));
        meatContentsList.add(new MeatContents(2, R.drawable.beef, R.drawable.fresh, "Sirloin Steak"));
        meatContentsList.add(new MeatContents(3, R.drawable.porkchop, R.drawable.fresh, "Pork Chop"));
        meatContentsList.add(new MeatContents(4, R.drawable.chicken, R.drawable.rotten, "Chicken Breast"));
        meatContentsList.add(new MeatContents(5, R.drawable.broccoli, R.drawable.fresh, "Broccoli"));
        meatContentsList.add(new MeatContents(6, R.drawable.tuna, R.drawable.fresh, "Tuna"));
        meatContentsList.add(new MeatContents(7, R.drawable.lamb, R.drawable.rotten, "Lamb"));
        meatContentsList.add(new MeatContents(8, R.drawable.apple, R.drawable.fresh, "Apple"));
        meatContentsList.add(new MeatContents(9, R.drawable.shrimp, R.drawable.fresh, "Shrimp"));

        setMeatContentsRecycler(meatContentsList);
    }

    private void setMeatContentsRecycler(List<MeatContents> datalist) {
        RecyclerView.LayoutManager LayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL , false);
        MeatContentRecyclerView.setLayoutManager(LayoutManager);
        MeatContentsAdapter = new meatcontentsadapter(getActivity(), datalist);
        MeatContentRecyclerView.setAdapter(MeatContentsAdapter);
    }


}
