package main.java.menus;

import java.util.Scanner;

import main.java.abstracts.problem.IRoutingProblems;
import main.java.concrete.Problems.vehiclesVRP.VRPvehiclesProblem;
import main.java.concrete.metaheuristics.vehiclesVRP.VRPHillClimbing;
import main.java.concrete.metaheuristics.vehiclesVRP.VRPHillClimbingModified;
import main.java.concrete.metaheuristics.vehiclesVRP.VRPSimulatedAnnealing;
import main.java.concrete.metaheuristics.vehiclesVRP.VRPTabu;

public class VRPvehiclesView {
	static final int HILLCLIMBING = 1;
	static final int SIMULATED_ANNELING = 2;
	static final int TABU = 3;
	static final int HILLCLIMBING_MODIFIED = 4;

	public static void run(Scanner sc, String dataFile) throws CloneNotSupportedException {
		String filename;

		if (dataFile != null) {
			// Si dataFile se proporciona a través de la línea de comandos, úsalo directamente
			filename = dataFile;
		} else {
			// Pedir al usuario que ingrese el nombre del archivo
			System.out.print("Introduce el nombre del fichero para el problema VRP: ");
			filename = sc.nextLine();
		}

		VRPvehiclesProblem instance = new VRPvehiclesProblem();
		String fileContent = instance.LoadDataFromFile(filename);
		
		if (fileContent != null && !fileContent.isEmpty()) {
			instance.setTextInstances(fileContent);
			instance.instancesfromFile(); // Ahora se procesa el contenido
		} else {
			System.out.println("El contenido del fichero está vacío o no se ha cargado correctamente.");
			return; // Sal del método si no hay contenido para procesar
		}

		int opcion;

		System.out.println("El fichero proporcionado tiene la siguiente estructura:");
		System.out.println("\n");
		System.out.println("Fichero cargado: "+ filename +"");
		// Determina el orden automáticamente
		System.out.println("Orden del gráfico: ("+ instance.getSize() +")");
		System.out.println(instance.toString());
		System.out.println("\n");

		String[] menu = {
			"------------------------------------------------",
			"--------- VRP Vehicle Routing Problem ----------",
			"------------------------------------------------",
			"                                               -",
			"Elige una metaheurística:                      -",
			"                                               -",
			"1. Hill Climbing (Local Search)                -",
			"2. Simulated Annealing Search                  -",
			"3. Tabu Search                                 -",
			"4. Hill Climbing (Modified)                    -",
			"0. <- Volver al menú anterior                  -",
			"------------------------------------------------",
		};

		for (int i = 0; i < menu.length; i++) {
			System.out.println(menu[i]);
		}

		do {
			System.out.print("Opción: ");
			opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {
				case HILLCLIMBING:
					hillClimbingVRP(instance);
					break;
				case SIMULATED_ANNELING:
					simulatedAnnealingVRP(instance);
					break;
				case TABU:
					tabuVRP(instance);
					break;
				case HILLCLIMBING_MODIFIED:
					hillClimbingModifiedVRP(instance);
					break;
			}
		} while (opcion != 0);
	}

	/**
	 * Hill Climbing (Local Search)
	 * @param vrpProblem
	 * @throws CloneNotSupportedException
	 */
	public static void hillClimbingVRP(IRoutingProblems vrpProblem) throws CloneNotSupportedException {
		System.out.println("\nMetaheurística: Hill Climbing (Local Search) \n");
		VRPHillClimbing serach = new VRPHillClimbing(vrpProblem);
		serach.solve();
	}

	/**
	 * Tabu search
	 * @param vrpProblem
	 * @throws CloneNotSupportedException
	 */
	public static void tabuVRP(IRoutingProblems vrpProblem) throws CloneNotSupportedException {
		System.out.println("\nMetaheurística: Tabu Search \n");
		VRPTabu serach = new VRPTabu(vrpProblem);
		serach.solve();
	}
	
	/**
	 * Simulated Annealing search
	 * @param vrpProblem
	 * @throws CloneNotSupportedException
	 */
	public static void simulatedAnnealingVRP(IRoutingProblems vrpProblem) throws CloneNotSupportedException {
		System.out.println("\nMetaheurística: Simulated Annealing Search \n");
		VRPSimulatedAnnealing serach = new VRPSimulatedAnnealing(vrpProblem);
		serach.solve();
	}

	/**
	 * Hill Climbing (Modified)
	 * @param vrpProblem
	 * @throws CloneNotSupportedException
	 */
	public static void hillClimbingModifiedVRP(IRoutingProblems vrpProblem) throws CloneNotSupportedException {
		System.out.println("\nMetaheurística: Hill Climbing (Modified) \n");
		VRPHillClimbingModified serach = new VRPHillClimbingModified(vrpProblem);
		//arreglado problema de solve en el ModifiedVRP
		serach.solve();
	}
}
