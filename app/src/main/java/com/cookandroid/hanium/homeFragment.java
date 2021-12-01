package com.cookandroid.hanium;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class homeFragment extends Fragment {
    MainActivity mainActivity;
    TextView menu_detail;
    TextView notice_detail;

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
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        // ListView 아이템에 표시될 사용자 테이터 정의
        String[] menuItems = {"2021학년도 동계방학 기숙사 합격자",  "즐거운 기숙사 생활을 위해 활용해보기", "생활원 통합행정실 운영시간 안내","코로나 19 문진표 작성안내", "2021 천원의 아침밥 운영안내",

                "2021학년도 기숙사 선발생 사전안내"};

        ListView listView = (ListView) v.findViewById(R.id.mainMenu);

        // 데이터 입력받을 Adapter 생성
        // fragment에서는 'this' 사용이 불가하므로, Activity의 참조 획득이 가능한 getActivity()함수 사용
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, menuItems);

        listView.setAdapter(listViewAdapter);


        // Inflate the layout for this fragment


        menu_detail = v.findViewById(R.id.menu_detail);
        menu_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.onClickMenuDetail();
            }

        });
        notice_detail = v.findViewById(R.id.notice_detail);
        notice_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.onClickNoticeDetail();
            }

        });

        return v;
    }

}