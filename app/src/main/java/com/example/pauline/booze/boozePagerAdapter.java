//package com.example.pauline.booze;
//
//
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentManager;
//import android.support.v4.app.FragmentPagerAdapter;
//
//import java.util.ArrayList;
//
//public class boozePagerAdapter extends FragmentPagerAdapter {
//        private ArrayList<Beer> mBeer= new ArrayList<>();
//
//
//    public boozePagerAdapter(FragmentManager fm, ArrayList<Beer> beer) {
//        super(fm);
//        mBeer = beer;
//    }
//
////    @Override
////    public Fragment getItem(int position) {
////        return boozeDetails.newInstance(mBeer.get(position));
////    }
//
//   @Override
//   public int getCount() {
//   return mBeer.size();
//    }
//
////    @Override
////    public CharSequence getPageTitle(int position) {
////        return mBeer.get(position).getName();
////
////    }
//}