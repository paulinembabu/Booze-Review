package com.example.pauline.booze;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.parceler.Parcels;

import java.util.ArrayList;


import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by pauline on 4/3/17.
 */

public class boozeDetails extends AppCompatActivity implements View.OnClickListener  {


    @Bind(R.id.categoryTextView) TextView mNameDetails;
    @Bind(R.id.description) TextView mDescription;
    @Bind(R.id.beerNameTextView) TextView mName;
    @Bind(R.id.beerImageView) ImageView mImage;
    @Bind(R.id.ratingTextView) TextView mRating;
    @Bind(R.id.reviewbeer) TextView mReviewBeerTextView;
    @Bind(R.id.reviewTextView) EditText mReviewBeerEditText;
    @Bind(R.id.saveReviewButton) Button mButton;
    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;


//    public  static boozeDetails newInstance (Beer beer){
//        boozeDetails newboozeDetailsFragment = new boozeDetails();
//        Bundle args = new Bundle();
//        args.putParcelable("beer", Parcels.wrap(beer));
//        newboozeDetailsFragment.setArguments(args);
//        return  newboozeDetailsFragment;
//    }

    public static  final  String TAG = boozeDetails.class.getSimpleName();


    private ArrayList<Beer> mBeer= new ArrayList<>();

    private Context mContext;


//    public boozeDetails(Context context, ArrayList<Beer> beer) {
//        mContext = context;
//        mBeer=beer;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booze_details);


        int currentPosition = getIntent().getIntExtra("position",0);
        mBeer = Parcels.unwrap(getIntent().getParcelableExtra("beer"));


       String string = mBeer.get(currentPosition).getName();

        Log.d(TAG, ">>>>>>" + string);





    }





//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)  {
//        View view = inflater.inflate(R.layout.activity_booze_detail , container, false);
//        ButterKnife.bind(this, view);
//
//        mName.setText(mBeer[position].getName());
//        mDescription.setText(mBeer.getDescription());
//
//        mButton.setOnClickListener(this);
//
//        return view;
//
//    }

    @Override
    public void onClick(View v) {
        if (v == mButton) {
//            DatabaseReference boozeRef = FirebaseDatabase
//                    .getInstance()
//                    .getReference(Constants.FIREBASE_CHILD_RESTAURANTS);
//            boozeRef.push().setValue(mBeer);
//            Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
        }
    }

}

