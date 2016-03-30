package Arrays;

/**
 * Created by arjun_000 on 2/16/2016.
 * Alternate question : Rotate an image by 90 degrees (Clockwise)
 *
 * Clarifications:
 * 1) N * M or N * N
 * 2) If N * M, should we do it in-place
 *      a. Yes, then we assume there is extra memory in the array or then we use additional space
 *      b. No, then we should do it in-place
 *
 */

/**
 * The following code will handle all combinations. Following are the combinations
 * 1) N * M and not in-place to the right
 * 2) N * M and not in-place to the left
 * 3) N * M and in-place to the right with extra space provided in the array
 * 4) N * M and in-place to the left with extra space provided in the array
 */
public class RotateMatrix90 {

    public int[][] rotateMatrixRightNotInplace(int[][] arr) throws Exception {
        int[][] rotatedArr = null;
        String msg = null;
        try {
            if(null != arr) {
                int row = arr.length;
                int col = arr[0].length;

                rotatedArr = new int[col][row];

                for(int n = 0; n < row; n++) {
                    for(int m = 0; m < col; m++) {
                        rotatedArr[m][row-n-1] = arr[n][m];
                    }
                }
            }
            else {
                msg = "Input array is null";
                throw new IllegalArgumentException(msg);
            }
        }
        catch (Exception e) {
            msg = "Exception occured while rotating matrix to the right";
            System.err.println(msg + "." + e.getMessage());
            throw new Exception(msg,e);
        }
        return rotatedArr;
    }

    public int[][] rotateMatrixLeftNotInPlace(int[][] arr) throws Exception {
        int[][] rotateArr = null;
        String msg = null;
        try {
            if(null != arr) {
                int row = arr.length;
                int col = arr[0].length;

                rotateArr = new int[col][row];

                for(int n = 0; n < row; n++) {
                    for(int m = 0; m < col; m++) {
                        rotateArr[col-m-1][n]  = arr[n][m];
                    }
                }
            }
            else {
                msg = "Input array is null";
                throw new IllegalArgumentException(msg);
            }
        }
        catch (Exception e) {
            msg = "Exception occured while rotating matrix to the left";
            System.err.println(msg + "." + e.getMessage());
            throw new Exception(msg,e);
        }
        return rotateArr;
    }

    public int[][] rotateMatrixRightInPlace(int[][] arr) throws Exception {
        String msg = null;
        try {
            //ToDo :
        }
        catch (Exception e) {
            msg = "Exception occured while rotating matrix to the right in place";
            System.err.println(msg + "." + e.getMessage());
            throw new Exception(msg,e);
        }
        return null;
    }

    public int[][] rotateMatrixLeftInPlace(int[][] arr) throws Exception {
        String msg = null;
        try {
            // ToDo :
        }
        catch (Exception e) {
            msg = "Exception occured while rotating matrix to the left";
            System.err.println(msg + "." + e.getMessage());
            throw new Exception(msg,e);
        }
        return null;
    }
}
