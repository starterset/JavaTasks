package com.espboorg.effectiveJava.item2_builder.activityTracker;

public class Ride extends Activity {
    private String speed;
    private double power;
    private int cadence;

    public static class Builder extends Activity.Builder<Builder> {
        private double maxSpeed;
        private double averagePower;
        private int cadence;

        public Builder(double distance, int duration) {
            super(distance, duration);
        }

        public Builder averagePower(double averagePower) {
            this.averagePower = averagePower;
            return self();
        }

        public Builder cadence(int cadence) {
            this.cadence = cadence;
            return self();
        }

        @Override
        Ride build() {
            return new Ride(self());
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private Ride(Builder builder) {
        super(builder);
        this.power = builder.averagePower;
        this.cadence = builder.cadence;
        setSpeed();
    }

    private void setSpeed() {
        this.speed = String.format("%.2f", super.distance / (super.duration / 3600.0)) + "km/h";
    }

    @Override
    public String toString() {
        return "Ride {" +
                "Distance = " + distance + " km" +
                ", Duration = " + getDuration() +
                ", Speed = " + speed +
                ", Cadence = " + cadence +
                ", Heart Rate = " + super.heartRate +
                ", Elevation = " + super.elevation +
                ", Calories = " + super.calories +
                '}';
    }
}
