package com.testingappforlampalampa.view.adapter;

import android.view.*;
import android.widget.*;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.testingappforlampalampa.R;
import com.testingappforlampalampa.model.Model;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MyViewHolder> {

    private List<Model> data;

    public RVAdapter(List<Model> list) {
        data = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new
                MyViewHolder(
                LayoutInflater.from(
                        parent.getContext()
                ).inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_title.setText(data.get(position).getTitle());
        holder.tv_url.setText(data.get(position).getClick_url());
        holder.tv_time.setText(data.get(position).getTime());
        if (data.get(position).getImg() != null) {
            Picasso.get()
                    .load(data.get(position).getImg())
                    .into(holder.imageView);
        } else {
            holder.imageView.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tv_title;
        TextView tv_url;
        TextView tv_time;

        public MyViewHolder(@NonNull View v) {
            super(v);
            imageView = v.findViewById(R.id.iv_item);
            tv_time = v.findViewById(R.id.tv_time);
            tv_title = v.findViewById(R.id.tv_title);
            tv_url = v.findViewById(R.id.tv_url);
        }

    }
}
