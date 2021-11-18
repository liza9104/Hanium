package com.cookandroid.hanium;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class freeBulletinRegisterFragment extends Fragment {
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
    View v = inflater.inflate(R.layout.fragment_free_register, container, false);


    return v;
}
}
