package test.java.concrete.Problems.vehiclesVRP;

import static org.junit.jupiter.api.Assertions.*;

import main.java.concrete.Problems.vehiclesVRP.VRPvehiclesProblem;
import org.junit.jupiter.api.Test;

class TestVRPvehiclesProblem {

    @Test
    void testGetSize() {
        VRPvehiclesProblem problem = new VRPvehiclesProblem(5);
        assertEquals(5, problem.getSize());
    }

    @Test
    void testSetSize() {
        VRPvehiclesProblem problem = new VRPvehiclesProblem();
        problem.setSize(8);
        assertEquals(8, problem.getSize());
    }

    @Test
    void testGetDistances() {
        int[][] distancesArray = { { 0, 1, 2 }, { 1, 0, 3 }, { 2, 3, 0 } };
        VRPvehiclesProblem problem = new VRPvehiclesProblem(3, distancesArray);
        assertArrayEquals(distancesArray, problem.getDistances());
    }

    @Test
    void testSetDistances() {
        VRPvehiclesProblem problem = new VRPvehiclesProblem();
        int[][] distancesArray = { { 0, 1, 2 }, { 1, 0, 3 }, { 2, 3, 0 } };
        problem.setDistances(distancesArray);
        assertArrayEquals(distancesArray, problem.getDistances());
    }

    @Test
    void testLoadDataFromFile() {
        VRPvehiclesProblem problem = new VRPvehiclesProblem();
        String textInstances = "0\t1\t2\n1\t0\t3\n2\t3\t0\n";
        problem.setTextInstances(textInstances);
        assertEquals(textInstances, problem.getTextInstances());
    }

    @Test
    void testInstancesFromFile() {
        VRPvehiclesProblem problem = new VRPvehiclesProblem();
        String textInstances = "Node\tA\tB\tC\nA\t0\t1\t2\nB\t1\t0\t3\nC\t2\t3\t0\n";
        problem.setTextInstances(textInstances);
        problem.instancesfromFile();
        int[][] expectedDistances = { { 0, 1, 2 }, { 1, 0, 3 }, { 2, 3, 0 } };
        assertArrayEquals(expectedDistances, problem.getDistances());
    }

    @Test
    void testRandomInstances() {
        VRPvehiclesProblem problem = new VRPvehiclesProblem(4);
        problem.randomInstances();
        int[][] distances = problem.getDistances();
        assertEquals(4, distances.length);
        assertEquals(4, distances[0].length);
    }

    @Test
    void testClosestNode() {
        VRPvehiclesProblem problem = new VRPvehiclesProblem();
        int[][] distancesArray = { { 0, 1, 2 }, { 1, 0, 3 }, { 2, 3, 0 } };
        problem.setDistances(distancesArray);

        int[] tab = { 0, 2 }; // Assuming tab is an array of visited nodes

        //assertEquals(1, problem.closestNode(0, tab));
        assertEquals(2, problem.closestNode(1, tab));
    }

    @Test
    void testToString() {
        VRPvehiclesProblem problem = new VRPvehiclesProblem();
        int[][] distancesArray = { { 0, 1, 2 }, { 1, 0, 3 }, { 2, 3, 0 } };
        problem.setDistances(distancesArray);

        String expectedString = "\tA\tB\tC\nA\t0\t1\t2\nB\t1\t0\t3\nC\t2\t3\t0\n";

        assertEquals(expectedString, problem.toString());
    }
}
