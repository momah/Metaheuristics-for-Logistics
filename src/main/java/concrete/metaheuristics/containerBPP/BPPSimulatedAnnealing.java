package main.java.concrete.metaheuristics.containerBPP;

import java.util.ArrayList;
import java.util.Random;

import main.java.abstracts.metaheuristics.LoadingAbsractMHeuristics;
import main.java.abstracts.problem.ILoadingProblems;
import main.java.abstracts.solution.ILoadingSolutions;
import main.java.concrete.solutions.BPPcontainerSolution;

/**
 * Clase que implementa el algoritmo de Simulated Annealing para el problema de Bin Packing.
 */
public class BPPSimulatedAnnealing extends LoadingAbsractMHeuristics {
    private final int maxIterationsI = 10;
    private final int maxIterationsK = 20;
    private final double alpha = 0.9;
    private ArrayList<BPPcontainerSolution> bPPcontainerSolutions;
    private Random random; // Instancia de Random para reutilización

    /**
     * Constructor para la clase BPPSimulatedAnnealing.
     * @param instancia Instancia del problema de Bin Packing a ser resuelto.
     */
    public BPPSimulatedAnnealing(ILoadingProblems instancia) {
        super(instancia);
        this.random = new Random(); // Inicialización de la instancia Random
    }

    /**
     * Método principal para resolver el problema de Bin Packing.
     */
    public void solve() {
        BPPcontainerSolution initialSolution = initialSolution();
        bestSolution(initialSolution);
    }

    /**
     * Método para encontrar la mejor solución mediante Simulated Annealing.
     * @param initialSolution Solución inicial para el algoritmo.
     */
    private void bestSolution(BPPcontainerSolution initialSolution) {
        BPPcontainerSolution newSolution = null;
        double temperature = this.temperaturaInicial(this.lProblem);
        int k = 0;

        // Bucle principal de Simulated Annealing
        do {
            int i = 0;
            do {
                newSolution = this.sucessorRandom(initialSolution);
                int variance = newSolution.priority() - initialSolution.priority();

                // Lógica para aceptar nuevas soluciones
                if (variance >= 0 && !newSolution.full()) {
                    initialSolution = newSolution;
                    this.addSolution(initialSolution);
                } else {
                    double rand = this.randomPercent();
                    double pVariance = -((double) variance / temperature);

                    if (pVariance > rand && !newSolution.full()) {
                        initialSolution = newSolution;
                        this.addSolution(initialSolution);
                    }
                }
                i++;
            } while (i < this.maxIterationsI);

            k++;
            temperature = this.alpha * temperature;

        } while (k < this.maxIterationsK);

        this.printBestSolution();
    }

    /**
     * Método para generar una solución inicial.
     * @return Solución inicial generada aleatoriamente.
     */
    private BPPcontainerSolution initialSolution() {
        this.bPPcontainerSolutions = new ArrayList<>();
        BPPcontainerSolution initialSolution;

        do {
            initialSolution = this.randomSolution(lProblem);
        } while (initialSolution.full());

        this.bPPcontainerSolutions.add(initialSolution);
        this.printSolution(initialSolution);
        return initialSolution;
    }

    /**
     * Añade una solución al conjunto de soluciones.
     * @param bPPcontainerSolution Solución a añadir.
     */
    private void addSolution(BPPcontainerSolution bPPcontainerSolution) {
        this.bPPcontainerSolutions.add(bPPcontainerSolution);
        this.printSolution(bPPcontainerSolution);
    }

    /**
     * Calcula la temperatura inicial basándose en el peso de los ítems del problema.
     * @param bppProblem Problema de Bin Packing.
     * @return Temperatura inicial.
     */
    private double temperaturaInicial(ILoadingProblems bppProblem) {
        return bppProblem.pesoItems();
    }

    /**
     * Genera una solución sucesora de manera aleatoria.
     * @param bPPcontainerSolution Solución actual.
     * @return Nueva solución generada.
     */
    private BPPcontainerSolution sucessorRandom(BPPcontainerSolution bPPcontainerSolution) {
        int index = this.random.nextInt(bPPcontainerSolution.getProblemInstance().getNumItems());
        return new BPPcontainerSolution(bPPcontainerSolution, index);
    }

    /**
     * Genera un porcentaje aleatorio.
     * @return Valor aleatorio entre 0.0 y 1.0.
     */
    private double randomPercent() {
        return this.random.nextDouble();
    }

    /**
     * Imprime la mejor solución encontrada.
     */
    protected void printBestSolution() {
        ILoadingSolutions best = this.bPPcontainerSolutions.get(0);
        for (ILoadingSolutions Solution : this.bPPcontainerSolutions)
            if (Solution.priority() > best.priority())
                best = Solution;
        System.out.println("SIMULATED ANNEALING:\n" + best.toString(true, true) + "\n");
    }
}
