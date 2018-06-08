package com.example.mzreikat.demoretrofit2rxjava.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mzreikat.demoretrofit2rxjava.R;
import com.example.mzreikat.demoretrofit2rxjava.adapter.RepoAdapter;
import com.example.mzreikat.demoretrofit2rxjava.model.Repo;
import com.example.mzreikat.demoretrofit2rxjava.retrofit.MyAPI;
import com.example.mzreikat.demoretrofit2rxjava.retrofit.RetrofitClient;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListReposFragment extends Fragment
{
    public static boolean count = false;

    private MyAPI myAPI;
    private RecyclerView mRecyclerView;
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    public ListReposFragment() {
        // Required empty public constructor
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_list_repos, container, false);

        // API
        Retrofit retrofit = RetrofitClient.getInstance();
        myAPI = retrofit.create(MyAPI.class);

        // View
        mRecyclerView = rootView.findViewById(R.id.listReposFrag_recycler);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        fetchReposData();
        return rootView;
    }
    public void fetchReposData() {
        String user = MainFragment.user_txt.getText().toString();
        compositeDisposable.add(myAPI.getRepos(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Repo>>() {
                    @Override
                    public void accept(List<Repo> repos) {
                        displayReposData(repos);
                    }
                }));
    }

    public void displayReposData(List<Repo> repos) {
        RepoAdapter adapter = new RepoAdapter(getContext(), repos);
        mRecyclerView.setAdapter(adapter);

        if (adapter.getItemCount() != 0) {
            count = true;
        }
    }

    @Override
    public void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }
}