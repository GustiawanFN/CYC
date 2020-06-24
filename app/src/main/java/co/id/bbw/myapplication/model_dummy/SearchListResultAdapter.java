package co.id.bbw.myapplication.model_dummy;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import co.id.bbw.myapplication.R;
import co.id.bbw.myapplication.fragment.FriendsFragment;

public class SearchListResultAdapter extends RecyclerView.Adapter<SearchListResultAdapter.ViewHolder> implements Filterable {

    private List<DummySearchHistory> listItem;
    private List<DummySearchHistory> itemAddAll;
    Context context;

    public SearchListResultAdapter(List<DummySearchHistory> dummySearchHistoryList, Context context) {
        this.context = context;
        this.listItem = dummySearchHistoryList;
        itemAddAll = new ArrayList<>();
        itemAddAll.addAll(listItem);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_search_result, viewGroup, false);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(layoutParams);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        DummySearchHistory dummySearchHistory = listItem.get(position);

        holder.nama_user.setText(dummySearchHistory.getNama());
        holder.iv_profile_pict.setImageDrawable(context.getResources().getDrawable(dummySearchHistory.getFoto()));
//        holder.nama_user.setText(listItem);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FriendsFragment friendsFragment = new FriendsFragment();
                FragmentManager fragmentManager = ((FragmentActivity) v.getContext()).getSupportFragmentManager(); // instantiate your view context
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_container, friendsFragment);// your container and your fragment
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    @Override
    public Filter getFilter() {
        return myFilter;
    }

    Filter myFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<DummySearchHistory> filteredList = new ArrayList<>();

            if (charSequence == null || charSequence.length() == 0) {
                filteredList.addAll(itemAddAll);
            } else {
                for (DummySearchHistory dummy : itemAddAll) {
                    if (dummy.getNama().toLowerCase().contains(charSequence.toString().toLowerCase())) {
                        filteredList.add(dummy);
                    }
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            listItem.clear();
            listItem.addAll((Collection<? extends DummySearchHistory>) filterResults.values);
            notifyDataSetChanged();
        }
    };

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_profile_pict, btnDelete;
        TextView nama_user;
        LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.linearLayout);
            nama_user = itemView.findViewById(R.id.nama_user);
            iv_profile_pict = itemView.findViewById(R.id.iv_profile_pict);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }


}
