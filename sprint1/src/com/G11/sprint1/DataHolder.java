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
    private String mString2;
    private float rating1_2;
    private float rating2_2;
    private String mString3;
    private float rating1_3;
    private float rating2_3;
    private int numFB;
    private String studnetid;
    private String computingid;
    private String firstname;
    private String lastname;
    private Boolean s_loggedIn;
    private Boolean a_loggedIn;

    private DataHolder(){
        mString = "";
        rating1 = 0;
        rating2 = 0;
        mString2 = "";
        rating1_2= 0;
        rating2_2 = 0;
        mString3 = "";
        rating1_3= 0;
        rating2_3 = 0;
        numFB = 0;
        studnetid="";
        computingid="";
        firstname="";
        lastname="";
        s_loggedIn=false;
        a_loggedIn=false;
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
    public String getString2(){return this.mString2;}
    public float getrating1_2(){return this.rating1_2;}
    public float getrating2_2(){
        return this.rating2_2;
    }
    public String getString3(){
        return this.mString3;
    }
    public float getrating1_3(){
        return this.rating1_3;
    }
    public float getrating2_3(){
        return this.rating2_3;
    }
    public int getNumFB() {return this.numFB; }
    public String getstudnetid(){return this.studnetid;}
    public String getcomputingid(){return this.computingid;}
    public String getfirstname(){return this.firstname;}
    public String getlastname(){return this.lastname;}
    public Boolean get_s_status(){return this.s_loggedIn;}
    public Boolean get_a_status(){return this.a_loggedIn;}

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
    public void setString2(String value){
        mString2 = value;
    }
    public void setrating1_2(float value){
        rating1_2 = value;
    }
    public void setrating2_2(float value){
        rating2_2 = value;
    }
    public void setString3(String value){
        mString3 = value;
    }
    public void setrating1_3(float value){
        rating1_3 = value;
    }
    public void setrating2_3(float value){rating2_3 = value;}
    public void setnumFB(int value) {numFB = value; }
    public void setstudentid(String s){studnetid=s;}
    public void setcomputingid(String s){computingid=s;}
    public void setfirstname(String s){firstname=s;}
    public void setlastname(String s){lastname=s;}
    public void set_s_status(Boolean l){s_loggedIn=l;}
    public void set_a_status(Boolean l){a_loggedIn=l;}
}
