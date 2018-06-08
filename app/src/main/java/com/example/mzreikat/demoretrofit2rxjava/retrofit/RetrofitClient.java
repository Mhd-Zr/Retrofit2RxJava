package com.example.mzreikat.demoretrofit2rxjava.retrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient
{
    private static final String base_url = "https://api.github.com";

    private static Retrofit myInstance;

    public static Retrofit getInstance() {
        if (myInstance == null) {
            myInstance = new Retrofit.Builder()
                    .baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return myInstance;
    }

    private RetrofitClient() {
    }
}