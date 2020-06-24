package co.id.bbw.myapplication.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import co.id.bbw.myapplication.R;
import co.id.bbw.myapplication.model_dummy.DummyDm;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.VHItem> {

    private List<DummyDm> data = new ArrayList<>();
    private Context context;

    public CommentAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CommentAdapter.VHItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment, parent, false);
        return new  CommentAdapter.VHItem(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentAdapter.VHItem holder, int position) {

        holder.ivPic.setImageDrawable(context.getResources().getDrawable(data.get(position).getImg()));
        holder.tvName.setText(data.get(position).getName());
        holder.tvName.setText(data.get(position).getName());
        holder.tvMessage.setText(data.get(position).getMessage());
        holder.tvDay.setText(data.get(position).getDay());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<DummyDm> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public class VHItem extends RecyclerView.ViewHolder {
        private ImageView ivPic;
        private TextView tvName, tvMessage, tvDay;
        public VHItem(@NonNull View v) {
            super(v);

            ivPic = v.findViewById(R.id.ivPic);
            tvName = v.findViewById(R.id.tvName);
            tvMessage = v.findViewById(R.id.tvMessage);
            tvDay = v.findViewById(R.id.tvWaktu);
        }
    }
}
