package concrete.metaheuristics.vehiclesVRP;

import java.util.Random;

import abstracts.metaheuristics.RoutingAbsractMHeuristics;
import abstracts.problem.IRoutingProblems;
import abstracts.solution.IRoutingSolutions;
import concrete.solutions.VRPvehiclesSolution;

public class VRPSimulatedAnnealing extends RoutingAbsractMHeuristics {
	
	int temp = 1000;
	private IRoutingSolutions lastBestSolution;
	
	public VRPSimulatedAnnealing(IRoutingProblems rProblem) {
		super(rProblem);
	}

	/**
	 * Renvoi un voision aléatoire
	 * @throws CloneNotSupportedException 
	 */
	public IRoutingSolutions randomNeighbour() throws CloneNotSupportedException{
		int j = (int)((Math.random()*(problem.getSize()-1)));
		return this.solution.getNeighbour(j);
	}
	/**
	 * 
	 * @param actualSolution
	 * @param neighbourSolution
	 * @return
	 */
	private double acceptProbability(int actualSolution, int neighbourSolution){
		return Math.exp(((actualSolution-neighbourSolution)/temp));
	}

	@Override
	public void solve() throws CloneNotSupportedException {
		long start = this.printInicialSolution(problem);
		
		IRoutingSolutions neighbourSolution = null;
		double rand = 0;
		lastBestSolution = (IRoutingSolutions) solution.clone();
		do {
			neighbourSolution = this.randomNeighbour();
			rand = new Random().nextDouble();
			if( rand < acceptProbability(this.solution.getCostPath(problem),neighbourSolution.getCostPath(problem)) ){
				if( neighbourSolution.getCostPath(problem) < lastBestSolution.getCostPath(problem)) lastBestSolution = (IRoutingSolutions) neighbourSolution.clone();
				solution = (VRPvehiclesSolution)neighbourSolution.clone();
			}
			temp--;
		} while( temp > 1 );
		if( solution.getCostPath(problem) > lastBestSolution.getCostPath(problem)) solution = (VRPvehiclesSolution) lastBestSolution.clone();

		long end = this.printFinalSolution(problem);
		System.out.println("Average time : "+(end-start)/1000+" us");
	}
	
	

}
