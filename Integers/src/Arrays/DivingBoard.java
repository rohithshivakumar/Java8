package Arrays;

import java.util.HashSet;

/**
 * Created by Rohith Shivakumar on 4/26/2016.
 * You are building a diving board by placing a bunch of planks of wood end to end.
 * There are two types of planks, one of length shorter and one of length longer.
 * You must use exactly K planks of wood.
 * Write a method to generate all possible lengths for the diving board.
 *
 * Tests:
 * Given shorter = 2, longer = 3, k = 4 => answer : 5
 * possibilities : {2,2,2,2 = 8},{2,3,3,3 = 11},{2,2,3,3 = 10},{2,2,2,3 = 9},{3,3,3,3 = 12}
 *
 * Questions to ask :
 * 1) Can the longer and shorter board be of same length (Then you can use ArrayList instead of HashSet and also the
 * number of possible lengths for k boards will always be 1)
 */
public class DivingBoard {
    int longerBoardLength;
    int shorterBoardLength;
    int numOfBoards;

    public DivingBoard(int longerBoardLength, int shorterBoardLength, int numOfBoards) {
        this.longerBoardLength = longerBoardLength;
        this.shorterBoardLength = shorterBoardLength;
        this.numOfBoards = numOfBoards;
    }

    /**
     * Given the length of short board, long board and the number of boards, determines the number of possible board
     * sizes possible
     * @return
     * @throws Exception
     */
    public int getNumberOfBoardLengths() throws Exception {
        String msg;
        HashSet<Integer> boards = new HashSet<>();
        int totalLength = 0;
        try {
            if(0 != numOfBoards) {
                for(int i = 0; i <= numOfBoards; i++) {
                    totalLength = (i * shorterBoardLength) + ((numOfBoards - i) * longerBoardLength);
                    boards.add(totalLength);
                }
            }
        }
        catch (Exception e) {
            msg = "Exception occured while getting the number of board lengths.";
            System.err.println(msg + ". " + e.getMessage());
            throw new Exception(msg,e);
        }
        return boards.size();
    }
}
