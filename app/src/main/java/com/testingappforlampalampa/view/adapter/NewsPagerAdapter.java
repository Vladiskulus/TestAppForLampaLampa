package com.testingappforlampalampa.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.squareup.picasso.Picasso;
import com.testingappforlampalampa.R;
import com.testingappforlampalampa.databinding.TopNewsBinding;
import com.testingappforlampalampa.model.Model;

import java.util.List;

public class NewsPagerAdapter  extends PagerAdapter {

    private List<Model>data;
    private Context context;

    public NewsPagerAdapter(List<Model> data, Context c) {
        this.data = data;
        context = c;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        TopNewsBinding binding = TopNewsBinding.inflate((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE), container, false);
        View view = inflater.inflate(R.layout.top_news, container,
                false);
        Model model = data.get(position);
        Picasso.get().load(model.getImg()).into(binding.topNewImg);
        binding.txtTitleTn.setText(model.getTitle());
        binding.txtTimeTn.setText(model.getTime());
        binding.txtUrlTn.setText(model.getClick_url());
        container.addView(binding.getRoot());
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);
    }
}
