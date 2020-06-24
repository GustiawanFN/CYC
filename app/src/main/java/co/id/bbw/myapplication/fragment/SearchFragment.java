package co.id.bbw.myapplication.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import co.id.bbw.myapplication.R;
import co.id.bbw.myapplication.adapter.SearchPagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {
    TextView searchHere;


    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_search, container, false);

        ViewPager viewPager = v.findViewById(R.id.vp);
        searchHere = v.findViewById(R.id.searchHere);
        searchHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailSearchFragment detailSearchFragment = new DetailSearchFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_container, detailSearchFragment, "findThisFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });

        FragmentManager manager = getChildFragmentManager();
        SearchPagerAdapter adapter = new SearchPagerAdapter(manager, 1);
        viewPager.setAdapter(adapter);

//        searchView = v.findViewById(R.id.searchView);
//        ImageView searchIcon = searchView.findViewById(R.id.search_button);
//        searchIcon.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.ic_search_black_24dp));
//
//        EditText searchEditText = searchView.findViewById(R.id.search_src_text);
//        searchEditText.setTextColor(getResources().getColor(R.color.black));
//        searchEditText.setHintTextColor(getResources().getColor(R.color.black));

        TabLayout tabs = v.findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        tabs.setSelectedTabIndicatorColor(getActivity().getResources().getColor(R.color.blue));
        tabs.setBackgroundColor(getActivity().getResources().getColor(R.color.white));
        tabs.setTabTextColors(getActivity().getResources().getColor(R.color.black), getActivity().getResources().getColor(R.color.black));


//        getSupportActionBar().setElevation(0);


        return v;
    }
}
