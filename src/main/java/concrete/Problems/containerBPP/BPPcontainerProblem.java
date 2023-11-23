package main.java.concrete.Problems.containerBPP;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import main.java.abstracts.problem.ILoadingProblems;
import main.java.abstracts.problem.Problem;

public class BPPcontainerProblem extends Problem implements ILoadingProblems {

	private int ContainerArea;
	private ArrayList<Item> items;
	
	public BPPcontainerProblem() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param filename
	 * Constructor using text file
	 */
	public BPPcontainerProblem(String filename) {
		super();
		this.textInstances = LoadDataFromFile(filename);
	}
	

	public BPPcontainerProblem(int capacity, ArrayList<Item> items) {
		super();
		this.ContainerArea = capacity;
		this.items = items;
	}

	public String LoadDataFromFile(String filename) {
	    // Leyendo el archivo que contiene las instancias
	    char[] buff = new char[1024 * 10];
	
	    try (FileReader file = new FileReader(filename)) {
	        file.read(buff);
	    } catch (IOException e) {
	        System.out.println("Error. " + e.getMessage());
	        System.exit(0);
	    }
	    return new String(buff);
	}
	
	/* (non-Javadoc)
	 * @see problems.LoadingProblems#instancesFromText()
	 */
	@Override
	public void instancesFromText(){
		String text = textInstances;
		String[] partes = text.split(":");
		int capacity = new Integer( partes[0].trim() );
		ArrayList<Item> items = new ArrayList<Item>();
		String[] stritems = partes[1].trim().split( "," );
		
		for( String item : stritems ){
			String[] atributos = item.split( "-" );
			items.add( new Item( new Integer( atributos[0].trim() ), new Integer( atributos[1].trim() ) ) );
		}

		this.items = items;
		this.ContainerArea = capacity;
	}

	/* (non-Javadoc)
	 * @see problems.LoadingProblems#getCapacity()
	 */
	@Override
	public int getCapacity(){
		return this.ContainerArea;
	}
	
	/* (non-Javadoc)
	 * @see problems.LoadingProblems#getItem(int)
	 */
	@Override
	public Item getItem(int index ){
		return this.items.get( index );
	}
	
	/* (non-Javadoc)
	 * @see problems.LoadingProblems#getItems()
	 */
	@Override
	public ArrayList<Item> getItems(){
		return this.items;
	}
	
	/* (non-Javadoc)
	 * @see problems.LoadingProblems#getNumItems()
	 */
	@Override
	public int getNumItems(){
		return this.items.size();
	}
	
	/* (non-Javadoc)
	 * @see problems.LoadingProblems#toString()
	 */
	@Override
	public String toString(){
		return "{ CAPACITY = " + this.ContainerArea + " }";
	}
	
	/* (non-Javadoc)
	 * @see problems.LoadingProblems#pesoItems()
	 */
	@Override
	public double pesoItems(){
		double p = 0;
		
		for( Item item : this.items )
			p += (double)item.getWeight();
		
		return p;
	}
	
	/* (non-Javadoc)
	 * @see problems.LoadingProblems#toString(boolean)
	 */
	@Override
	public String toString( boolean outputitems ){
		String str = "";
		if( outputitems ){
			for( Item i : this.items ){
				str += "\n\t" + i.toString();
			}
		}
		return this.toString() + str;
	}
}
