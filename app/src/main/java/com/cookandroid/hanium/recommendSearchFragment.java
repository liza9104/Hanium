package com.cookandroid.hanium;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

    public class recommendSearchFragment extends Fragment {
        private Button back_btn, filtering_btn;
        MainActivity mainActivity;
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
            filtering_btn = v.findViewById(R.id.filtering_btn);

            back_btn.setOnClickListener(onClickListener);
            filtering_btn.setOnClickListener(onClickListener);


            return v;


        }
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()){
                    case R.id.search_back_btn:
                        mainActivity.onClickBackBtn();
                        break;
                    case R.id.filtering_btn:
                        Intent intent = new Intent(v.getContext(), FilteringPopUp.class);
                        startActivity(intent);
                        break;
                }
            }

        };
    }
