package Strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Roy wanted to increase his typing speed for programming contests. So, his friend advised him to type the sentence "The quick brown fox jumps over the lazy dog" repeatedly, because it is a pangram. (Pangrams are sentences constructed by using every letter of the alphabet at least once.)

 After typing the sentence several times, Roy became bored with it. So he started to look for other pangrams.

 Given a sentence ss, tell Roy if it is a pangram or not.

 Input Format

 Input consists of a string ss.

 Constraints
 Length of ss can be at most 103103 (1≤|s|≤103)(1≤|s|≤103) and it may contain spaces, lower case and upper case letters. Lower-case and upper-case instances of a letter are considered the same.

 Output Format

 Output a line containing pangram if ss is a pangram, otherwise output not pangram.

 Sample Input

 Input #1

 We promptly judged antique ivory buckles for the next prize
 Input #2

 We promptly judged antique ivory buckles for the prize
 Sample Output

 Output #1

 pangram
 Output #2

 not pangram
 Explanation

 In the first test case, the answer is pangram because the sentence contains all the letters of the English alphabet.
 */
public class Pangram {

    public static boolean isPangramExtraSpace(String inputString) throws Exception {
        try {
            Set<Character> alphabets = new HashSet<Character>();

            //Commenting this out so that tests can be run using JUnits without being prompted for user input.
            /*Scanner sc = new Scanner(System.in);
            String inputStr = sc.nextLine();*/
            StringBuilder sb = new StringBuilder(inputString);
            toLower(sb);

            for(int i = 0; i < sb.length(); i++) {
                if(' ' != sb.charAt(i)) {
                    alphabets.add(sb.charAt(i));
                }
            }

            if(alphabets.size() < 26)
                return false;
            else
                return true;
        }
        catch (Exception e) {
            System.err.println("Failed to determine if the input string is a Pangram. " + e.getMessage());
            throw e;
        }
    }

    private static void toLower(StringBuilder sb) {
        if(null != sb) {
            for(int i = 0; i < sb.length(); i++) {
                if(sb.charAt(i) != ' ' && sb.charAt(i) >= 'A' && sb.charAt(i) <= 'Z') {
                    sb.setCharAt(i,Character.toLowerCase(sb.charAt(i)));
                }
            }
        }
    }

    public static boolean isPangramNoExtraSpace(String inputString){
        return false;

    }
}
