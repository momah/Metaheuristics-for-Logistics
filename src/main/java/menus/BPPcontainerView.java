package main.java.menus;

import java.util.Scanner;

import main.java.abstracts.problem.ILoadingProblems;
import main.java.concrete.Problems.containerBPP.BPPcontainerProblem;
import main.java.concrete.metaheuristics.containerBPP.BPPGrasp;
import main.java.concrete.metaheuristics.containerBPP.BPPGreedy;
import main.java.concrete.metaheuristics.containerBPP.BPPHillClimbing;
import main.java.concrete.metaheuristics.containerBPP.BPPSimulatedAnnealing;

public class BPPcontainerView {
	static final int HILLCLIMBING = 1;
	static final int ANNELING = 2;
	static final int GREEDY  = 3;
	static final int GRASP = 4;

	public static void run(Scanner sc, String dataFile) throws CloneNotSupportedException {
		String fileName;
		int opcion = 0;
		BPPcontainerProblem instance = null;

		if (dataFile != null) {
			// Si dataFile se proporciona a través de la línea de comandos, úsalo directamente
			fileName = dataFile;
		} else {
			// Pedir al usuario que ingrese el nombre del archivo
			System.out.print("Introduce el nombre del fichero para el problema BPP (o 'exit' para salir): ");
			fileName = sc.nextLine();
		}

		do {
			if (!fileName.equalsIgnoreCase("exit")) {
				try {
					instance = new BPPcontainerProblem(fileName);
					instance.instancesFromText();

					// Limpia la cadena obtenida de getTextInstances
					String containerArea = cleanString(instance.getTextInstances());

					String[] menu = {
						"-------------------------------------------------",
						"--------- BPP Container Loading Problem ---------",
						"-------------------------------------------------",
						"Fichero cargado: " + fileName,
						"-------------------------------------------------",
						"Área contenida: \n" + containerArea,
						"-------------------------------------------------",
						"Elige una metaheurística:                        ",
						"                                                 ",
						"  1. Hill Climbing (Local Search)               -",
						"  2. Simulated Annealing Search                 -",
						"  3. Greedy Search Search                       -",
						"  4. Grasp Search Search                        -",
						"  0. <- Volver al menú anterior                 -",
						"-------------------------------------------------",
					};

					for (String menuItem : menu) {
						System.out.println(menuItem);
					}

					System.out.print("Opción: ");
					opcion = sc.nextInt();
					sc.nextLine();

					switch (opcion) {
						case HILLCLIMBING:
							hillClimbingBPP(instance);
							break;
						case ANNELING:
							simulatedAnnealingBPP(instance);
							break;
						case GREEDY:
							greedyBPP(instance);
							break;
						case GRASP:
							graspBPP(instance);
							break;
					}
				} catch (Exception e) {
					System.out.println("Error al cargar el archivo: " + e.getMessage());
				 	if (dataFile == null) {
       			 		fileName = null;
   					}
				}
			
			}
		} while (!fileName.equalsIgnoreCase("exit") && opcion != 0);
		if (dataFile == null) {
       		fileName = null;
    	}
	}

	public static void hillClimbingBPP(ILoadingProblems bppProblem) {
		System.out.println("\nMetaheuristica: Hill Climbing Search \n");
		BPPHillClimbing search = new BPPHillClimbing(bppProblem);
		search.solve();
	}

	public static void simulatedAnnealingBPP(ILoadingProblems bppProblem) {
		System.out.println("\nMetaheurística: Simulated Annealing Search \n");
		BPPSimulatedAnnealing search = new BPPSimulatedAnnealing(bppProblem);
		search.solve();
	}

	public static void greedyBPP(ILoadingProblems bppProblem) {
		System.out.println("\nMetaheurística: Greedy Search \n");
		BPPGreedy search = new BPPGreedy(bppProblem);
		search.solve();
	}

	public static void graspBPP(ILoadingProblems bppProblem) {
		System.out.println("\nMetaheurística: Grasp Search \n");
		BPPGrasp search = new BPPGrasp(bppProblem, 0.8, 100);
		search.solve();
	}

	// Método para limpiar la cadena
	// El programa original imprimía caracteres blancos al procesar ficheros
	private static String cleanString(String data) {
		// Eliminar caracteres no imprimibles
		data = data.replaceAll("\\p{Cntrl}", "");
		// Eliminar espacios en blanco extra al final de la cadena
		data = data.replaceAll("\\s+$", "");
		return data;
	}
}
