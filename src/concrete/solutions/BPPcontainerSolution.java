package concrete.solutions;

import java.util.Random;

import abstracts.problem.ILoadingProblems;
import abstracts.solution.ILoadingSolutions;
import abstracts.solution.Solution;
import concrete.Problems.containerBPP.Item;


public class BPPcontainerSolution extends Solution implements ILoadingSolutions {

	private boolean[] forbiden;
	private ILoadingProblems problem;
	private boolean full = false;

	/**
	 * @param forbiden
	 * @param problem
	 * @param full
	 */
	public BPPcontainerSolution(int[] solution, ILoadingProblems bppProblem) {
		super();
		this.solution = solution.clone();
		this.problem = bppProblem;
		this.forbiden = new boolean[bppProblem.getNumItems()];
		for (int i = 0; i < this.problem.getNumItems(); i++)
			this.forbiden[i] = false;
	}

	public BPPcontainerSolution(BPPcontainerSolution bPPcontainerSolution, int index) {
		this.solution = bPPcontainerSolution.solution.clone();
		this.problem = bPPcontainerSolution.problem;
		this.forbiden = new boolean[problem.getNumItems()];
		for (int i = 0; i < this.problem.getNumItems(); i++)
			this.forbiden[i] = false;

		if (this.solution[index] == 0)
			this.solution[index] = 1;
		else
			this.solution[index] = 0;
	}

	/* (non-Javadoc)
	 * @see concrete.solutions.LoadingSolutions#explode()
	 */
	@Override
	public boolean full() {
		return this.actualWeight() > this.problem.getCapacity();
	}

	private int actualWeight() {
		int peso = 0;
		for (int i = 0; i < this.solution.length; i++)
			peso += this.solution[i] * this.problem.getItem(i).getWeight();
		return peso;
	}

	/* (non-Javadoc)
	 * @see concrete.solutions.LoadingSolutions#size()
	 */
	@Override
	public int size() {
		return this.solution.length;
	}

	/* (non-Javadoc)
	 * @see concrete.solutions.LoadingSolutions#value()
	 */
	@Override
	public int priority() {
		int priority = 0;
		for (int i = 0; i < this.solution.length; i++)
			priority += this.solution[i] * this.problem.getItem(i).getItemPriority();
		return priority;
	}

	/* (non-Javadoc)
	 * @see concrete.solutions.LoadingSolutions#select(int)
	 */
	@Override
	public boolean select(int index) {
		return this.solution[index] == 1;
	}

	/* (non-Javadoc)
	 * @see concrete.solutions.LoadingSolutions#getMochila()
	 */
	@Override
	public ILoadingProblems getProblemInstance() {
		return this.problem;
	}

	/* (non-Javadoc)
	 * @see concrete.solutions.LoadingSolutions#toString()
	 */
	@Override
	public String toString() {
		String str = "(" + this.solution[0];
		for (int i = 1; i < this.solution.length; i++)
			str += ", " + this.solution[i];
		str += ")";
		return str;
	}

	/* (non-Javadoc)
	 * @see concrete.solutions.LoadingSolutions#toString(boolean, boolean)
	 */
	@Override
	public String toString(boolean printPeso, boolean printValue) {
		String str = this.toString();
		if (printPeso)
			str += " Container Area = " + this.actualWeight();
		if (printValue)
			str += " Objects Priority Sum = " + this.priority();
		return str;
	}

	/* (non-Javadoc)
	 * @see concrete.solutions.LoadingSolutions#isFull()
	 */
	@Override
	public boolean isFull() {
		return this.full;
	}

	/* (non-Javadoc)
	 * @see concrete.solutions.LoadingSolutions#addNextItem(boolean)
	 */
	@Override
	public void addNextItem(boolean isRandom) {
		if (isRandom) {
			Random random = new Random();
			int index;
			do {
				index = random.nextInt(this.solution.length);
			} while (this.select(index) && !this.isForbiden(index));
			this.solution[index] = 1;
			if (this.full()) {
				this.solution[index] = 0;
				this.full = true;
			}
		} else {
			// Sin ser aleatorio
		}
	}

	/* (non-Javadoc)
	 * @see concrete.solutions.LoadingSolutions#addNextBestItem()
	 */
	@Override
	public void addNextBestItem() {
		int index = this.getBestItemIndex();
		if (index != -1) {
			this.solution[index] = 1;
			if (this.full()) {
				this.forbiden[index] = true;
				this.solution[index] = 0;
			}
		} else
			this.full = true;
	}

	private boolean isForbiden(int index) {
		return this.forbiden[index];
	}

	private int getBestItemIndex() {
		int index = -1;
		double bestFator = 0;

		for (int i = 0; i < this.solution.length; i++)
			if (!this.select(i) && !this.isForbiden(i))
				if (this.problem.getItem(i).getFator() > bestFator) {
					index = i;
					bestFator = this.problem.getItem(i).getFator();
				}
		return index;
	}

	/* (non-Javadoc)
	 * @see concrete.solutions.LoadingSolutions#removeItem(int)
	 */
	@Override
	public void removeItem(int index) {
		this.solution[index] = 0;
		this.forbiden[index] = true;
		this.full = false;
	}

	/* (non-Javadoc)
	 * @see concrete.solutions.LoadingSolutions#tryAddOneMore()
	 */
	@Override
	public void tryAddOneMore() {
		if (!this.full()) {
			int capacidadeLivre = this.problem.getCapacity() - this.actualWeight();
			int index = -1;
			Item bestItem = null;
			for (int i = 0; i < this.solution.length; i++) {

				// If not selected
				if (!this.select(i)) {
					if (this.problem.getItem(i).getWeight() <= capacidadeLivre) {
						if (bestItem == null) {
							bestItem = this.problem.getItem(i);
							index = i;
						} else if (this.problem.getItem(i).getWeight() < bestItem.getWeight()) {

							bestItem = this.problem.getItem(i);
							index = i;
						}
					}
				}
			}
			// Si hay un elemento que pueda incluirse
			if (index != -1) {
				this.solution[index] = 1;
			}
		}
	}

	/* (non-Javadoc)
	 * @see concrete.solutions.LoadingSolutions#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}