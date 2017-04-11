package com.example.pauline.booze.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pauline.booze.adapters.FirebaseBoozeViewHolder;
import com.example.pauline.booze.R;
import com.example.pauline.booze.model.Beer;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by pauline on 4/11/17.
 */

public class ReviewedBeers extends AppCompatActivity{

    public  static  final String TAG = ReviewedBeers.class.getSimpleName();


    private DatabaseReference mBeerReference;
    private FirebaseRecyclerAdapter mFirebaseAdapter;

    @Bind(R.id.description) TextView mDescription;
    @Bind(R.id.beerNameTextView) TextView mName;
    @Bind(R.id.beerImageView) ImageView mImage;
    @Bind(R.id.ratingTextView) TextView mRating;
    @Bind(R.id.reviewbeer) TextView mReviewBeerTextView;
    @Bind(R.id.reviewTextView) EditText mReviewBeerEditText;
    @Bind(R.id.saveReviewButton) Button mButton;
    @Bind(R.id.listView1) ListView mListView;
    @Bind(R.id.recyclerView2) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_booze_details);
        ButterKnife.bind(this);

        mBeerReference = FirebaseDatabase.getInstance().getReference("booze-f8fe7");
        Log.d(TAG,">>>>>>" + mBeerReference);

        mBeerReference.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    String value= (String) snapshot.getValue();
                    Log.d(TAG,"heeeeeer"+ value);
                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        setUpFirebaseAdapter();
    }




    private void setUpFirebaseAdapter() {
        mFirebaseAdapter = new FirebaseRecyclerAdapter<Beer, FirebaseBoozeViewHolder>
                (Beer.class, R.layout.activity_booze_details, FirebaseBoozeViewHolder.class,
                        mBeerReference) {

            @Override
            protected void populateViewHolder(FirebaseBoozeViewHolder viewHolder,
                                              Beer model, int position) {
                viewHolder.bindBooze(model);
            }
        };
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFirebaseAdapter.cleanup();
    }
}
