package concrete.metaheuristics.vehiclesVRP;

import java.util.ArrayList;
import java.util.Collections;

import abstracts.metaheuristics.RoutingAbsractMHeuristics;
import abstracts.problem.IRoutingProblems;
import abstracts.solution.IRoutingSolutions;
import concrete.solutions.VRPvehiclesSolution;

public class VRPTabu extends RoutingAbsractMHeuristics {

	ArrayList<VRPvehiclesSolution> tabuList;
	
	public VRPTabu(IRoutingProblems rProblem) {
		super(rProblem);
		this.tabuList = new ArrayList<>();
	}


	public IRoutingSolutions randomNeighbour() throws CloneNotSupportedException{
		int j = (int)((Math.random()*(problem.getSize()-1)));
		return this.solution.getNeighbour(j);
	}

	public VRPvehiclesSolution getMinNeighbour() throws CloneNotSupportedException{
		return Collections.min(solution.getNeighbours());
	}
	@Override
	public void solve() throws CloneNotSupportedException {
		long start = this.printInicialSolution(problem);
		
		int cmpt = this.getInstance().getSize()*10;
		VRPvehiclesSolution s1 = solution, newSolution;
		this.tabuList.add(s1);
		do {
			newSolution = this.getMinNeighbour();
			if(newSolution.compareTo(s1) < 0) {
				s1 = newSolution;
				solution = newSolution;
				this.tabuList.add(newSolution);
				cmpt = this.getInstance().getSize()*10;
			}
			else cmpt--;
		} while(cmpt>0);
		
		long end = this.printFinalSolution(problem);

		System.out.println("Average time : "+(end-start)/1000+" us");
	}
	
	

}
