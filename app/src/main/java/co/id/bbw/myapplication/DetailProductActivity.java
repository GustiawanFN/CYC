package co.id.bbw.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailProductActivity extends AppCompatActivity {
    private String namaBarang, hargaBarang, fotoBarang, namaToko;
    ImageView poster;
    TextView namaProduct, hargaProduct, namaStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);

        poster = findViewById(R.id.poster);
        namaProduct = findViewById(R.id.nama_product);
        hargaProduct = findViewById(R.id.harga_product);
        namaStore = findViewById(R.id.nama_toko);

        namaProduct.setText(getIntent().getStringExtra("namaProduct"));
        hargaProduct.setText(getIntent().getStringExtra("hargaPorduct"));
        namaStore.setText(getIntent().getStringExtra("namaStore"));

        fotoBarang = getIntent().getStringExtra("poster_path");

        Glide.with(getApplicationContext())
                .load(fotoBarang)
                .into(poster);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Shop");
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
