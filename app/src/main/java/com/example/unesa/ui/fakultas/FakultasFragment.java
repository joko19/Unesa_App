package com.example.unesa.ui.fakultas;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.unesa.R;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class FakultasFragment extends Fragment {
    private TabLayout tabLayout1;
    private ViewPager viewPager;
    private FakultasAdapter fakultasAdapter;


    public FakultasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fakultas, container, false);
        tabLayout1 = v.findViewById(R.id.tl_fakulatas);
        viewPager = v.findViewById(R.id.vp_fakultas);

        fakultasAdapter = new FakultasAdapter(getChildFragmentManager());
        fakultasAdapter.AddFragment(new FIP(), "FIP");
        fakultasAdapter.AddFragment(new FBS(), "FBS");
        fakultasAdapter.AddFragment(new FMIPA(), "FMIPA");
        fakultasAdapter.AddFragment(new FISH(), "FISH");
        fakultasAdapter.AddFragment(new FT(), "FT");
        fakultasAdapter.AddFragment(new FIO(), "FIO");
        fakultasAdapter.AddFragment(new FE(), "FE");
        viewPager.setAdapter(fakultasAdapter);
        tabLayout1.setupWithViewPager(viewPager);

        return v;
    }

}
