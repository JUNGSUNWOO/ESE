package com.example.myapplication;

import android.graphics.drawable.Drawable;

public class page4_Item {

    private String maxspeed ;
    private String lowspeed ;
    private String avespeed ;
    private String time;
    private String id;

    public void setMax(String maxspeed) {
        this.maxspeed = maxspeed ;
    }
    public void setLow (String lowspeed) {
        this.lowspeed = lowspeed ;
    }
    public void setAve (String avespeed) {
        this.avespeed = avespeed ;
    }
    public void setTime (String time) {
        this.time = time ;
    }
    public void setId(String id){this.id = id;}
    public String getMax() {
        return this.maxspeed ;
    }
    public String getLow() {
        return this.lowspeed ;
    }
    public String getAve() {
        return this.avespeed ;
    }
    public String getTime() {
        return this.time ;
    }
    public String getId(){return this.id;}
}