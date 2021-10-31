package com.cookandroid.hanium;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class recommendInitialFragment extends Fragment {
    MainActivity mainActivity;
    ServiceApi service;
    RecyclerView recyclerView;
    String id;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mainActivity = null;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_recommend_initial, container, false);
        recyclerView = v.findViewById(R.id.recyclerview);
        Button myBtn = v.findViewById(R.id.my_btn);
        Button searchBtn = v.findViewById(R.id.search_btn);
        final ArrayList<RecommendData> arrayList = new ArrayList<>();
        service = RetrofitClient.getClient().create(ServiceApi.class);

        Bundle bundle = getArguments();
        id = bundle.getString("id");



        service.getRecommendList(id).enqueue(new Callback<RecommendResponse>() {
            @Override
            public void onResponse(Call<RecommendResponse> call, Response<RecommendResponse> response) {
                if(response.isSuccessful()){
                    RecommendResponse result = response.body();


                    for(int i = 0 ; i<result.getData().size(); i++) {
                            arrayList.add(result.getData().get(i));
                    }

                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    RecyclerViewAdapter adapter = new RecyclerViewAdapter(arrayList);
                    recyclerView.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<RecommendResponse> call, Throwable t) {
                    Log.d("test","실패");
            }
        });



        myBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.onClickMyBtn();
            }
        });

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    mainActivity.onClickSearchBtn();
            }
        });

        return v;
    }


}
