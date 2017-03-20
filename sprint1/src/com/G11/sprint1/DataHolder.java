package com.G11.sprint1;

/**
 * Singleton File used to get information from one activity to another
 *
 * Created by Ryan on 3/17/2017.
 */

public class DataHolder {
    private static DataHolder mInstance = null;


    //Stores variables to transfer between activities
    private String mString;
    private float rating1;
    private float rating2;

    private DataHolder(){
        mString = "";
        rating1 = 0;
        rating2 = 0;
    }

    //makes an instance of this class
    public static DataHolder getInstance(){
        if(mInstance == null)
        {
            mInstance = new DataHolder ();
        }
        return mInstance;
    }


    //returns the variables stored when called
    public String getString(){
        return this.mString;
    }
    public float getrating1(){
        return this.rating1;
    }
    public float getrating2(){
        return this.rating2;
    }

    //sets the variables that are to be transfered
    public void setString(String value){
        mString = value;
    }
    public void setrating1(float value){
        rating1 = value;
    }
    public void setrating2(float value){
        rating2 = value;
    }
}
