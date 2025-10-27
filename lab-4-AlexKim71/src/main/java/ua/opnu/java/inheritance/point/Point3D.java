package ua.opnu.java.inheritance.point;

public class Point3D extends Point {
    private int z;

    // Конструктори
    public Point3D() {
        super(0, 0);
        this.z = 0;
    }

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public Point3D(Point3D p) {
        super(p.getX(), p.getY());
        this.z = p.getZ();
    }

    // Геттер координати z
    public int getZ() {
        return z;
    }

    // setLocation(x, y) встановлює z = 0
    @Override
    public void setLocation(int x, int y) {
        super.setLocation(x, y);
        this.z = 0;
    }

    // setLocation(x, y, z)
    public void setLocation(int x, int y, int z) {
        super.setLocation(x, y);
        this.z = z;
    }

    // Відстань від поточної точки до іншої Point3D
    public double distance(Point3D p) {
        int dx = this.getX() - p.getX();
        int dy = this.getY() - p.getY();
        int dz = this.z - p.getZ();
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    // Перевизначення distanceFromOrigin()
    @Override
    public double distanceFromOrigin() {
        int x = this.getX();
        int y = this.getY();
        return Math.sqrt(x * x + y * y + z * z);
    }

    // Перевизначення toString()
    @Override
    public String toString() {
        return "(" + getX() + "," + getY() + "," + z + ")";
    }
}
