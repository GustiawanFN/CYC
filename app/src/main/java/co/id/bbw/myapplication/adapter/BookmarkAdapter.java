package co.id.bbw.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import co.id.bbw.myapplication.R;
import co.id.bbw.myapplication.model_dummy.ModelPost;

public class BookmarkAdapter extends RecyclerView.Adapter<BookmarkAdapter.GridViewHolder> {

    private ArrayList<ModelPost> listItem;
    Context context;

    public BookmarkAdapter(Context context, ArrayList<ModelPost> list) {
        this.context = context;
        this.listItem = list;
    }



    @NonNull
    @Override
    public BookmarkAdapter.GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bookmark_grid_item, viewGroup, false);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(layoutParams);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookmarkAdapter.GridViewHolder holder, int position) {
        final ModelPost modelPost = listItem.get(position);

        Glide.with(holder.itemView.getContext())
                .load(modelPost.getFoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.img_item_photo);

    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {

        ImageView img_item_photo;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            img_item_photo = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
