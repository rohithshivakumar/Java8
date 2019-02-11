package RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Question:
 * Given a string line "CatsDogsGreat" and a dictionary of words {"Cat", "cats" , "dogs","grea"} ,
 * o/p true if its possible to form the string by concatenating the words from the dictionary
 *
 * Company: Sony Playstation Nov 2018
 */
public class ConcatWords {
    private String str;
    private HashMap dictionary;

    public boolean concatWords(String str, HashMap<String, String> dictionary) {

        this.str = str;
        this.dictionary = dictionary;

        return false;
    }
}
