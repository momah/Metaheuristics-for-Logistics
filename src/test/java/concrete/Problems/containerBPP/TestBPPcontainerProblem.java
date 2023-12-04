package test.java.concrete.Problems.containerBPP;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import main.java.concrete.Problems.containerBPP.BPPcontainerProblem;
import main.java.concrete.Problems.containerBPP.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BPPcontainerProblemTest {

    private BPPcontainerProblem bppContainerProblemDefault;
    private BPPcontainerProblem bppContainerProblem;
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
        String loadedData = bppContainerProblem.LoadDataFromFile(filename);
        //TODO
        assertNotEquals("", loadedData);
    }

    @Test
    void testInstancesFromText() {
        // Test the instancesFromText method

        // Set up test data
        bppContainerProblem.setTextInstances("100:10-20,30-40,50-60");
        bppContainerProblem.instancesFromText();

        // Verify the loaded values
        assertEquals(100, bppContainerProblem.getCapacity());

        ArrayList<Item> expectedItems = new ArrayList<>();
        expectedItems.add(new Item(10, 20));
        expectedItems.add(new Item(30, 40));
        expectedItems.add(new Item(50, 60));

        assertEquals(expectedItems, bppContainerProblem.getItems());
    }

    @Test
    void testGetCapacity() {
        // Test the getCapacity method

        // Verify the capacity value
        assertEquals(150, bppContainerProblem.getCapacity());
    }

    @Test
    void testGetItem() {
        // Test the getItem method
        // Verify the getItem method
        assertEquals(new Item(10, 20), bppContainerProblem.getItem(0));
        assertEquals(new Item(30, 40), bppContainerProblem.getItem(1));
    }

    @Test
    void testGetItems() {
        // Verify the getItems method
        assertEquals(this.array, bppContainerProblem.getItems());
    }

    @Test
    void testGetNumItems() {
        // Verify the getNumItems method
        assertEquals(2, bppContainerProblem.getNumItems());
    }

    @Test
    void testToString() {
        // Verify the toString method
        assertEquals("{ CAPACITY = 150 }", bppContainerProblem.toString());
    }

    @Test
    void testPesoItems() {
        // Test the pesoItems method

        // Verify the pesoItems method
        assertEquals(20 + 40, bppContainerProblem.pesoItems());
    }

    @Test
    void testToStringWithItems() {
        // Test the toString method with outputitems set to true


        // Verify the toString method with outputitems set to true
        assertEquals("{ CAPACITY = 150 }\n\tItem{Weight=10, Volume=20}\n\tItem{Weight=30, Volume=40}}",
                bppContainerProblem.toString(true));
    }
}
