package co.id.bbw.myapplication.adapter;

import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import co.id.bbw.myapplication.fragment.HomeCruchFragment;
import co.id.bbw.myapplication.fragment.HomeFragment;
import co.id.bbw.myapplication.fragment.HomeNasionalFragment;
import co.id.bbw.myapplication.fragment.SearchAllFragment;
import co.id.bbw.myapplication.fragment.SearchCruchClubFragment;
import co.id.bbw.myapplication.fragment.SearchNasionalFragment;
import co.id.bbw.myapplication.fragment.SearchPersonalFragment;

public class ProfilePagerAdapter extends FragmentPagerAdapter {

    public ProfilePagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new SearchAllFragment();
                break;
            case 1:
                fragment = new HomeNasionalFragment();
                break;
            case 2:
                fragment = new HomeCruchFragment();


        }
        return fragment;
    }



//    @Nullable
//    @Override
//    public CharSequence getPageTitle(int position) {
//        switch (position) {
//            case 0:
//                return "All";
//            case 1:
//                return "Personal";
//
//        }
//        return null;
//    }

    @Override
    public int getCount() {
        return 3;
    }
}
