package co.id.bbw.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class PlaylistMusicActivity extends AppCompatActivity {

    ImageView musicPoster, addPlaylist, btnExpand;
    TextView nameSong, albumSong;
    String poster;
    LinearLayout bottomSheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist_music);

        musicPoster = findViewById(R.id.poster_playlist);
        addPlaylist = findViewById(R.id.add_playlist);
        nameSong = findViewById(R.id.name_music);
        albumSong = findViewById(R.id.album_music);
        btnExpand = findViewById(R.id.btnExpand);

        bottomSheet = findViewById(R.id.bottomSheet);
        bottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlaylistMusicActivity.this, NowPlayingActivity.class);
                startActivity(intent);
            }
        });

        btnExpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlaylistMusicActivity.this, NowPlayingActivity.class);
                startActivity(intent);
            }
        });

        nameSong.setText(getIntent().getStringExtra("judulMusik"));
        albumSong.setText(getIntent().getStringExtra("albumMusik"));

        poster = getIntent().getStringExtra("posterMusik");
        Glide.with(getApplicationContext())
                .load(poster)
                .into(musicPoster);

        addPlaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlaylistMusicActivity.this, AddPlaylistActivity.class);
                startActivity(intent);
            }
        });


        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Music");
        toolbar.setTitleTextColor(Color.BLACK);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
