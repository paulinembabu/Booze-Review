package com.example.pauline.booze.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pauline.booze.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by pauline on 4/10/17.
 */

public class userProfile extends AppCompatActivity {

    public static final String TAG = userProfile.class.getSimpleName();

    @Bind(R.id.add_friend)
    ImageView mImageAddFriend;
    @Bind(R.id.header_cover_image)
    ImageView mImageCover;
    @Bind(R.id.user_profile_photo)
    ImageView mImageProfile;
    @Bind(R.id.user_profile_name)
    TextView mProfileName;
    @Bind(R.id.user_profile_short_bio)
    TextView mBio;
    @Bind(R.id.editProfile)
    Button mEditProfileButton;
    @Bind(R.id.reviwed)
    Button mButtonReview;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile);

        ButterKnife.bind(this);

        String name = getIntent().getStringExtra("name");
        String email= getIntent().getStringExtra("email");
        mProfileName.setText(name);
        mBio.setText(email);

        Log.d(TAG,">>>>>>"+name);
    }
}