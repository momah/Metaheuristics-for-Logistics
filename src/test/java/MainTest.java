package test.java;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import main.java.Main;

public class MainTest {

    @Test
    public void testMainWithArguments() {
        String[] args = {"dataFile.txt"};
        assertDoesNotThrow(() -> Main.main(args));
    }

    @Test
    public void testMainWithoutArguments() {
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("0\n".getBytes());
        System.setIn(in);

        assertDoesNotThrow(() -> Main.main(new String[0]));

        System.setIn(sysInBackup);
    }
}
