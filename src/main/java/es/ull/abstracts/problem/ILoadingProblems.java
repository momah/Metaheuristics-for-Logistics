package es.ull.abstracts.problem;

import es.ull.concrete.Problems.containerBPP.Item;

import java.util.ArrayList;


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
