package RecursionAndDynamicProgramming;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Given a List of results of games , which has a 2 teams and a winner amongst them (no ties possible).
 * Rank them with a condition that no team is ranked below a team that it has defeated
 * Ex: If Team 4 defeats Team 1 , Team 4's rank has to be higher than Team 1
 *
 * Thinking :
 * - There are n teams, and each could play each other more than once in a tournament
 * - Initially you can think of sorting by number of wins, however look at the rule above
 * - The Rule above states that only condition is if Team 4 defeats Team 2 & Team 5, it should be ranked higher
 * - In the implementation below, lower index will be higher rank
 * - After discussing, we did come to know it is sort of a topological sort but i want to try out my recursive
 *   implementation first
 *   - Also determined case of cyclic dependancy where we should error out, think of this next time
 *
 * Pseudo code :
 * - Build a hash map of winner with a linked list of loosers
 * - Initialize a ranking array where a[i] = i (ith team is at rank i)
 * - Go through the map
 * - For  each entry
 *          Get list of loosers
 *          Check if rank is in correct order already (i < j )
 *          If it is not order , call same function to fix ordering of the loosing team.
 *
 *           Exit conditions
 *           a. No more loosers to process
 *           b. The entry has an empty list
 *           c. Cyclic
 */
public class RankGameResults {

    /*
      Assumption : Teams are number based and nteams tells us total teams
     */
    public int[] getRanking(List<Result> results, int nteams) throws Exception {
        int[] ranks = new int[nteams+1];
        HashMap<Integer,LinkedList<Integer>> map = new HashMap<>();
        //initialize ranks a[0] =0 not counted
        for(int i=1;i<=nteams;i++){
            ranks[i] = i;
        }
        //build hashmap
        buildHashmap(results, map);

        boolean[] visited = new boolean[nteams+1];
        for(Map.Entry<Integer,LinkedList<Integer>> entry: map.entrySet()){
            initializeVisited(visited);
            boolean success = adjustRanks(map,entry.getKey(),visited, ranks);
            if(!success){
                throw new IllegalArgumentException("Cannot rank due to cyclic dependancy");
            }
        }
        return ranks;
    }

    void initializeVisited(boolean[] visited){
        for(int i=1;i< visited.length;i++){
            visited[i] = false;
        }
    }
    private boolean adjustRanks(HashMap<Integer, LinkedList<Integer>> map, int currentTeam, boolean[] visited , int[] ranks){
        LinkedList<Integer> looserList = map.get(currentTeam);
        if(map == null || map.size() ==0){
            return true;
        }

        if(visited[currentTeam]){
            //cyclic dependancy
            return false;
        }
        visited[currentTeam] = true;
        int winIndex = getIndexForTeam(currentTeam, ranks);
        if(looserList == null){
            return true;
        }
        for(Integer looser: looserList){
            int looseIndex = getIndexForTeam(looser,ranks);
            if(winIndex > looseIndex) {
                int temp = ranks[winIndex];
                ranks[winIndex] = ranks[looseIndex];
                ranks[looseIndex] = temp;
                boolean success = adjustRanks(map, looser, visited, ranks);
                if(!success){
                    return false;
                }
            }
        }
        return true;
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
    private void buildHashmap(List<Result> results, HashMap<Integer, LinkedList<Integer>> map) {
        for(Result r : results){
            int winner = r.winner;
            int looser = (r.winner == r.teamA) ? r.teamB : r.teamA;
            if(!map.containsKey(winner)){
                map.put(winner,null);
            }
            LinkedList<Integer> looserList = map.get(winner);
            if(looserList == null){
                looserList = new LinkedList<>();
            }
            looserList.add(looser);
            map.put(winner,looserList);
        }
    }
}
