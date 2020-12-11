package com.example.myapplication;

public class public_url {
    private String per_url;
    public String getPer_url(){return per_url;}
    public void setPer_url(String url){this.per_url = url;}
    private static public_url instance = null;

    public static synchronized public_url getInstance(){

        if(null == instance){

            instance = new public_url();

        }


        return instance;

    }



}
