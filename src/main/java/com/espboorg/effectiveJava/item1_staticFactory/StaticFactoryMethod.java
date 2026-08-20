package com.espboorg.effectiveJava.item1_staticFactory;

class Geolocation {
    private final double latitude;
    private final double longitude;

    private Geolocation(double latitude, double longitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public static Geolocation instance(double latitude, double longitude) {
        return new Geolocation(latitude, longitude);
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    @Override
    public String toString() {
        return latitude + ", " + longitude;
    }
}

public class StaticFactoryMethod {
    public static void main(String[] args) {
        Geolocation loc = Geolocation.instance(40.187666, 44.482798);
        System.out.println(loc);
    }
}
