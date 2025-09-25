package ua.opnu;

public class TimeSpan {
    private int hours;
    private int minutes;

    TimeSpan(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes >= 60) {
            this.hours = 0;
            this.minutes = 0;
        } else {
            this.hours = hours;
            this.minutes = minutes;
        }
    }

    int getHours() {
        return hours;
    }

    int getMinutes() {
        return minutes;
    }

    void add(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes >= 60) return;
        int totalMinutes = this.hours * 60 + this.minutes + hours * 60 + minutes;
        if (totalMinutes < 0) return;
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }

    void addTimeSpan(TimeSpan timespan) {
        if (timespan == null) return;
        add(timespan.getHours(), timespan.getMinutes());
    }

    double getTotalHours() {
        return hours + minutes / 60.0;
    }

    int getTotalMinutes() {
        return hours * 60 + minutes;
    }

    void subtract(TimeSpan span) {
        if (span == null) return;
        int currentTotal = this.hours * 60 + this.minutes;
        int subtractTotal = span.getHours() * 60 + span.getMinutes();
        if (currentTotal >= subtractTotal) {
            int newTotal = currentTotal - subtractTotal;
            this.hours = newTotal / 60;
            this.minutes = newTotal % 60;
        }
    }

    void scale(int factor) {
        if (factor <= 0) return;
        int totalMinutes = (hours * 60 + minutes) * factor;
        if (totalMinutes < 0) return;
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }
}