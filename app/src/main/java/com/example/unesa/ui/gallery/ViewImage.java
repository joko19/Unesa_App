package com.example.unesa.ui.gallery;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.unesa.R;
import com.example.unesa.model.Gallery;

public class ViewImage extends AppCompatActivity {

    public static final String EXTRA_IMAGE = "extra_image";
    public ImageView imageView;
    public Gallery gallery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_image);
        imageView = findViewById(R.id.imageView2);
        gallery = getIntent().getParcelableExtra(EXTRA_IMAGE);
        Glide.with(ViewImage.this)
                .load(gallery.getImg())
                .into(imageView);
    }
}
