package com.example.androidproyecto2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class fragment2 extends Fragment {
//    Declara elementos
    TextView tvlastname;

    public fragment2() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getParentFragmentManager().setFragmentResultListener("key1", this, (requestKey, bundle1) -> {
            String lastname = bundle1.getString("lastname");

            tvlastname.setText(lastname);
        });

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment2, container, false);
    }

    @Override
    public  void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        tvlastname=view.findViewById(R.id.Fragment2__Texto_Apellido);
    }

}