package Geometry;

/**
 * Created by arjun_000 on 4/7/2016.
 */
public class Point {
    private double x;
    private double y;

    public Point(double x, double y){
        this.setX(x);
        this.setY(y);
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}
