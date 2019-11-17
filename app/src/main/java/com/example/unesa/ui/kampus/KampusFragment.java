package com.example.unesa.ui.kampus;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.unesa.R;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class KampusFragment extends Fragment {
    private TabLayout tabLayout1;
    private ViewPager viewPager;
    private KampusAdapter kampusAdapter;

    public KampusFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_kampus, container, false);
        tabLayout1 = v.findViewById(R.id.tl_kampus);
        viewPager = v.findViewById(R.id.vp_kampus);


        kampusAdapter = new KampusAdapter(getChildFragmentManager());
        kampusAdapter.AddFragment(new VisiMisi(),"Visi");
        kampusAdapter.AddFragment(new Sejarah(),"sejarah");
        kampusAdapter.AddFragment(new SelayangPandang(),"Profile");
        viewPager.setAdapter(kampusAdapter);
        tabLayout1.setupWithViewPager(viewPager);

        return v;
    }

}
