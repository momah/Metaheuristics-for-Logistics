package main.java.abstracts.solution;

import java.util.ArrayList;

import main.java.abstracts.problem.IRoutingProblems;
import main.java.concrete.solutions.VRPvehiclesSolution;

public interface IRoutingSolutions {
	int getSize();
	void setSize(int size);
	void initialiserSolution();
	void randomSolution();
	IRoutingSolutions getNeighbour(int i) throws CloneNotSupportedException;
	ArrayList<VRPvehiclesSolution> getNeighbours() throws CloneNotSupportedException;
	int getCostPath(IRoutingProblems tspProblem);
	int getIndice(int i);
	String toString(IRoutingProblems tspProblem);
	Object clone() throws CloneNotSupportedException;
	int compareTo(Object o);
	boolean equals(Object obj);
	void setSolution(Object[] array);
	void randomSolutionModified();
}
