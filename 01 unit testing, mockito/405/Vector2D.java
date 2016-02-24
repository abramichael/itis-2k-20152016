/**
 * Created by ma on 15.02.2016.
 */
public class Vector2D {
    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Vector2D() {
        this(0, 0);
    }
    public double length() {
        return Math.sqrt(x * x + y * y);
    }
    private double x, y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Vector2D add(Vector2D v2) {
        return null;
    }
}
