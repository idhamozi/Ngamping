package com.example.midterm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.midterm.models.GroundCampData;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListGroundAdapter extends RecyclerView.Adapter<ListGroundAdapter.MyViewHolder>{

    private Context mContext;
    private List<GroundCampData> mData;
    private final OnItemClickListener listener;

    public ListGroundAdapter(Context mContext, List<GroundCampData> mData, OnItemClickListener listener) {
        this.mContext = mContext;
        this.mData = mData;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.list_camp_adapter, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.campName.setText(mData.get(position).getName());
        holder.ticket.setText(mData.get(position).getTicket());
        Picasso.with(mContext).load(mData.get(position).getImageUri()).fit().into(holder.groundImage);
        holder.bind(position, listener);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int item);
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView campName;
        TextView ticket;
        ImageView groundImage;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            campName = itemView.findViewById(R.id.ground_name_list);
            ticket = itemView.findViewById(R.id.ground_ticket_list);
            groundImage = itemView.findViewById(R.id.ground_image_list);

        }

        public void bind(final int item, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    listener.onItemClick(item);
                }
            });
        }
    }
}
