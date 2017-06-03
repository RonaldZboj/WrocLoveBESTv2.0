package com.example.android.wroclovebest;

/**
 * Created by RonaldZboj on 2017-05-30.
 */

/**
 * {@link Attraction} represents the place in Wroclaw. It contains name, image for
 * this place and coordinates to show the place on the map.
 */

public class Attraction {

    /**
     * String ID resource for name
     */
    private int mName;

    /**
     * String ID resource for description
     */

    private int mDescription;

    /**
     * Image resource for attraction
     */
    private int mImageResourceId;

    /**
     * Latitude for coordinates
     */
    private double mLatitude;

    /**
     * longitude for coordinates
     */
    private double mLongitude;

    /**
     * Create a new Attraction object.
     */

    public Attraction(int imageResourceId, int name, int description, double latitude, double longitude) {
        mImageResourceId = imageResourceId;
        mName = name;
        mDescription = description;
        mLatitude = latitude;
        mLongitude = longitude;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public int getName() {
        return mName;
    }

    public int getDescription() {
        return mDescription;
    }

    public double getLatitude() {
        return mLatitude;
    }

    public double getLongitude() {
        return mLongitude;
    }

}
