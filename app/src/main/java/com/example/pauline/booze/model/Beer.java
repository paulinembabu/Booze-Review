package com.example.pauline.booze.model;

import com.example.pauline.booze.R;

import org.parceler.Parcel;

import java.util.Random;

/**
 * Created by pauline on 3/28/17.
 */

@Parcel

public class Beer {

    public String  name;
    //private String  mNameDisplay;
   public String description;

    int image= R.drawable.beer1;
    int image1 = R.drawable.beer1;
    int image2 =R.drawable.beer2;
    int image3 = R.drawable.beer3;
    int image4 =R.drawable.beer4;
    int image5 = R.drawable.beer5;
    int image6 = R.drawable.beer6;
    int image7 = R.drawable.beer7;
    int image8 = R.drawable.beer8;


    private int [] beerImages =new  int [] {image,image1,image2,image3,image4,image5,image6,image7,image8};





    public  Beer(){}


    public Beer(String name,String description){
        this.name=name;
        //this.mNameDisplay=mNameDisplay;
        this.description=description;
    }
    public String getName() {

        return name;
    }
//    public String getNameDisplay() {
//        return mNameDisplay;
//    }

    public String getDescription() {
        return description;
    }


    public int getImage(){
     int randomImage = new Random().nextInt(beerImages.length);
        return beerImages[randomImage];
    }

}
