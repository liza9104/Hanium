package com.cookandroid.hanium;

import android.content.Context;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

    public class freeBulletinFragment extends Fragment {
    MainActivity mainActivity;
    Button free_new_btn;

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
        View v = inflater.inflate(R.layout.fragment_free_bulletin, container, false);
        free_new_btn = v.findViewById(R.id.free_new);
        free_new_btn.setOnClickListener(onClickListener);
        return v;
    }

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()){
                    case R.id.free_new:
                        mainActivity.onClickFreeBulletinRegister();
                        break;

                }
            }

        };
}
