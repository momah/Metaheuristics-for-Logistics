package test.java.menus;

import main.java.Main;
import main.java.menus.BPPcontainerView;
import main.java.menus.VRPvehiclesView;

import java.util.Scanner;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void mainTest() {
        // Redirect System.in and System.out for testing
        String input = "1\n0\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Test the main method
        Main.main(new String[]{});

        // Restore original System.in and System.out
        System.setIn(System.in);
        System.setOut(System.out);

        // Verify the output
        String expectedOutput = "------------------------------------------------\n" +
                                "---------------- MENÚ PRINCIPAL ----------------\n" +
                                "------------------------------------------------\n" +
                                " Elige una metaheurística: ----------------------\n" +
                                "------------------------------------------------\n" +
                                "1. BPP Container Loading Problem                -\n" +
                                "2. VRP Vehicle Routing Problem                  -\n" +
                                "0. Salir                                        -\n" +
                                "------------------------------------------------\n" +
                                "Opción: ";
        assertEquals(expectedOutput, outputStream.toString());
    }
}
