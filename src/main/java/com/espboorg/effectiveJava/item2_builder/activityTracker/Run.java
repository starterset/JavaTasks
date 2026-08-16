package com.espboorg.effectiveJava.item2_builder.activityTracker;

public class Run extends Activity {
    private String pace;
    private int cadence;

    public static class Builder extends Activity.Builder<Builder> {
        private int cadence;

        public Builder(double distance, int duration) {
            super(distance, duration);
        }

        public Builder cadence(int cadence) {
            this.cadence = cadence;
            return self();
        }

        @Override
        Run build() {
            return new Run(self());
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private Run(Builder builder) {
        super(builder);
        this.cadence = builder.cadence;
        setPace();
    }

    private void setPace() {
        int minutes = (int) (super.duration / super.distance) / 60;
        int seconds = (int) (super.duration / super.distance) % 60;
        this.pace = minutes + ":" + String.format("%02d", seconds) + "/km";
    }

    @Override
    public String toString() {
        return "Run {" +
                "Distance = " + distance + " km" +
                ", Duration = " + getDuration() +
                ", Pace = " + pace +
                ", Cadence = " + cadence +
                ", Heart Rate = " + super.heartRate +
                ", Elevation = " + super.elevation +
                ", Calories = " + super.calories +
                '}';
    }
}
