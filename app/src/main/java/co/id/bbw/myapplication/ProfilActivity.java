package co.id.bbw.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import co.id.bbw.myapplication.adapter.ProfilePagerAdapter;

public class ProfilActivity extends AppCompatActivity {
    TabLayout tabs;
    Button btnEditProfile;
    Toolbar toolbar;
    AppBarLayout app_bar_layout;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        btnEditProfile = findViewById(R.id.btnEdit);
        btnEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfilActivity.this, EditProfileActivity.class);
                startActivity(intent);
            }
        });


        ViewPager viewPager = findViewById(R.id.vp);
        FragmentManager manager = getSupportFragmentManager();
        ProfilePagerAdapter profilePagerAdapter = new ProfilePagerAdapter(manager, 1);
        viewPager.setAdapter(profilePagerAdapter);

        tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        tabs.setSelectedTabIndicatorColor(getApplicationContext().getResources().getColor(R.color.blue));
        tabs.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.white));
        tabs.setTabTextColors(getApplicationContext().getResources().getColor(R.color.black), getApplicationContext().getResources().getColor(R.color.black));

        setupTabIcons();

        allotEachTabWithEqualWidth();
//
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        toolbar.setTitle("Detail Movie");
//        setSupportActionBar(toolbar);
//        if (getSupportActionBar() != null) getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
//
//    @Override
//    public boolean onSupportNavigateUp() {
//        onBackPressed();
//        return true;
//    }
//
//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        finish(); // or your code
//    }

    private void allotEachTabWithEqualWidth() {

        ViewGroup slidingTabStrip = (ViewGroup) tabs.getChildAt(0);
        for (int i = 0; i < tabs.getTabCount(); i++) {
            View tab = slidingTabStrip.getChildAt(i);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tab.getLayoutParams();
            layoutParams.weight = 1;
            tab.setLayoutParams(layoutParams);
        }

    }

    private void setupTabIcons() {
        tabs.getTabAt(0).setIcon(R.drawable.ic_grid);
        tabs.getTabAt(1).setIcon(R.drawable.ic_grid);
        tabs.getTabAt(2).setIcon(R.drawable.ic_grid);

    }
}
