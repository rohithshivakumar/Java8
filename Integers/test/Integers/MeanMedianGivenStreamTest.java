package Integers;

import static org.junit.Assert.*;

/**
 * Created by arjun_000 on 2/16/2016.
 */
public class MeanMedianGivenStreamTest {
    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void testRunningMedian() throws Exception {
        MeanMedianGivenStream meanMedianGivenStream = new MeanMedianGivenStream();
        meanMedianGivenStream.addNewNumber(10);
        assertEquals("Running median should be 10",meanMedianGivenStream.getRunningMedian(),10);
        meanMedianGivenStream.addNewNumber(30);
        assertEquals("Running median should be 20",meanMedianGivenStream.getRunningMedian(),20);

        meanMedianGivenStream.addNewNumber(20);
        meanMedianGivenStream.addNewNumber(40);
        meanMedianGivenStream.addNewNumber(60);
        meanMedianGivenStream.addNewNumber(50);

        assertEquals("Running median should be 35",meanMedianGivenStream.getRunningMedian(),35);
    }

}