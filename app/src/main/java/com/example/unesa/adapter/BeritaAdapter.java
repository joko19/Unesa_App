package com.example.unesa.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.unesa.DetailNewsActivity;
import com.example.unesa.R;
import com.example.unesa.model.Berita;

import java.util.List;

public class BeritaAdapter extends RecyclerView.Adapter<BeritaAdapter.MyViewHolder>{

    private Context mContext;
    private List<Berita> mBerita;

    public BeritaAdapter(Context mContext, List<Berita> mBerita) {
        this.mContext = mContext;
        this.mBerita = mBerita;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.list_news, parent, false);
        final MyViewHolder myViewHolder = new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.tv_title.setText(mBerita.get(position).getTitle());
        holder.tv_content.setText(mBerita.get(position).getKonten());
        final Berita berita = mBerita.get(position);
        Glide.with(holder.list_item.getContext())
                .load(berita.getImg_url())
                .apply(new RequestOptions().override(200, 300))
                .into(holder.img_news);
        holder.list_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent detail = new Intent(context, DetailNewsActivity.class);
                detail.putExtra(DetailNewsActivity.EXTRA_NEWS, mBerita.get(position));
                context.startActivity(detail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mBerita.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private RelativeLayout list_item;
        private TextView tv_title, tv_content;
        private ImageView img_news;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            list_item = itemView.findViewById(R.id.baris);
            tv_title = itemView.findViewById(R.id.tv_judul);
            tv_content = itemView.findViewById(R.id.tv_deskripsi);
            img_news = itemView.findViewById(R.id.img_poster);
        }
    }
}
