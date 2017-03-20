package com.G11.sprint1;

/**
 * Created by Ryan on 3/17/2017.
 */

public class DataHolder {
    private static DataHolder mInstance = null;

    private String mString;
    private float rating1;
    private float rating2;
    private String studnetid;
    private String computingid;
    private String firstname;
    private String lastname;

    private DataHolder(){
        mString = "";
        rating1 = 0;
        rating2 = 0;
        studnetid="";
        computingid="";
        firstname="";
        lastname="";
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
    public String getstudnetid(){return this.studnetid;}
    public String getcomputingid(){return this.computingid;}
    public String getfirstname(){return this.firstname;}
    public String getlastname(){return this.lastname;}

    public void setString(String value){
        mString = value;
    }
    public void setrating1(float value){
        rating1 = value;
    }
    public void setrating2(float value){
        rating2 = value;
    }
    public void setstudentid(String s){studnetid=s;}
    public void setcomputingid(String s){computingid=s;}
    public void setfirstname(String s){firstname=s;}
    public void setlastname(String s){lastname=s;}
}
