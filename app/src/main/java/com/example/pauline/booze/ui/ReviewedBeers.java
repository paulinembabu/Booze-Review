package com.example.pauline.booze.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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

public class ReviewedBeers extends AppCompatActivity implements View.OnClickListener{

    public  static  final String TAG = ReviewedBeers.class.getSimpleName();




    @Bind(R.id.description) EditText mDescription;
    @Bind(R.id.beerNameTextView) EditText mName;
    @Bind(R.id.beerImageView) ImageView mImage;
    @Bind(R.id.ratingTextView) EditText mRating;
    @Bind(R.id.reviewbeer) TextView mReviewBeerTextView;
    @Bind(R.id.reviewTextView) EditText mReviewBeerEditText;
    @Bind(R.id.saveReviewButton) Button mButton;
    @Bind(R.id.listView1) TextView mListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_booze_details_review);
        ButterKnife.bind(this);
        mButton.setOnClickListener(this);


    }





    @Override
    public void onClick(View v) {

        if (v == mButton) {
             String name =   mName.getText().toString();
            String review = mReviewBeerEditText.getText().toString();
            String rate = mRating.getText().toString();
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference("beers").child(name);
                        reference.child("review").setValue(review);


            Toast.makeText(ReviewedBeers.this, "saved", Toast.LENGTH_SHORT).show();
            mName.setText("");
            mReviewBeerEditText.setText("");
            mDescription.setText("");

        }
    }
}
