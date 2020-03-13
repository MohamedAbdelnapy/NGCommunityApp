package com.example.ngcommunityapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.ngcommunityapp.Fragments.DiscoverFragment;
import com.example.ngcommunityapp.Fragments.NotificationFragment;
import com.example.ngcommunityapp.Fragments.ServicesFragment;
import com.example.ngcommunityapp.Fragments.ShopFragment;
import com.example.ngcommunityapp.Fragments.TimelineFragment;
import com.example.ngcommunityapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private BottomNavigationView bottomNavigationView;
    private TimelineFragment timelineFragment;
    private ServicesFragment servicesFragment;
    private ShopFragment shopFragment;
    private DiscoverFragment discoverFragment;
    private NotificationFragment notificationFragment;
    private ImageView openNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openNav = findViewById(R.id.open_navigation);
        bottomNavigationView = findViewById(R.id.nav_buttons);

        openNav.setOnClickListener(this);

        timelineFragment =new TimelineFragment();
        servicesFragment = new ServicesFragment();
        shopFragment = new ShopFragment();
        discoverFragment = new DiscoverFragment();
        notificationFragment = new NotificationFragment();


        SetFragment(timelineFragment);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){

                    case R.id.nav_timeline :
                        SetFragment(timelineFragment);
                        return true;

                    case R.id.nav_services :
                        SetFragment(servicesFragment);
                        return true;

                    case R.id.nav_shop :
                        SetFragment(shopFragment);
                        return true;

                    case R.id.nav_discover :
                        SetFragment(discoverFragment);
                        return true;

                    case R.id.nav_notification :
                        SetFragment(notificationFragment);
                        return true;
                }
                return false;
            }
        });
    }

    private void SetFragment(Fragment fragment){

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container,fragment);
        transaction.commit();

    }

    @Override
    public void onClick(View v) {


    }
}
