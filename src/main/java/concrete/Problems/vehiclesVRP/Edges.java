package concrete.Problems.vehiclesVRP;

public class Edges {
	/**
	 * The number of nodes in the problem
	 */
	private int size;
	/**
	 * The distance between nodes: The value of distances[i][j] is the distance between nodes i and j.
	 */
	private int[][] distances;

	public Edges() {
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int[][] getDistances() {
		return distances;
	}

	public void setDistances(int[][] distances) {
		this.distances = distances;
	}
}