package main.java.abstracts.problem;

public interface IRoutingProblems {
	int getSize();
	void setSize(int size);
	int[][] getDistances();
	void setDistances(int[][] distances);
	String getTextInstances();
	void setTextInstances(String textInstances);
	void getInstance();
	void setInstance(int[][] instance);
	void instancesfromFile();
	void randomInstances();
	String LoadDataFromFile(String filename);
	int getDistance(int i, int j);
	String toString();
	int closestNode(int i, int[] tab);
}
