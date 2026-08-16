package com.espboorg.effectiveJava.item2_builder.activityTracker;

public abstract class Activity {
    protected final double distance;
    protected final int duration;
    protected int elevation;
    protected int heartRate;
    protected int calories;

    public static abstract class Builder<T extends Builder<T>> {
        private final double distance;
        private final int duration;
        private int elevation;
        private int averageHeartRate;
        private int calories;

        public Builder(double distance, int duration) {
            this.distance = distance;
            this.duration = duration;
        }

        public T elevation(int elevation) {
            this.elevation = elevation;
            return self();
        }

        public T averageHeartRate(int averageHeartRate) {
            this.averageHeartRate = averageHeartRate;
            return self();
        }

        public T calories(int calories) {
            this.calories = calories;
            return self();
        }

        abstract Activity build();

        protected abstract T self();
    }

    protected Activity(Builder<?> builder) {
        this.distance = builder.distance;
        this.duration = builder.duration;
        this.elevation = builder.elevation;
        this.heartRate = builder.averageHeartRate;
        this.calories = builder.calories;
    }

    public String getDuration() {
        StringBuilder time = new StringBuilder();
        int hours = duration / 3600;
        int minutes = (duration % 3600) / 60;
        int seconds = duration % 60;
        return hours > 0 ? String.format("%d:%02d:%02d", hours, minutes, seconds)
                : String.format("%d:%02d", minutes, seconds);
    }
}
