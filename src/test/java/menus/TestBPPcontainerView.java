package test.java.menus;

import main.java.concrete.Problems.containerBPP.BPPcontainerProblem;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

    public class TestBPPcontainerView {

        @Test
        void testLoadDataFromFile() {
            BPPcontainerProblem bppProblem = new BPPcontainerProblem();
            String testData = "10:1-2,3-4,5-6";
            bppProblem.setTextInstances(testData);

            assertEquals(testData, bppProblem.LoadDataFromFile("testFileName"));
        }

        @Test
        void testInstancesFromText() {
            BPPcontainerProblem bppProblem = new BPPcontainerProblem();
            String testData = "10:1-2,3-4,5-6";
            bppProblem.setTextInstances(testData);

            bppProblem.instancesFromText();

            assertEquals(10, bppProblem.getCapacity());
            assertEquals(3, bppProblem.getNumItems());
        }

        // Add more tests for other functionalities as needed
    }
