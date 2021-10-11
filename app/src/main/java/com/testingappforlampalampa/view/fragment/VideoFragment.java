package com.testingappforlampalampa.view.fragment;

import static com.testingappforlampalampa.Constants.TYPE_FAVOURITES;
import static com.testingappforlampalampa.Constants.TYPE_VIDEO;

import android.os.Build;
import android.os.Bundle;
import android.view.*;

import androidx.annotation.*;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.testingappforlampalampa.R;
import com.testingappforlampalampa.model.IGetterJSON;
import com.testingappforlampalampa.model.Model;
import com.testingappforlampalampa.model.RetrofitClient;
import com.testingappforlampalampa.view.adapter.RVAdapter;

import java.util.*;
import java.util.stream.Collectors;

import io.reactivex.Maybe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.*;

public class VideoFragment extends Fragment {

    private RecyclerView rv;
    private final CompositeDisposable disposable = new CompositeDisposable();
    private Maybe<List<Model>> maybe;
    private IGetterJSON iGetterJSON;

    public static VideoFragment newInstance() {
        return new VideoFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);
        rv = view.findViewById(R.id.rv);
        Retrofit retrofit = RetrofitClient.getInstance();
        iGetterJSON = retrofit.create(IGetterJSON.class);
        fetchData();
        return view;
    }


    private void fetchData() {
        disposable.add(iGetterJSON.getList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(list -> list
                        .stream()
                        .filter(item -> item.getType()
                                .equals(TYPE_VIDEO))
                        .collect(Collectors.toList()))
                .subscribe(this::initRecyclerView));
    }

    public void initRecyclerView(List<Model> list) {
        RVAdapter adapter = new RVAdapter(list);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(adapter);

    }
}
