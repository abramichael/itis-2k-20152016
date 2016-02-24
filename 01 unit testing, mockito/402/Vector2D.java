/**
 * Created by ma on 16.02.2016.
 */
public class Vector2D {

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D() {
    }

    public double length(){
        return Math.sqrt(x * x + y * y);
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }

    private double x;
    private double y;

}
