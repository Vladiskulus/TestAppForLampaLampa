package com.testingappforlampalampa.view.fragment;

import static com.testingappforlampalampa.Constants.TYPE_VIDEO;

import android.os.Bundle;
import android.view.*;

import androidx.annotation.*;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.testingappforlampalampa.databinding.FragmentBinding;
import com.testingappforlampalampa.model.Model;
import com.testingappforlampalampa.view.adapter.RVAdapter;
import com.testingappforlampalampa.viewmodel.MyVM;

import java.util.*;

public class VideoFragment extends Fragment {

    private MyVM vm;
    private FragmentBinding binding;

    public static VideoFragment newInstance() {
        return new VideoFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentBinding.inflate(inflater, container, false);
        vm = new ViewModelProvider(this).get(MyVM.class);
        vm.initList(TYPE_VIDEO);
        vm.getList().observe(getViewLifecycleOwner(), this::initRecyclerView);
        return binding.getRoot();
    }

    public void initRecyclerView(List<Model> list) {
        RVAdapter adapter = new RVAdapter(list);
        binding.rv.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rv.setAdapter(adapter);
    }
}
