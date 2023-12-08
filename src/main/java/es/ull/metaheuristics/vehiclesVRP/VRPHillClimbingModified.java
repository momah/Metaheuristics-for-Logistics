package es.ull.metaheuristics.vehiclesVRP;

import es.ull.abstracts.problem.IRoutingProblems;
import es.ull.metaheuristics.vehiclesVRP.VRPHillClimbing;

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
