package com.example.unesa.ui.fakultas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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

public class FBS extends Fragment {

    private TextView tv_nama_fakultas, tv_visi, tv_misi;
    private ImageView img_fakultas;
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference("fakultas/fbs");

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.detail_fakultas, container, false);
        tv_nama_fakultas = v.findViewById(R.id.tv_nama_fakultas);
        tv_visi = v.findViewById(R.id.tv_visi);
        tv_misi = v.findViewById(R.id.tv_misi);
        img_fakultas = v.findViewById(R.id.img_fakultas);
        getData();
        return v;
    }

    private void getData() {
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Fakultas fakultas =dataSnapshot.getValue(Fakultas.class);
                tv_nama_fakultas.setText(fakultas.getNama());
                tv_visi.setText(fakultas.getVisi());
                tv_misi.setText(fakultas.getMisi());
                Glide.with(FBS.this)
                        .load(fakultas.getGambar())
                        .into(img_fakultas);
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
