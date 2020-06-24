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

import org.w3c.dom.Text;

import java.util.ArrayList;

import co.id.bbw.myapplication.DetailProductActivity;
import co.id.bbw.myapplication.PlaylistMusicActivity;
import co.id.bbw.myapplication.R;
import co.id.bbw.myapplication.model_dummy.ModelMusic;
import co.id.bbw.myapplication.model_dummy.ProductItem;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.GridViewHolder> {

    private ArrayList<ModelMusic> listItem;
    Context context;

    public MusicAdapter(Context context, ArrayList<ModelMusic> list) {
        this.context = context;
        this.listItem = list;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.music_item, viewGroup, false);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(layoutParams);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {

        final ModelMusic modelMusic = listItem.get(position);

        holder.namaMusic.setText(modelMusic.getMusicName());
        holder.albumMusic.setText(modelMusic.getAlbumMusic());

        Glide.with(holder.itemView.getContext())
                .load(modelMusic.getPosterMusic())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.musicPoster);

        holder.musicPoster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, PlaylistMusicActivity.class);
                i.putExtra("judulMusik", modelMusic.getMusicName());
                i.putExtra("albumMusik", modelMusic.getAlbumMusic());
                i.putExtra("posterMusik", modelMusic.getPosterMusic());

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
        ImageView musicPoster;
        TextView namaMusic, albumMusic;


        public GridViewHolder(@NonNull View itemView) {
            super(itemView);

            musicPoster = itemView.findViewById(R.id.poster_music);
            namaMusic = itemView.findViewById(R.id.name_music);
            albumMusic = itemView.findViewById(R.id.album_music);
        }
    }
}
