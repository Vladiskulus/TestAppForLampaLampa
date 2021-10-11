package com.testingappforlampalampa.view.fragment;

import static com.testingappforlampalampa.Constants.*;

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

import java.util.List;

public class PagerFragment extends Fragment {

    private FragmentBinding binding;

    public static PagerFragment newInstance(int position) {
        PagerFragment fragment = new PagerFragment();
        Bundle args = new Bundle();
        args.putInt(POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentBinding.inflate(inflater, container, false);
        MyVM vm = new ViewModelProvider(this).get(MyVM.class);
        if (getArguments().get(POSITION).equals(0)) {
            vm.initList(TYPE_FAVOURITES);
        } else if (getArguments().get(POSITION).equals(1)) {
            vm.initList(TYPE_STORIES);
        } else if (getArguments().get(POSITION).equals(2)) {
            vm.initList(TYPE_VIDEO);
        }
        vm.getList().observe(getViewLifecycleOwner(), this::initRecyclerView);
        return binding.getRoot();
    }

    public void initRecyclerView(List<Model> list) {
        RVAdapter adapter = new RVAdapter(list);
        binding.rv.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rv.setAdapter(adapter);
    }
}