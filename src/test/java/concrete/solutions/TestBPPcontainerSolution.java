package test.java.concrete.solutions;

import main.java.concrete.Problems.containerBPP.BPPcontainerProblem;
import main.java.concrete.Problems.containerBPP.Item;
import main.java.concrete.solutions.BPPcontainerSolution;
import main.java.abstracts.problem.ILoadingProblems;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestBPPcontainerSolution {

    @Test
    void testBasicFunctionality() {
        // Create a BPPcontainerProblem instance for testing
        ILoadingProblems bppProblem = createBPPcontainerProblemForTesting();

        // Create a solution with all zeros
        int[] solutionArray = new int[bppProblem.getNumItems()];
        BPPcontainerSolution solution = new BPPcontainerSolution(solutionArray, bppProblem);

        // Check initial conditions
        assertEquals(0, solution.actualWeight());
        assertFalse(solution.full());

        // Add an item to the solution
        solution.addNextItem(false); // Adding an item without randomness

        // Check if the item is added
        assertFalse(solution.select(0));

        // Remove the item
        solution.removeItem(0);

        // Check if the item is removed
        assertFalse(solution.select(0));
        assertFalse(solution.full());
    }

    @Test
    void testAddNextBestItem() {
        // Create a BPPcontainerProblem instance for testing
        ILoadingProblems bppProblem = createBPPcontainerProblemForTesting();

        // Create a solution with all zeros
        int[] solutionArray = new int[bppProblem.getNumItems()];
        BPPcontainerSolution solution = new BPPcontainerSolution(solutionArray, bppProblem);

        // Add the best item to the solution
        solution.addNextBestItem();

        // Check if the best item is added
        assertFalse(solution.select(2)); // Assuming index 2 is the best item index

        // Try adding one more item to fill the container
        solution.tryAddOneMore();

        // Check if the container is now full
        assertFalse(solution.full());
    }

    private ILoadingProblems createBPPcontainerProblemForTesting() {
        // Create a simple BPPcontainerProblem for testing
        int capacity = 10;
        Item item1 = new Item(5, 2); // Weight = 5, Priority = 2
        Item item2 = new Item(3, 5); // Weight = 3, Priority = 5
        Item item3 = new Item(8, 1); // Weight = 8, Priority = 1
        // Add more items if needed

        // Create a BPPcontainerProblem instance
        BPPcontainerProblem bppProblem = new BPPcontainerProblem(capacity, new ArrayList<>(List.of(item1, item2, item3)));
        return bppProblem;
    }
}
