package Strings;

/**
 *We've going to build one of those new smart ATMs that let you scan and deposit checks. Banking requirements are such that we have to enforce that the number in the upper part of the check matches what the user wrote on the amount line. We've got a perfect ACR system, so we need you to write a function that will take in whatever the user has written and return the numeric value.

 If you feel like being generous you can cap it at Int32.MAXVALUE, I usually do just so we can bound the problem a little bit.

 Now, we're working with a bank that's associated with a lot of astronomers and poets, so we need to allow them to be a bit loose with the language. For example, if they were going to write a check for a billion dollars, they might describe that as a thousand million.

 If this is a more senior individual you can throw in some of the colloqualisms described in the Variants section (I usually do). I also typically let the candidate come up with their own sample input since what they come up with tells you a lot about the sort of edge cases their thinking about. That being said, something like the following usually catches most logic flaws: three hundred twenty nine million two hundred five thousand fifty

 I usually allow the candidate to wave away things like punctuation and and, but it's a good sign if they ask about it. Similarly, misspelling I usually don't care about but it's good if they ask about. Up for debate is what happens on "bad" input (listed in test cases below)

 Solutions
 Most solutions fall in to one of these two general buckets. Both involve a map of word values to their numeric values and some concept of a number being a "value" or a "multiple" (typically powers of 10 >= 100)

 Split on Multiple Find the largest multiple scanning from right to left to handle the case of two thousand thousand = 2,000,000, calculate the value of the left side (recursive), multiply it by the multiple and add the value of the right side.

 Right to Left A state machine, you're either looking at values or multiples. you sum values until you see a multiple then multiply your current running total by your last multiple, add it to the overall total, store your new multiple and start a new running total.

 Test Cases
 five = 5
 fifty = 50
 five hundred = 500
 five hundred thousand = 500000
 five hundred million = 500000000
 five hundred thirty nine = 539
 five hundred = 500
 five million eight hundred = 5000800
 five million eight hundred thousand = 5800000
 three billion five hundred forty nine million eight hundred thousand = 3549800000
 three thousand five hundred forty nine = 3549
 five hundred twenty thousand = 520000
 five hundred twenty one thousand eight hundred fifteen = 521815
 three thousand five hundred forty nine million eight hundred thousand = 3549800000
 five thousand million = 5000000000
 twenty eighteen = 2018
 fifty nine twenty = 5920
 twenty fifty nine = 2059
 vague input: hundred or thousand only.
 "bad" input: three thousand hundred, that could either be 300,000 or 3100 depending on your interpretations of vague input.
 Variants & Progressions
 Can you handle colloqualisms such as nine eighteen for 918, twenty ten or nineteen oh one
 Can you handle units which aren't multiples of ten? dozen, score, gross, or the like.
 How hard would it be to scale this beyond Int32.MAXVALUE (if we needed to support Zimbabwe for example). Up through Quadrillions, does your algorithm need to change?
 */
public class NumberWords {

    public static int convertNumberToWord(String s){

        String[] split = s.split(" ");

        int resNum = 0;

//        //Handle cases like hundred or hundred fifty
//        if(isMultiplier(split[0])){
//            resNum = 1 ;
//        }

        int mul = 1;
        String prev =  null;

        for ( int i = split.length - 1; i >=0 ; i-- ) {

            String word = split[i];
            int num = wordtonum(word.toLowerCase());

            System.out.println(word+':'+num + " " + "mul:" + mul);
            num = num * mul;
            mul = 1;
            if(isMultiplier(word.toLowerCase())){
                mul *= num;
                continue;
            }

            //handle cases like 2059
//            if(resNum > 9 || num > 9){
//                System.out.println("resNum:"+ resNum + " num:" + num);
//                //generate
//                int factor = generateMultiplier(resNum);
//                System.out.println("num:"+ num + " factor:" + factor);
//                num = (num * factor);
//
//
//            }
            System.out.println("num:"+ num + " (before)resNum:" + resNum);
            resNum += num;
            System.out.println("(after)" + resNum);

        }


        // if mul is not 1 then we need to multiply it by 1 and add te res
        if(mul != 1 ){

            resNum += mul;
        }

        System.out.println(resNum);


        return resNum;

    }

    private static int generateMultiplier(int num){
        //Example 112;

        int cur = 1 ;

        while (num > 0){
            cur *=cur*10;
            num /= 10;
        }

        return  cur;
    }

    public static int wordtonum(String word)
    {
        int num = 0;
        switch (word) {
            case "one":  num = 1;
                break;
            case "two":  num = 2;
                break;
            case "three":  num = 3;
                break;
            case "four":  num = 4;
                break;
            case "five":  num = 5;
                break;
            case "six":  num = 6;
                break;
            case "seven":  num = 7;
                break;
            case "eight":  num = 8;
                break;
            case "nine":  num = 9;
                break;
            case "ten": num = 10;
                break;
            case "eleven": num = 11;
                break;
            case "twelve": num = 12;
                break;
            case "thirteen": num = 13;
                break;
            case "fourteen": num = 14;
                break;
            case "fifteen": num = 15;
                break;
            case "sixteen": num = 16;
                break;
            case "seventeen": num = 17;
                break;
            case "eighteen": num = 18;
                break;
            case "nineteen": num = 19;
                break;
            case "twenty":  num = 20;
                break;
            case "thirty":  num = 30;
                break;
            case "forty":  num = 40;
                break;
            case "fifty":  num = 50;
                break;
            case "sixty":  num = 60;
                break;
            case "seventy":  num = 70;
                break;
            case"eighty":  num = 80;
                break;
            case "ninety":  num = 90;
                break;
            case "hundred": num = 100;
                break;
            case "thousand": num = 1000;
                break;
            case "million": num = 1000000;
                break;
            case "billion": num = 1000000000;
                break;
           /*default: num = "Invalid month";
                             break;*/
        }
        return num;
    }

    public  static boolean isMultiplier(String word)
    {
        switch (word) {

            case "hundred":
            case "thousand":
            case "million":
            case "billion":
                return true;
           /*default: num = "Invalid month";
                             break;*/
        }
        return false;
    }
}
