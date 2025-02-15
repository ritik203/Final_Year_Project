package com.example.mobileshop;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.mobileshop.fragments.MobileListFragment;
import com.example.mobileshop.fragments.OrdersFragment;
import com.example.mobileshop.fragments.ProfileFragment;

public class MobileFragmentAdapter extends FragmentStateAdapter {


    public MobileFragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new MobileListFragment();
            case 1:
                return new OrdersFragment();
            case 2:
                return new ProfileFragment();


        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
