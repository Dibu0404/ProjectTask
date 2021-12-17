package com.whizzdreamer.divisha0404.projecttask.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.whizzdreamer.divisha0404.projecttask.Data.Detail;
import com.whizzdreamer.divisha0404.projecttask.R;

import java.util.List;

public class DetailListAdapter extends RecyclerView.Adapter<DetailListAdapter.MyViewHolder> {
    private List<Detail> dataSet;
    Context context;
    String imageUrl;


    //View Holder Class
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView sportName;
        TextView sportFact;
        ImageView sportImage;

        public MyViewHolder(View itemView) {
            super(itemView);

            this.sportName = (TextView) itemView.findViewById(R.id.sport_name_TV);
            this.sportFact = (TextView) itemView.findViewById(R.id.sport_fact_TV);
            this.sportImage = (ImageView) itemView.findViewById(R.id.image_IV);

        }
    }

    public DetailListAdapter(List<Detail> data, Context context) {
        this.dataSet = data;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {
        holder.sportName.setText(dataSet.get(listPosition).getSport());
        holder.sportFact.setText(dataSet.get(listPosition).getFact());
        imageUrl = dataSet.get(listPosition).getIcon();

        if (imageUrl.equals("afl.png")) {
            holder.sportImage.setImageResource(R.drawable.afl);
        }
        if (imageUrl.equals("boxing.png")) {
            holder.sportImage.setImageResource(R.drawable.boxing);
        }
        if (imageUrl.equals("cricket.png")) {
            holder.sportImage.setImageResource(R.drawable.cricket);
        }
        if (imageUrl.equals("cycling.png")) {
            holder.sportImage.setImageResource(R.drawable.cycling);
        }

    }


    @Override
    public int getItemCount() {
        return dataSet.size();

    }
}
