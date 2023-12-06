package test.java.menus;

import main.java.menus.BPPcontainerView;
import main.java.abstracts.problem.ILoadingProblems;
import main.java.concrete.Problems.containerBPP.BPPcontainerProblem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BPPcontainerViewTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private Scanner scannerMock;
    private ILoadingProblems bppProblemMock;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        scannerMock = Mockito.mock(Scanner.class);
        bppProblemMock = Mockito.mock(BPPcontainerProblem.class);
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void testRun_withValidDataFile() {
        // Setup input for testing
        String dataFile = "BPP_1.txt";
        ByteArrayInputStream in = new ByteArrayInputStream(dataFile.getBytes());
        System.setIn(in);

        // Call the method to be tested
        BPPcontainerView.run(scannerMock, dataFile);

        // Assertions and verification
        assertTrue(outContent.toString().contains("BPP Container Loading Problem"));
        verify(bppProblemMock, times(1)).instancesFromText();
        // Add more assertions and verifications as needed
    }

    @Test
    void testRun_exitCommand() {
        // Setup input for testing
        String input = "exit";
        when(scannerMock.nextLine()).thenReturn(input);

        // Call the method to be tested
        BPPcontainerView.run(scannerMock, null);

        // Assertions and verification
        assertTrue(outContent.toString().contains("exit"));
        verify(scannerMock, times(1)).nextLine();
        // Add more assertions and verifications as needed
    }

    // Additional tests for hillClimbingBPP, simulatedAnnealingBPP, greedyBPP, graspBPP, etc.
    
    // Example:
    @Test
    void testHillClimbingBPP() {
        BPPcontainerView.hillClimbingBPP(bppProblemMock);
        // Assertions and verifications for hillClimbingBPP
        // ...
    }

    // ... other tests
}
