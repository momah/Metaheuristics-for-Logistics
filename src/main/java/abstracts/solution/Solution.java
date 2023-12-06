package main.java.abstracts.solution;

import main.java.abstracts.metaheuristics.RoutingAbsractMHeuristics;
import main.java.abstracts.problem.Problem;

/**
 * @author mmahrach
 *
 */
public abstract class Solution implements Cloneable, Comparable<Object> {
    /**
     * The problem represents the Problem class object, which is an instance of the input data to solve.
     */
    protected Problem problem;

    /**
     * The output solution dataset of the problem.
     */
    protected int[] result;  // Renamed from "solution"

    /**
     * Metaheuristics used for resolution
     */
    protected RoutingAbsractMHeuristics metaheuristics;

    /**
     *
     */
    protected Solution() {
        super();
    }

    /**
     * @return the result
     */
    public int[] getResult() {  // Renamed from "getSolution"
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(int[] result) {  // Renamed from "setSolution"
        this.result = result;
    }

    /**
     * @return the problem
     */
    public Problem getProblem() {
        return problem;
    }

    /**
     * @param problem the problem to set
     */
    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    /**
     * @return the metaheuristics of solution
     */
    public RoutingAbsractMHeuristics getMetaheuristics() {
        return metaheuristics;
    }

    /**
     * @param metaheuristics, the metaheuristics to set to the solution
     */
    public void setMetaheuristics(RoutingAbsractMHeuristics metaheuristics) {
        this.metaheuristics = metaheuristics;
    }
}
