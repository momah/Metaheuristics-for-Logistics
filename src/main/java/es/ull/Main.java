package es.ull;

import es.ull.menus.BPPcontainerView;
import es.ull.menus.VRPvehiclesView;


import java.util.Scanner;

public class Main {
    static final int OPCION1 = 1;
    static final int OPCION2 = 2;
    private static String dataFile = null;

    public static void main(String[] args) {
        // Verificar si se han proporcionado argumentos de línea de comandos
        if (args.length > 0) {
            dataFile = args[0];
            System.out.println("Archivo de datos seleccionado: " + dataFile);
        }

        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            printMenu();
            opcion = sc.nextInt();
            sc.nextLine(); // Consumir el salto de línea después de leer el entero

            try {
                if (opcion == OPCION1) {
                    BPPcontainerView.run(sc, dataFile);
                } else if (opcion == OPCION2) {
                    VRPvehiclesView.run(sc, dataFile);
                }
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }

        } while (opcion != 0);

        sc.close(); // Cerrar el Scanner al final del programa
    }


	public static void printMenu() {
		String[] menu = {
				"------------------------------------------------",
				"---------------- MENÚ PRINCIPAL ----------------",
				"------------------------------------------------",
				" Elige una metaheurística: ----------------------",
				"------------------------------------------------",
				"1. BPP Container Loading Problem                -",
				"2. VRP Vehicle Routing Problem                  -",
				"0. Salir                                        -",
				"------------------------------------------------",
		};
		for (String line : menu) {
			System.out.println(line);
		}
		System.out.print("Opción: ");
	}
}
