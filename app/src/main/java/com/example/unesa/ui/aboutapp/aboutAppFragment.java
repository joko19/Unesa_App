package com.example.unesa.ui.aboutapp;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.unesa.R;

public class aboutAppFragment extends Fragment {


    public aboutAppFragment() { }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_about_app, container, false);
       // final TextView textView = v.findViewById(R.id.version);
       // textView.setText("LISENSES");

       // return v;
    }

}
