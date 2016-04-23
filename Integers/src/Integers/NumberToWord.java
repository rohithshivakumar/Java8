package Integers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
2,147,483,647

        2
        147
        483
        647

        int pIndex = 4 (chunked the number by 3 and round to ceiling)
        places[] = {"", thousand, million, billion }

        StringBuilder words = new StringBuilder();
        String s;
//Check if number is -ve and print "negative", X'ly by -1
        for(int i=0; i< parts.length;i++){
        s= convertToWord(parts[i])
        words.append(s)
        words.append(" ");
        words.append(places[pIndex]);
        pIndex--;
        }

        Ex:126
//We know the max length is always 3
private static String convertToWord(int Num){
        String units[] = {"zero" "one","two","three"......."nine"}
        String tweens[] = {" ","eleven","twelve","thirteen"......."ninteen"}
        String tens[] = {" ", "ten","twenty","thirty"......."ninety"}
        StringBuilder op = new StringBuilder();
//Validate if num > 99 return
        if(num > 99){
        int nPos = num/100;
        op.append(units[nPos], " ");
        op.append("hundred");
        num = num - nPos *100; //126 - 100
        }

//Check if its tween

        if(num >=11 && num <=19{
        op.append(tweens[num%10]);
        return;
        }
        if(num < 10){
        op.append(units[num]);
        return
        }

//Print the tens and then units place
        op.append(tens[num/10]," ");
        op.append(units[num%10]);

        }
        */
public class NumberToWord {

    public static String convertNumberToWord(int num){


        String places[] = {" ", "thousand " , "million ", "billion " };

        StringBuilder words = new StringBuilder();
        String s;
        //Check if number is -ve and print "negative", X'ly by -1
        if(num < 0){
            num = num *-1;
            words.append("Negative ");
        }
        if(num == 0){
            return "Zero";
        }
        LinkedList<Integer> parts = getParts(num);
        int pIndex = parts.size()-1;// (chunked the number by 3 and round to ceiling)
        for(int i=0; i< parts.size();i++){
            s= convertToWord(parts.get(i));
            words.append(s);
            words.append(" ");
            words.append(places[pIndex]);
            pIndex--;
        }

        return words.toString();
    }

    private static LinkedList<Integer> getParts(Integer num){
        LinkedList<Integer> parts = new LinkedList<>();
        while(num>0){
            if (num % 1000 != 0) {
                parts.addFirst(num%1000);
            }
            num=num/1000;
        }
        return parts;
    }

    //We know the max length is always 3
    private static String convertToWord(Integer num) {
        String units[] = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String tweens[] = {" ", "eleven", "twelve", "thirteen", "fouteen", "fifteen", "sixteen", "seventeen", "eighteen", "ninteen"};
        String tens[] = {" ", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        StringBuilder op = new StringBuilder();
        //Validate if num > 99 return
        if (num > 99) {
            int nPos = num / 100;
            op.append(units[nPos]);
            op.append(" ");
            op.append("hundred");
            op.append(" ");
            num = num - nPos * 100; //126 - 100
        }

       //Check if its tween

        if (num >= 11 && num <= 19){
            op.append(tweens[num % 10]);
            return op.toString();
        }
        if (num < 10) {
            op.append(units[num]);
            return op.toString();
        }

//Print the tens and then units place
        op.append(tens[num / 10]);
        op.append(" ");
        op.append(units[num % 10]);
        return op.toString();

    }
}
