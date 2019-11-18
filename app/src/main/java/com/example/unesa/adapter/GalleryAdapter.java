package com.example.unesa.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unesa.R;
import com.example.unesa.model.Gallery;

import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.MyViewHolder> {

    private Context context;
    private List<Gallery> galleryList;

    public GalleryAdapter(Context context, List<Gallery> galleryList) {
        this.context = context;
        this.galleryList = galleryList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        Glide.with(holder.ga)
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private RelativeLayout grid;
        private ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
//            grid = itemView.findViewById(R.id.)
            imageView = itemView.findViewById(R.id.img_grid);

        }
    }

//    public View getView(int position, View convertView, ViewGroup viewGroup){
//        ImageView imageView;
//        if (convertView == null){
//            imageView = new ImageView(context);
//            imageView.setLayoutParams(new GridLayout.LayoutParams());
//            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            imageView.setPadding(8,8,8,8);
//        }
//        else {
//            imageView = (ImageView) convertView;
//        }
//        imageView.setImageResource(galleryList.get(position));
//    }
}
