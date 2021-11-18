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
    private TextView tvCount,tvCount2 ,tvCount3 ;
    private Button btnAdd,  btnMinus, btnAdd2, btnAdd3,btnMinus2,btnMinus3;
    private int count=0;


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
    tvCount = v.findViewById(R.id.tv_count);
    tvCount.setText(count + "");
    tvCount3 = v.findViewById(R.id.josik);
    tvCount.setText(count + "");
    tvCount2 = v.findViewById(R.id.lunch);
    tvCount.setText(count + "");
    btnAdd = v.findViewById(R.id.btn_add);
    btnMinus = v.findViewById(R.id.btn_minus);
    btnAdd2 = v.findViewById(R.id.btn_add2);
    btnMinus2 = v.findViewById(R.id.btn_minus2);
    btnAdd3 = v.findViewById(R.id.btn_add3);
    btnMinus3 = v.findViewById(R.id.btn_minus3);

    btnAdd.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            count++;
            tvCount.setText(count + "");
        }
    });

    btnMinus.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (count > 0) {
                count--;
                tvCount.setText(count + "");
            }
        }
    });
    btnAdd2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            count++;
            tvCount2.setText(count + "");
        }
    });

    btnAdd3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            count++;
            tvCount3.setText(count + "");
        }
    });
    btnMinus2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (count > 0) {
                count--;
                tvCount2.setText(count + "");
            }
        }
    });
    btnMinus3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (count > 0) {
                count--;
                tvCount3.setText(count + "");
            }
        }
    });



    return v;
    }
}
