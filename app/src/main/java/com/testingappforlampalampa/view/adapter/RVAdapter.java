package com.testingappforlampalampa.view.adapter;

import android.content.Context;
import android.view.*;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.squareup.picasso.Picasso;
import com.testingappforlampalampa.R;
import com.testingappforlampalampa.databinding.ListItemBinding;
import com.testingappforlampalampa.databinding.VpTopNewsBinding;
import com.testingappforlampalampa.model.Model;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Model> data;

    public RVAdapter(List<Model> list) {
        data = list;
        notifyDataSetChanged();
    }


    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder;
        ListItemBinding binding;
        VpTopNewsBinding topNewsBinding;
        if (viewType == 0) {
            topNewsBinding = VpTopNewsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            holder = new TopNewsHolder(topNewsBinding);
        } else {
            binding = ListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            holder = new SecondHolder(binding);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (this.getItemViewType(position) == 0) {
            TopNewsHolder topNewsHolder = (TopNewsHolder) holder;
//            NewsPagerAdapter adapter = new NewsPagerAdapter(data, context);
//            topNewsHolder.binder.vpTopNews.setAdapter(adapter);
//            topNewsHolder.binder.progressBar.setMax(data.size());
//            topNewsHolder.binder.progressBar.setProgress(topNewsHolder.binder.vpTopNews.getCurrentItem()+1);
        } else {
            Model model = data.get(position - 1);
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

    }

    @Override
    public int getItemCount() {
        return data.size() + 1;//top news is a new list element
    }

    public static class SecondHolder extends RecyclerView.ViewHolder {
        ListItemBinding binder;

        public SecondHolder(ListItemBinding binding) {
            super(binding.getRoot());
            binder = binding;
        }
    }

    public static class TopNewsHolder extends RecyclerView.ViewHolder {
        VpTopNewsBinding binder;

        public TopNewsHolder(VpTopNewsBinding binding) {
            super(binding.getRoot());
            binder = binding;
        }
    }
}