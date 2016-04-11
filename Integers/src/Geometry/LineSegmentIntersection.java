package Geometry;

/**
 * Given 2 Line Segments, return the point of Intersection
 * You are given the points of the line segments
 */
public class LineSegmentIntersection {
    public static Point getIntersetingPoint(Point start1, Point end1, Point start2, Point end2) {
        Point intersection = null;

        //Sort Points by occurence on X-Axis
        if (start1.getX() > end1.getX()) {
            swap(start1, end1);
        }
        if (start2.getX() > end2.getX()) {
            swap(start2, end2);
        }
        if (start1.getX() > start2.getX()) {
            swap(start1, start2);
            swap(end1, end2);
        }


        //Create the Line Segments
        Line l1 = new Line(start1, end1);
        Line l2 = new Line(start2, end2);

        //if slopes are same then it could be parallel lines
        if (l1.getSlope() == l2.getSlope()) {
            //if the intercepts are same and start2 is in between Start1 and end2, then start 2 is the
            //intersecting point
            if (l1.getyIntercept() == l2.getyIntercept() && isBetween(start1, start2, end2)) {
                return start2;
            }
            return null;

        }

        //Else the line slopes are different

        double x = (l2.getyIntercept() - l1.getyIntercept()) / (l1.getSlope() - l2.getSlope());
        double y = x * l1.getSlope() + l1.getyIntercept();
        intersection = new Point(x, y);

        if (isBetween(start1, intersection, end1) && isBetween(start2, intersection, end2)) {
            return intersection;
        }
        return null;
    }

    private static boolean isBetween(Point start, Point middle, Point end) {
        return isBetween(start.getX(), middle.getX(), end.getX())
                && isBetween(start.getY(), middle.getY(), end.getY());
    }

    private static boolean isBetween(double start, double middle, double end) {
        if (start > end) {
            return end <= middle && middle <= start;
        }
        return start <= middle && middle <= end;

    }

    private static void swap(Point start1, Point end1) {
        Point temp = new Point(start1.getX(), start1.getY());
        start1.setX(end1.getX());
        start1.setY(end1.getY());
        end1.setX(temp.getX());
        end1.setY(temp.getY());
    }
}
