package main.java.abstracts.solution;

import main.java.abstracts.metaheuristics.RoutingAbstractMHeuristics;
import main.java.abstracts.problem.Problem;

/**
 * @author mmahrach
 *
 */
public abstract class Solution implements Cloneable,Comparable<Object> {
	/**
	 * The problem represents the Problem class object, which is an instance of the input data to solve.
	 */
	protected Problem problem;
	
	/**
	 * The outlput solution dataset of the problem.
	 */
	protected int[] solution;
	
	/**
	 * Metaheuristics used for resolution
	 */
	protected RoutingAbstractMHeuristics metaheuristics;
	
	/**
	 * 
	 */
	public Solution() {
		super();
	}

	/**
	 * @return the solution
	 */
	public int[] getSolution() {
		return solution;
	}

	/**
	 * @param solution the solution to set
	 */
	public void setSolution(int[] solution) {
		this.solution = solution;
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
	public RoutingAbstractMHeuristics getMetaheuristics() {
		return metaheuristics;
	}

	/**
	 * @param metaheuristics, the metaheuristics to set to the solution
	 */
	public void setMetaheuristics(RoutingAbstractMHeuristics metaheuristics) {
		this.metaheuristics = metaheuristics;
	}
}
