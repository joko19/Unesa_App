package com.example.unesa.ui.fakultas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.unesa.R;
import com.example.unesa.model.Fakultas;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FIO extends Fragment {

    private TextView tv_nama_fakultas, tv_visi, tv_misi, visi, misi, cekkoneksi;
    private ImageView img_fakultas;
    private ProgressBar progressBar;
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference("fakultas/fio");

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.detail_fakultas, container, false);
        tv_nama_fakultas = v.findViewById(R.id.tv_nama_fakultas);
        tv_visi = v.findViewById(R.id.tv_visi);
        tv_misi = v.findViewById(R.id.tv_misi);
        visi = v.findViewById(R.id.visi);
        misi = v.findViewById(R.id.misi);
        progressBar = v.findViewById(R.id.progressBarfakultas);
        cekkoneksi = v.findViewById(R.id.tv_cek_koneksifakultas);
        img_fakultas = v.findViewById(R.id.img_fakultas);
        getData();
        return v;
    }

    private void getData() {
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Fakultas fakultas =dataSnapshot.getValue(Fakultas.class);
                if (fakultas != null){
                    visi.setVisibility(View.VISIBLE);
                    misi.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                    cekkoneksi.setVisibility(View.GONE);
                    tv_nama_fakultas.setText(fakultas.getNama());
                    tv_visi.setText(fakultas.getVisi());
                    tv_misi.setText(fakultas.getMisi());
                    Glide.with(FIO.this)
                            .load(fakultas.getGambar())
                            .into(img_fakultas);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
