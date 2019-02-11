package Strings;

/**
 *Dothraki are planning an attack to usurp King Robert's throne. King Robert learns of this conspiracy from Raven and plans to lock the single door through which the enemy can enter his kingdom.

 door

 But, to lock the door he needs a key that is an anagram of a certain palindrome string.

 The king has a string composed of lowercase English letters. Help him figure out whether any anagram of the string can be a palindrome or not.

 Input Format
 A single line which contains the input string.

 Constraints
 1≤1≤ length of string ≤105≤105
 Each character of the string is a lowercase English letter.

 Output Format
 A single line which contains YES or NO in uppercase.

 Sample Input : 01

 aaabbbb
 Sample Output : 01

 YES
 Explanation
 A palindrome permutation of the given string is bbaaabb.

 Sample Input : 02

 cdefghmnopqrstuvw
 Sample Output : 02

 NO
 Explanation
 You can verify that the given string has no palindrome permutation.

 Sample Input : 03

 cdcdcdcdeeeef
 Sample Output : 03

 YES
 */
public class GameOfThrones {

    public static boolean isAnagramStringPalindrome(String inputString){
        int count =0;
        char[] a = inputString.toCharArray();

        for(int i=0;i< inputString.length();i++){
            if(a[i] == '*'){
                continue;
            }

            for(int j=i+1;j< inputString.length();j++){

                if(a[j] == a[i]){
                    a[i]=a[j]='*';
                    break;
                }
            }
        }

        for(int i=0;i< inputString.length();i++){
            if(a[i] != '*'){
                count++;
            }
        }
        if(a.length %2==0 && count == 0){
            System.out.println("YES");
            return true;

        }
        else if(a.length %2 != 0 && count == 1){
            System.out.println("YES");
            return true;
        }else{
            System.out.println("NO");
            return false;
        }
    }
}
