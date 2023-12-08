package es.ull.concrete.metaheuristics.vehiclesVRP;

import es.ull.abstracts.problem.IRoutingProblems;

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
