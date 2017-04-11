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
    ListView mListView;
    @Bind(R.id.recyclerView2)
    RecyclerView mRecyclerView2;

    private DatabaseReference mBeerReference;
    public String value;


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


    }

    @Override
    public void onClick(View v) {

        if (v == mButton) {
            String review = mReviewBeerEditText.getText().toString();


            DatabaseReference boozeRef = FirebaseDatabase
                    .getInstance()
                    .getReference().child(stringName);


            boozeRef.push().setValue(review);


            Toast.makeText(boozeDetails.this, "saved", Toast.LENGTH_SHORT).show();


        }
    }


    public void getReviewed() {
        ArrayList<String> myStringArray1 = new ArrayList<String>();

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, myStringArray1);

        myStringArray1.add(value);

        mListView.setAdapter(adapter);


        mBeerReference = FirebaseDatabase.getInstance().getReference().child(stringName);
//        Log.d(TAG,">>>>"+mBeerReference);

        ChildEventListener childEventListener = new ChildEventListener() {


            @Override
            public void onChildAdded(DataSnapshot dataSnapshot,String stringName) {
                String value = (String) dataSnapshot.getValue();
                Log.d(TAG,">>>>>>" + value);


            }

//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    String value = (String) snapshot.getValue();
//                    Log.d(TAG, "heeeeeer" + value);
//
//
//
//                }
//
//
//            }

//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//            }
//
//
//        });

//    }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String previousChildName) {

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String previousChildName) {

            }


        };
        mBeerReference.addChildEventListener(childEventListener);
    }
}






