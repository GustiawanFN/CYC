package co.id.bbw.myapplication.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import co.id.bbw.myapplication.DirectMessageActivity;
import co.id.bbw.myapplication.R;
import co.id.bbw.myapplication.adapter.HomePagerAdapter;
import co.id.bbw.myapplication.adapter.SearchPagerAdapter;
import co.id.bbw.myapplication.adapter.StoryAdapter;
import co.id.bbw.myapplication.model_dummy.DataItem;
import co.id.bbw.myapplication.model_dummy.ListItemAdapter;
import co.id.bbw.myapplication.model_dummy.ModelPost;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<ModelPost> list = new ArrayList<>();
    private ArrayList<ModelPost> listStory = new ArrayList<>();
    private ListItemAdapter listItemAdapter;
    private RecyclerView recyclerViewStory;
    private StoryAdapter storyAdapter;
    private ImageView directMessage;

    Dialog moreDialog;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        ViewPager viewPager = v.findViewById(R.id.vpHome);
        directMessage = v.findViewById(R.id.directMessage);

        recyclerViewStory = v.findViewById(R.id.recycler_view_story);

        list.addAll(DataItem.getListData());
        listStory.addAll(DataItem.getListData());
        showStory();

        FragmentManager manager = getChildFragmentManager();

        HomePagerAdapter adapter = new HomePagerAdapter(manager, 1);
        viewPager.setAdapter(adapter);

        TabLayout tabs = v.findViewById(R.id.tabsHome);
        tabs.setupWithViewPager(viewPager);
        tabs.setSelectedTabIndicatorColor(getActivity().getResources().getColor(R.color.blue));
        tabs.setBackgroundColor(getActivity().getResources().getColor(R.color.white));
        tabs.setTabTextColors(getActivity().getResources().getColor(R.color.black), getActivity().getResources().getColor(R.color.black));

        directMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DirectMessageActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }

    private void showStory() {
        Log.i("list", String.valueOf(list));
        Log.i("show product adapter", "dijalankan");
        Log.i("story", String.valueOf(listStory));
        storyAdapter = new StoryAdapter(getContext(), listStory);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewStory.setHasFixedSize(true);

        recyclerViewStory.setLayoutManager(layoutManager);
        recyclerViewStory.setAdapter(storyAdapter);
    }
}
