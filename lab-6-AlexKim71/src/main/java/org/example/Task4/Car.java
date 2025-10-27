package org.example.Task4;

// Клас автомобіля що реалізує Comparable
public class Car implements Comparable {
    private int price;
    private int year;
    private int horsePower;

    public Car(int price, int year, int horsePower) {
        this.price = price;
        this.year = year;
        this.horsePower = horsePower;
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Car)) {
            return 0;
        }
        
        Car other = (Car) o;
        
        // Спочатку порівнюємо ціну (менша ціна = "більше")
        if (this.price < other.price) {
            return 1;
        } else if (this.price > other.price) {
            return -1;
        }
        
        // Якщо ціни рівні, порівнюємо рік (новіший = "більше")
        if (this.year > other.year) {
            return 1;
        } else if (this.year < other.year) {
            return -1;
        }
        
        // Якщо роки рівні, порівнюємо кінські сили (більше = "більше")
        if (this.horsePower > other.horsePower) {
            return 1;
        } else if (this.horsePower < other.horsePower) {
            return -1;
        }
        
        return 0;
    }

    public int getPrice() { return price; }
    public int getYear() { return year; }
    public int getHorsePower() { return horsePower; }
}