package test;

import Integers.NimGame;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by arjun_000 on 2/25/2016.
 */
public class NimGameTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testWillYouWinTheGame() throws Exception {

        assertTrue("You should have won the game", NimGame.willYouWinTheGame(5));
        assertTrue("You should have won the game",NimGame.willYouWinTheGame(567));
        assertFalse("You should have lost the game",NimGame.willYouWinTheGame(8));
        assertFalse("You should have lost the game",NimGame.willYouWinTheGame(16));
    }
}