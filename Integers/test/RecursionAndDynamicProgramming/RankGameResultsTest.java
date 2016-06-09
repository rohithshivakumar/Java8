package RecursionAndDynamicProgramming;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by arjun_000 on 6/8/2016.
 */
public class RankGameResultsTest {

    RankGameResults rankGameResults;
    @Before
    public void setUp() throws Exception {
        rankGameResults = new RankGameResults();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetRanking() throws Exception {

        //General list
        LinkedList<Result> results = new LinkedList<>();
        results.add(new Result(1, 4, 1));
        results.add(new Result(4, 2, 4));
        results.add(new Result(2, 3, 3));

        int[] ranks = rankGameResults.getRanking(results,5);
        printRanks(ranks);

    }

    private void checkRanks(int[] ranks, LinkedList<Result> results) {
        for(Result r : results){
            int winIndex = getIndexForTeam(r.winner, ranks);
            int looserIndex = getIndexForTeam((r.winner== r.teamA)?r.teamB: r.teamA,ranks);
            assertTrue("Not ordered properly", winIndex < looserIndex);

        }
    }
    @Test(expected = IllegalArgumentException.class)
    public void testGetRankingCyclic() throws Exception {
        LinkedList<Result> results = new LinkedList<>();

        //cyclic list
        results = new LinkedList<>();
        results.add(new Result(1, 2, 1));
        results.add(new Result(1, 2, 2));
        rankGameResults.getRanking(results,5);
    }
    private void printRanks(int[] ranks) {
        for(int i=1; i < ranks.length; i++){
            System.out.print(ranks[i] + " ");
        }
    }

    private int getIndexForTeam(int team, int[] ranks){
        int index = -1;
        for(int i=1;i< ranks.length;i++){
            if(ranks[i] == team){
                index = i;
                break;
            }
        }
        return index;
    }
}