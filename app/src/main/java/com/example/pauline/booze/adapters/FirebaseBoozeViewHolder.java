package com.example.pauline.booze.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pauline.booze.R;
import com.example.pauline.booze.model.Beer;
import com.example.pauline.booze.ui.ReviewedBeers;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by pauline on 4/11/17.
 */

public class FirebaseBoozeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;

    View mView;
    Context mContext;
    public  static  final String TAG = FirebaseBoozeViewHolder.class.getSimpleName();


    @Bind(R.id.description) TextView mDescription;
    @Bind(R.id.beerNameTextView) TextView mName;
    @Bind(R.id.beerImageView) ImageView mImage;
    @Bind(R.id.ratingTextView) TextView mRating;
    @Bind(R.id.reviewbeer) TextView mReviewBeerTextView;
    @Bind(R.id.reviewTextView)
    EditText mReviewBeerEditText;
    @Bind(R.id.saveReviewButton)
    Button mButton;
    @Bind(R.id.listView1)
    ListView mListView;


    public FirebaseBoozeViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }




    public void bindBooze(Beer beer) {
        mName.setText(beer.getName());



    }

    @Override
    public void onClick(View view) {
        final ArrayList<Beer> mBeer = new ArrayList<>();

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("booze-f8fe7");
        Log.d(TAG,"heeeeeer"+ ref);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {


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
    }

}