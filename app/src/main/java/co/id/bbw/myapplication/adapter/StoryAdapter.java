package co.id.bbw.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import co.id.bbw.myapplication.R;
import co.id.bbw.myapplication.model_dummy.ListItemAdapter;
import co.id.bbw.myapplication.model_dummy.ModelPost;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.ListViewHolder> {

    private ArrayList<ModelPost> listItem;
    Context context;

    public StoryAdapter(Context context, ArrayList<ModelPost> list) {
        this.context = context;
        this.listItem = list;
    }


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        if (i == 0) {
//            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.add_story_item, viewGroup, false);
//            RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//            view.setLayoutParams(layoutParams);
//            return new ListViewHolder(view);
//        } else {
//            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_story, viewGroup, false);
//            RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//            view.setLayoutParams(layoutParams);
//            return new ListViewHolder(view);
//        }
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_story, viewGroup, false);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(layoutParams);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {

        final ModelPost modelPost = listItem.get(position);

        Glide.with(holder.itemView.getContext())
                .load(modelPost.getFoto())
                .into(holder.story_photo);
        holder.story_username.setText(modelPost.getNama());

    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        public ImageView story_photo, story_plus, story_photo_seen;
        public TextView story_username, addstory_text;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            story_photo = itemView.findViewById(R.id.story_photo);
            story_username = itemView.findViewById(R.id.story_username);
            story_plus = itemView.findViewById(R.id.story_plus);
            addstory_text = itemView.findViewById(R.id.addstory_text);
            story_photo_seen = itemView.findViewById(R.id.story_photo_seen);
        }
    }
}
