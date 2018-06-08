package com.example.mzreikat.demoretrofit2rxjava.retrofit;

import com.example.mzreikat.demoretrofit2rxjava.model.Repo;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MyAPI {

    @GET("/users/{user}/repos")
    Observable<List<Repo>> getRepos(@Path("user") String user);
}