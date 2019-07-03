package com.example.android.myndapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.android.myndapplication.R;
import com.example.android.myndapplication.fragments.AccountFragment;
import com.example.android.myndapplication.fragments.ChatFragment;
import com.example.android.myndapplication.fragments.MainFragment;
import com.example.android.myndapplication.fragments.NotificationFragment;
import com.example.android.myndapplication.fragments.SellFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private BottomNavigationView bottomNavigationView;
    private MainFragment mainFragment = MainFragment.newInstance();
    private AccountFragment accountFragment = AccountFragment.newInstance();
    private SellFragment sellFragment = SellFragment.newInstance();
    private ChatFragment chatFragment = ChatFragment.newInstance();
    private NotificationFragment notificationFragment = NotificationFragment.newInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // launch the introActivity
        Intent intent = new Intent(this, IntroActivity.class);
        startActivity(intent);


        drawer = findViewById(R.id.drawer_layout);

        ImageButton menuRight = findViewById(R.id.leftRight);
        menuRight.setOnClickListener(v -> {
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                drawer.openDrawer(GravityCompat.START);
            }
        });

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        bottomNavigationView = findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.action_announces:
                    selectedFragment = mainFragment;
                    break;
                case R.id.action_account:
                    selectedFragment = accountFragment;
                    break;
                case R.id.action_sell:
                    selectedFragment = sellFragment;
                    break;
                case R.id.action_chat:
                    selectedFragment = chatFragment;
                    break;
                case R.id.action_notifications:
                    selectedFragment = notificationFragment;
                    break;
            }
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if (selectedFragment != null) {
                transaction.replace(R.id.f_container, selectedFragment);
                transaction.commit();
            }
            return true;
        });

        //Manually displaying the first fragment - one time only
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.f_container, mainFragment);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawer.closeDrawers();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        switch (item.getItemId()) {
            case R.id.nav_announces:
                bottomNavigationView.setSelectedItemId(R.id.action_announces);
                ft.replace(R.id.f_container, mainFragment);
                break;
            case R.id.nav_account:
                bottomNavigationView.setSelectedItemId(R.id.action_account);
                ft.replace(R.id.f_container, accountFragment);
                break;
            case R.id.nav_sell:
                bottomNavigationView.setSelectedItemId(R.id.action_sell);
                ft.replace(R.id.f_container, sellFragment);
                break;
            case R.id.nav_chat:
                bottomNavigationView.setSelectedItemId(R.id.action_chat);
                ft.replace(R.id.f_container, chatFragment);
                break;
            case R.id.nav_notifications:
                bottomNavigationView.setSelectedItemId(R.id.action_notifications);
                ft.replace(R.id.f_container, notificationFragment);
                break;
        }

        ft.commit();
        return true;
    }
}
