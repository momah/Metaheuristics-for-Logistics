package concrete.metaheuristics.containerBPP;

import java.util.Random;

import abstracts.metaheuristics.LoadingAbsractMHeuristics;
import abstracts.problem.ILoadingProblems;
import abstracts.solution.ILoadingSolutions;
import concrete.solutions.BPPcontainerSolution;


public class BPPGrasp extends LoadingAbsractMHeuristics {

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
		
	
	/**
	 * Including an initial greedy solution
	 * @param problem
	 * @return 
	 */
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
		// escolhendo randomicamente um item selecionado
		do {
			index1 = this.random.nextInt( solution.size() );
		} while( solution.select( index1 ) );
		// retirando este item da mochila
		solution.removeItem( index1 );
		// adiciona um outro item nao selecionado ainda
		do {
			index2 = this.random.nextInt( solution.size() );
		} while( !solution.select( index2 ) );
		return new BPPcontainerSolution( solution, index2 );
	}
	
	protected void printBestSolution(){
		System.out.println("Grasp:\n" + this.solution.toString(true,true) + "\n");
	}
	
	
	
}