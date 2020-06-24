package co.id.bbw.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;

import java.util.ArrayList;

import co.id.bbw.myapplication.adapter.MusicAdapter;
import co.id.bbw.myapplication.model_dummy.DataItem;
import co.id.bbw.myapplication.model_dummy.ModelMusic;
import co.id.bbw.myapplication.model_dummy.ProductItem;

public class MusicActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private ArrayList<ModelMusic> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        recyclerView = findViewById(R.id.rv_music);
        list.addAll(DataItem.getMusic());

        showMusic();


        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Music");
        toolbar.setTitleTextColor(Color.BLACK);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null)getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void showMusic() {

        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        MusicAdapter musicAdapter = new MusicAdapter(this, list);
        recyclerView.setAdapter(musicAdapter);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
