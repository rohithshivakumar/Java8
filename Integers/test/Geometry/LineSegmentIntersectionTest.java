package Geometry;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.DecimalFormat;

import static org.junit.Assert.*;

/**
 * Created by arjun_000 on 4/8/2016.
 */
public class LineSegmentIntersectionTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetIntersetingPoint() throws Exception {

        //Check solutions at http://jsfiddle.net/justin_c_rounds/Gd2S2/

        Point ix = LineSegmentIntersection.getIntersetingPoint(new Point(1,10), new Point(60,60),
                new Point(1,60), new Point(40,0));

        System.out.println(String.format("Point of intersection is (%.2f,%.2f) ",ix.getX(),ix.getY()));

        assertEquals("X-axis intersection Mismatch", 21.95,ix.getX(), 0.5);
        assertEquals("Y-axis intersection Mismatch", 27.76,ix.getY(), 0.5);

       ix = LineSegmentIntersection.getIntersetingPoint(new Point(10,10), new Point(60,60),
                new Point(50,50), new Point(100,100));

        System.out.println(String.format("Point of intersection for overlapping linses is (%.2f,%.2f) ",ix.getX(),ix.getY()));

        assertEquals("X-axis intersection Mismatch", 50,ix.getX(), 0.5);
        assertEquals("Y-axis intersection Mismatch", 50,ix.getY(), 0.5);

        ix = LineSegmentIntersection.getIntersetingPoint(new Point(10,10), new Point(60,60),
                new Point(10,12), new Point(60,62));

        if(ix == null) {
            System.out.println("Point of intersection is null");
        }else{
            System.out.println(String.format("Point of intersection for parallel lines is (%.2f,%.2f) ", ix.getX(), ix.getY()));
        }
        assertNull("Point of intersection should be null",ix);



    }
}