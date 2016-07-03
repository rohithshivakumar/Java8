package Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

 You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

 Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

 For the last line of text, it should be left justified and no extra space is inserted between words.

 For example,
 words: ["This", "is", "an", "example", "of", "text", "justification."]
 L: 16.

 Return the formatted lines as:
 [
 "This    is    an",
 "example  of text",
 "justification.  "
 ]
 Note: Each word is guaranteed not to exceed L in length.

 click to show corner cases.

 Corner Cases:
 A line other than the last line might contain only one word. What should you do in this case?
 In this case, that line should be left-justified.
 */
public class TextJustifyLeftLeetCode {
    public List<String> fullJustify(String[] words, int maxWidth) {

        System.out.println("===================Starting ====================================");
        List<String> lines = new ArrayList<>();
        StringBuilder currentLine = new StringBuilder();
        int count = 0 ;
        int currentLength = 0;

        while(count < words.length){
            System.out.println("Current word:" + words[count]);
            currentLength = currentLine.toString().length();
            int newLength = currentLength + words[count].length();
            System.out.println("currentlength: "+currentLength+" newLength " + newLength + " max: " + maxWidth);
            if(newLength > maxWidth){

                String lineJustified = justifyLine(currentLine, maxWidth);
                lines.add(lineJustified);
                currentLine = new StringBuilder();

            }
            currentLine.append(words[count]);
            if(currentLine.length() !=  maxWidth){
                currentLine.append(" ");
            }

            System.out.println("currentLine : " + currentLine.toString());
            count++;
        }

        lines.add(justifyLastLine(currentLine, maxWidth));
        System.out.println("===================Ending ====================================");
        return lines;
    }

    public String justifyLine(StringBuilder currentLine, int maxWidth){

        //Count spaces & words
        String[] words = currentLine.toString().split(" ");
        int wordLength =0;
        for(String word: words){
            wordLength += word.length();
        }

        int wordCount = words.length;
        int spaceCount = maxWidth - wordLength;

        System.out.println("line:" + currentLine.toString());
        System.out.println("currentLine length: "+currentLine.length() + "wordLength: " + wordLength + "spaceCount:" + spaceCount);
        int i = 0;
        while(spaceCount > 0){
            words[i]+= " ";
            spaceCount--;
            i++;
            if(i >= wordCount-1){
                i=0;
            }
        }

        StringBuilder finalLine = new StringBuilder();
        for(String word: words){
            finalLine.append(word);
        }
        System.out.println("line:" + finalLine.toString());
        return finalLine.toString();
    }

    public String justifyLastLine(StringBuilder currentLine, int maxWidth){
        System.out.println("Justifying last line");
        String[] words = currentLine.toString().split(" ");
        int wordCount = words.length;
        int spaceCount = maxWidth - currentLine.length();
        System.out.println("line:" + currentLine.toString());
        System.out.println("wordCount: " + wordCount + "spaceCount:" + spaceCount);
        int i = 0;
        while(spaceCount > 0){
            currentLine.append(" ");
            spaceCount--;

        }
        System.out.println("line:" + currentLine.toString());
        return currentLine.toString();
    }
}
