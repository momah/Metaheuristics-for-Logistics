package main.java;

import main.java.menus.BPPcontainerView;
import main.java.menus.VRPvehiclesView;

import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private static final String SEPARATOR_LINE = "------------------------------------------------";
    private static final int OPCION1 = 1;
    private static final int OPCION2 = 2;
    private static String dataFile = null;

    public static void main(String[] args) {
        // Verificar si se han proporcionado argumentos de línea de comandos
        if (args.length > 0) {
            dataFile = args[0];
            logger.info("Archivo de datos seleccionado: {}", dataFile);
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
                logger.severe("Error durante la ejecución: {}", e.getMessage());
            }

        } while (opcion != 0);

        sc.close(); // Cerrar el Scanner al final del programa
    }

    private static void printMenu() {
        String[] menu = {
                SEPARATOR_LINE,
                "---------------- MENÚ PRINCIPAL ----------------",
                SEPARATOR_LINE,
                " Elige una metaheurística: ----------------------",
                SEPARATOR_LINE,
                "1. BPP Container Loading Problem                -",
                "2. VRP Vehicle Routing Problem                  -",
                "0. Salir                                        -",
                SEPARATOR_LINE,
        };
        for (String line : menu) {
            logger.info(line);
        }
        logger.info("Opción: ");
    }
}
