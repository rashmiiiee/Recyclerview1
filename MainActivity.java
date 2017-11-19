package com.example.rashmi.myapplication;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button mButton;
    private Context mcontext;
    private String url="http://google.com";
    private Activity mActivity;
    private RecyclerView recyclerView;
    private MyAdapter mAdapter;
    private List<Movie> movieList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.mrecyclerview);
        mAdapter = new MyAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);
        movieData();
        mButton=(Button)findViewById(R.id.BTaction);
        textView=(TextView)findViewById(R.id.TVText);
        mcontext=getApplicationContext();
        mActivity= MainActivity.this;
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        textView.setText(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textView.setText("error");

                    }
                });
                MySingleton.getInstance(mcontext).addToRequestQueue(stringRequest);
            }

        });

    }
    private void movieData(){
        Movie newMovie= new Movie("abcd","action", 1999);
        movieList.add(newMovie);
        newMovie=new Movie("bhjk","adventure",2000);
        movieList.add(newMovie);
        mAdapter.notifyDataSetChanged();


    }
    }

