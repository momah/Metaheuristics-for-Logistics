package main.java.abstracts.metaheuristics;

import java.util.Random;
import java.util.logging.Logger;

import main.java.abstracts.problem.ILoadingProblems;
import main.java.abstracts.solution.ILoadingSolutions;
import main.java.concrete.solutions.BPPcontainerSolution;

public abstract class LoadingAbsractMHeuristics {
    private static final Logger logger = Logger.getLogger(LoadingAbsractMHeuristics.class.getName());

    /**
     * The common solution to the problem
     */
    protected BPPcontainerSolution solution;

    /**
     * The problem instance: Capacity of the container,
     * set of weights and values of different items
     */
    protected ILoadingProblems lProblem;

    /**
     * A Random instance for generating random solutions //BUGFIX
     */
    protected Random rand = new Random();

    /**
     * @param lProblem
     */
    protected LoadingAbsractMHeuristics(ILoadingProblems lProblem) {
        super();
        this.lProblem = lProblem;
    }

    protected BPPcontainerSolution randomSolution(ILoadingProblems instance) {
        int size = instance.getNumItems();
        int[] sol = new int[size];

        boolean bool;
        for (int i = 0; i < size; i++) {
            bool = rand.nextBoolean();
            sol[i] = (bool) ? 1 : 0;
        }

        return new BPPcontainerSolution(sol, instance);
    }

    protected BPPcontainerSolution resetSolution(ILoadingProblems lProblem) {
        int size = lProblem.getNumItems();
        int[] sol = new int[size];

        for (int i = 0; i < sol.length; i++)
            sol[i] = 0;
        return new BPPcontainerSolution(sol, lProblem);
    }

    public void solve(ILoadingProblems lProblem) {
        // Implementation of the solution method
    }

    protected void printSolution(ILoadingSolutions lSolution) {
        logger.info(lSolution.toString(true, true));
    }

    protected void printInitialSolution() {
        logger.info("Initial Solution:\n" + this.solution.toString(true, true) + "\n");
    }

    protected void printBestSolution() {
        logger.info("Final Solution :\n" + this.solution.toString(true, true) + "\n");
    }
}
