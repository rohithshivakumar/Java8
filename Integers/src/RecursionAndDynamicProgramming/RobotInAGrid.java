package RecursionAndDynamicProgramming;

import Geometry.Point;

import java.io.Console;
import java.util.*;

/**
 * Robot goes from top left to bottom right, can go only down and right. Find a path if exists between start and end.
 * Also certain cells in the Grid are off limits ( here it is indicated by value of -ve num)
 */
public class RobotInAGrid {
    private static HashMap<Point, Boolean> cache = new HashMap<>();


    public static List<String> findPathTopDown(int[][] grid){
        List<String> pointsList = new ArrayList<>();
        findPathR(grid,grid.length-1,grid[0].length-1,pointsList);
        return pointsList;
    }

    public static List<String> findPathTopDownWithCache(int[][] grid){
        List<String> pointsList = new ArrayList<>();
        findPathRWithCache(grid,grid.length-1,grid[0].length-1,pointsList);
        return pointsList;
    }

    private static boolean findPathRWithCache(int[][] grid, int row, int col, List<String> points){
        if(isOffLimit(grid,row,col)){
            return  false;
        }
        if( row < 0 || col < 0){
            return false;
        }
        Point p = new Point(row,col);
        if(cache.containsKey(p)){
            return cache.get(p);
        }
        boolean success = false;
        //Found final destination point
        if(row == 0 && col == 0 ){
            points.add(new String(String.valueOf(row)+":"+ String.valueOf(col)));
            success = true;
        }
        if(findPathR(grid,row-1,col,points) || findPathR(grid,row,col-1,points)){
            points.add(new String(String.valueOf(row)+":"+ String.valueOf(col)));
            success = true;
        }
        cache.put(p,success);
        return success;
    }
    private static boolean isOffLimit(int[][] grid, int r, int c){
        return (grid[r][c] < 0);
    }
    private static boolean findPathR(int[][] grid, int row, int col, List<String> points){
        if(isOffLimit(grid,row,col)){
            return  false;
        }
        if( row < 0 || col < 0){
            return false;
        }
        //Found final destination point
        if(row == 0 && col == 0 ){
            points.add(new String(String.valueOf(row)+":"+ String.valueOf(col)));
            return true;
        }
        if(findPathR(grid,row-1,col,points) || findPathR(grid,row,col-1,points)){
            points.add(new String(String.valueOf(row)+":"+ String.valueOf(col)));
            return true;
        }
        return false;
    }

    public static List<String> findPathBottomUp(int[][] grid) throws Exception {
        List<String> pointsList = new ArrayList<>();
        boolean[][] table = findPathBottomUpCore(grid);
        pointsList = tracePath(table);
        return pointsList;
    }

    private static void printTable(boolean[][] table) {
        for(int i= 0; i < table.length; i++){
            for(int j=0; j < table[0].length; j++){
                System.out.print(table[i][j]+ " ");
            }
            System.out.println();
        }
    }

    private static boolean[][] findPathBottomUpCore(int[][] grid) throws Exception {
        if(grid == null || grid[0] == null || grid.length ==0 || grid[0].length == 0){
            throw new Exception("Grid is invalid");
        }
        boolean[][] table = new boolean[grid.length][grid[0].length];

        for(int i= 0; i < grid.length; i++){
            for(int j=0; j < grid[0].length; j++){
                table[i][j] = !isOffLimit(grid,i,j);
            }
        }
        System.out.println("After iniializating");
        printTable(table);
        //build table
        for(int i= 1; i < grid.length; i++){
            for(int j=1; j < grid[0].length; j++){
                if(!isOffLimit(grid,i,j)) {
                    table[i][j] = table[i - 1][j] || table[i][j - 1];
                }
            }
        }
        System.out.println("After DP");
        printTable(table);
        return table;
    }
    private static List<String> tracePath(boolean[][] table) throws Exception {
        List<String> points = new ArrayList<>();
        int i = table.length -1;
        int j = table[0].length -1 ;

        while(i > 0 && j> 0){
            if(table[i][j]){
                points.add(new String(String.valueOf(i)+":"+ String.valueOf(j)));
            }
            if(table[i-1][j]){
                i--;
                continue;
            }
            if(table[i][j-1]){
                j--;
                continue;
            }


        }
        //Can move only column
        if(i ==0 ){
            while(j>0){
                points.add(new String(String.valueOf(i)+":"+ String.valueOf(j)));
                j--;
            }
        }

        //Can move only rows
        if(j ==0 ){
            while(i>0){
                points.add(new String(String.valueOf(i)+":"+ String.valueOf(j)));
                i--;
            }
        }
        points.add(new String(String.valueOf(i)+":"+ String.valueOf(j)));
        //Since we are back tracking path is reversed
        Collections.reverse(points);
        return points;

    }


}
