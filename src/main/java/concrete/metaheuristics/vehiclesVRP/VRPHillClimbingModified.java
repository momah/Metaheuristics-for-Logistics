package main.java.concrete.metaheuristics.vehiclesVRP;

import main.java.abstracts.problem.IRoutingProblems;

public class VRPHillClimbingModified extends VRPHillClimbing {
	public VRPHillClimbingModified(IRoutingProblems rProblem) {
		super(rProblem);
	}
	
	protected long initialSolution() {
		this.solution.randomSolutionModified();
		long start = this.printInicialSolution(problem);
		return start;
	}
}
