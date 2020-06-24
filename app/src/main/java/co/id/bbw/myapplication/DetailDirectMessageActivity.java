package co.id.bbw.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class DetailDirectMessageActivity extends AppCompatActivity {

    ImageView photoProfil;
    TextView username,txt_msg;
    String photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_direct_message);

        photoProfil = findViewById(R.id.img_detail_chat);
        username = findViewById(R.id.tv_usrname_chat);
        txt_msg = findViewById(R.id.txt_msg);
        txt_msg.setText(getIntent().getStringExtra("message"));
        username.setText(getIntent().getStringExtra("username"));

        Toolbar toolbar = findViewById(R.id.toolbar);
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
