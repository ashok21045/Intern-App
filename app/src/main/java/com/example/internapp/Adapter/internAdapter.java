package com.example.internapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.internapp.Model.internItem;
import com.example.internapp.R;

import java.util.ArrayList;

public class internAdapter extends RecyclerView.Adapter<internAdapter.InternViewHolder> {

    private ArrayList<internItem> internList;

    public internAdapter(ArrayList<internItem> internList) {
        this.internList = internList;
    }

    @NonNull
    @Override
    public InternViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_intern, parent, false);

        return new InternViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InternViewHolder holder, int position) {

        internItem item = internList.get(position);

        holder.title.setText(item.getTitle());
        holder.role.setText(item.getRole());
        holder.company.setText(item.getCompanyName());
        holder.address.setText(item.getAddress());
        holder.publishedDate.setText(item.getPublishedDate());
        holder.appliedByNo.setText(item.getAppliedByNo());
    }

    @Override
    public int getItemCount() {
        return internList.size();
    }

    public static class InternViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView role;
        TextView company;
        TextView address;
        TextView publishedDate;
        TextView appliedByNo;

        public InternViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.interntitle);
            role = itemView.findViewById(R.id.role);
            company = itemView.findViewById(R.id.company);
            address = itemView.findViewById(R.id.address);
            publishedDate = itemView.findViewById(R.id.publishedDate);
            appliedByNo = itemView.findViewById(R.id.appliedByNo);
        }
    }
}