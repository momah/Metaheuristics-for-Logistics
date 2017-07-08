package concrete.metaheuristics.containerBPP;

import java.util.ArrayList;
import java.util.Random;

import abstracts.metaheuristics.LoadingAbsractMHeuristics;
import abstracts.problem.ILoadingProblems;
import abstracts.solution.ILoadingSolutions;
import concrete.solutions.BPPcontainerSolution;

public class BPPSimulatedAnnealing extends LoadingAbsractMHeuristics {

	public BPPSimulatedAnnealing(ILoadingProblems instancia) {
		super(instancia);
		// TODO Auto-generated constructor stub
	}

	private final int maxIterationsI = 10;
	private final int maxIterationsK = 20;
	private final double alpha = 0.9;
	private ArrayList<BPPcontainerSolution> bPPcontainerSolutions;
	
	public void solve(){
		BPPcontainerSolution initialSolution = initialSolution();
		bestSolution(initialSolution);
	}

	/**
	 * @param initialSolution
	 */
	private void bestSolution(BPPcontainerSolution initialSolution) {
		BPPcontainerSolution newSolution = null;
		double temperature = this.temperaturaInicial(this.lProblem);
		int k = 0;
		
		do {
			int i = 0;
			do {
				newSolution = this.sucessorRandom( initialSolution );
				int variance = newSolution.priority() - initialSolution.priority();
				
				if( variance >= 0 && !newSolution.full() ){	
					initialSolution = newSolution;
					this.addSolution( initialSolution );
				} else {
					double rand = this.randomPercent();
					double pVariance = -((double)variance / temperature);
				
					if( pVariance > rand && !newSolution.full() ){		
						initialSolution = newSolution;
						this.addSolution( initialSolution );
					}
				}
				i++;
				
			} while( i < this.maxIterationsI );
			
			k++;
			temperature = this.alpha * temperature;
						
		} while( k < this.maxIterationsK );
		
		this.printBestSolution();
	}

	/**
	 * @return
	 */
	private BPPcontainerSolution initialSolution() {
		this.bPPcontainerSolutions = new ArrayList<BPPcontainerSolution>();
		BPPcontainerSolution initialSolution = null;
		
		do {
			initialSolution = this.randomSolution(lProblem);
		} while( initialSolution.full() );
		
		this.bPPcontainerSolutions.add( initialSolution );
		this.printSolution( initialSolution );
		return initialSolution;
	}
	
	private void addSolution( BPPcontainerSolution bPPcontainerSolution ){
		this.bPPcontainerSolutions.add( bPPcontainerSolution );
		this.printSolution( bPPcontainerSolution );
	}
	

	
	private double temperaturaInicial( ILoadingProblems bppProblem ){
		return bppProblem.pesoItems();
	}
	
	private BPPcontainerSolution sucessorRandom( BPPcontainerSolution bPPcontainerSolution ){
		int index = new Random().nextInt( bPPcontainerSolution.getProblemInstance().getNumItems() );
		return new BPPcontainerSolution( bPPcontainerSolution, index );
	}
	
	private double randomPercent(){
		return new Random().nextDouble();
	}
	
	protected void printBestSolution(){
		ILoadingSolutions best = this.bPPcontainerSolutions.get(0);
		for( ILoadingSolutions Solution : this.bPPcontainerSolutions )
			if( Solution.priority() > best.priority() )
				best = Solution;
		System.out.println( "SIMULATED ANNEALING:\n" + best.toString( true, true ) + "\n" );
	}
	
}
