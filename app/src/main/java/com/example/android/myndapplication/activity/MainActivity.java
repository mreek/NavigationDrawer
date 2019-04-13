package com.example.android.myndapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.myndapplication.fragments.AccountFragment;
import com.example.android.myndapplication.fragments.ChatFragment;
import com.example.android.myndapplication.fragments.MainFragment;
import com.example.android.myndapplication.fragments.MainFragmentTab;
import com.example.android.myndapplication.R;
import com.example.android.myndapplication.fragments.NotificationFragment;
import com.example.android.myndapplication.fragments.SellFragment;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private TextView appBarTV;



    private static final String TAG = "MyActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // launch the introActivity
        Intent intent= new Intent(this,IntroActivity.class);
        startActivity(intent);


        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        appBarTV = findViewById(R.id.appbar_text_view);

        ImageButton menuRight = findViewById(R.id.leftRight);
        menuRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    drawer.openDrawer(GravityCompat.START);
                }
            }
        });

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.action_item1:
                                selectedFragment = MainFragment.newInstance();
                               // Log.v(TAG, "lwl" );
                                break;
                            case R.id.action_item2:
                                selectedFragment = AccountFragment.newInstance();
                                //Log.v(TAG, "tani" );
                                break;
                            case R.id.action_item3:
                                selectedFragment = SellFragment.newInstance();
                                //Log.v(TAG, "talet" );
                                break;

                            case R.id.action_item4:
                                selectedFragment = ChatFragment.newInstance();
                                //Log.v(TAG, "talet" );
                                break;

                            case R.id.action_item5:
                                selectedFragment = NotificationFragment.newInstance();
                                //Log.v(TAG, "talet" );
                                break;
                        }
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.f_container, selectedFragment);
                        transaction.commit();
                        return true;
                    }
                });

        //Manually displaying the first fragment - one time only
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.f_container, MainFragment.newInstance());
        transaction.commit();

        //Used to select an item programmatically
        //bottomNavigationView.getMenu().getItem(2).setChecked(true);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        drawer.closeDrawers();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.nav_camera) {
           // appBarTV.setText("Main Page");
            MainFragment fragment = new MainFragment();
            ft.replace(R.id.f_container, fragment);
            ft.commit();

        } else if (id == R.id.nav_gallery) {
            //appBarTV.setText("Fragment With Tabs");
            ChatFragment fragment = new ChatFragment();
            ft.replace(R.id.f_container, fragment);
            ft.commit();

        } else if (id == R.id.nav_slideshow) {
            //appBarTV.setText("Slideshow Page");
            //AccountFragment
            //Toast.makeText(this, "Slideshow", Toast.LENGTH_SHORT).show();
            AccountFragment fragmentTab = new AccountFragment();
            ft.replace(R.id.f_container, fragmentTab);
            ft.commit();
        } else if (id == R.id.nav_manage) {
            //appBarTV.setText("Tools Page");
           // Toast.makeText(this, "Contactez_nous Activity", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_share) {
            //appBarTV.setText("Share Page");
            Toast.makeText(this, "Partager", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_send) {
            //appBarTV.setText("Send");
            Toast.makeText(this, "Rate 5 stars", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
