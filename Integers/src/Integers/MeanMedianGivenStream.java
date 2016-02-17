package Integers;

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
 */
public class MeanMedianGivenStream {
}
