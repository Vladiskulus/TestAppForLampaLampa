package com.testingappforlampalampa.view.fragment;

import static com.testingappforlampalampa.Constants.TYPE_FAVOURITES;
import static com.testingappforlampalampa.Constants.TYPE_STORIES;

import android.os.Build;
import android.os.Bundle;
import android.view.*;

import androidx.annotation.*;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.*;

import com.testingappforlampalampa.R;
import com.testingappforlampalampa.model.*;
import com.testingappforlampalampa.view.adapter.RVAdapter;
import com.testingappforlampalampa.viewmodel.MyVM;

import org.reactivestreams.Subscriber;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import io.reactivex.Maybe;

import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;

import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.*;

public class FavoriteFragment extends Fragment {

    private RecyclerView rv;
    private final CompositeDisposable disposable = new CompositeDisposable();
    private IGetterJSON iGetterJSON;


    public static FavoriteFragment newInstance() {
        return new FavoriteFragment();
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
                                        .equals(TYPE_FAVOURITES))
                                        .collect(Collectors.toList()))
                .subscribe(this::initRecyclerView));
    }

    public void initRecyclerView(List<Model> list) {
        RVAdapter adapter = new RVAdapter(list);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(adapter);
    }
}