package main.java.abstracts.solution;

import main.java.abstracts.problem.ILoadingProblems;

public interface ILoadingSolutions {
	boolean full();
	int size();
	int priority();
	boolean select(int index);
	ILoadingProblems getProblemInstance();
	String toString();
	String toString(boolean printPeso, boolean printValue);
	boolean isFull();
	void addNextItem(boolean isRandom);
	void addNextBestItem();
	void removeItem(int index);
	void tryAddOneMore();
	int compareTo(Object o);
}
