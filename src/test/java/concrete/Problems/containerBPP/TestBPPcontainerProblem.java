package test.java.concrete.Problems.containerBPP;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import main.java.concrete.Problems.containerBPP.BPPcontainerProblem;
import main.java.concrete.Problems.containerBPP.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestBPPcontainerProblem {

    private BPPcontainerProblem bppContainerProblemDefault;
    private BPPcontainerProblem bppContainerProblemInitialize;
    private ArrayList<Item> array;

    @BeforeEach
    void setUp() {
        // Initialize the BPPcontainerProblem instance for testing
        bppContainerProblemDefault = new BPPcontainerProblem();
        array = new ArrayList<>();
        array.add(new Item(10, 20));
        array.add(new Item(30, 40));
        bppContainerProblemInitialize = new BPPcontainerProblem(150, array);
    }

    @Test
    void testLoadDataFromFile() {
        String filename = "inputs/BPP_1.txt";
        String loadedData = bppContainerProblemInitialize.LoadDataFromFile(filename);
        //TODO
        assertNotEquals("", loadedData);
    }

    @Test
    void testInstancesFromText() {
        // Test the instancesFromText method

        // Set up test data
        bppContainerProblemInitialize.setTextInstances("100:10-20,30-40,50-60");
        bppContainerProblemInitialize.instancesFromText();

        // Verify the loaded values
        assertEquals(100, bppContainerProblemInitialize.getCapacity());

        ArrayList<Item> expectedItems = new ArrayList<>();
        expectedItems.add(new Item(10, 20));
        expectedItems.add(new Item(30, 40));
        expectedItems.add(new Item(50, 60));

        assertEquals(expectedItems, bppContainerProblemInitialize.getItems());
    }

    @Test
    void testGetCapacity() {
        // Test the getCapacity method

        // Verify the capacity value
        assertEquals(150, bppContainerProblemInitialize.getCapacity());
    }

    @Test
    void testGetItem() {
        // Test the getItem method
        // Verify the getItem method
        assertEquals(new Item(10, 20), bppContainerProblemInitialize.getItem(0));
        assertEquals(new Item(30, 40), bppContainerProblemInitialize.getItem(1));
    }

    @Test
    void testGetItems() {
        // Verify the getItems method
        assertEquals(this.array, bppContainerProblemInitialize.getItems());
    }

    @Test
    void testGetNumItems() {
        // Verify the getNumItems method
        assertEquals(2, bppContainerProblemInitialize.getNumItems());
    }

    @Test
    void testToString() {
        // Verify the toString method
        assertEquals("{ CAPACITY = 150 }", bppContainerProblemInitialize.toString());
    }

    @Test
    void testPesoItems() {
        // Test the pesoItems method
        // Verify the pesoItems method
        assertEquals(10 + 30, bppContainerProblemInitialize.pesoItems());
    }

    @Test
    void testToStringWithItems() {
        // Test the toString method with outputitems set to true
        // Verify the toString method with outputitems set to true
        assertEquals("{ CAPACITY = 150 }\nItem{Weight=10, Volume=20}\nItem{Weight=30, Volume=40}}",
                bppContainerProblemInitialize.toString(true));
    }
}
