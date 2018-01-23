package com.m.m.asmaa.movies.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.m.m.asmaa.movies.Commiunication;
import com.m.m.asmaa.movies.R;
import com.m.m.asmaa.movies.model.modelmovie;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.android.volley.VolleyLog.TAG;

/**
 * Created by hp on 21/10/2017.
 */


public  class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {
    List<modelmovie> movie;
    Context c;

    public ItemsAdapter(List<modelmovie> movie, Context c) {
        this.movie = movie;
        this.c = c;

    }

    @Override
    public ItemsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Log.d(TAG, "onCreateViewHolder called");
       View view;
      view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
        }


@Override
public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(movie.get(position).getTitle());
        holder.rate.setText(movie.get(position).getVote_average());
        holder.date.setText(movie.get(position).getDate());
        holder.overview.setText(movie.get(position).getOverview());
        holder.type.setText(movie.get(position).getType());
        Picasso.with(c)
        .load("http://image.tmdb.org/t/p/w185/"+movie.get(position).getPoster_path())
        .placeholder(R.drawable.placeholder)
        .into(holder.imge);
       Log.d(TAG, "onCreateViewHolder called");


        }

@Override
public int getItemCount() {
        return movie.size();
        }
public class ViewHolder extends RecyclerView.ViewHolder {
    TextView title,rate,date,type,overview;
    ImageView imge;

    public ViewHolder(View itemView) {
        super(itemView);
        title= (TextView) itemView.findViewById(R.id.title);
        rate= (TextView) itemView.findViewById(R.id.like);
        date= (TextView) itemView.findViewById(R.id.date);
        type= (TextView) itemView.findViewById(R.id.type);
        overview= (TextView) itemView.findViewById(R.id.overview);
        imge= (ImageView) itemView.findViewById(R.id.imagemovie);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Commiunication com=(Commiunication)c;
                int postion= getAdapterPosition();
                com.setdata(movie.get(postion));

            }
        });
    }
}

}
