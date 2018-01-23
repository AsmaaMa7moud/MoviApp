package com.m.m.asmaa.movies.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.m.m.asmaa.movies.Commiunication;
import com.m.m.asmaa.movies.R;
import com.m.m.asmaa.movies.fragment.DitailsFragment;
import com.m.m.asmaa.movies.fragment.ItemsFragment;
import com.m.m.asmaa.movies.model.modelmovie;

public class MainActivity extends AppCompatActivity implements Commiunication{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getFragmentManager().beginTransaction().replace(R.id.container,new ItemsFragment()).commit();

    }

    @Override
    public void setdata(modelmovie modelmovie) {
       // Toast.makeText(getApplicationContext(),modelmovie.getTitle(),Toast.LENGTH_SHORT).show();
        getFragmentManager().beginTransaction().replace(R.id.container,new DitailsFragment()).commit();

    }
}
