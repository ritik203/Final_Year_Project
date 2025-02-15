package com.example.mobileshop.Activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.example.mobileshop.MobileFragmentAdapter;
import com.example.mobileshop.R;
import com.example.mobileshop.fragments.MobileListFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class HomeActivity extends AppCompatActivity {
     TabLayout tabLayout;
     ViewPager2 viewPager2;
     MobileFragmentAdapter mobileFragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        tabLayout=findViewById(R.id.tabLayout);
        viewPager2=findViewById(R.id.viewPager2);
        mobileFragmentAdapter=new MobileFragmentAdapter(this);
        viewPager2.setAdapter(mobileFragmentAdapter);
        new TabLayoutMediator(tabLayout,viewPager2,(tab, position) ->
        {
            switch (position){
                case 0:
                    tab.setIcon(R.drawable.list);
                    break;
                case 1:
                    tab.setIcon(R.drawable.cart);
                    break;
                case 2:
                    tab.setIcon(R.drawable.person);
                    break;
            }
        }).attach();




    }
}