package com.m.m.asmaa.movies.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.m.m.asmaa.movies.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DitailsFragment extends Fragment {


    public DitailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ditails, container, false);
    }

}
