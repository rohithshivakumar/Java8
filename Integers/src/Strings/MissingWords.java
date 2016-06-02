package Strings;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Rohith Shivakumar on 6/1/2016.
 *
 */

/** Julia and Samantha are playing with strings. Julia has a string S, and Samantha has a string T which is a subsequence of string S. They are trying to find out what words are missing in T.
 Help Julia and Samantha to solve the problem. List all the missing words in T, such that inserting them at the appropriate positions in T, in the same order, results in the string S.
 Constraints
 1 <= |T| <= |S| <= 106, where |X| denotes the length of string X.
 The length of each word will be less than 15.

 Function Parameter
 You are given a function missingWords that takes the strings S and T as its arguments.

 Function Return Value
 Return an array of the missing words.

 Sample Input
 I am using hackerrank to improve programming
 am hackerrank to improve
 Sample Output
 I
 using
 programming
 */

/**
 * Idea : Split on " " both the strings.
 *		   Run index on each of the split string lists.
 *        Compare if the two strings match
 *			 if not matching : put the value from first string into the missing lists
 *          if matching : Increment the index on both the string lists
 *		   Do the above 3 lines until index of first string or second string reaches the end
 *			 if first string has not reached the end, then add the rest of its strings into the missing lists.
 *
 * Complexity : One pass on both the strings. So 0(n), where n is the number of words in first sentence.*/

public class MissingWords {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            String t = br.readLine();

            List<String> missingWords = missingWords(s,t);

            for(String missingWord : missingWords) {
                System.out.println(missingWord);
            }
        } catch (Exception e) {
            System.err.println("Error occured in Missing Words determination. " + e);
        }
    }

    public static List<String> missingWords(String s, String t) throws Exception {
        List<String> missingWords = new ArrayList<String>();
        try {
            if(!(s == null || s.isEmpty())) {
                String[] sWords = s.split(" ");

                if(t == null || t.isEmpty()) {
                    missingWords.addAll(Arrays.asList(sWords));
                }
                else {
                    String[] tWords = t.split(" ");
                    int sLength = sWords.length;
                    int tLength = tWords.length;
                    int i = 0;
                    int j = 0;
                    while(i < sLength && j < tLength) {
                        if(!sWords[i].equals(tWords[j])){
                            missingWords.add(sWords[i]);
                            i++;
                        }
                        else {
                            i++;
                            j++;
                        }
                    }

                    while(i < sLength) {
                        missingWords.add(sWords[i]);
                        i++;
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Failed to return missing words. " + e.getMessage());
            throw e;
        }
        return missingWords;
    }
}
