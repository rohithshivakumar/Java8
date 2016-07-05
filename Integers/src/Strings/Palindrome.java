package Strings;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 Example:

 "A man, a plan, a canal: Panama" is a palindrome.

 "race a car" is not a palindrome.

 Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
public class Palindrome {
    public int isPalindrome(String a) {

        a = a.toLowerCase();
        StringBuffer sb = new StringBuffer();

        for(int i = 0 ; i < a.length() ; i++){
            if(Character.isLetter(a.charAt(i)) || Character.isDigit(a.charAt(i))){
                sb.append(a.charAt(i));
            }

        }
        String f = sb.toString();

        int low = 0;
        int high = f.length()-1;

        while(low < high){
            Character left = new Character(f.charAt(low));
            Character right = new Character(f.charAt(high));
            if(left.compareTo(right) != 0){
                return 0;
            }
            low++;
            high--;

        }

        return 1;

    }
}
