package com.example.demo.view;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.R;

public class CustomViewHolder extends RecyclerView.ViewHolder {
    TextView tvUserId, tvId, tvTitle, tvBody;
    public CustomViewHolder(View itemView) {
        super(itemView);
        tvUserId = itemView.findViewById(R.id.tvUserId);
        tvId = itemView.findViewById(R.id.tvId);
        tvTitle = itemView.findViewById(R.id.tvTitle);
        tvBody = itemView.findViewById(R.id.tvBody);
    }
}
