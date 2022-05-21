package com.example.mypostuz;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PagerAdapter extends FragmentStateAdapter {
    public PagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new Home();
            case 1:
                return new Qidiruv();
            case 2:
                return new Post();
            case 3:
                return new Eslatma();
            case 4:
                return new Hisob();
            default:
                return new Home();

        }

    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
