package RecursionAndDynamicProgramming;

/**
 * Created by arjun_000 on 6/8/2016.
 */
public class Result {
    int teamA;
    int teamB;
    int winner;

    public Result(int one, int two, int winner) throws Exception {
        if (winner != one && winner != two) {
            throw new Exception("Bad Entry");
        }
        teamA = one;
        teamB = two;
        this.winner = winner;
    }
}
