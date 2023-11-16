package main;

import java.util.Scanner;

import abstracts.problem.IRoutingProblems;
import concrete.Problems.vehiclesVRP.VRPvehiclesProblem;
import concrete.metaheuristics.vehiclesVRP.VRPHillClimbing;
import concrete.metaheuristics.vehiclesVRP.VRPHillClimbingModified;
import concrete.metaheuristics.vehiclesVRP.VRPSimulatedAnnealing;
import concrete.metaheuristics.vehiclesVRP.VRPTabu;

public class VRPvehiclesView {
	
	static final int HILLCLIMBING = 1;
	static final int SIMULATED_ANNELING =2;
	static final int TABU = 3;
	
	static final int HILLCLIMBING_MODIFIED = 4;
	
	public static void run(Scanner sc) throws CloneNotSupportedException{
		
		
		int orden = 5;
		IRoutingProblems instance = new VRPvehiclesProblem(orden);
		instance.randomInstances();
			
		int opcion;
		String[] menu = {
				"------------------------------------------------",
				"--------- VRP Vehicle Routing Problem ----------",
				"------------------------------------------------",
				"Instance Loaded :								-",
				"												-",
				"Choose a metaheuristic : 						-",
				"												-",
				"1. Hill Climbing (Local Search)				-",
				"2. Simulated Annealing Search     				-",
				"3. Tabu Search									-",
				"-												-",
				"4. Hill Climbing (Modified)					-",
				"-												-",
				"0. <- Return to previous menu					-",
				"------------------------------------------------",
			};
		for (int i=0;i<5;i++){
			System.out.println(menu[i]);
		}
		System.out.println("Graph order ("+ orden+")");
		System.out.println(instance.toString());
		
		do{	

			for (int i=4;i<menu.length;i++){
				System.out.println(menu[i]);
			}
			System.out.print("Option : ");
			opcion = sc.nextInt();
			sc.nextLine();
			
			switch(opcion){
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

		} while(opcion !=0);
	}
	
	/**
	 * Hill Climbing (Local Search)
	 * @param vrpProblem
	 * @throws CloneNotSupportedException
	 */
	public static void hillClimbingVRP(IRoutingProblems vrpProblem) throws CloneNotSupportedException {
		System.out.println("\nMetaheuristic : Hill Climbing (Local Search) \n");
		VRPHillClimbing serach = new VRPHillClimbing(vrpProblem);
		serach.solve();
	}
	/**
	 * Tabu search
	 * @param vrpProblem
	 * @throws CloneNotSupportedException
	 */
	public static void tabuVRP(IRoutingProblems vrpProblem) throws CloneNotSupportedException {
		System.out.println("\nMetaheuristic : Tabu Search \n");
		VRPTabu serach = new VRPTabu(vrpProblem);
		serach.solve();
	}
	/**
	 * Simulated Annealing search
	 * @param vrpProblem
	 * @throws CloneNotSupportedException
	 */
	public static void simulatedAnnealingVRP(IRoutingProblems vrpProblem) throws CloneNotSupportedException {
		System.out.println("\nMetaheuristic : Simulated Annealing Search \n");
		VRPSimulatedAnnealing serach = new VRPSimulatedAnnealing(vrpProblem);
		serach.solve();
	}

	/**
	 * Hill Climbing (Modified)
	 * @param vrpProblem
	 * @throws CloneNotSupportedException
	 */
	public static void hillClimbingModifiedVRP(IRoutingProblems vrpProblem) throws CloneNotSupportedException {
		System.out.println("\nMetaheuristic : Hill Climbing (Modified) \n");
		VRPHillClimbingModified serach = new VRPHillClimbingModified(vrpProblem);
		serach.solve();
	}
	
}
