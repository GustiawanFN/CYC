package co.id.bbw.myapplication.fragment;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import co.id.bbw.myapplication.R;
import co.id.bbw.myapplication.model_dummy.CreateDummyContent;
import co.id.bbw.myapplication.model_dummy.DataItem;
import co.id.bbw.myapplication.model_dummy.DummyDm;
import co.id.bbw.myapplication.model_dummy.DummySearchHistory;
import co.id.bbw.myapplication.model_dummy.ModelPost;
import co.id.bbw.myapplication.model_dummy.SearchListResultAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResultSearchAllFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<DummySearchHistory> list = new ArrayList<>();
    private SearchListResultAdapter searchListResultAdapter;

    SearchView searchView;


    public ResultSearchAllFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_result_search_all, container, false);

        recyclerView = v.findViewById(R.id.rv_search_all_result);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //add data
        List<DummySearchHistory> dummyDms = CreateDummyContent.createDummySearchHistory();

        searchListResultAdapter = new SearchListResultAdapter(dummyDms, getContext());
        recyclerView.setAdapter(searchListResultAdapter);


        searchView = getParentFragment().getView().findViewById(R.id.searchView);
        ImageView searchIcon = searchView.findViewById(R.id.search_button);
        searchIcon.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.ic_search_black_24dp));
        searchView.setIconifiedByDefault(true);
        searchView.setFocusable(true);
        searchView.setIconified(false);
        searchView.requestFocusFromTouch();

        EditText searchEditText = searchView.findViewById(R.id.search_src_text);
        searchEditText.setTextColor(getResources().getColor(R.color.black));
        searchEditText.setHintTextColor(getResources().getColor(R.color.black));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchListResultAdapter.getFilter().filter(newText);
                return false;
            }
        });


        return v;
    }


}
