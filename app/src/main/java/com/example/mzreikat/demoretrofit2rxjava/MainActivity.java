package com.example.mzreikat.demoretrofit2rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mzreikat.demoretrofit2rxjava.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container, new MainFragment(), MainFragment.class.getSimpleName())
                .commit();
    }
}