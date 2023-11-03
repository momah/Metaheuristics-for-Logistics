package main;

import java.util.Scanner;

import abstracts.problem.ILoadingProblems;
import concrete.Problems.containerBPP.BPPcontainerProblem;
import concrete.metaheuristics.containerBPP.BPPGrasp;
import concrete.metaheuristics.containerBPP.BPPGreedy;
import concrete.metaheuristics.containerBPP.BPPHillClimbing;
import concrete.metaheuristics.containerBPP.BPPSimulatedAnnealing;


public class BPPcontainerView {
	
	static final int HILLCLIMBING = 1;
	static final int ANNELING = 2;
	static final int GREEDY  = 3;
	static final int GRASP = 4;

	public static void run(Scanner sc) throws CloneNotSupportedException{

		BPPcontainerProblem instance = new BPPcontainerProblem("BPP_1.txt");
		instance.instancesFromText();
		
		int opcion;
		String[] menu = {
				"------------------------------------------------",
				"------ BPP Container Loading Problem   ---------",
				"------------------------------------------------",
				"Instance Loaded :								 ",
				"----------------------------------------------------------------------------------------------------------",
				"Container Area  : objects (area-priority, ...)	 ",
				"----------------------------------------------------------------------------------------------------------",
				"Choose a metaheuristic : 						 ",
				"												 ",
				"  1. Hill Climbing (Local Search)				-",
				"  2. Simulated Annealing Search 				-",
				"  3. Greedy Search Search    					-",
				"  4. Grasp	Search Search						-",
				"  0. <- Return to previous menu				-",
				"------------------------------------------------",
			};
		for (int i=0;i<6;i++){
			System.out.println(menu[i]);
		}
			System.out.println(instance.getTextInstances() );
		do{

			for (int i=6;i<menu.length;i++){
				System.out.println(menu[i]);
			}
			System.out.print("Option : ");
		
			opcion = sc.nextInt();
			sc.nextLine();
			
			switch(opcion){
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

		} while(opcion !=0);
	}
	
		
	public static void hillClimbingBPP(ILoadingProblems bppProblem){
		System.out.println("\nMetaheuristic : Hill Climbing Search \n");
		BPPHillClimbing serach = new BPPHillClimbing(bppProblem);
		serach.solve();	
	}
	
	public static void simulatedAnnealingBPP(ILoadingProblems bppProblem){
		System.out.println("\nMetaheuristic : Simulated Annealing Search \n");
		BPPSimulatedAnnealing serach = new BPPSimulatedAnnealing(bppProblem);
		serach.solve();
	}
	
	public static void greedyBPP(ILoadingProblems bppProblem){
		System.out.println("\nMetaheuristic : Greedy Search \n");
		BPPGreedy serach = new BPPGreedy(bppProblem);
		serach.solve();
	}
	
	public static void graspBPP(ILoadingProblems bppProblem){
		System.out.println("\nMetaheuristic : Grasp Search \n");
		BPPGrasp serach = new BPPGrasp(bppProblem, 0.8, 100 );
		serach.solve();
	}
	
	
}