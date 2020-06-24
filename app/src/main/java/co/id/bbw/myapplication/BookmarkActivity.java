package co.id.bbw.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import co.id.bbw.myapplication.adapter.BookmarkAdapter;
import co.id.bbw.myapplication.model_dummy.DataItem;
import co.id.bbw.myapplication.model_dummy.ModelPost;

public class BookmarkActivity extends AppCompatActivity {

    RecyclerView rvGridBookmark;
    private ArrayList<ModelPost> list = new ArrayList<>();
    BookmarkAdapter bookmarkAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark);

        rvGridBookmark = findViewById(R.id.rv_bookmark);

        list.addAll(DataItem.getListData());

        showBookmark();


        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Bookmark");
        toolbar.setTitleTextColor(Color.BLACK);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null)getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void showBookmark() {

        Log.i("bookmark adapter", "dijalankan");
        rvGridBookmark.setLayoutManager(new GridLayoutManager(this, 3));
        BookmarkAdapter gridHeroAdapter = new BookmarkAdapter(this, list);
        rvGridBookmark.setAdapter(gridHeroAdapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
