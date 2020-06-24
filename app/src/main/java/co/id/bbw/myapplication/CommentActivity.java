package co.id.bbw.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

import co.id.bbw.myapplication.adapter.CommentAdapter;
import co.id.bbw.myapplication.adapter.DmAdapter;
import co.id.bbw.myapplication.model_dummy.CreateDummyContent;
import co.id.bbw.myapplication.model_dummy.DummyDm;

public class CommentActivity extends AppCompatActivity {

    private RecyclerView rv;
    ImageView post_comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        rv = findViewById(R.id.recycler_view);
        post_comment = findViewById(R.id.post_comment);
        post_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommentActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });


        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(manager);
        CommentAdapter adapter = new CommentAdapter(getApplicationContext());
        rv.setAdapter(adapter);
        List<DummyDm> dummyDms = CreateDummyContent.createDummyDm();
        adapter.setData(dummyDms);


        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Comment");
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
