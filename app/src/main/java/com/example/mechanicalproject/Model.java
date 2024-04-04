package com.example.mechanicalproject;

import java.io.Serializable;

public class Model implements Serializable {
    String distance;
    String distanceCount;
    String magnitude;
    String magnitudeCount;
    int back;

    public Model(String distance, String distanceCount, String magnitude, String magnitudeCount, int back) {
        this.distance = distance;
        this.distanceCount = distanceCount;
        this.magnitude = magnitude;
        this.magnitudeCount = magnitudeCount;
        this.back = back;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getDistanceCount() {
        return distanceCount;
    }

    public void setDistanceCount(String distanceCount) {
        this.distanceCount = distanceCount;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(String magnitude) {
        this.magnitude = magnitude;
    }

    public String getMagnitudeCount() {
        return magnitudeCount;
    }

    public void setMagnitudeCount(String magnitudeCount) {
        this.magnitudeCount = magnitudeCount;
    }

    public int getBack() {
        return back;
    }

    public void setBack(int back) {
        this.back = back;
    }
}
