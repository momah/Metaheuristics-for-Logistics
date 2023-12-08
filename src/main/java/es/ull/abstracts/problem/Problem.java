package es.ull.abstracts.problem;

public abstract class Problem {
	protected String textInstances;

	public Problem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public abstract String toString();
	
	/**
	 * @return the textInstances
	 */
	public String getTextInstances() {
		return textInstances;
	}

	/**
	 * @param textInstances the textInstances to set
	 */
	public void setTextInstances(String textInstances) {
		this.textInstances = textInstances;
	}
}
