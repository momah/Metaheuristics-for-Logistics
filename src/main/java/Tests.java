package main.java;

import java.util.Scanner;


public class Tests {

	static final int OPCION1 = 1;
	static final int OPCION2 = 2;

	public static void main( String[] args ){
		Scanner sc = new Scanner(System.in);
		int opcion;
		do{
			printMenu();
			opcion = sc.nextInt();
			try {
				if (opcion == OPCION1) {
					main.BPPcontainerView.run(sc);
				} else if (opcion == OPCION2) {
					main.VRPvehiclesView.run(sc);
				}

			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}

		} while(opcion !=0);

	}

	public static void printMenu(){
		String[] menu ={
				"------------------------------------------------",
				"---------------- MENU PRINCIPAL ----------------",
				"------------------------------------------------",
				" Choose a metaheuristic : ----------------------",
				"------------------------------------------------",
				"1. BPP Container Loading Problem				-",
				"2. VRP Vehicle Routing Problem					-",
				"0. Exit         	          					-",
				"------------------------------------------------",
			};
			for (int i=0;i<menu.length;i++){
				System.out.println(menu[i]);
			}
			System.out.print("Option : ");
	}


}
