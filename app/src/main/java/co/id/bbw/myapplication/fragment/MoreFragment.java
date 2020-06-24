package co.id.bbw.myapplication.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import co.id.bbw.myapplication.BookmarkActivity;
import co.id.bbw.myapplication.EventActivity;
import co.id.bbw.myapplication.LoginActivity;
import co.id.bbw.myapplication.MusicActivity;
import co.id.bbw.myapplication.ProfilActivity;
import co.id.bbw.myapplication.R;
import co.id.bbw.myapplication.SettingActivity;
import co.id.bbw.myapplication.ShopActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoreFragment extends Fragment {
    LinearLayout profil, music, shop, bookmark, event, setting, logout;

    public MoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_more, container, false);
        getActivity().setTitle("More");

        profil = v.findViewById(R.id.profil);
        music = v.findViewById(R.id.music);
        shop = v.findViewById(R.id.shop);
        bookmark = v.findViewById(R.id.bookmark);
        event = v.findViewById(R.id.event);
        setting = v.findViewById(R.id.setting);
        logout = v.findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SettingActivity.class);
                startActivity(intent);
            }
        });

        event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EventActivity.class);
                startActivity(intent);
            }
        });

        bookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BookmarkActivity.class);
                startActivity(intent);
            }
        });

        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ShopActivity.class);
                startActivity(intent);
            }
        });

        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MusicActivity.class);
                startActivity(intent);
            }
        });

        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ProfilActivity.class);
                startActivity(intent);
            }
        });


        return v;
    }
}
