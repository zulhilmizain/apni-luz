package com.n2w.inpa.prototype.DestinationViewDetails;

import android.content.Context;
import android.graphics.drawable.Icon;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.n2w.inpa.prototype.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class IconCellsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater mInflater;
    private ArrayList<IconCellsModel> mData;

    public IconCellsAdapter(Context cont, ArrayList<IconCellsModel> mData)
    {
        this.mInflater = LayoutInflater.from(cont);
        this.mData = mData;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = mInflater.inflate(R.layout.destination_details_with_icons_cells, viewGroup, false);

        return new IconCellsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        IconCellsModel data = mData.get(i);

        ((IconCellsViewHolder) viewHolder).tvDestDetailsCellsText.setText(data.content);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class IconCellsViewHolder extends RecyclerView.ViewHolder {

        TextView tvDestDetailsCellsText;

        public IconCellsViewHolder(@NonNull View itemView) {
            super(itemView);

            tvDestDetailsCellsText = itemView.findViewById(R.id.tvDestDetailsCellsText);

        }
    }
}
