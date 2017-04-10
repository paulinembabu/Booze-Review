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
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.Objects;


import butterknife.Bind;
import butterknife.ButterKnife;

import static java.security.AccessController.getContext;

/**
 * Created by pauline on 4/3/17.
 */

public class boozeDetails extends AppCompatActivity implements View.OnClickListener {


    //@Bind(R.id.categoryTextView) TextView mNameDetails;
    @Bind(R.id.description)
    TextView mDescription;
    @Bind(R.id.beerNameTextView)
    TextView mName;
    @Bind(R.id.beerImageView)
    ImageView mImage;
    @Bind(R.id.ratingTextView)
    TextView mRating;
    @Bind(R.id.reviewbeer)
    TextView mReviewBeerTextView;
    @Bind(R.id.reviewTextView)
    EditText mReviewBeerEditText;
    @Bind(R.id.saveReviewButton)
    Button mButton;


    public static final String TAG = boozeDetails.class.getSimpleName();


    private ArrayList<Beer> mBeer = new ArrayList<>();
    String stringName;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booze_details);
        ButterKnife.bind(this);


        int currentPosition = getIntent().getIntExtra("position", 0);
        mBeer = Parcels.unwrap(getIntent().getParcelableExtra("beer1"));


        stringName = mBeer.get(currentPosition).getName();

        String stringDescription = mBeer.get(currentPosition).getDescription();
        int image = mBeer.get(currentPosition).getImage();

        mName.setText(stringName);
        mDescription.setText(stringDescription);
        mImage.setImageResource(image);



    }

    @Override
    public void onClick(View v) {

        if (v == mButton) {
            Log.d("log this",stringName);
            String review = mReviewBeerEditText.getText().toString();

            DatabaseReference boozeRef = FirebaseDatabase
                    .getInstance()
                    .getReference().child(stringName);

            boozeRef.push().setValue(review);


        }
    }

    }


