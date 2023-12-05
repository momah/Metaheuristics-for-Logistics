package test.java.concrete.solutions;

import main.java.abstracts.metaheuristics.RoutingAbstractMHeuristics;
import main.java.abstracts.problem.IRoutingProblems;
import main.java.concrete.Problems.vehiclesVRP.VRPvehiclesProblem;
import main.java.concrete.metaheuristics.vehiclesVRP.VRPHillClimbing;
import main.java.concrete.solutions.VRPvehiclesSolution;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class TestVRPvehiclesSolution {

    @Test
    void testBasicFunctionality() {
        // Create an instance of VRPvehiclesSolution for testing
        int[] solutionArray = {0, 1, 2, 3}; // Adjust based on the problem size
        RoutingAbstractMHeuristics metaheuristics = new VRPHillClimbing(new VRPvehiclesProblem("inputs/VRP_1.txt"));
        VRPvehiclesSolution solution = new VRPvehiclesSolution(solutionArray, metaheuristics);

        // Check initial conditions
        assertEquals(4, solution.getSize());
        assertEquals(3, solution.getIndice(3));
        try {
            assertFalse(solution.getNeighbours().isEmpty());
        } catch (Exception e) {

        }

        // Test toString method
        assertNotNull(solution.toString());

        // Test cloning
        try {
            VRPvehiclesSolution clonedSolution = (VRPvehiclesSolution) solution.clone();
            assertArrayEquals(solutionArray, clonedSolution.getSolution());
        } catch (CloneNotSupportedException e) {
            fail("CloneNotSupportedException should not be thrown");
        }
    }

    @Test
    void testCostCalculation() {
        // Create an instance of VRPvehiclesSolution for testing
        int[] solutionArray = {0, 1, 2, 3}; // Adjust based on the problem size
        VRPvehiclesSolution solution = new VRPvehiclesSolution(solutionArray, new VRPHillClimbing(new VRPvehiclesProblem("inputs/VRP_1.txt")));


        // Test cost calculation
        assertEquals(3, solution.getCostPath(new VRPvehiclesProblem("inputs/VRP_1.txt")));
    }


}
