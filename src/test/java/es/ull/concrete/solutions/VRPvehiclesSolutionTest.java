package es.ull.concrete.solutions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import es.ull.concrete.Problems.vehiclesVRP.VRPvehiclesProblem;
import es.ull.concrete.Problems.vehiclesVRP.Edges;

class VRPvehiclesSolutionTest {

    private VRPvehiclesSolution solution;
    private VRPvehiclesProblem problem;
    private int size;
    private int[][] distances;

    @BeforeEach
    void setUp() {
        size = 5;
        distances = new int[][]{
                {0, 1, 2, 3, 4},
                {1, 0, 3, 4, 5},
                {2, 3, 0, 5, 6},
                {3, 4, 5, 0, 7},
                {4, 5, 6, 7, 0}
        };
        problem = new VRPvehiclesProblem(size, distances);

        solution = new VRPvehiclesSolution(size, null);
        solution.initialiserSolution();
    }

    @Test
    void testConstructor() {
        assertNotNull(solution);
        assertEquals(size, solution.getSize());
    }

    @Test
    void testInitialiserSolution() {
        for (int i = 0; i < size; i++) {
            assertEquals(i, solution.getSolution()[i]);
        }
    }

    @Test
    void testRandomSolution() {
        solution.randomSolution();
        assertNotNull(solution.getSolution());
        assertEquals(size, solution.getSolution().length);
    }

    @Test
    void testGetNeighbour() throws CloneNotSupportedException {
        VRPvehiclesSolution neighbour = solution.getNeighbour(0);
        assertNotNull(neighbour);
        assertEquals(solution.getSolution()[1], neighbour.getSolution()[0]);
        assertEquals(solution.getSolution()[0], neighbour.getSolution()[1]);
    }

    @Test
    void testGetCostPath() {
        int cost = solution.getCostPath(problem);
        assertTrue(cost >= 0);
    }

    // Aquí pueden añadirse más pruebas para otros métodos

}
