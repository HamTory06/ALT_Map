package com.haker.ah;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RainFragment extends Fragment {
    private ArrayList<RainData> itemList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RainAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_rain, container, false);
        // Inflate the layout for this fragment
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        mAdapter = new RainAdapter(itemList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        return v;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prepareData();
    }

    private void prepareData() {
        itemList.add(new RainData("비비비비비비ㅣㅂ",37.54892296550104,126.99089033876304));
        itemList.add(new RainData("힘드러",37.54892296550104,126.99089033876304));
        itemList.add(new RainData("난 여기랑 안맞나바",37.54892296550104,126.99089033876304));
        itemList.add(new RainData("개발이 머야",37.54892296550104,126.99089033876304));
        itemList.add(new RainData("울고싶다",37.54892296550104,126.99089033876304));
    }
}

