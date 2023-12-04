package main.java.concrete.metaheuristics.containerBPP;

import java.util.Random;

import main.java.abstracts.metaheuristics.LoadingAbstractMHeuristics;
import main.java.abstracts.problem.ILoadingProblems;
import main.java.abstracts.solution.ILoadingSolutions;
import main.java.concrete.solutions.BPPcontainerSolution;

public class BPPGrasp extends LoadingAbstractMHeuristics {
	private double alpha;
	private int interations;
	private Random random = new Random();
	
	/**
	 * @param instance
	 * @param alpha
	 * @param interations
	 */
	public BPPGrasp(ILoadingProblems instance, double alpha, int interations) {
		super(instance);
		this.lProblem = instance;
		this.alpha = alpha;
		this.interations = interations;
	}

	public void solve(){
		for( int i = 0; i < this.interations; i++ ){
			initialSolution();
			bestSolution();
		}
		this.printBestSolution();
	}

	/**
	 * Iterating each pair of the solution
	 */
	private void bestSolution() {
		BPPcontainerSolution alternativeSolution;
		alternativeSolution = this.localSearch( this.lProblem );
		if( alternativeSolution.priority() > this.solution.priority() )
			this.solution = alternativeSolution;
	}
		
	protected ILoadingSolutions initialSolution(){
		this.solution = this.resetSolution(this.lProblem);
		while( !this.solution.isFull() ){
			if( this.random.nextDouble() <= this.alpha )
				this.solution.addNextBestItem();
			else
				this.solution.addNextItem( true );
		}
		this.printSolution(this.solution);
		return solution;
	}
	
	private BPPcontainerSolution localSearch( ILoadingProblems problem ){
		BPPcontainerSolution solution, newSolution, bestSolution = this.solution;
		if( this.random.nextDouble() < this.alpha ){
			// Run 2-op in 20% of the container items randomly and choose the best solution among them
			int numSolutions = (int) (0.2 * this.solution.size()) + 1;
			solution = this.solution;
			for( int i = 0; i < numSolutions; i++ ){
				newSolution = this._2optSwap( solution );
				newSolution.tryAddOneMore();
				if( newSolution.priority() > solution.priority() ){
					solution = newSolution;
					if( !newSolution.full() )
						bestSolution = newSolution;
				}
			}
		} else {
			newSolution = this._2optSwap( this.solution );
			if( !newSolution.full() ){
				bestSolution = newSolution;
				bestSolution.tryAddOneMore();
			}
		}
		return bestSolution;
	}
	
	private BPPcontainerSolution _2optSwap( BPPcontainerSolution solution ){
		int index1, index2;
		// Escogiendo aleatoriamente un item seleccionado
		do {
			index1 = this.random.nextInt( solution.size() );
		} while( solution.select( index1 ) );
		// Retirando este item del contenedor
		solution.removeItem( index1 );
		// Añade otro item aún no seleccionado
		do {
			index2 = this.random.nextInt( solution.size() );
		} while( !solution.select( index2 ) );
		return new BPPcontainerSolution( solution, index2 );
	}
	
	protected void printBestSolution(){
		System.out.println("Grasp:\n" + this.solution.toString(true,true) + "\n");
	}
}
