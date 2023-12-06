package main.java.concrete.metaheuristics.containerBPP;

import main.java.abstracts.metaheuristics.LoadingAbsractMHeuristics;
import main.java.abstracts.problem.ILoadingProblems;
import main.java.concrete.solutions.BPPcontainerSolution;

public class BPPHillClimbing extends LoadingAbsractMHeuristics {
	/**
	 * @param actual
	 * @param instancia
	 */
	public BPPHillClimbing(ILoadingProblems instancia) {
		super(instancia);

	}

	public void solve(){
		initialSolution();
		bestSolution();	
	}

	private void bestSolution() {
		while(true){
			BPPcontainerSolution neighbor = this.getMinNeighbour(solution);
			if(neighbor.priority() <= solution.priority())
				break;
			solution = neighbor;
		}
		this.printBestSolution();
	}

	private void initialSolution() {
		do {
			this.solution = this.randomSolution(lProblem);
		} while(this.solution.full());
		this.printInitialSolution();
	}
	
	private BPPcontainerSolution getMinNeighbour(BPPcontainerSolution actualSolution){
		BPPcontainerSolution newSolution = null;
		BPPcontainerSolution bestSolution = actualSolution;
		int bestValue = bestSolution.priority();
		int length = actualSolution.getProblemInstance().getNumItems();
		
		for(int i = 0; i < length; i++){
			if(!actualSolution.select(i)){
				newSolution = new BPPcontainerSolution(actualSolution, i);
				int newValue = newSolution.priority();
				if(newValue >= bestValue && !newSolution.full()){
					bestValue = newValue;
					bestSolution = newSolution;
				}
			}
		}

		return bestSolution;
	}

	protected void printBestSolution(){
		System.out.println("Hill Climbing (Local Search)\n" + this.solution.toString(true, true) + "\n");
	}
	
}
