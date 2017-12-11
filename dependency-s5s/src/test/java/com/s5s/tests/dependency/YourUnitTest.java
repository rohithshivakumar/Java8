package com.s5s.tests.dependency;

import org.junit.Test;

import java.io.IOException;

/**
 * Place holder for your unit tests
 */
public class YourUnitTest extends BaseTest {

    @Test
    //DEPEND: no output for DEPEND
    public void testDepend() throws IOException {
        String[] input = {
                "DEPEND A B\n",
                "END\n"
        };

        String expectedOutput = "DEPEND A B\n" +
                "END\n";

        runTest(expectedOutput, input);
    }

    @Test
    //DEPEND: no output for DEPEND
    public void testDepend2() throws IOException {
        String[] input = {
                "DEPEND A B\n",
                "DEPEND B A\n",
                "END\n"
        };

        String expectedOutput = "DEPEND A B\n" + "A depends on B, ignoring command\n" +
                "END\n";

        runTest(expectedOutput, input);
    }

    @Test
    //INSTALL: output "Installing"
    public void testInstall() throws IOException {
        String[] input = {
                "DEPEND A B\n",
                "INSTALL B\n",
                "INSTALL foo\n",
                "END\n"
        };

        String expectedOutput = "DEPEND A B\n" +
                "INSTALL B\n" +
                "Installing B\n" +
                "INSTALL foo\n" +
                "Installing foo\n" +
                "END\n";

        runTest(expectedOutput, input);
    }


}
