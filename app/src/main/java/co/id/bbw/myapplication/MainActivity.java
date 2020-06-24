package co.id.bbw.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import co.id.bbw.myapplication.fragment.HomeFragment;
import co.id.bbw.myapplication.fragment.MainFragment;
import co.id.bbw.myapplication.fragment.MoreFragment;
import co.id.bbw.myapplication.fragment.NotificationFragment;
import co.id.bbw.myapplication.fragment.SearchFragment;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new HomeFragment());



        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setItemIconTintList(null);
    }

    private void loadFragment(Fragment fragment) {

        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment, fragment.getClass().getSimpleName());
        // transaction.addToBackStack(null);
        transaction.commit();
    }

    //Bottom Navigation
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {

                case R.id.navigation_beranda:
                    HomeFragment mainFragment = new HomeFragment();
                    loadFragment(mainFragment);
                    return true;

                case R.id.navigation_more:
                    MoreFragment moreFragment = new MoreFragment();
                    loadFragment(moreFragment);
                    return true;

                case R.id.navigation_browse:
                    SearchFragment searchFragment = new SearchFragment();
                    loadFragment(searchFragment);
                    return true;

                case R.id.navigation_notification:
                    NotificationFragment notificationFragment = new NotificationFragment();
                    loadFragment(notificationFragment);
                    return true;


            }

            return false;
        }
    };
}
