package es.ull.metaheuristics.vehiclesVRP;

import java.util.Collections;

import es.ull.abstracts.metaheuristics.RoutingAbsractMHeuristics;
import es.ull.abstracts.problem.IRoutingProblems;
import es.ull.concrete.solutions.VRPvehiclesSolution;



public class VRPHillClimbing extends RoutingAbsractMHeuristics {
	public VRPHillClimbing(IRoutingProblems rProblem) {
		super(rProblem);
	}

	public VRPvehiclesSolution getBestNeighbour() throws CloneNotSupportedException{
		return Collections.min(this.solution.getNeighbours());
	}

	@Override
	public void solve() throws CloneNotSupportedException {
		long start = initialSolution();
		
		bestSolution();
		
		long end = this.printFinalSolution(problem);
		System.out.println("Average time : "+(end-start)/1000+" us");
	}

	protected long initialSolution() {
		long start = this.printInicialSolution(problem);
		return start;
	}
	
	private void bestSolution() throws CloneNotSupportedException {
		do {
			VRPvehiclesSolution neighbor = this.getBestNeighbour();
			if(neighbor.compareTo(solution) < 0) {
				solution = neighbor;
			} else break;
		} while(true);
	}
}
