package Games;

import java.util.ArrayList;

/**
 * Created by arjun on 7/12/16.
 */
public class Sudoku {
    public void solveSudoku(ArrayList<ArrayList<Character>> a) {
        solve(a);
    }

    public boolean solve(ArrayList<ArrayList<Character>> a){
        Integer row = null, col = null;
        int[] rc = new int[2];
        if(!findEmptyRowCol(a,rc)){
            return true;
        }
        row = rc[0];
        col = rc[1];
        System.out.print("===="+row+":"+col+"====");
        for(Character n = '1' ; n <= '9'; n++){
            System.out.print("Trying:"+n);
            if(isValid(a,row,col)){
                a.get(row).set(col, n);
                if(solve(a)){
                    System.out.print("Success");
                    return true;
                }
                a.get(row).set(col,'.');
                System.out.print("Val:" + a.get(row).get(col));
            }
        }
        return false;
    }

    public boolean findEmptyRowCol(ArrayList<ArrayList<Character>> a, int[] rc){
        for(int i=0 ; i < 9 ; i++){

            for(int j= 0; j < 9 ; j++){

                if(a.get(i).get(j) == '.'){
                    //System.out.print( i + ":"+ j);
                    rc[0] =i;
                    rc[1] = j;
                    return true;
                }
            }

        }
        return false;
    }
    public void printBoard(ArrayList<ArrayList<Character>> a){
        for(int i=0 ; i < 9 ; i++){
            System.out.print("[");
            for(int j= 0; j < 9 ; j++){

                System.out.print(a.get(j) + ",");
            }
            System.out.print("]");
        }
    }
    public boolean isValid(ArrayList<ArrayList<Character>> a, Integer row, Integer col){

        if(row == null || col == null){
            return false;
        }
        Character num = a.get(row).get(col);

        //check Row
        for(int i=0 ; i < 9 ; i++){
            if(a.get(i).get(col) == num)return false;
        }
        //check column
        for(int i=0 ; i < 9 ; i++){
            if(a.get(row).get(i) == num)return false;
        }
        //check the box
        Integer boxRow = row - (row % 3);
        Integer boxCol = col - (col % 3);

        for(int i=0 ; i < 3 ; i++){

            for(int j= 0; j < 3 ; j++){

                if(a.get(i+boxRow).get(j+boxCol) == num){
                    return false;
                }
            }

        }
        return true;
    }
}
