package com.cookandroid.hanium;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class recommendSearchFragment extends Fragment {
        private Button back_btn, search_btn;
        MainActivity mainActivity;
        String id, sql;
        recommendInitialFragment recommendInitialFragment = new recommendInitialFragment();



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
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View v = inflater.inflate(R.layout.fragment_recommend_search, container, false);
            back_btn = v.findViewById(R.id.search_back_btn);
            search_btn = v.findViewById(R.id.search_btn);
            back_btn.setOnClickListener(onClickListener);
            search_btn.setOnClickListener(onClickListener);
            sql ="SELECT * FROM info.RR_info where `id` not in (?) and sex = (select sex from info.RR_info where `id`=?);" ;
            Bundle bundle = getArguments();
            id = bundle.getString("id");

            return v;


        }
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()){
                    case R.id.search_back_btn:
                        mainActivity.onClickBackBtn();
                        break;
                    case R.id.search_btn:
                        Intent intent = new Intent();
                        intent.putExtra("sql",sql);
                        mainActivity.setIntent(intent);
                        mainActivity.onClickBackBtn();
                        break;
                }
            }

        };
    }
