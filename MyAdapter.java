package com.example.rashmi.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by QCS2015 on 19-11-2017.
 */

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
        List<Movie> movieList;

        public MyAdapter(List<Movie> movieList) {
            this.movieList = movieList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View myview;
            myview= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
            return new MyViewHolder(myview);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            Movie movie = movieList.get(position);
            holder.name.setText(movie.getName());
            holder.description.setText(movie.getDescription());
            holder.id.setText(movie.getId());

        }

        @Override
        public int getItemCount() {
            return movieList.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView name,description,id;

            public MyViewHolder(View view) {
                super(view);
                name=(TextView)view.findViewById(R.id.title);
                description=(TextView)view.findViewById(R.id.desc);
                id=(TextView)view.findViewById(R.id.movie_id);

            }
        }
    }

