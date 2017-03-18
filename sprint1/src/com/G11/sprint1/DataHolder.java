package com.G11.sprint1;

/**
 * Created by Ryan on 3/17/2017.
 */

public class DataHolder {
    private static DataHolder mInstance = null;

    private String mString;
    private float rating1;
    private float rating2;

    private DataHolder(){
        mString = "";
        rating1 = 0;
        rating2 = 0;
    }


    public static DataHolder getInstance(){
        if(mInstance == null)
        {
            mInstance = new DataHolder ();
        }
        return mInstance;
    }

    public String getString(){
        return this.mString;
    }
    public float getrating1(){
        return this.rating1;
    }
    public float getrating2(){
        return this.rating2;
    }


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
