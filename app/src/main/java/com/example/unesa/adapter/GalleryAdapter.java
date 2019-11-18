package com.example.unesa.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.unesa.R;
import com.example.unesa.model.Gallery;
import com.example.unesa.ui.gallery.ViewImage;

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
        Context mcontext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_grid, parent, false);
        GalleryAdapter.MyViewHolder viewHolder = new GalleryAdapter.MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        Gallery gallery = galleryList.get(position);
        ImageView imageView = holder.imageView;
        Glide.with(context)
                .load(gallery.getImg())
                .apply(new RequestOptions().override(200, 200))
                .into(imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent datagambar = new Intent(context, ViewImage.class);
                datagambar.putExtra(ViewImage.EXTRA_IMAGE, galleryList.get(position));
                context.startActivity(datagambar);
            }
        });
    }

    @Override
    public int getItemCount() {
        return galleryList.size();
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

}
