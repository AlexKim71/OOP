package ua.opnu;

public class TimeSpan {
    private int hours;
    private int minutes;

    // Конструктор без аргументів (0 годин, 0 хвилин)
    public TimeSpan() {
        this.hours = 0;
        this.minutes = 0;
    }

    // Конструктор з 1 аргументом (хвилини)
    public TimeSpan(int minutes) {
        this.hours = minutes / 60;
        this.minutes = minutes % 60;
    }

    // Конструктор з 2 аргументами (години та хвилини)
    public TimeSpan(int hours, int minutes) {
        this.hours = hours + minutes / 60;
        this.minutes = minutes % 60;
    }

    // Конструктор з 1 аргументом типу TimeSpan
    public TimeSpan(TimeSpan other) {
        this.hours = other.hours;
        this.minutes = other.minutes;
    }

    // Додавання часу (години та хвилини)
    public void add(int hours, int minutes) {
        int totalMinutes = this.hours * 60 + this.minutes + hours * 60 + minutes;
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }

    // Додавання часу (хвилини)
    public void add(int minutes) {
        add(0, minutes);
    }

    // Додавання часу (TimeSpan)
    public void add(TimeSpan other) {
        add(other.hours, other.minutes);
    }

    // Віднімання часу (години та хвилини)
    public void subtract(int hours, int minutes) {
        int totalMinutes = this.hours * 60 + this.minutes - (hours * 60 + minutes);
        if (totalMinutes < 0) {
            this.hours = 0;
            this.minutes = 0;
        } else {
            this.hours = totalMinutes / 60;
            this.minutes = totalMinutes % 60;
        }
    }

    // Віднімання часу (хвилини)
    public void subtract(int minutes) {
        subtract(0, minutes);
    }

    // Віднімання часу (TimeSpan)
    public void subtract(TimeSpan other) {
        subtract(other.hours, other.minutes);
    }

    // Гетери
    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    // Для зручного виводу
    @Override
    public String toString() {
        return String.format("%d hours, %d minutes", hours, minutes);
    }
}