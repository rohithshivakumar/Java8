package Strings;

import java.util.Stack;

/**
 * Evaluate expressions like 2-5+7/8*2-4
 */
public class computeArithematicExpression {
    private enum Operator{
        ADD,
        SUB,
        MUL,
        DIV,
        BLANK
    }

    private int getPriority(Operator op){
        switch (op){
            case ADD: return 1;
            case SUB: return 1;
            case MUL: return 2;
            case DIV: return 2;
            case BLANK: return 0;
        }
        return 0;
    }

    public double compute(String sequence){
        sequence = sequence.trim();
        Stack<Double> numStack = new Stack<>();
        Stack<Operator> opStack = new Stack<>();
        int start = 0;
        boolean isNeg = false;
        if(!Character.isDigit(sequence.charAt(0))){

            if(sequence.charAt(0) == '-') {
                isNeg = true;
            }
            start++;
        }
        for(int i= start;i < sequence.length();i++){
            try{
                int val = parseNextNumber(sequence, i);
                i=i+Integer.toString(val).length();
                if(isNeg){
                    val *= -1;
                    isNeg=false;
                }
                numStack.push((double)val);


                if(i>=sequence.length()){
                    break;
                }
                Operator op = parseOperator(sequence,i);
                collapseTop(op,numStack,opStack);
                opStack.push(op);

            }catch (Exception e){
                return Integer.MIN_VALUE;
            }

        }
        collapseTop(Operator.BLANK, numStack,opStack);
        if(numStack.size() == 1 && opStack.size() == 0){
            return numStack.pop();
        }
        return 0;
    }

    private void collapseTop(Operator fOp, Stack<Double> numStack, Stack<Operator> opStack) {

        while(opStack.size()>=1 && numStack.size() >=2){
            if(getPriority(fOp) <= getPriority(opStack.peek())){
                double right = numStack.pop();
                double left = numStack.pop();
                Operator op = opStack.pop();
                numStack.push(evaluate(op,left,right));
            }else{
                break;
            }
        }
    }

    private Double evaluate(Operator op, double left, double right) {
        switch (op){

            case ADD: return left + right;
            case SUB: return left - right;
            case MUL: return left * right;
            case DIV: return left / right;
            default: return right;
        }
    }

    private Operator parseOperator(String seq, int offset) {
        if(offset < seq.length()){
            char op = seq.charAt(offset);
            switch (op){
                case '+': return Operator.ADD;
                case '-': return Operator.SUB;
                case '*': return Operator.MUL;
                case '/': return Operator.DIV;
            }
        }
        return Operator.BLANK;
    }

    private int parseNextNumber(String sequence, int offset) {
        StringBuffer sb = new StringBuffer();

        while (offset < sequence.length() && Character.isDigit(sequence.charAt(offset))){
            sb.append(sequence.charAt(offset));
            offset++;
        }
        return Integer.parseInt(sb.toString());
    }
}
