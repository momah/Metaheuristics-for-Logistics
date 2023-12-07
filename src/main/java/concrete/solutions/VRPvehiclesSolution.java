package main.java.concrete.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import main.java.abstracts.metaheuristics.RoutingAbsractMHeuristics;
import main.java.abstracts.problem.IRoutingProblems;
import main.java.abstracts.solution.IRoutingSolutions;
import main.java.abstracts.solution.Solution;

public class VRPvehiclesSolution extends Solution implements IRoutingSolutions {
    private int size;
    private RoutingAbsractMHeuristics metaheuristics;

    public VRPvehiclesSolution() {
        super();
    }

    public VRPvehiclesSolution(int size, RoutingAbsractMHeuristics metaheuristics) {
        super();
        this.size = size;
        this.metaheuristics = metaheuristics;
        this.solution = new int[size];
    }

    public VRPvehiclesSolution(int[] solution, RoutingAbsractMHeuristics methode) {
        this.solution = solution;
        this.size = solution.length;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public void initialiserSolution() {
        for (int i = 0; i < size; i++)
            solution[i] = i;
    }

    @Override
    public void randomSolution() {
        initialiserSolution();
        for (int i = 0; i < size; i++) {
            int temp = solution[i];
            int j = (int) (Math.random() * size);
            solution[i] = solution[j];
            solution[j] = temp;
        }
    }

    @Override
    public void randomSolutionModified() {
        initialiserSolution();
        for (int i = 0; i < size; i++) {
            solution[i] = (int) (Math.random() * size);
        }
    }

    @Override
    public VRPvehiclesSolution getNeighbour(int i) throws CloneNotSupportedException {
        VRPvehiclesSolution neighbour = (VRPvehiclesSolution) this.clone();
        int temp = neighbour.solution[i];
        neighbour.solution[i] = neighbour.solution[i + 1];
        neighbour.solution[i + 1] = temp;
        return neighbour;
    }

    @Override
    public ArrayList<VRPvehiclesSolution> getNeighbours() throws CloneNotSupportedException {
        ArrayList<VRPvehiclesSolution> neighbours = new ArrayList<>();
        for (int i = 0; i < size - 1; i++) {
            neighbours.add(this.getNeighbour(i));
        }
        return neighbours;
    }

    @Override
    public int getCostPath(IRoutingProblems vrpProblem) {
        int cout = 0;
        for (int i = 0; i < vrpProblem.getSize() - 1; i++) {
            cout += vrpProblem.getDistance(solution[i], solution[i + 1]);
        }
        cout += vrpProblem.getDistance(solution[0], solution[vrpProblem.getSize() - 1]);
        return cout;
    }

    @Override
    public int getIndice(int i) {
        for (int j = 0; j < size; j++)
            if (i == solution[j]) return j;
        return -1;
    }

    @Override
    public String toString() {
        char nodo = 'A';
        StringBuilder sol = new StringBuilder("Solution = [\t");
        for (int i = 0; i < solution.length; i++) {
            sol.append((char) (nodo + solution[i])).append("\t");
        }
        sol.append("]");
        return sol.toString();
    }

    public String toString(IRoutingProblems Problem) {
        char nodo = 'A';
        StringBuilder sol = new StringBuilder("Solution = [\t");
        for (int i = 0; i < solution.length; i++) {
            if (i < solution.length - 1) {
                sol.append("(").append((char) (nodo + solution[i]))
                   .append(") --- ").append(Problem.getDistance(solution[i], solution[i + 1]))
                   .append(" ---> ");
            } else {
                sol.append("(").append((char) (nodo + solution[i])).append(") --- ");
            }
        }

        sol.append(Problem.getDistance(solution[Problem.getSize() - 1], solution[0]))
           .append(" ---> (").append((char) (nodo + solution[0])).append(")\t]");
        return sol.toString();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        VRPvehiclesSolution cloned = (VRPvehiclesSolution) super.clone();
        cloned.solution = cloned.solution.clone();
        return cloned;
    }

    @Override
    public int compareTo(Object obj) {
        IRoutingSolutions sol = (IRoutingSolutions) obj;
        return this.getCostPath(metaheuristics.getInstance()) - sol.getCostPath(metaheuristics.getInstance());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        VRPvehiclesSolution other = (VRPvehiclesSolution) obj;
        return size == other.size && Arrays.equals(solution, other.solution);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, Arrays.hashCode(solution));
    }

    @Override
    public void setSolution(Object[] array) {
        for (int i = 0; i < solution.length; i++) {
            solution[i] = (int) array[i];
        }
    }
}
