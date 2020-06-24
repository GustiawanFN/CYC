package co.id.bbw.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;

import java.util.ArrayList;

import co.id.bbw.myapplication.adapter.BookmarkAdapter;
import co.id.bbw.myapplication.adapter.ShopCategoryAdapter;
import co.id.bbw.myapplication.model_dummy.DataItem;
import co.id.bbw.myapplication.model_dummy.ModelCategoryShop;

public class ShopActivity extends AppCompatActivity {

    private RecyclerView rvCategoryShop;
    private ArrayList<ModelCategoryShop> list = new ArrayList<>() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        rvCategoryShop = findViewById(R.id.rv_shop);
        list.addAll(DataItem.getCategoryShop());

        showCategoryShop();


        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Music");
        toolbar.setTitleTextColor(Color.BLACK);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void showCategoryShop() {

        rvCategoryShop.setLayoutManager(new GridLayoutManager(this, 2));
        ShopCategoryAdapter shopCategoryAdapter = new ShopCategoryAdapter(this, list);
        rvCategoryShop.setAdapter(shopCategoryAdapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
