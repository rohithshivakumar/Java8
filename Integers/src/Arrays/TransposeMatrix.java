package Arrays;

/**
 * Created by arjun_000 on 2/16/2016.
 */
public class TransposeMatrix {
    public static int[][] transposeMatrixExtraMemory(int[][] m , int row, int col){
        int[][] transMatrix = new int[col][row];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                transMatrix[j][i] = m[i][j];
            }
        }
        return transMatrix;
    }

    public static int[][] transposeMatrixInPlace(int[][] m , int row, int col){
        int[][] transMatrix = new int[col][row];
        return transMatrix;
    }

    public static void printMatrix(int[][] m){
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }
}
