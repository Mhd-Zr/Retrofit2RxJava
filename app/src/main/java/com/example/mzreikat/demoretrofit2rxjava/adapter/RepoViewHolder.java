package com.example.mzreikat.demoretrofit2rxjava.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mzreikat.demoretrofit2rxjava.R;

public class RepoViewHolder extends RecyclerView.ViewHolder
{
    public TextView id_txt, name_txt, fullName_txt;
    public ImageView imageView;

    RepoViewHolder(View itemView) {
        super(itemView);

        id_txt = itemView.findViewById(R.id.repo_id_txt);
        name_txt = itemView.findViewById(R.id.repo_name_txt);
        fullName_txt = itemView.findViewById(R.id.repo_fullName_txt);
        imageView = itemView.findViewById(R.id.repo_avatarView);
    }
}