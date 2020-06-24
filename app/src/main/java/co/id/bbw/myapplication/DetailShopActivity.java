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
import co.id.bbw.myapplication.adapter.ProductAdapter;
import co.id.bbw.myapplication.model_dummy.DataItem;
import co.id.bbw.myapplication.model_dummy.ModelPost;
import co.id.bbw.myapplication.model_dummy.ProductItem;

public class DetailShopActivity extends AppCompatActivity {


    RecyclerView rvProduct;
    private ArrayList<ProductItem> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_shop);

        rvProduct = findViewById(R.id.rv_detail_shop);
        list.addAll(DataItem.getProductItem());

        showProduct();


        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Shop");
        toolbar.setTitleTextColor(Color.BLACK);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null)getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void showProduct() {
        Log.i("list", String.valueOf(list));
        Log.i("show product adapter", "dijalankan");

        rvProduct.setLayoutManager(new GridLayoutManager(this,2));
        ProductAdapter productAdapter = new ProductAdapter(this, list);
        rvProduct.setAdapter(productAdapter);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
