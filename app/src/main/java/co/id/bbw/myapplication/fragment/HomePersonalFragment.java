package co.id.bbw.myapplication.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Objects;

import co.id.bbw.myapplication.DirectMessageActivity;
import co.id.bbw.myapplication.R;
import co.id.bbw.myapplication.model_dummy.DataItem;
import co.id.bbw.myapplication.model_dummy.ListItemAdapter;
import co.id.bbw.myapplication.model_dummy.ModelPost;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomePersonalFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<ModelPost> list = new ArrayList<>();
    private ListItemAdapter listItemAdapter;

    Dialog moreDialog;

    public HomePersonalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View v = inflater.inflate(R.layout.fragment_home_personal, container, false);


        recyclerView = v.findViewById(R.id.recycler_view);
        list.addAll(DataItem.getListData());



//        Log.i("data", String.valueOf(list));

        showRecycleLists();

        return v;
    }


    private void showRecycleLists() {
        listItemAdapter = new ListItemAdapter(getContext(), list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(listItemAdapter);
    }
}
