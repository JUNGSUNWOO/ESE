package com.example.myapplication;

public class myinformation_item {
    String date;
    String distance;
    String best_race;
    String worst_race;
    String normal_race;

    public myinformation_item(String date, String distance, String best_race, String worst_race, String normal_race) {
        this.date = date;
        this.distance = distance;
        this.best_race = best_race;
        this.worst_race = worst_race;
        this.normal_race = normal_race;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getBest_race() {
        return best_race;
    }

    public void setBest_race(String best_race) {
        this.best_race = best_race;
    }

    public String getWorst_race() {
        return worst_race;
    }

    public void setWorst_race(String worst_race) {
        this.worst_race = worst_race;
    }

    public String getNormal_race() {
        return normal_race;
    }

    public void setNormal_race(String normal_race) {
        this.normal_race = normal_race;
    }

    @Override
    public String toString() {
        return "myinformation_item{" +
                "date='" + date + '\'' +
                ", distance='" + distance + '\'' +
                ", best_race='" + best_race + '\'' +
                ", worst_race='" + worst_race + '\'' +
                ", normal_race='" + normal_race + '\'' +
                '}';
    }
}
