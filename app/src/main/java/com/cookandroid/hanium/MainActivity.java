package com.cookandroid.hanium;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager = getSupportFragmentManager();
    homeFragment homeFragment = new homeFragment();
    bulletinFragment bulletinFragment = new bulletinFragment();
    recommendInitialFragment rrInitialFragment = new recommendInitialFragment();
    myPageFragment myPageFragment = new myPageFragment();
    recommendFragment rrFragment = new recommendFragment();
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String id;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, homeFragment).commitAllowingStateLoss();

        sharedPreferences = getSharedPreferences("preferences", MODE_PRIVATE);
        id = sharedPreferences.getString("id",null);


        Bundle bundle = new Bundle();
        bundle.putString("id",id);
        rrFragment.setArguments(bundle);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                switch(item.getItemId()){
                    case R.id.home:
                        transaction.replace(R.id.frameLayout, homeFragment).commitAllowingStateLoss();
                        break;
                    case R.id.bulletin:
                        transaction.replace(R.id.frameLayout, bulletinFragment).commitAllowingStateLoss();
                        break;
                    case R.id.rr:
                        transaction.replace(R.id.frameLayout, rrInitialFragment).commitAllowingStateLoss();
                        break;
                    case R.id.myPage:
                        transaction.replace(R.id.frameLayout, myPageFragment).commitAllowingStateLoss();
                        break;
                }

                return true;
            }
        });


    }
    public void onClickMyBtn(){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_left);
        fragmentTransaction.replace(R.id.frameLayout,rrFragment).commitAllowingStateLoss();
    }
    public void onClickBackBtn(){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter_from_left,R.anim.exit_to_right);
        fragmentTransaction.replace(R.id.frameLayout,rrInitialFragment).commitAllowingStateLoss();
    }
}
