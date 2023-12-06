package main.java.concrete.metaheuristics.vehiclesVRP;

import java.util.Random;

import main.java.abstracts.metaheuristics.RoutingAbsractMHeuristics;
import main.java.abstracts.problem.IRoutingProblems;
import main.java.abstracts.solution.IRoutingSolutions;
import main.java.concrete.solutions.VRPvehiclesSolution;

/**
 * Clase que implementa el algoritmo de Simulated Annealing para el problema de Vehicle Routing.
 */
public class VRPSimulatedAnnealing extends RoutingAbsractMHeuristics {
    int temp = 1000;
    private IRoutingSolutions lastBestSolution;
    private Random random; // Instancia de Random para reutilización

    /**
     * Constructor de la clase VRPSimulatedAnnealing.
     * @param rProblem Problema de enrutamiento de vehículos a ser resuelto.
     */
    public VRPSimulatedAnnealing(IRoutingProblems rProblem) {
        super(rProblem);
        this.random = new Random(); // Inicialización de Random
    }

    /**
     * Genera una solución vecina aleatoria.
     * @return Solución vecina generada aleatoriamente.
     * @throws CloneNotSupportedException Si la clonación no es soportada.
     */
    public IRoutingSolutions randomNeighbour() throws CloneNotSupportedException {
        int j = this.random.nextInt(problem.getSize() - 1);
        return this.solution.getNeighbour(j);
    }

    /**
     * Calcula la probabilidad de aceptación de una solución vecina.
     * @param actualSolution Costo de la solución actual.
     * @param neighbourSolution Costo de la solución vecina.
     * @return Probabilidad de aceptación.
     */
    private double acceptProbability(int actualSolution, int neighbourSolution) {
        return Math.exp(((actualSolution - neighbourSolution) / (double) temp));
    }

    /**
     * Método principal para resolver el problema mediante Simulated Annealing.
     * @throws CloneNotSupportedException Si la clonación no es soportada.
     */
    @Override
    public void solve() throws CloneNotSupportedException {
        long start = this.printInicialSolution(problem);

        IRoutingSolutions neighbourSolution;
        double rand;
        lastBestSolution = (IRoutingSolutions) solution.copy();
        do {
            neighbourSolution = this.randomNeighbour();
            rand = this.random.nextDouble();

            if (rand < acceptProbability(this.solution.getCostPath(problem), neighbourSolution.getCostPath(problem))) {
                if (neighbourSolution.getCostPath(problem) < lastBestSolution.getCostPath(problem))
                    lastBestSolution = (IRoutingSolutions) neighbourSolution.copy();
                solution = (VRPvehiclesSolution) neighbourSolution.copy();
            }
            temp--;
        } while (temp > 1);

        if (solution.getCostPath(problem) > lastBestSolution.getCostPath(problem))
            solution = (VRPvehiclesSolution) lastBestSolution.copy();

        long end = this.printFinalSolution(problem);
        System.out.println("Average time : " + (end - start) / 1000 + " us");
    }
}
