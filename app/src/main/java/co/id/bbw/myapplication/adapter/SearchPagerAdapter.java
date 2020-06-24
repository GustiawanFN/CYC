package co.id.bbw.myapplication.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import co.id.bbw.myapplication.R;
import co.id.bbw.myapplication.fragment.CruchClubFragment;
import co.id.bbw.myapplication.fragment.SearchAllFragment;
import co.id.bbw.myapplication.fragment.SearchCruchClubFragment;
import co.id.bbw.myapplication.fragment.SearchNasionalFragment;
import co.id.bbw.myapplication.fragment.SearchPersonalFragment;

public class SearchPagerAdapter extends FragmentPagerAdapter {


    public SearchPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }


    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new SearchAllFragment();
                break;
            case 1:
                fragment = new SearchPersonalFragment();
                break;
            case 2:
               fragment = new SearchCruchClubFragment();
               break;
            case 3:
                fragment = new SearchNasionalFragment();

        }
        return fragment;
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

    @Override
    public int getCount() {
        return 4;
    }
}
