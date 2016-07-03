package Arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * We have a string of length N. The string contains only lower-case letters (a-z). Figure out the num of occurences
 * of the most frequent substring. We are only interested in substring that have following properties
 *
 * Length of substring is between K & L
 * num of unique characters in a substring do not exceed M
 * EX:-
 * abcde, K =2 L =4, M=26
 * o/p: 1
 *
 */
public class SubStringFrequency {
    public static Map<String, Integer> subStringMap = new HashMap<>();
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int strLen = Integer.parseInt(br.readLine());
        String line = br.readLine();
        String[] lineSplit = line.split(" ");
        int K = Integer.parseInt(lineSplit[0]);
        int L = Integer.parseInt(lineSplit[1]);
        int M = Integer.parseInt(lineSplit[2]);
        String s = br.readLine();


        int max = findSubStrings(s,strLen,K,L,M);

        System.out.println(max);
    }

    private static int getMaxFrequency(Map<String, Integer> subStringMap) {
        int max = 0;

        for(String key : subStringMap.keySet()){

            int val = subStringMap.get(key);
            if(val > max){
                max = val;
            }
        }
        return max;
    }

    public static int findSubStrings(String s , int strLen, int K, int L , int M){
        Map<String, Integer> subStringMap = new HashMap<>();;
        for(int i= K; i <= L; i++){
           generateSubString(subStringMap, s,i,M);
        }
        return getMaxFrequency(subStringMap);

    }

    public static void generateSubString(Map<String, Integer> subStringMap,String s, int subStringLength, int allowedUniqueChars){
        for(int i =0 ; i < s.length() ; i++){
            int startIndex = i;
            int endIndex = i + subStringLength;
            if(endIndex < s.length()+1){
                String subString = s.substring(startIndex, endIndex);
                if(getUniqueChars(subString) < allowedUniqueChars){
                    Integer count = 0;
                    if(subStringMap.containsKey(subString)){
                        count  = subStringMap.get(subString);
                        count = count + 1 ;
                    }else{
                        count = 1;
                    }
                    subStringMap.put(subString,count);
                }

            }
        }

    }

    private static int getUniqueChars(String s){
        int[] map = new int[26];

        for(int  i = 0 ; i < 26 ; i++ ){
            map[i] = 0;
        }

        for(int j = 0 ; j< s.length(); j++){
            char c = s.charAt(j);
            int pos = c - 'a';
            map[pos]++;
        }
        int count = 0;
        for(int  i = 0 ; i < 26 ; i++ ){
            if(map[i] == 1){
                count ++;
            }
        }

        return count;
    }
}
