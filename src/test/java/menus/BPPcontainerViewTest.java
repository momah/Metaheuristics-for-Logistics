package test.java.menus;

import main.java.menus.BPPcontainerView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BPPcontainerViewTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private Scanner scannerMock;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        scannerMock = Mockito.mock(Scanner.class);
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void testRun_withValidDataFile() {
        try {
            String dataFile = "valid_data.txt";
            BPPcontainerView.run(scannerMock, dataFile);
            assertTrue(outContent.toString().contains("BPP Container Loading Problem"));
        } catch (CloneNotSupportedException e) {
            fail("CloneNotSupportedException should not have been thrown");
        }
    }

    @Test
    void testRun_exitCommand() {
        try {
            String input = "exit";
            when(scannerMock.nextLine()).thenReturn(input);
            BPPcontainerView.run(scannerMock, null);
            assertTrue(outContent.toString().contains("exit"));
        } catch (CloneNotSupportedException e) {
            fail("CloneNotSupportedException should not have been thrown");
        }
    }

    // Additional tests...

}
