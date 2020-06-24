package co.id.bbw.myapplication.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.material.tabs.TabLayout;

import co.id.bbw.myapplication.R;
import co.id.bbw.myapplication.adapter.ProfilePagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class FriendsFragment extends Fragment {
    TabLayout tabs;
    Button btnEditProfile;

    public FriendsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_friends, container, false);

        ViewPager viewPager = v.findViewById(R.id.vp);

        FragmentManager manager = getChildFragmentManager();
        ProfilePagerAdapter profilePagerAdapter = new ProfilePagerAdapter(manager, 1);
        viewPager.setAdapter(profilePagerAdapter);

        tabs = v.findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        tabs.setSelectedTabIndicatorColor(getActivity().getResources().getColor(R.color.blue));
        tabs.setBackgroundColor(getActivity().getResources().getColor(R.color.white));
        tabs.setTabTextColors(getActivity().getResources().getColor(R.color.black), getActivity().getResources().getColor(R.color.black));

        setupTabIcons();

        allotEachTabWithEqualWidth();
        return v;
    }


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
