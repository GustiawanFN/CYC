package co.id.bbw.myapplication.fragment;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import co.id.bbw.myapplication.R;
import co.id.bbw.myapplication.adapter.SearchPagerAdapter;
import co.id.bbw.myapplication.adapter.SearchResultPagerAdapter;
import co.id.bbw.myapplication.model_dummy.ModelPost;
import co.id.bbw.myapplication.model_dummy.SearchListResultAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailSearchFragment extends Fragment {
    private ArrayList<ModelPost> list = new ArrayList<>();
    SearchView searchView;
    SearchListResultAdapter searchListResultAdapter;

    public DetailSearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_detail_search, container, false);


//        searchView = v.findViewById(R.id.searchView);
//        ImageView searchIcon = searchView.findViewById(R.id.search_button);
//        searchIcon.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.ic_search_black_24dp));
//        searchView.setIconifiedByDefault(true);
//        searchView.setFocusable(true);
//        searchView.setIconified(false);
//        searchView.requestFocusFromTouch();
//
//        EditText searchEditText = searchView.findViewById(R.id.search_src_text);
//        searchEditText.setTextColor(getResources().getColor(R.color.black));
//        searchEditText.setHintTextColor(getResources().getColor(R.color.black));

        ViewPager viewPager = v.findViewById(R.id.vp);

        FragmentManager manager = getChildFragmentManager();
        SearchResultPagerAdapter adapter = new SearchResultPagerAdapter(manager, 1);
        viewPager.setAdapter(adapter);

        TabLayout tabs = v.findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        tabs.setSelectedTabIndicatorColor(getActivity().getResources().getColor(R.color.blue));
        tabs.setBackgroundColor(getActivity().getResources().getColor(R.color.white));
        tabs.setTabTextColors(getActivity().getResources().getColor(R.color.black), getActivity().getResources().getColor(R.color.black));


        return v;
    }


}
