package com.verizon.util.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.bumptech.glide.Glide;
import com.verizon.R;
import com.verizon.imagesGrid.model.Datum;

import java.util.List;

/**
 * Created by memoPilgrim on 29/11/16.
 */

public class GridImgAdapter extends RecyclerView.Adapter<GridImgAdapter.MyViewHolder> {

    private List<Datum> imgList;
    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Datum item);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
       ImageView cover;


        public MyViewHolder(View view) {
            super(view);
            cover = (ImageView) view.findViewById(R.id.cover);
        }

        public void bind(final Datum item, final OnItemClickListener listener) {
            Glide.with(itemView.getContext()).load(item.getArtist().getPictureMedium()).into(cover);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }


    public GridImgAdapter(List<Datum> imgList, OnItemClickListener listener) {
        this.imgList = imgList;
        this.listener = listener;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_list_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bind(imgList.get(position),listener);
    }

    @Override
    public int getItemCount() {
        return imgList.size();
    }
}
