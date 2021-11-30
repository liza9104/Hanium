package com.cookandroid.hanium;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class menuDetailFragment extends Fragment {
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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_menu_detail, container, false);
        Button btn_morninggood;
        Button btn_lunchgood;
        Button btn_dinnergood;



        btn_morninggood = v.findViewById(R.id.morninggood);
        btn_lunchgood = v.findViewById(R.id.lunchgood);
        btn_dinnergood = v.findViewById(R.id.dinnergood);


        btn_morninggood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"감사합니다!", Toast.LENGTH_SHORT).show();
            }
        });
        btn_lunchgood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"감사합니다!", Toast.LENGTH_SHORT).show();
            }
        });
        btn_dinnergood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"감사합니다!", Toast.LENGTH_SHORT).show();
            }
        });




        return v;
        }
}
