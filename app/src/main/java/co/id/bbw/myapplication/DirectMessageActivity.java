package co.id.bbw.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import co.id.bbw.myapplication.adapter.DmAdapter;
import co.id.bbw.myapplication.model_dummy.CreateDummyContent;
import co.id.bbw.myapplication.model_dummy.DummyDm;

public class DirectMessageActivity extends AppCompatActivity {
    private RecyclerView rv;
    private TextInputEditText etSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direct_message);

        rv = findViewById(R.id.recycler_view);

        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(manager);

        DmAdapter adapter = new DmAdapter(getApplicationContext());
        rv.setAdapter(adapter);
        List<DummyDm> dummyDms = CreateDummyContent.createDummyDm();
        adapter.setData(dummyDms);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Direct Message");
        toolbar.setTitleTextColor(Color.BLACK);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null)getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
