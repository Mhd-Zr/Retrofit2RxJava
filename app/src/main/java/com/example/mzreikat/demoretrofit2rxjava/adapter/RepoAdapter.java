package com.example.mzreikat.demoretrofit2rxjava.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mzreikat.demoretrofit2rxjava.R;
import com.example.mzreikat.demoretrofit2rxjava.model.Repo;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RepoAdapter extends RecyclerView.Adapter<RepoViewHolder>
{
    private Context context;
    private List<Repo> repoList;

    public RepoAdapter(Context context, List<Repo> repoList) {
        this.context = context;
        this.repoList = repoList;
    }

    private Context getContext() {
        return context;
    }

    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.repo_layout, parent, false);

        return new RepoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder holder, int position) {
        holder.id_txt.setText(String.valueOf(repoList.get(position).getId()));
        holder.name_txt.setText(repoList.get(position).getName());
        holder.fullName_txt.setText(repoList.get(position).getFull_name());

        Picasso.with(getContext()).load(repoList.get(position).getOwner().getAvatar_url()).into(holder.imageView);
        //new ImageTask(holder.imageView).execute(repoList.get(position).getOwner().getAvatar_url());
    }

    @Override
    public int getItemCount() {
        return repoList.size();
    }
}