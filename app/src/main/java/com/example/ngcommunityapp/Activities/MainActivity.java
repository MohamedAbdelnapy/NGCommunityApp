package com.example.ngcommunityapp.Activities;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.ngcommunityapp.Fragments.CommunityFragment;
import com.example.ngcommunityapp.Fragments.DiscoverFragment;
import com.example.ngcommunityapp.Fragments.IdentifyBadgeFragment;
import com.example.ngcommunityapp.Fragments.InviteToLiveFragment;
import com.example.ngcommunityapp.Fragments.ManageGatesFragment;
import com.example.ngcommunityapp.Fragments.NeighborsFragment;
import com.example.ngcommunityapp.Fragments.NotificationFragment;
import com.example.ngcommunityapp.Fragments.ReportIssueFragment;
import com.example.ngcommunityapp.Fragments.ServicesFragment;
import com.example.ngcommunityapp.Fragments.ShopFragment;
import com.example.ngcommunityapp.Fragments.SupportFragment;
import com.example.ngcommunityapp.Fragments.TimelineFragment;
import com.example.ngcommunityapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private BottomNavigationView bottomNavigationView;
    private ImageView openNav;
    private DrawerLayout drawerLayout;
    private TimelineFragment timelineFragment;
    private ServicesFragment servicesFragment;
    private ShopFragment shopFragment;
    private DiscoverFragment discoverFragment;
    private NotificationFragment notificationFragment;
    private NeighborsFragment neighborsFragment;
    private CommunityFragment communityFragment;
    private InviteToLiveFragment inviteToLiveFragment;
    private ManageGatesFragment manageGatesFragment;
    private ReportIssueFragment reportIssueFragment;
    private IdentifyBadgeFragment identifyBadgeFragment;
    private SupportFragment supportFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openNav = findViewById(R.id.open_navigation);
        bottomNavigationView = findViewById(R.id.nav_buttons);

        openNav.setOnClickListener(this);
        drawerLayout = findViewById(R.id.drawerLayout);

        timelineFragment = new TimelineFragment();
        SetFragment(timelineFragment);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){

                    case R.id.b_nav_timeline:
                        SetFragment(timelineFragment);
                        return true;

                    case R.id.b_nav_services:
                        servicesFragment = new ServicesFragment();
                        SetFragment(servicesFragment);
                        return true;

                    case R.id.b_nav_shop:
                        shopFragment = new ShopFragment();
                        SetFragment(shopFragment);
                        return true;

                    case R.id.b_nav_discover:
                        discoverFragment = new DiscoverFragment();
                        SetFragment(discoverFragment);
                        return true;

                    case R.id.b_nav_notification:
                        notificationFragment = new NotificationFragment();
                        SetFragment(notificationFragment);
                        return true;
                }
                return false;
            }
        });


        NavigationView navigationView = findViewById(R.id.navigationView);
        // navigationView.setItemIconTintList(null);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.nav_neighbors:
                        neighborsFragment = new NeighborsFragment();
                        SetFragment(neighborsFragment);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;

                    case R.id.nav_community_info:
                        communityFragment = new CommunityFragment();
                        SetFragment(communityFragment);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;

                    case R.id.nav_invite_toLive:
                        inviteToLiveFragment = new InviteToLiveFragment();
                        SetFragment(inviteToLiveFragment);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;

                    case R.id.nav_manage_gate_pass:
                        manageGatesFragment = new ManageGatesFragment();
                        SetFragment(manageGatesFragment);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;

                    case R.id.nav_report_issue:
                        reportIssueFragment = new ReportIssueFragment();
                        SetFragment(reportIssueFragment);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;

                    case R.id.nav_identify_badge:
                        identifyBadgeFragment = new IdentifyBadgeFragment();
                        SetFragment(identifyBadgeFragment);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;

                    case R.id.nav_support:
                        supportFragment = new SupportFragment();
                        SetFragment(supportFragment);
                        drawerLayout.closeDrawer(GravityCompat.START);
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

        switch (v.getId()) {
            case R.id.open_navigation:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
        }


    }
}
