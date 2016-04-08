package Geometry;

/**
 * Created by arjun_000 on 4/7/2016.
 */
public class Line {
    private Point startPoint;
    private Point endPoint;
    private double slope;
    private double yIntercept;

    public Line(Point start, Point end){

        setStartPoint(start);
        setEndPoint(end);
        setSlope((getEndPoint().getY() - getStartPoint().getY())/(getEndPoint().getX() - getStartPoint().getX()));
        setyIntercept(getEndPoint().getY() - getSlope() * end.getX());

    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    public double getSlope() {
        return slope;
    }

    public void setSlope(double slope) {
        this.slope = slope;
    }

    public double getyIntercept() {
        return yIntercept;
    }

    public void setyIntercept(double yIntercept) {
        this.yIntercept = yIntercept;
    }
}
