package main.java.abstracts.problem;

import java.util.ArrayList;

import main.java.concrete.Problems.containerBPP.Item;

public interface ILoadingProblems {
	void instancesFromText();
	int getCapacity();
	Item getItem(int index);
	ArrayList<Item> getItems();
	int getNumItems();
	String toString();
	double pesoItems();
	String toString(boolean outputitems);
}
