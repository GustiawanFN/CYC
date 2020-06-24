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

import java.util.ArrayList;
import java.util.List;

import co.id.bbw.myapplication.DetailDirectMessageActivity;
import co.id.bbw.myapplication.R;
import co.id.bbw.myapplication.model_dummy.DummyDm;

public class DmAdapter extends RecyclerView.Adapter<DmAdapter.VHItem> {

    private List<DummyDm> data = new ArrayList<>();
    private Context context;

    public DmAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public DmAdapter.VHItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dm_item, parent, false);
        return new VHItem(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DmAdapter.VHItem holder, int position) {
        final DummyDm dummyDm = data.get(position);

        holder.ivPic.setImageDrawable(context.getResources().getDrawable(dummyDm.getImg()));
        holder.tvName.setText(dummyDm.getName());
        holder.tvMessage.setText(dummyDm.getMessage());
        holder.tvDay.setText(dummyDm.getDay());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailDirectMessageActivity.class);

                intent.putExtra("photo_profile", dummyDm.getImg());
                intent.putExtra("username", dummyDm.getName());
                intent.putExtra("message", dummyDm.getMessage());

                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

//        holder.ivPic.setImageDrawable(context.getResources().getDrawable(data.get(position).getImg()));
//        holder.tvName.setText(data.get(position).getName());
//        holder.tvMessage.setText(data.get(position).getMessage());
//        holder.tvDay.setText(data.get(position).getDay());
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, DetailDirectMessageActivity.class);
//
//                intent.putExtra("judulMusik", modelMusic.getMusicName());
//                context.startActivity(intent);
//            }
//        });
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
            tvDay = v.findViewById(R.id.tvDay);
        }
    }
}
