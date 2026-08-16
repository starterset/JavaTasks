package com.espboorg.effectiveJava.item2_builder.activityTracker;

public class Main {
    public static void main(String[] args) {
        Activity run = new Run.Builder(5, 1200)
                .cadence(176)
                .elevation(127)
                .averageHeartRate(146)
                .calories(334)
                .build();
        Activity ride = new Ride.Builder(102, 11380)
                .cadence(90)
                .elevation(1250)
                .averageHeartRate(154)
                .averagePower(226)
                .calories(1231)
                .build();

        System.out.println(run);
        System.out.println(ride);
    }
}
