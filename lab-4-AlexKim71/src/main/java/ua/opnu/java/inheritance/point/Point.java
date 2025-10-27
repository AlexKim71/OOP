package ua.opnu.java.inheritance.point;

public class Point {
    private int x;
    private int y;

    // Конструктори
    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point p) {
        this.x = p.getX();
        this.y = p.getY();
    }

    // Геттери
    public int getX() { return x; }
    public int getY() { return y; }

    // Встановлення координат
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Відстань до іншої точки
    public double distance(Point p) {
        int dx = this.x - p.getX();
        int dy = this.y - p.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    // Відстань від початку координат
    public double distanceFromOrigin() {
        return Math.sqrt(x * x + y * y);
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
