package com.testingappforlampalampa.view.adapter;

import android.view.*;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.testingappforlampalampa.databinding.ListItemBinding;
import com.testingappforlampalampa.model.Model;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Model> data;

    public RVAdapter(List<Model> list) {
        data = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder;
        ListItemBinding binding = ListItemBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        holder = new SecondHolder(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Model model = data.get(position);
        SecondHolder secondHolder = (SecondHolder) holder;
        ListItemBinding v = secondHolder.binder;
        v.tvTitle.setText(String.valueOf(model.getTitle()));
        v.tvUrl.setText(String.valueOf(model.getClick_url()));
        v.tvTime.setText(String.valueOf(model.getTime()));
        if (model.getImg() != null) {
            Picasso.get()
                    .load(model.getImg())
                    .into(v.ivItem);
        } else {
            v.ivItem.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class SecondHolder extends RecyclerView.ViewHolder {
        ListItemBinding binder;

        public SecondHolder(ListItemBinding binding) {
            super(binding.getRoot());
            binder = binding;
        }
    }
}