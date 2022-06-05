package com.example.mypostuz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.content.Intent;
import android.hardware.input.InputManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.example.mypostuz.databinding.ActivityAsosiyBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Asosiy extends AppCompatActivity {
    ActivityAsosiyBinding binding;
    Fragment fragment = new Home();
    boolean ispressed=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAsosiyBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();
        setContentView(v);
        BadgeDrawable badgeDrawable = binding.bottom.getOrCreateBadge(R.id.notif);
        badgeDrawable.setVisible(true);
        badgeDrawable.setNumber(9);
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, fragment).commit();


        binding.bottom.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.asosiy:
                        fragment = new Home();
                        closekey();
                        break;
                    case R.id.qid:
                        fragment = new Qidiruv();
                        break;
                    case R.id.yuk:
                        fragment = new Post();
                        closekey();
                        break;
                    case R.id.notif:
                        fragment = new Eslatma();
                        closekey();
                        break;
                    case R.id.his:
                        fragment = new Hisob();
                        closekey();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, fragment).commit();
                return true;
            }
        });

    }

    public void closekey() {
        View v = this.getCurrentFocus();
        if (v != null) {
            InputMethodManager manager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            manager.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
    }

    @Override
    public void onBackPressed() {

        if (ispressed) {
            finishAffinity();
        } else {
            ispressed = true;
            Toast.makeText(this, "chiqish uchun yana bir marta bosing !", Toast.LENGTH_SHORT).show();
        }
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                ispressed = false;
            }
        };
        new Handler().postDelayed(runnable, 2000);
    }
}