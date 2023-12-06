package test.java.concrete.Problems.containerBPP;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import main.java.abstracts.problem.ILoadingProblems;
import main.java.abstracts.problem.Problem;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class BPPcontainerProblemTest {

    @Test
    void testConstructorWithFilename() {
        String filename = "testFile.txt";
        BPPcontainerProblem bppContainerProblem = new BPPcontainerProblem(filename);
        // Add assertions based on the expected behavior of the constructor with a filename
        assertNotNull(bppContainerProblem);
        // Example: assertEquals(expectedValue, bppContainerProblem.getSomeValue());
    }

    @Test
    void testInstancesFromText() {
        BPPcontainerProblem bppContainerProblem = new BPPcontainerProblem();
        bppContainerProblem.setTextInstances("10:1-2,3-4,5-6");
        bppContainerProblem.instancesFromText();
        // Add assertions based on the expected behavior of instancesFromText
        assertEquals(10, bppContainerProblem.getCapacity());
        List<Item> items = bppContainerProblem.getItems();
        assertEquals(3, items.size());
        // Example: assertEquals(expectedValue, bppContainerProblem.getSomeValue());
    }

    @Test
    void testGetCapacity() {
        BPPcontainerProblem bppContainerProblem = new BPPcontainerProblem(15, null);
        int capacity = bppContainerProblem.getCapacity();
        // Add assertions based on the expected behavior of getCapacity
        assertEquals(15, capacity);
        // Example: assertEquals(expectedValue, bppContainerProblem.getSomeValue());
    }

    @Test
    void testGetItem() {
        List<Item> items = List.of(new Item(1, 2), new Item(3, 4), new Item(5, 6));
        BPPcontainerProblem bppContainerProblem = new BPPcontainerProblem(10, items);
        Item item = bppContainerProblem.getItem(1);
        // Add assertions based on the expected behavior of getItem
        assertNotNull(item);
        assertEquals(3, item.getIndex());
        // Example: assertEquals(expectedValue, bppContainerProblem.getSomeValue());
    }

    @Test
    void testGetItems() {
        List<Item> items = List.of(new Item(1, 2), new Item(3, 4), new Item(5, 6));
        BPPcontainerProblem bppContainerProblem = new BPPcontainerProblem(10, items);
        List<Item> retrievedItems = bppContainerProblem.getItems();
        // Add assertions based on the expected behavior of getItems
        assertNotNull(retrievedItems);
        assertEquals(3, retrievedItems.size());
        // Example: assertEquals(expectedValue, bppContainerProblem.getSomeValue());
    }

    @Test
    void testGetNumItems() {
        List<Item> items = List.of(new Item(1, 2), new Item(3, 4), new Item(5, 6));
        BPPcontainerProblem bppContainerProblem = new BPPcontainerProblem(10, items);
        int numItems = bppContainerProblem.getNumItems();
        // Add assertions based on the expected behavior of getNumItems
        assertEquals(3, numItems);
        // Example: assertEquals(expectedValue, bppContainerProblem.getSomeValue());
    }

    @Test
    void testToString() {
        BPPcontainerProblem bppContainerProblem = new BPPcontainerProblem(10, null);
        String toStringResult = bppContainerProblem.toString();
        // Add assertions based on the expected behavior of toString
        assertNotNull(toStringResult);
        assertTrue(toStringResult.contains("CAPACITY = 10"));
        // Example: assertTrue(toStringResult.contains("ExpectedSubstring"));
    }

    @Test
    void testPesoItems() {
        List<Item> items = List.of(new Item(1, 2), new Item(3, 4), new Item(5, 6));
        BPPcontainerProblem bppContainerProblem = new BPPcontainerProblem(10, items);
        double pesoItems = bppContainerProblem.pesoItems();
        // Add assertions based on the expected behavior of pesoItems
        assertEquals(12.0, pesoItems);
        // Example: assertEquals(expectedValue, bppContainerProblem.getSomeValue());
    }

    @Test
    void testToStringWithOutputItems() {
        List<Item> items = List.of(new Item(1, 2), new Item(3, 4), new Item(5, 6));
        BPPcontainerProblem bppContainerProblem = new BPPcontainerProblem(10, items);
        String toStringResult = bppContainerProblem.toString(true);
        // Add assertions based on the expected behavior of toString with outputItems
        assertNotNull(toStringResult);
        assertTrue(toStringResult.contains("CAPACITY = 10"));
        assertTrue(toStringResult.contains("1-2"));
        // Example: assertTrue(toStringResult.contains("ExpectedSubstring"));
    }
}
