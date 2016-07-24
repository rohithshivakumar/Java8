package RecursionAndDynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * ou are given a matrix with  rows and  columns of cells, each of which contains either  or . Two cells are said to be connected if they are adjacent to each other horizontally, vertically, or diagonally. The connected and filled (i.e. cells that contain a ) cells form a region. There may be several regions in the matrix. Find the number of cells in the largest region in the matrix.

 Input Format
 There will be three parts of t input:
 The first line will contain , the number of rows in the matrix.
 The second line will contain , the number of columns in the matrix.
 This will be followed by the matrix grid: the list of numbers that make up the matrix.

 Output Format
 Print the length of the largest region in the given matrix.

 Constraints



 Sample Input:

 4
 4
 1 1 0 0
 0 1 1 0
 0 0 1 0
 1 0 0 0
 Sample Output:

 5
 Task:
 Write the complete program to find the number of cells in the largest region.

 Explanation

 X X 0 0
 0 X X 0
 0 0 X 0
 1 0 0 0
 The X characters indicate the largest connected component, as per the given definition. There are five cells in this component.
 */
public class ConnectedCell {
    static boolean[][] visited;
    public static void main(String[] args) throws Exception{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int rows = Integer.parseInt(br.readLine());
        int cols = Integer.parseInt(br.readLine());

        int[][] board = new int[rows][cols];
        visited= new boolean[rows][cols];

        for(int i = 0; i < rows; i++){
            String row = br.readLine();
            String[] cells = row.split(" ");
            for(int j =0; j < cols; j++){
                board[i][j] = Integer.parseInt(cells[j]);
            }
        }
        int maxC = 0;
        for(int i = 0; i < rows; i++){
            for(int j =0; j < cols; j++){
                init(visited, rows , cols);
                //visited[i][j] = true;
                // System.out.println("--------Starting for " + i +":" + j);
                int size = getMaxSize(board, i ,j);
                // getMaxSizeWithCell(board, i ,j, 1 );
                //int size = board[i][j];
                if(size > maxC){
                    maxC = size;
                }
                // visited[i][j] = false;
            }
        }

        System.out.println(maxC);
    }

    private static void init(boolean[][] visited , int rows , int cols){
        for(int i = 0; i < rows; i++){
            for(int j =0; j < cols; j++){

                visited[i][j] = false;

            }
        }
    }

    private static boolean inBounds(int[][] board, int row , int col){
        //check row bounds
        if(row < 0 || row >= board.length){
            //System.out.println("Row is out of bound , it is " + row);
            return false;
        }

        if(col < 0 || col >= board[0].length){
            //System.out.println("Col is out of bound , it is " + col);
            return false ;
        }
        return true;
    }
    private static int getMaxSize(int[][] board, int row , int col){
        // System.out.println("Visiting ("+ row + ":" + col + ")" );
        //check row bounds
        if(row < 0 || row >= board.length){
            //System.out.println("Row is out of bound , it is " + row);
            return 0;
        }

        if(col < 0 || col >= board[row].length){
            //System.out.println("Col is out of bound , it is " + col);
            return 0;
        }
        if(visited[row][col] == true){
            // System.out.println("Visited cell already :"+ row + "," + col + " ,returning size:" + (size - 1) );
            return 0 ;
        }
        if(board[row][col] == 0){
            //  System.out.println("Visited cell has \"0\" :"+ row + "," + col + " ,returning size:" + (size - 1) );
            return 0;
        }
        visited[row][col] = true;
        //go in all directions up,down ,left right and diagnals and return max size
        int leftS = getMaxSize(board, row , col - 1 );
        int rightS = getMaxSize(board, row , col + 1 );
        int upS = getMaxSize(board, row-1 , col );
        int downS = getMaxSize(board, row + 1 , col );
        int diagRDS = getMaxSize(board, row + 1 , col + 1 );
        int diagLUS = getMaxSize(board, row - 1 , col - 1);
        int sDiagRUS = getMaxSize(board, row - 1 , col + 1);
        int sDiagLDS = getMaxSize(board, row +1 , col -1);
        //System.out.println(leftS +" "+ rightS + " "+  upS + " "+ downS + " "+ diagRDS +  " " + diagLUS + " "+  sDiagRUS + " "+  sDiagLDS);

        // int max = Math.max( Math.max(Math.max(Math.max( Math.max(Math.max (Math.max(leftS, rightS) , upS), downS), diagRDS), diagLUS), sDiagRUS), sDiagLDS);
        int max = leftS + rightS + upS + downS + diagRDS + diagLUS + sDiagRUS + sDiagLDS + 1;
        // System.out.println("Max:" + max);
        return max;
    }




}
