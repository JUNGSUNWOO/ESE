package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class myfighting_item {
    String distance;
    String best_race;
    String worst_race;
    String normal_race;


    public myfighting_item(String distance, String best_race, String worst_race, String normal_race) {
        this.distance = distance;
        this.best_race = best_race;
        this.worst_race = worst_race;
        this.normal_race = normal_race;
    }

    public String getDistance2() {
        return distance;
    }

    public void setDistance2(String distance) {
        this.distance = distance;
    }

    public String getBest_race2() {
        return best_race;
    }

    public void setBest_race2(String best_race) {
        this.best_race = best_race;
    }

    public String getWorst_race2() {
        return worst_race;
    }

    public void setWorst_race2(String worst_race) {
        this.worst_race = worst_race;
    }

    public String getNormal_race2() {
        return normal_race;
    }

    public void setNormal_race2(String normal_race) {
        this.normal_race = normal_race;
    }
}