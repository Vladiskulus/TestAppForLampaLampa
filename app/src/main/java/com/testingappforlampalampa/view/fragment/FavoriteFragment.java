package com.testingappforlampalampa.view.fragment;

import static com.testingappforlampalampa.Constants.*;

import android.os.Bundle;
import android.view.*;

import androidx.annotation.*;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.*;
import com.testingappforlampalampa.R;
import com.testingappforlampalampa.model.IGetterJSON;
import com.testingappforlampalampa.model.Model;
import com.testingappforlampalampa.view.adapter.RVAdapter;

import java.util.*;

import retrofit2.*;
import retrofit2.converter.gson.GsonConverterFactory;

public class FavoriteFragment extends Fragment {

    private List<Model> favorite;
    private RecyclerView rv;

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
        favorite = new ArrayList<>();
        getRetrofit();
        return view;
    }


    public void getRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IGetterJSON iGetterJSON = retrofit.create(IGetterJSON.class);
        Call<List<Model>> call = iGetterJSON.getList();
        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call,
                                   Response<List<Model>> response) {
                if (!response.isSuccessful()) {
                    return;
                }
                String title, img, click_url, time, type;
                List<Model> posts = response.body();
                for (Model model : posts) {

                    title = model.getTitle();
                    time = model.getTime();
                    img = model.getImg();
                    click_url = model.getClick_url();
                    type = model.getType();
                    if (model.getType().equals(TYPE_FAVOURITES)) {
                        model = new Model(title, img, click_url, time, type);
                        favorite.add(model);
                    }
                }
                initRecyclerView(favorite);
            }

            @Override
            public void onFailure(Call<List<Model>> call,
                                  Throwable t) {
            }
        });
    }
    private void initRecyclerView(List<Model> list){
        RVAdapter adapter = new RVAdapter(list);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(adapter);
    }
}
