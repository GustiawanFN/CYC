package co.id.bbw.myapplication.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Objects;

import co.id.bbw.myapplication.DirectMessageActivity;
import co.id.bbw.myapplication.R;
import co.id.bbw.myapplication.adapter.StoryAdapter;
import co.id.bbw.myapplication.model_dummy.DataItem;
import co.id.bbw.myapplication.model_dummy.ListItemAdapter;
import co.id.bbw.myapplication.model_dummy.ModelPost;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView recyclerViewStory;
    private ArrayList<ModelPost> list = new ArrayList<>();
    private ArrayList<ModelPost> listStory = new ArrayList<>();
    private ListItemAdapter listItemAdapter;
    private StoryAdapter storyAdapter;
    private ImageView directMessage;

    Dialog moreDialog;


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        directMessage = v.findViewById(R.id.directMessage);
        recyclerView = v.findViewById(R.id.recycler_view);
        recyclerViewStory = v.findViewById(R.id.recycler_view_story);

        list.addAll(DataItem.getListData());
        listStory.addAll(DataItem.getListData());

        moreDialog = new Dialog(Objects.requireNonNull(getActivity()));

//        Log.i("data", String.valueOf(list));

        directMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DirectMessageActivity.class);
                startActivity(intent);
            }
        });
        showRecycleLists();
//        showStory();

        return v;


    }

    private void showStory() {
        storyAdapter = new StoryAdapter(getContext(), list);
        recyclerViewStory.setHasFixedSize(true);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewStory.setLayoutManager(layoutManager);
        recyclerViewStory.setAdapter(storyAdapter);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }


    private void showRecycleLists() {
        listItemAdapter = new ListItemAdapter(getContext(), list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(listItemAdapter);
    }
}
