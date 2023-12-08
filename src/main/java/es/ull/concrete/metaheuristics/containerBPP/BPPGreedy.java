package es.ull.concrete.metaheuristics.containerBPP;

import es.ull.abstracts.metaheuristics.LoadingAbsractMHeuristics;
import es.ull.abstracts.problem.ILoadingProblems;

public class BPPGreedy extends LoadingAbsractMHeuristics {
	public BPPGreedy(ILoadingProblems instancia) {
		super(instancia);

	}
	
	public void solve(){
		initialSolution();
		bestSolution();
	}

	private void bestSolution() {
		while( !this.solution.isFull() ){
			this.printSolution( this.solution );
			this.solution.addNextBestItem();
		}
		
		this.printBestSolution();
	}

	private void initialSolution() {
		this.solution = this.resetSolution(lProblem);
	}
	
	protected void printBestSolution(){
		System.out.println("GREEDY:\n" + this.solution.toString(true, true) + "\n");
	}
}
