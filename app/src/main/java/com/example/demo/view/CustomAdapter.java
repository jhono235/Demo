package com.example.demo.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.R;
import com.example.demo.model.user.User;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder>{

    private List<User> dataSet;

    public void setDataSet(List<User> dataSet){
        this.dataSet = dataSet;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new CustomViewHolder(
                LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_layout,
                        viewGroup,
                        false));
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.tvUserId.setText(dataSet.get(position).mUserId);
        holder.tvId.setText(dataSet.get(position).mId);
        holder.tvTitle.setText(dataSet.get(position).mTitle);
        holder.tvBody.setText(dataSet.get(position).mBody);


    }

    @Override
    public int getItemCount() {
        return dataSet != null ?
                dataSet.size() : 0;
    }
}
