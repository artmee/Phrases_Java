package ru.nsu.g.akononov.phrases;

import org.junit.Test;
import static org.junit.Assert.*; 
import org.junit.After;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import ru.nsu.g.akononov.phrases.*;

public class FrequencyStreamTest {

    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @Test
    public void test3() {
        Frequency temp = new FrequencyStream("input/in1.txt", 3, 3);

        temp.phrases_count();

        assertEquals("yellow submarine yellow (4)\n" +
                "submarine yellow submarine (4)\n", output.toString());
    }

    @Test
    public void test4() {
        try {
            Frequency temp = new FrequencyStream("input/in2.txt", 3, 3);

            temp.phrases_count();

        } catch (RuntimeException e) {
            assertEquals("java.lang.RuntimeException: Text length < required phrases length", e.toString());
        }
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
}
