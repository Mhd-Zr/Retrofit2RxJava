package com.example.mzreikat.demoretrofit2rxjava.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.mzreikat.demoretrofit2rxjava.R;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment
{
    @SuppressLint("StaticFieldLeak")
    public static EditText user_txt;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        user_txt = rootView.findViewById(R.id.mainFrag_userName);

        final Button btn = rootView.findViewById(R.id.mainFrag_getDataBtn);
        btn.setEnabled(false);

        user_txt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().equals("")) {
                    btn.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                user_txt.setOnKeyListener(new View.OnKeyListener() {
                    @Override
                    public boolean onKey(View v, int keyCode, KeyEvent event) {
                        if (keyCode == KeyEvent.KEYCODE_DEL) {
                            if (user_txt.getText().toString().equals("")) {
                                btn.setEnabled(false);
                            }
                        }
                        return false;
                    }
                });
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getRepos();
            }
        });
        return rootView;
    }

    public void getRepos() {
        Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container, new ListReposFragment(), ListReposFragment.class.getSimpleName())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .addToBackStack(null)
                .commit();
    }
}