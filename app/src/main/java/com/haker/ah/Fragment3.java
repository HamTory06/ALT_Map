package com.haker.ah;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


public class Fragment3 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_3, container, false);

        //처음 childfragment 지정
        getFragmentManager().beginTransaction().add(R.id.Sunny_fragment, new SunnyFragment()).commit();

        //하위버튼
        LinearLayout subButton1 = (LinearLayout) v.findViewById(R.id.subButton1);
        LinearLayout subButton2 = (LinearLayout) v.findViewById(R.id.subButton2);
        LinearLayout subButton3 = (LinearLayout) v.findViewById(R.id.subButton3);

        //클릭 이벤트
        subButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.Sunny_fragment, new SunnyFragment()).commit();
            }
        });
        subButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.Sunny_fragment, new CloudFragment()).commit();

            }
        });
        subButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.Sunny_fragment, new RainFragment()).commit();

            }
        });

        return v;
    }

}