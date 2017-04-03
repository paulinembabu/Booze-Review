//package com.example.pauline.booze;
//
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//
//import org.parceler.Parcels;
//
//import java.util.ArrayList;
//
//import butterknife.ButterKnife;
//
//public class boozeDetail extends AppCompatActivity {
//
//    private boozePagerAdapter adapterViewPager;
//    ArrayList<Beer> mBeer = new ArrayList<>();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_booze_details);
//        View view =
//    ButterKnife.bind(this);
//
//        mBeer = Parcels.unwrap(getIntent().getParcelableExtra("beer"));
//        int currentPosition = getIntent().getIntExtra("position", 0);
//
//        adapterViewPager = new boozePagerAdapter(getSupportFragmentManager(), mBeer);
//        mViewPager.setAdapter(adapterViewPager);
//        mViewPager.setCurrentItem(currentPosition);
//
//
//    }
//}