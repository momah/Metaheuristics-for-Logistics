package concrete.Problems.vehiclesVRP;

import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import abstracts.problem.IRoutingProblems;
import abstracts.problem.Problem;


public class VRPvehiclesProblem extends Problem implements IRoutingProblems {
	
	private Edges distances = new Edges();

	/**
	 * Default constructor
	 */
	public VRPvehiclesProblem() {
		super();
	}
	
	/**
	 * Constructor using the 'size' attribute
	 * @param size
	 */
	public VRPvehiclesProblem(int size) {
		super();
		this.distances.setSize(size);
	}

	/**
	 * @param size
	 * @param distances
	 */
	public VRPvehiclesProblem(int size, int[][] distances) {
		super();
		this.distances.setSize(size);
		this.distances.setDistances(distances);
	}
	
	/**
	 * 
	 * @param Constructor using text file
	 */
	public VRPvehiclesProblem(String filename) {
		super();
		this.textInstances = LoadDataFromFile(filename);
	}
	
	
	@Override
	public int getSize() {
		return distances.getSize();
	}

	@Override
	public void setSize(int size) {
		this.distances.setSize(size);
	}

	@Override
	public int[][] getDistances() {
		return distances.getDistances();
	}


	@Override
	public void setDistances(int[][] distances) {
		this.distances.setDistances(distances);
	}
	

	@Override
	public String getTextInstances() {
		return textInstances;
	}


	@Override
	public void setTextInstances(String textInstances) {
		this.textInstances = textInstances;
	}


	@Override
	public void getInstance() {
		this.toString();
	}


	@Override
	public void setInstance(int[][] instance) {
		this.distances.setDistances(instance);
	}


	@Override
	public void instancesfromFile(){
		/*
		ArrayList<Mochila> mochilas = new ArrayList<Mochila>();
		String[] instancias = textInstances.split(";");

		for( String instancia : instancias ){

			String[] partes = instancia.split(":");
			int capacidade = new Integer( partes[0].trim() );
			ArrayList<Item> items = new ArrayList<Item>();
			String[] stritems = partes[1].trim().split( "," );
			
			for( String item : stritems ){

				String[] atributos = item.split( "-" );
				items.add( new Item( new Integer( atributos[0].trim() ), new Integer( atributos[1].trim() ) ) );
			}
			
			mochilas.add( new Mochila( capacidade, items ) );
		}
		
		instancia = mochilas;
		*/
	}
	
	/* (non-Javadoc)
	 * @see problems.RoutingProblems#randomInstances()
	 */
	@Override
	public void randomInstances(){
	    Random random = new Random(); // Create a single Random instance here
	    distances.setDistances(new int[distances.getSize()][distances.getSize()]);
	    for(int i = 0; i < distances.getSize(); i++){
	        for(int j = 0; j < distances.getSize(); j++){
	            if(i != j) distances.getDistances()[i][j] = random.nextInt(100); // Reuse the same Random instance
	            else distances.getDistances()[i][j] = 0; 
	        }
	    }
	}
	
	
	@Override
	public String LoadDataFromFile(String filename){
		// Reading the file containing the instances
		FileReader file = null;
		char[] buff = new char[ 1024*10 ];
		try {
			file = new FileReader( filename );
			file.read( buff );
		} catch (IOException e) {
			System.out.println("Error. " + e.getMessage());
			System.exit(0);
		}
		return new String( buff );

	}
	

	@Override
	public int getDistance(int i , int j){
		return distances.getDistances()[i][j];
	}
	
	
	@Override
	public String toString() {
		char nodo = 65;
		String s = "\t"+"A"+"\t"+"B"+"\t"+"C"+"\t"+"D"+"\t"+"E"+"\n";
		for( int i = 0 ; i < distances.getDistances().length ; i++ ){

			s += (char)(nodo+i)+"\t";
			for( int j = 0 ; j < distances.getDistances()[i].length ; j++ )
				s += distances.getDistances()[i][j]+"\t";
			s += "\n";
		}
		return s;
	}
	/**
	 * Returns true if the value i is in the array tab, false otherwise 
	 * @param i
	 * @param tab
	 * @return
	 */
	private boolean exists(int i , int[] tab){
		for( int j = 0 ; j < tab.length ; j++ ){
			if( tab[j] == i) return true;
		}
		return false;
	}
	/**
	 * Return the minimum of row i
	 * @param i
	 * @return
	 */
	private int getMinRow(int i, int[] tab){
		int minDistance = -1, minDistanceIndex = -1;
		while(true){
			if(!exists(minDistanceIndex, tab) && minDistanceIndex != i){
				minDistance = distances.getDistances()[i][minDistanceIndex];
				break;
			}else if( minDistanceIndex == distances.getSize() ) break;
			else minDistanceIndex++;	
		}
		for( int j = 0 ; j < distances.getSize() ; j++ ){
			if( i != j  && !exists(i,tab) && distances.getDistances()[i][j] < minDistance){
				minDistance = distances.getDistances()[i][j];
				minDistanceIndex = j;
			}
		}
		return minDistanceIndex;
	}
	/**
	 * Return the minimum of column j
	 * @param j
	 * @return
	 */
	private int getMinCol(int j, int[] tab){
		int minDistance = -1;
		int minDistanceIndex = 0 ;
		while(true){
			if(!exists(minDistanceIndex, tab) && minDistanceIndex != j){
				minDistance = distances.getDistances()[minDistanceIndex][j];
				break;
			}else if( minDistanceIndex == distances.getSize() ) break;
			else minDistanceIndex++;	
		}
		for( int i = 0 ; i < distances.getSize() ; i++ ){
			if( i != j && !exists(j, tab) && distances.getDistances()[i][j] < minDistance){
				minDistance = distances.getDistances()[i][j];
				minDistanceIndex = i ;
			}
		}
		return minDistanceIndex;
	}

	
	@Override
	public int closestNode(int i,int[] tab){
		int minCol = getMinCol(i,tab);
		int minRow = getMinRow(i, tab); 
		if( distances.getDistances()[minRow][i] < distances.getDistances()[i][minCol]) 
			return minRow;
		else return minCol;
	}
}
