package co.id.bbw.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import co.id.bbw.myapplication.DetailProductActivity;
import co.id.bbw.myapplication.R;
import co.id.bbw.myapplication.model_dummy.ProductItem;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.GridViewHolder> {

    private ArrayList<ProductItem> listItem;
    Context context;

    public ProductAdapter(Context context, ArrayList<ProductItem> list) {
        this.context = context;
        this.listItem = list;
    }

    @NonNull
    @Override
    public ProductAdapter.GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_product_shop, viewGroup, false);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(layoutParams);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.GridViewHolder holder, int position) {

        final ProductItem productItem = listItem.get(position);

        holder.namaStore.setText(productItem.getNamaToko());
        holder.namaProduct.setText(productItem.getNamaProduct());
        holder.hargaProduct.setText(productItem.getHargaProduct());

        Glide.with(holder.itemView.getContext())
                .load(productItem.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.posterProduct);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, DetailProductActivity.class);
                i.putExtra("namaProduct", productItem.getNamaProduct());
                i.putExtra("poster_path", productItem.getPhoto());
                i.putExtra("hargaPorduct", productItem.getHargaProduct());
                i.putExtra("namaStore", productItem.getNamaToko());
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {

        ImageView posterProduct;
        TextView namaProduct, hargaProduct, namaStore;
        CardView cardView;
        public GridViewHolder(@NonNull View itemView) {
            super(itemView);

            posterProduct = itemView.findViewById(R.id.poster_product);
            namaProduct = itemView.findViewById(R.id.nama_product);
            namaStore = itemView.findViewById(R.id.nama_store);
            hargaProduct = itemView.findViewById(R.id.harga_product);
            cardView = itemView.findViewById(R.id.cv_item);
        }
    }
}
