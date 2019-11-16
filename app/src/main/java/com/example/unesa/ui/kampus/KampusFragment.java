package com.example.unesa.ui.kampus;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.unesa.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class KampusFragment extends Fragment {


    public KampusFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kampus, container, false);
    }

}
