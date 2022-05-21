package com.example.mypostuz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.hardware.input.InputManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.example.mypostuz.databinding.ActivityAsosiyBinding;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.navigation.NavigationBarView;

public class Asosiy extends AppCompatActivity {
    ActivityAsosiyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAsosiyBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();
        setContentView(v);
        BadgeDrawable badgeDrawable = binding.bottom.getOrCreateBadge(R.id.notif);
        badgeDrawable.setVisible(true);
        badgeDrawable.setNumber(9);

        PagerAdapter pagerAdapter = new PagerAdapter(this);
        binding.pager2.setAdapter(pagerAdapter);
        binding.bottom.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.asosiy:
                        binding.pager2.setCurrentItem(0);
                        binding.liner.setVisibility(View.VISIBLE);
                        closekey();
                        break;
                    case R.id.qid:
                        binding.pager2.setCurrentItem(1);
                        binding.liner.setVisibility(View.GONE);
                        break;
                    case R.id.yuk:
                        binding.pager2.setCurrentItem(2);
                        binding.liner.setVisibility(View.GONE);
                        closekey();
                        break;
                    case R.id.notif:
                        binding.pager2.setCurrentItem(3);
                        binding.liner.setVisibility(View.GONE);
                        closekey();
                        break;
                    case R.id.his:
                        binding.pager2.setCurrentItem(4);
                        binding.liner.setVisibility(View.GONE);
                        closekey();
                        break;
                }
                return true;
            }
        });
        binding.pager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case 0:
                        binding.bottom.setSelectedItemId(R.id.asosiy);
                        binding.liner.setVisibility(View.VISIBLE);
                        closekey();
                        break;
                    case 1:
                        binding.bottom.setSelectedItemId(R.id.qid);
                        binding.liner.setVisibility(View.GONE);
                        break;
                    case 2:
                        binding.bottom.setSelectedItemId(R.id.yuk);
                        binding.liner.setVisibility(View.GONE);
                        closekey();
                        break;
                    case 3:
                        binding.bottom.setSelectedItemId(R.id.notif);
                        binding.liner.setVisibility(View.GONE);
                        closekey();
                        break;
                    case 4:
                        binding.bottom.setSelectedItemId(R.id.his);
                        binding.liner.setVisibility(View.GONE);
                        closekey();
                        break;
                }

            }
        });

    }
    public void closekey(){
        View v=this.getCurrentFocus();
        if (v!=null){
            InputMethodManager manager= (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            manager.hideSoftInputFromWindow(v.getWindowToken(),0);
        }
    }
}