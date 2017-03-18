package com.G11.sprint1;

/**
 * Created by Ryan on 3/17/2017.
 */

public class DataHolder {
    private static DataHolder mInstance = null;

    private String mString;

    private DataHolder(){
        mString = "Hello";
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

    public void setString(String value){
        mString = value;
    }
}
