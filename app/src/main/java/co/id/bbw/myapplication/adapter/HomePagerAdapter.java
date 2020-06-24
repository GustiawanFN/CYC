package co.id.bbw.myapplication.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import co.id.bbw.myapplication.fragment.HomeAllFragment;
import co.id.bbw.myapplication.fragment.HomeCruchFragment;
import co.id.bbw.myapplication.fragment.HomeNasionalFragment;
import co.id.bbw.myapplication.fragment.HomePersonalFragment;

public class HomePagerAdapter extends FragmentPagerAdapter {

    public HomePagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new HomeAllFragment();
                break;
            case 1:
                fragment = new HomePersonalFragment();
                break;
            case 2:
                fragment = new HomeCruchFragment();
                break;
            case 3:
                fragment = new HomeNasionalFragment();

        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "All";
            case 1:
                return "Personal";
            case 2:
                return "Cruch Club";
            case 3:
                return "Nasional";
        }
        return null;
    }
}
