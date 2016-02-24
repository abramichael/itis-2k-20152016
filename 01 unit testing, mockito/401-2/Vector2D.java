/**
 * Created by ma on 19.02.2016.
 */
public class Vector2D {

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D() {
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
        return new Vector2D(x + v2.getX(), y + v2.getY());
    }

    public boolean equals(Object v) {
        /*
        try {
            Vector2D v2 = (Vector2D) v;
            return (x == v2.getX() && y == v2.getY());
        }
        catch (ClassCastException e) {
            return false;
        }*/
        if (v instanceof Vector2D) {
            Vector2D v2 = (Vector2D) v;
            return (x == v2.getX() && y == v2.getY());
        }
        else {
            return false;
        }
    }

    public void reduceLengthBy(int n) throws LengthReduceException {
        if (n <= 0)
            throw new LengthReduceException();
        this.x /= n;
        this.y /= n;
    }
}
