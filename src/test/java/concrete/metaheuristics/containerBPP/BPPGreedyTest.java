package main.java.concrete.metaheuristics.containerBPP;

import main.java.abstracts.problem.ILoadingProblems;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BPPGreedyTest {

    @Test
    public void testBPPGreedyConstructor() {
        ILoadingProblems instancia = null;
        BPPGreedy expected = new BPPGreedy(null);
        BPPGreedy actual = new BPPGreedy(instancia);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintBestSolution() {
        BPPGreedy b = new BPPGreedy(null);

        // Assuming printBestSolution returns a string, you might want to check for a non-null result
        assertNotNull(b.printBestSolution());
    }

    @Test
    public void testSolve() {
        ILoadingProblems loadingProblem = null;
        BPPGreedy b = new BPPGreedy(loadingProblem);

        // Assuming solve method updates some state, you might want to check for its side effects
        assertDoesNotThrow(() -> b.solve());

        // If solve method returns a result, you might want to check it
        // For example, if solve returns a boolean indicating success:
        assertTrue(b.solve());
    }
}
