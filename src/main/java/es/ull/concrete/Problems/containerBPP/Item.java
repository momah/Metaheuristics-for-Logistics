package es.ull.concrete.Problems.containerBPP;

public class Item {
	private int itemArea;
	private int priority;
	private double priorityFactor;

	public Item( int itemArea, int priority ){
		this.itemArea = itemArea;
		this.priority = priority;
		this.priorityFactor = (double)priority / (double)itemArea;
	}
	
	public int getWeight(){
		return this.itemArea;
	}
	
	public int getItemPriority(){
		return this.priority;
	}
	
	public double getFator(){
		return this.priorityFactor;
	}
	
	public String toString(){
		return "[ Item Area = " + this.itemArea + ", Priority = " + this.priority + " ]";
	}
}
