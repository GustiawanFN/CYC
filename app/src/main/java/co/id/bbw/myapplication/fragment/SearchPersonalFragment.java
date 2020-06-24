package co.id.bbw.myapplication.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import co.id.bbw.myapplication.R;
import co.id.bbw.myapplication.adapter.BookmarkAdapter;
import co.id.bbw.myapplication.model_dummy.DataItem;
import co.id.bbw.myapplication.model_dummy.ModelPost;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchPersonalFragment extends Fragment {
    RecyclerView rvSearchPersonal;
    private ArrayList<ModelPost> list = new ArrayList<>();

    public SearchPersonalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_search_personal, container, false);

        rvSearchPersonal = v.findViewById(R.id.rv_search_personal);
        list.addAll(DataItem.getListData());

        showSearchPersonal();
        return v;
    }

    private void showSearchPersonal() {

        rvSearchPersonal.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        BookmarkAdapter gridHeroAdapter = new BookmarkAdapter(getContext(), list);
        rvSearchPersonal.setAdapter(gridHeroAdapter);
    }
}
