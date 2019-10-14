package com.example.midterm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.midterm.models.GroundCampData;

import java.util.List;

public class ListGroundAdapter extends RecyclerView.Adapter<ListGroundAdapter.MyViewHolder> {

    private Context mContext;
    private List<GroundCampData> mData;

    public ListGroundAdapter(Context mContext, List<GroundCampData> mData) {
        this.mContext = mContext;
        this.mData = mData;
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
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView campName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            campName = itemView.findViewById(R.id.ground_name_list);
        }
    }
}
