package com.m.m.asmaa.movies.fragment;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.m.m.asmaa.movies.Commiunication;
import com.m.m.asmaa.movies.R;
import com.m.m.asmaa.movies.adapter.ItemsAdapter;
import com.m.m.asmaa.movies.model.modelmovie;
import com.m.m.asmaa.movies.volley.vollySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ItemsFragment extends Fragment implements Commiunication {
    String url="https://api.themoviedb.org/3/movie/popular?api_key=777660159186d81259c9dcfa910ad0f1&page=";
    List<modelmovie> data = new ArrayList<modelmovie>();
    Context con;

    ItemsAdapter itemsAdapter;
    RecyclerView mRecyclerView;

    public ItemsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_items, container, false);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
       mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        itemsAdapter = new ItemsAdapter(data,getActivity());
        mRecyclerView.setAdapter(itemsAdapter);
        con=getActivity();
        getdata();
        return v;
    }
    public void getdata(){
        JsonObjectRequest objectRequest=new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            data=Parsing_Json(response+"");
                            itemsAdapter=new ItemsAdapter(data,con);
                            mRecyclerView.setAdapter(itemsAdapter);
                            mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
                            mRecyclerView.setHasFixedSize(true);

                            Toast.makeText(getActivity(),"the size of array is "+Parsing_Json(response+"").size(), Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                      /* try {
                            JSONObject object = new JSONObject(response.toString());
                            JSONArray array = object.getJSONArray("results");
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject obj = array.getJSONObject(i);
                              modelmovie model = new modelmovie( obj.getString("title")
                                        ,obj.getString("poster_path")
                                        ,obj.getString("release_date")
                                        ,obj.getString("overview")
                                        ,obj.getString("vote_average")
                                        ,obj.getString("adult"));
                                data.add(model);
                                //  Log.v("dddd",obj.getString("title"));
                            }

                            itemsAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getActivity(), e.getMessage() + " ", Toast.LENGTH_SHORT).show();

                        }*/


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        vollySingleton.getInstance(getActivity()).addToRequestQueue(objectRequest);
    }
    public ArrayList<modelmovie> Parsing_Json(String Json) throws JSONException {
        ArrayList<modelmovie>data=new ArrayList<>();
        JSONObject root=new JSONObject(Json);
        JSONArray results=root.getJSONArray("results");
        for(int i=0;i<results.length();i++){
           // (String id, String date, String overview, String poster_path, String title, String type, String vote_average)
            JSONObject mov=results.getJSONObject(i);
            modelmovie newmov= new modelmovie(
                    mov.getString("title")
                    ,mov.getString("poster_path")
                    ,mov.getString("release_date")
                    ,mov.getString("overview")
                    ,mov.getString("vote_average")
                    ,mov.getString("adult")

            );
            data.add(newmov);
        }
        return data;

    }


    @Override
    public void setdata(modelmovie modelmovie) {
        //Toast.makeText(con,modelmovie.getTitle(),Toast.LENGTH_SHORT).show();
        getFragmentManager().beginTransaction().replace(R.id.container,new DitailsFragment()).commit();


    }
}
