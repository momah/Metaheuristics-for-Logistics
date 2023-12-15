package es.ull.concrete.Problems.vehiclesVRP;

import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import es.ull.abstracts.problem.IRoutingProblems;
import es.ull.abstracts.problem.Problem;

public class VRPvehiclesProblem extends Problem implements IRoutingProblems {

    private Edges distances = new Edges();
    private Random random = new Random(); // Una sola instancia de Random BUGFIX
    private String textInstances;

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
     * Constructor with size and distances
     * @param size
     * @param distances
     */
    public VRPvehiclesProblem(int size, int[][] distances) {
        super();
        this.distances.setSize(size);
        this.distances.setDistances(distances);
    }

    /**
     * Constructor using text file
     * @param filename
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
    public void instancesfromFile() { // Modificado para issue
        String[] lines = textInstances.split("\n");
        int size = lines.length - 1; // Resta 1 para excluir la línea de encabezados
        this.distances.setSize(size);
        int[][] distancesArray = new int[size][size];

        for (int i = 1; i <= size; i++) { // Comienza en 1 para omitir la línea de encabezados
            String[] distanceValues = lines[i].split("\t"); // Asume que los valores están separados por tabuladores
            for (int j = 1; j < distanceValues.length; j++) { // Comienza en 1 para omitir la etiqueta de la fila
                distancesArray[i - 1][j - 1] = Integer.parseInt(distanceValues[j].trim());
            }
        }

        this.distances.setDistances(distancesArray);
    }

    @Override
    public void randomInstances() {
        int size = distances.getSize();
        int[][] randomDistances = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i != j) {
                    randomDistances[i][j] = random.nextInt(100); // Reusa la misma instancia Random BUGFIX
                } else {
                    randomDistances[i][j] = 0;
                }
            }
        }
        distances.setDistances(randomDistances);
    }

    @Override
    public String LoadDataFromFile(String filename) {
        FileReader file = null;
        char[] buff = new char[1024 * 10];
        int length;
        try {
            file = new FileReader(filename);
            length = file.read(buff);
            return new String(buff, 0, length);
        } catch (IOException e) {
            System.out.println("Error reading file. " + e.getMessage());
            return null;
        } finally {
            try {
                if (file != null) {
                    file.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing file. " + e.getMessage());
            }
        }
    }

    @Override
    public int getDistance(int i, int j) {
        return distances.getDistances()[i][j];
    }

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
