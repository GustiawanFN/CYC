package co.id.bbw.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import co.id.bbw.myapplication.DetailShopActivity;
import co.id.bbw.myapplication.R;
import co.id.bbw.myapplication.model_dummy.ModelCategoryShop;

public class ShopCategoryAdapter extends RecyclerView.Adapter<ShopCategoryAdapter.GridViewHolder> {
    private ArrayList<ModelCategoryShop> listItem;
    Context context;

    public ShopCategoryAdapter(Context context, ArrayList<ModelCategoryShop> list) {
        this.context = context;
        this.listItem = list;
    }

    @NonNull
    @Override
    public ShopCategoryAdapter.GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.category_shop_item, viewGroup, false);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(layoutParams);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopCategoryAdapter.GridViewHolder holder, int position) {
        final ModelCategoryShop modelCategoryShop = listItem.get(position);

        Glide.with(holder.itemView.getContext())
                .load(modelCategoryShop.getPoster())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.poster);
        holder.category.setText(modelCategoryShop.getCategory());

        holder.poster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailShopActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        TextView category;
        ImageView poster;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);

            category = itemView.findViewById(R.id.category_item);
            poster = itemView.findViewById(R.id.img_category_shop);
        }
    }
}
