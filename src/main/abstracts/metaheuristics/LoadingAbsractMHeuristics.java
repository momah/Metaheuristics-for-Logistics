package abstracts.metaheuristics;

import java.util.Random;

import abstracts.problem.ILoadingProblems;
import abstracts.solution.ILoadingSolutions;
import concrete.solutions.BPPcontainerSolution;

public abstract class LoadingAbsractMHeuristics {
	/**
	 * The common solution to the problem
	 */
	protected BPPcontainerSolution solution;
	
	/**
	 * The problem instance : Capacity of the container
	 * set of weights and values of different items
	 */
	protected ILoadingProblems lProblem;
	
	/**
	 * @param actual
	 * @param lProblem
	 */
	public LoadingAbsractMHeuristics(ILoadingProblems lProblem) {
		super();
		this.lProblem = lProblem;
	}

	protected BPPcontainerSolution randomSolution(ILoadingProblems instance){
		int size = instance.getNumItems();
		int[] sol = new int[size];
		
		Random rand = new Random();
		boolean bool;
		for( int i = 0; i < size; i++ ){
			bool = rand.nextBoolean();
			sol[i]=(bool)?1:0;
		}
		
		return new BPPcontainerSolution(sol, instance);
	}
	
	protected BPPcontainerSolution resetSolution(ILoadingProblems lProblem){
		int size = lProblem.getNumItems();
		int[] sol = new int[size];
		
		for( int i : sol )
			sol[i] = 0;

		return new BPPcontainerSolution(sol, lProblem);
	}
	
	public void solve( ILoadingProblems lProblem ){
	}
	
	protected void printSolution( ILoadingSolutions lSolution ){
			System.out.println( lSolution.toString( true, true ) );
	}
	
	protected void printInitialSolution(){
		System.out.println("Initial Solution:\n" + this.solution.toString(true, true) + "\n");
	}
	protected void printBestSolution(){
		System.out.println("Final Solution :\n" + this.solution.toString(true, true) + "\n");
	}
	
}