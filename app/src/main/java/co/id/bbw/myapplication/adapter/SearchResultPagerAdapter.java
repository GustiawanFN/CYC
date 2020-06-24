package co.id.bbw.myapplication.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import co.id.bbw.myapplication.fragment.ResultSearchAllFragment;
import co.id.bbw.myapplication.fragment.SearchAllFragment;
import co.id.bbw.myapplication.fragment.SearchCruchClubFragment;
import co.id.bbw.myapplication.fragment.SearchNasionalFragment;
import co.id.bbw.myapplication.fragment.SearchPersonalFragment;

public class SearchResultPagerAdapter extends FragmentPagerAdapter {

    public SearchResultPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new ResultSearchAllFragment();
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
