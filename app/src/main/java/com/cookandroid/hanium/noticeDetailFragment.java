package com.cookandroid.hanium;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass.
 */
public class noticeDetailFragment extends Fragment {


    public noticeDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // LayoutInflater 사용해 Resource Layout을 View로 변환해준 후 findViewById() 호출
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notice_detail, container, false);

        // ListView 아이템에 표시될 사용자 테이터 정의
        String[] menuItems = {"2021학년도 동계방학 기숙사 합격자",  "즐거운 기숙사 생활을 위해 활용해보기", "생활원 통합행정실 운영시간 안내","코로나 19 문진표 작성안내", "2021 천원의 아침밥 운영안내",

                "2021학년도 기숙사 선발생 사전안내", "생활원 중간고사 격려 간식나눔 이벤트", "입사포기 및 중도퇴사 기숙사 사용료 환불 기준 안내","동계방학중 제 1기숙사 생활치료센터 활용안내",
                "동계방학기간 입사 미 신청자 안내",  " PCR 결과서 제출안내", "기숙사 추가선발 안내", "추가선발자 안내","2021학년도 동계방학 기숙사 합격자",  "즐거운 기숙사 생활을 위해 활용해보기", "생활원 통합행정실 운영시간 안내","코로나 19 문진표 작성안내", "2021 천원의 아침밥 운영안내",

                "2021학년도 기숙사 선발생 사전안내", "생활원 중간고사 격려 간식나눔 이벤트", "입사포기 및 중도퇴사 기숙사 사용료 환불 기준 안내","동계방학중 제 1기숙사 생활치료센터 활용안내",
                "동계방학기간 입사 미 신청자 안내",  " PCR 결과서 제출안내", "기숙사 추가선발 안내", "추가선발자 안내",};

        ListView listView = (ListView) view.findViewById(R.id.mainMenu);

        // 데이터 입력받을 Adapter 생성
        // fragment에서는 'this' 사용이 불가하므로, Activity의 참조 획득이 가능한 getActivity()함수 사용
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, menuItems);

        listView.setAdapter(listViewAdapter);

        return view;
    }
}