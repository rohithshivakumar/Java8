package Games;

/**
 * Created by Rohith Shivakumar on 4/11/2016.
 * Given a nxn board of TicTacToe, determine if there is a winner and who won it.
 *
 * Note : Variation to take care of exposing it as a service and have multiple requests coming,
 * Prepopulate hash table with all possible combinations
 *
 * Assumptions/Confirmations :
 * 1) In an NxN board, all the cells are filled with either red, blue or empty pawn symbols.
 * 2) There will be only one winner if at all there is a winner.
 * 3) Returning empty pawn if there are no winners.
 * 4) Check if the board is not a tic-tac-toe valid board. (In case of NxM where N != M) -> return empty
 * 5) This is a 2 player game.
 */
/*
    Test cases :
    {{red,empty,blue},{red,empty,blue},{red,empty,empty}} -> red
    {{empty,empty,empty},{empty,empty,empty},{empty,empty,empty}} -> empty
    {{red,empty,red},{blue,empty,empty},{empty,empty,empty}} -> empty
 */
public class TicTacToe {
    public enum Pawns {
        red,
        blue,
        empty
    }

    /**
     * Takes a 2d board and returns the Pawn that has won, if nobody has won, the Pawns.empty will be returned.
     * @param board
     * @return
     */
    public Pawns whoWon(Pawns[][] board) throws Exception {
        String msg = null;
        try {
            if(null == board) {
                return Pawns.empty;
            }
            if(board.length != board[0].length) {
                return Pawns.empty;
            }

            //Check row winner
            Pawns consideredPawn = null;
            boolean hasWinner = false;
            for(int i = 0; i < board.length; i++) {
                consideredPawn = board[i][0];
                if(consideredPawn == Pawns.empty) {
                    continue;
                }
                for(int j = 0; j < board[0].length; j++) {
                    if(consideredPawn == board[i][j]){
                        hasWinner = true;
                    }
                    else {
                        hasWinner = false;
                        break;
                    }
                }
                if(hasWinner){
                    return consideredPawn;
                }
            }

            //Check column winner
            for(int j = 0; j < board.length; j++) {
                consideredPawn = board[0][j];

                if(consideredPawn == Pawns.empty) {
                    continue;
                }

                for(int i = 0; i < board[0].length; i++) {
                    if(consideredPawn == board[i][j]){
                        hasWinner = true;
                    }
                    else {
                        hasWinner = false;
                        break;
                    }
                }
                if(hasWinner){
                    return consideredPawn;
                }
            }
            //Check principal diagonal winner
            consideredPawn = board[0][0];
            for(int i = 0; i < board.length; i++) {
                if(consideredPawn != Pawns.empty && consideredPawn == board[i][i]) {
                    hasWinner = true;
                }
                else {
                    hasWinner = false;
                    break;
                }
            }
            if(hasWinner) {
                return consideredPawn;
            }

            //Check secondary diagonal winner
            int j = board.length - 1;
            consideredPawn = board[0][j];
            for(int i = 0; i < board.length; i++) {
                if(consideredPawn != Pawns.empty && consideredPawn == board[i][j - i]) {
                    hasWinner = true;
                }
                else {
                    hasWinner = false;
                    break;
                }
            }
            if(hasWinner)
                return consideredPawn;
        }
        catch (Exception e) {
            msg = "Exception occured while determining Tic Tac Toe winner.";
            System.err.println(msg + ". " + e.getMessage());
            throw new Exception(msg,e);
        }
        return Pawns.empty;
    }

    /**
     * This method determines the winner by pre-computing all winning combination
     * when the first request comes in. Successive requests for determining the winner will
     * be of constant time for the same board
     * @param board
     * @return
     * @throws Exception
     */
    public Pawns wonWonOptimized(Pawns[][] board) throws Exception {
        //ToDo : implement this
        return Pawns.empty;
    }
}
