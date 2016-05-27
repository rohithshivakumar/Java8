package RecursionAndDynamicProgramming;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by arjun_000 on 5/26/2016.
 */
public class RobotInAGridTest {

    private int[][] grid;
    @Before
    public void setUp() throws Exception {
        grid = new int[4][4];
        for(int i= 0; i < 4; i++){
            for(int j=0; j < 4; j++){
                grid[i][j] = 1;
            }
        }

        grid[1][1] = -999;
        grid[0][1] = -999;
        grid[1][2] = -999;
        grid[2][3] = -999;
        grid[2][2] = -999;

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testFindPath() throws Exception {
        List<String> points = RobotInAGrid.findPathTopDown(grid);
        StringBuffer finalList= new StringBuffer();

        String expectedList = "(0:0)(1:0)(2:0)(2:1)(3:1)(3:2)(3:3)";
        System.out.println("*****************");
        for (String s :points) {
            finalList.append("(");
            finalList.append(s);
            finalList.append(")");
        }
        System.out.println("*****************");
        System.out.println(finalList.toString());
        System.out.println(expectedList);
        assertTrue(expectedList.contentEquals(finalList));

    }

    @Test
    public void testFindPathBottomUp() throws Exception {
        List<String> points = RobotInAGrid.findPathBottomUp(grid);
        StringBuffer finalList= new StringBuffer();
        String expectedList = "(0:0)(1:0)(2:0)(2:1)(3:1)(3:2)(3:3)";
        System.out.println("*****************");
        for (String s :points) {
            finalList.append("(");
            finalList.append(s);
            finalList.append(")");
        }
        System.out.println("*****************");
        System.out.println(finalList.toString());
        System.out.println(expectedList);
        assertTrue(expectedList.contentEquals(finalList));
    }

    @Test
    public void testFindPathTopDownWithCache() throws Exception {
        List<String> points = RobotInAGrid.findPathTopDownWithCache(grid);
        StringBuffer finalList= new StringBuffer();
        String expectedList = "(0:0)(1:0)(2:0)(2:1)(3:1)(3:2)(3:3)";
        System.out.println("*****************");
        for (String s :points) {
            finalList.append("(");
            finalList.append(s);
            finalList.append(")");
        }
        System.out.println("*****************");
        System.out.println(finalList.toString());
        System.out.println(expectedList);
        assertTrue(expectedList.contentEquals(finalList));
    }
}