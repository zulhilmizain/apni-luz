package com.n2w.inpa.prototype.DestinationViewDetails;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.n2w.inpa.prototype.R;

import java.util.ArrayList;

public class IconIICellsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater mInflater;
    private ArrayList<IconIICellsModel> mData;

    public IconIICellsAdapter(Context cont, ArrayList<IconIICellsModel> mData)
    {
        this.mInflater = LayoutInflater.from(cont);
        this.mData = mData;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = mInflater.inflate(R.layout.destination_details_with_icons_cells_ii, viewGroup, false);

        return new IconCellsIIViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        IconIICellsModel data = mData.get(i);

        ((IconCellsIIViewHolder) viewHolder).ivDestDetailsIcon.setImageResource(data.imgIconDrawable);
        ((IconCellsIIViewHolder) viewHolder).tvDestDetailsTextView.setText(data.description);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class IconCellsIIViewHolder extends RecyclerView.ViewHolder {

        ImageView ivDestDetailsIcon;
        TextView tvDestDetailsTextView;

        public IconCellsIIViewHolder(@NonNull View itemView) {
            super(itemView);

            ivDestDetailsIcon = itemView.findViewById(R.id.ivDestDetailsIcon);
            tvDestDetailsTextView = itemView.findViewById(R.id.tvDestDetailsTextView);
        }
    }
}
