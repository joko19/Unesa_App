package com.example.unesa.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unesa.R;
import com.example.unesa.adapter.BeritaAdapter;
import com.example.unesa.model.Berita;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Berita> dataBerita;
    private ProgressBar progressBar;
    private TextView cekKoneksi;
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference("berita");

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getData();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = v.findViewById(R.id.rv_home);
        progressBar = v.findViewById(R.id.progressBar);
        cekKoneksi = v.findViewById(R.id.tv_cek_koneksi);

        getData();
        return v;
    }
    private void getData() {
        ValueEventListener valueEventListener= new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                dataBerita = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Berita berita =snapshot.getValue(Berita.class);

                    dataBerita.add(berita);
                }
                BeritaAdapter beritaAdapter = new BeritaAdapter(getContext(), dataBerita);
                if (beritaAdapter != null){
                    progressBar.setVisibility(View.GONE);
                    cekKoneksi.setVisibility(View.GONE);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    recyclerView.setAdapter(beritaAdapter);
                } else {

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        ref.addValueEventListener(valueEventListener);
    }

}