package Integers;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an unending stream of integers within the range of 0-999,
 * write code to find out the mean, median of the numbers at any point of time
 *
 * Clarifications:
 * 1. Must do validation of incoming numbers
 * 2. The count is in millions
 *
 * Approach:
 * Keep an array of 1000 elements, index will give the count of the times that number occurred.
 * Every time a number enters , mean is simple the running sum divided by the totalCount of numbers
 * For Median, we need to check if total count is odd or even, based on that go through the array and find out the
 * position of the median. Then the index or the average of the 2 adjacent indices is the answer
 *
 * For an unlimited stream we maintain 2 heaps min and max heaps
 * Consider Situation
 10,20,30   40,50,60
 Median = 30+40/2 = 35

 Insert 37

 37 <40, so insert in left(max heap)

 10,20,30,37-Root   Root-40,50,60

 Median = 37

 Consider situation
 10,20,30   40,50,60

 Insert 45 into original instead of 37

 45>40
 1. Extract 40 from Min heap
 2. Insert 45 into Min Heap
 3. Insert 40 into Max heap


 10,20,30,40-Root   Root-45,50,60

 Median - 40

 Now insert above 47

 47>45 && maxheap.size > minheap.size

 insert into minheap

 10,20,30,40 - Root Root- 45,47,50,60

 Median = (40+45)/2 42.5



 Consider the situation

 10,20,30,40-Root   Root-45,50,60

 Insert 37

 maxheap.size > minheap.size
 37<45
 1. Extract 40 from Maxheap
 2.Insert 37 into MaxHeap
 3. Insert 40 to min heap

 10,20,30,37-Root Root-40,45,50,60

 Median = (37+40)/2 = 33.5
 */

public class MeanMedianGivenStream {
    private PriorityQueue<Integer> maxLeftHeap;
    private PriorityQueue<Integer> minRightHeap;
    public int runningSum;
    public int runningMean;

    public Comparator<Integer> minRightHeapComparator, maxLeftHeapComparator;
    public MeanMedianGivenStream(){
//        minRightHeapComparator = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                if(o1 <= o2)
//                return 1;
//                else
//                    return -1;
//            }
//        };
//        maxLeftHeapComparator =  new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                if(o1 <= o2)
//                    return -1;
//                else
//                    return 1;
//            }
//        };

        maxLeftHeap = new PriorityQueue<>(10,Collections.reverseOrder());
        minRightHeap = new PriorityQueue<>();
        runningMean = runningSum =0;
    }

    public int currentSize(){
        return maxLeftHeap.size() + minRightHeap.size();
    }

    public int getRunningMedian(){

        if(currentSize()% 2==0){
            return (maxLeftHeap.peek()+minRightHeap.peek())/2;
        }
        return maxLeftHeap.peek();
    }

    public void updateSum(int currentNum){
        if(currentSize() < 0){
            throw new IllegalStateException("size cannot be <=0");

        }
        runningMean = currentNum/(currentSize()+ 1) ;
    }

    /*
    For explanation see top
    Note:- While adding number we make sure we keep the diff in size of heap by 1. Always the maxHeap will have 1 more element
     */
    public void addNewNumber(Integer number){
        updateSum(number);

        if(maxLeftHeap.size() == minRightHeap.size()){

            if (minRightHeap.peek()!= null && number > minRightHeap.peek()) {
                //remove top element from right min heap
                maxLeftHeap.offer( minRightHeap.poll());
                minRightHeap.offer(number);
            } else {
                maxLeftHeap.offer(number);
            }
        }else {

            //Case when the size are different i.e. the left max heap has one more element

            if(maxLeftHeap.peek()== null){
                maxLeftHeap.offer(number);
                return;
            }
            if (number < maxLeftHeap.peek()) {
                minRightHeap.offer(maxLeftHeap.poll());
                maxLeftHeap.offer(number);

            } else {
                minRightHeap.offer(number);
            }
        }

    }
}

