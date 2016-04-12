package Geometry;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Rohith Shivakumar on 4/2/2016.
 * All rights reserved.
 *
 * Given a two-dimentional graph with points on it. find a line which passes the most number of points
 */
public class MaximumPointsOnLine {
    private Set<Point> points;

    public void setPoints(Set<Point> points) {
        this.points = points;
    }

    /**
     * Creates a map of slope of a line to all points that are present on that line from the given set.
     * @return
     * @throws Exception
     */
    private Map<Double,Set<Point>> createMapOfSlopeToPointsOnLine() throws Exception {
        Map<Double,Set<Point>> map = new HashMap<Double,Set<Point>>();
        Line l;
        Double slope;
        Set<Point> pt;
        String msg = null;
        try {
            if(null != points) {
                for(Point p1 : points) {
                    for(Point p2 : points) {
                        if(!p1.equals(p2)) {
                            l = new Line(p1,p2);
                            slope = l.getSlope();

                            if(map.keySet().contains(slope)) {
                                //Already a line with same slope is present. Add this new line's end and start point
                                pt = map.get(slope);
                            }
                            else {
                                //A line with this slope is seen for the first time. Add it to the map
                                pt = new HashSet<Point>();
                            }
                            pt.add(p1);
                            pt.add(p2);
                            map.put(slope,pt);
                        }
                    }
                }
            }
        }
        catch (Exception e) {
            msg = "Exception occured while creating a map that holds slope as key and all points that fall on the line as value.";
            System.err.println(msg + ". " + e.getMessage());
            throw new Exception(msg,e);
        }
        return map;
    }

    /**
     * Computes the highest number of points that fall on the single line from a given set of points and returns the
     * set that fall on that line.
     * @return
     * @throws Exception
     */
    public Set<Point> getHighestNumberOfPoints() throws Exception {
        String msg = null;
        Set<Point> highestNumberOfPoints = new HashSet<Point>();
        try {
            Map<Double, Set<Point>> map = createMapOfSlopeToPointsOnLine();
            for(Double key : map.keySet()){
                if(map.get(key).size() > highestNumberOfPoints.size()){
                    highestNumberOfPoints = map.get(key);
                }
            }
        }
        catch (Exception e) {
            msg = "Exception occured while getting points that are highest on the same line.";
            System.err.println(msg + ". " + e.getMessage());
            throw new Exception(msg,e);
        }
        return highestNumberOfPoints;
    }

}
