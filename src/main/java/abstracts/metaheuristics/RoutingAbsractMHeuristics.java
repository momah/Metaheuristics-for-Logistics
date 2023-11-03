package abstracts.metaheuristics;

import abstracts.problem.IRoutingProblems;
import abstracts.solution.IRoutingSolutions;
import concrete.solutions.VRPvehiclesSolution;

public abstract class RoutingAbsractMHeuristics {
	/**
	 * The problem instance : distances between nodes
	 */
	protected IRoutingProblems problem;
	/**
	 * The common solution to the problem
	 */
	protected VRPvehiclesSolution solution;
	
	/**
	 * Constructor using class fields
	 * @param rProblem
	 */
	public RoutingAbsractMHeuristics(IRoutingProblems rProblem) {
		super();
		this.problem = rProblem;
		this.solution = new VRPvehiclesSolution(rProblem.getSize(),this);
		solution.randomSolution();
	}
	/**
	 * Method that solve the problem to be defined in each concrete method
	 * @throws CloneNotSupportedException 
	 */
	public abstract void solve() throws CloneNotSupportedException;
	
	/**
	 * @return the instance problem
	 */
	public IRoutingProblems getInstance() {
		return problem;
	}
	/**
	 * @param instance, the instance problem to set
	 */
	public void setInstance(IRoutingProblems instance) {
		this.problem = instance;
	}
	
	/**
	 * @return the Routing Solution
	 */
	public IRoutingSolutions getVRPSolution() {
		return solution;
	}
	/**
	 * @param rSolution the Routing Solution to set
	 */
	public void setTspSolution(VRPvehiclesSolution rSolution) {
		this.solution = rSolution;
	}
	
	public long printInicialSolution(IRoutingProblems rProblem){
		System.out.println("Inicial Solution:\n");
		System.out.println(this.getVRPSolution().toString(rProblem));
		System.out.println("Distance or Cost Path : "+this.getVRPSolution().getCostPath(rProblem)+"\n");
		long start = System.nanoTime();
		return start;
	}
	public long printFinalSolution(IRoutingProblems routingProblem){
		System.out.println("Final Solution:\n");
		long end = System.nanoTime(); 
		System.out.println(this.getVRPSolution().toString(routingProblem));
		System.out.println("Distance or Cost Path : "+this.getVRPSolution().getCostPath(routingProblem));
		return end;
	}

	
	
	
}
