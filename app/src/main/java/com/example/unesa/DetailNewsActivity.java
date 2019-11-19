package com.example.unesa;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.unesa.model.Berita;

public class DetailNewsActivity extends AppCompatActivity {
    public static final String EXTRA_NEWS = "extra_news";
    private TextView tvJudul, tvKonten;
    private ImageView imgNews;
    private Berita berita;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_news);
        inisialisasi();
        getSupportActionBar().setTitle("Detail News");
        berita = getIntent().getParcelableExtra(EXTRA_NEWS);
        setData();
    }

    private void setData() {
        tvJudul.setText(berita.getTitle());
        tvKonten.setText(berita.getKonten());
        Glide.with(DetailNewsActivity.this)
                .load(berita.getImg_url())
                .into(imgNews);
    }

    private void inisialisasi() {
        tvJudul = findViewById(R.id.tv_detail_news_title);
        tvKonten = findViewById(R.id.tv_detail_news_content);
        imgNews = findViewById(R.id.img_detail_news_);
    }
}
