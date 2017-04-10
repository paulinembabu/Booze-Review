package com.example.pauline.booze;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class  BoozeList extends AppCompatActivity {

    @Bind(R.id.listView) ListView mListView;
    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;


    private String mSearchedBeerName;


   public static String TAG = BoozeList.class.getSimpleName();

    public BoozeListAdapter mAdapter;

    public ArrayList<Beer> mBeer = new ArrayList<>();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beer);

        ButterKnife.bind(this);
        getBeer();

    }

    public void getBeer(){
        final BeerService  beerService = new BeerService();
        beerService.findBeers(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {

                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response)  {
                mBeer = beerService.processResult(response);

                BoozeList.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        mAdapter= new  BoozeListAdapter(getApplicationContext(),mBeer);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(BoozeList.this, 2);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                    }
                });
            }
        });
    }
}