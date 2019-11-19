package com.example.unesa.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unesa.R;
import com.example.unesa.adapter.GalleryAdapter;
import com.example.unesa.model.Gallery;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Gallery> dataGallery;
    private ProgressBar progressBar;
    private TextView cekkoneksi;
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference("gallery");


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_gallery, container, false);
        recyclerView = v.findViewById(R.id.rv_gallery);
        progressBar = v.findViewById(R.id.progressBargallery);
        cekkoneksi = v.findViewById(R.id.tv_cek_koneksigallery);
        getData();
        return v;
    }

    private void getData() {
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                dataGallery = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Gallery gallery = snapshot.getValue(Gallery.class);
                    dataGallery.add(gallery);
                }
                GalleryAdapter galleryAdapter = new GalleryAdapter(getContext(), dataGallery);
                if (galleryAdapter != null){
                    progressBar.setVisibility(View.GONE);
                    cekkoneksi.setVisibility(View.GONE);
                    recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
                    recyclerView.setAdapter(galleryAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
