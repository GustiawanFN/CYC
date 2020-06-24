package co.id.bbw.myapplication.model_dummy;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;

import co.id.bbw.myapplication.CommentActivity;
import co.id.bbw.myapplication.R;

public class ListItemAdapter extends RecyclerView.Adapter<ListItemAdapter.ListViewHolder> {

    private ArrayList<ModelPost> listItem;
    Context context;

    public ListItemAdapter(Context context, ArrayList<ModelPost> list) {
        this.context = context;
        this.listItem = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.post_item, viewGroup, false);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(layoutParams);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        final ModelPost modelPost = listItem.get(position);

        Glide.with(holder.itemView.getContext())
                .load(modelPost.getFoto())
                .into(holder.imgPhotoPost);

        holder.tvNama.setText(modelPost.getNama());
        holder.tvCaption.setText(modelPost.getCaption());
        holder.tvPublisher.setText(modelPost.getNama());
        holder.comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CommentActivity.class);
                context.startActivity(intent);
            }
        });

        //dialog more option (report, unfollow, bookmark, copy link
        holder.imgMoreAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView report, unfollow, bookmark, copyLink;

                final Dialog dialog = new Dialog(v.getRootView().getContext());
                dialog.setContentView(R.layout.popup_more_option);
                report = dialog.findViewById(R.id.dialog_report);
                unfollow = dialog.findViewById(R.id.dialog_unfollow);
                bookmark = dialog.findViewById(R.id.dialog_bookmark);
                copyLink = dialog.findViewById(R.id.dialog_copy_link);

                report.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(v.getContext(), "reported", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

                unfollow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(v.getContext(), "unfollowed", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

                bookmark.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(v.getContext(), "bookmarked", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

                copyLink.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(v.getContext(), "link copied", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });
    }


    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhotoPost, imgMoreAction, comment;
        TextView tvCaption, tvNama, tvPublisher;


        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPhotoPost = itemView.findViewById(R.id.post_image);
            imgMoreAction = itemView.findViewById(R.id.more);
            tvCaption = itemView.findViewById(R.id.caption);
            tvNama = itemView.findViewById(R.id.username);
            tvPublisher = itemView.findViewById(R.id.publisher);
            comment = itemView.findViewById(R.id.comment);
        }
    }
}
