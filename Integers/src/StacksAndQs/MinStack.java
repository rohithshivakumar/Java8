package StacksAndQs;

import java.util.Stack;

/**
 * Created by arjun_000 on 6/23/2016.
 */
public class MinStack extends Stack<Integer> {
        Stack<Integer> minStack;

        public MinStack(){
            minStack = new Stack<>();

        }

        public void push(int val){

            if(val <= min()){
                minStack.push(val);
            }
            super.push(val);
        }

        @Override
        public Integer pop(){
            int v = super.pop();
            if(v == min()){
                minStack.pop();
            }
            return v;
        }

        public int min(){

            if(minStack.isEmpty()){
                return Integer.MAX_VALUE;
            }

            return minStack.peek();

        }


    }

