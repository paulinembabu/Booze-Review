package com.example.pauline.booze;

import org.parceler.Parcel;

/**
 * Created by pauline on 3/28/17.
 */

@Parcel

public class Beer {

    public String  name;
    //private String  mNameDisplay;
   public String description;



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
}
