package com.example.pauline.booze.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pauline.booze.R;
import com.example.pauline.booze.model.Beer;
import com.google.firebase.database.ChildEventListener;
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
    @Bind(R.id.listView1)
    TextView mListView;



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
        mButton.setOnClickListener(this);

      //  getReviewed(stringName);


    }

    @Override
    public void onClick(View v) {

        if (v == mButton) {
            String review = mReviewBeerEditText.getText().toString();

            DatabaseReference boozeRef = FirebaseDatabase
                    .getInstance()
                    .getReference("beers").child(stringName);


            boozeRef.child("review").push().setValue(review);


            Toast.makeText(boozeDetails.this, "saved", Toast.LENGTH_SHORT).show();

            mReviewBeerEditText.setText("");

                   getReviewed(stringName);

        }
    }


    public void getReviewed(final String stringName) {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("beers").child(stringName);

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               mListView.setText(dataSnapshot.child("review").getValue().toString());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}






