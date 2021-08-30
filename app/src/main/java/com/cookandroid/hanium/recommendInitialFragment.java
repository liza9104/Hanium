package com.cookandroid.hanium;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class recommendInitialFragment extends Fragment {
    MainActivity mainActivity;
    ServiceApi service;
    RecyclerView recyclerView;

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
        final ArrayList<RecommendData> arrayList = new ArrayList<>();
        service = RetrofitClient.getClient().create(ServiceApi.class);
        service.getRecommendList().enqueue(new Callback<RecommendResponse>() {
            @Override
            public void onResponse(Call<RecommendResponse> call, Response<RecommendResponse> response) {
                if(response.isSuccessful()){
                    for(int i = 0 ; i<response.body().getData().size(); i++) {
                        arrayList.add(response.body().getData().get(i));
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

        //arrayList.add(new RecommendData("201701654","여성","2기숙사","비흡연자","코골이","일부 허용","9시~12시","매일","매일","제목","내용"));




        myBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.onClickMyBtn();
            }
        });

        return v;
    }


}
