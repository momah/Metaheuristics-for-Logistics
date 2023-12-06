package test.java.menus;

import main.java.menus.BPPcontainerView;
import main.java.abstracts.problem.ILoadingProblems;
import main.java.concrete.Problems.containerBPP.BPPcontainerProblem;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class BPPcontainerViewTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Test
    public void testRun_withValidDataFile() throws CloneNotSupportedException {
        // Simula la entrada del nombre del archivo
        systemInMock.provideLines("valid_data.txt");

        // Crea un mock de BPPcontainerProblem
        BPPcontainerProblem problemMock = mock(BPPcontainerProblem.class);

        // Ejecuta el método run
        BPPcontainerView.run(null, "BPP_1.txt");

        // Verifica la salida esperada
        assertTrue(systemOutRule.getLog().contains("BPP Container Loading Problem"));
    }

    @Test
    public void testRun_exitCommand() throws CloneNotSupportedException {
        // Simula la entrada de 'exit'
        systemInMock.provideLines("exit");

        // Ejecuta el método run
        BPPcontainerView.run(null, null);

        // Verifica que el sistema maneje el comando 'exit'
        assertTrue(systemOutRule.getLog().contains("exit"));
    }

    @Test
    public void testHillClimbingBPP() throws CloneNotSupportedException {
        // Simula un problema de BPP
        ILoadingProblems bppProblem = mock(ILoadingProblems.class);

        // Ejecuta hillClimbingBPP
        BPPcontainerView.hillClimbingBPP(bppProblem);

        // Verifica la salida esperada
        assertTrue(systemOutRule.getLog().contains("Metaheuristica: Hill Climbing Search"));
    }

    @Test
    public void testSimulatedAnnealingBPP() throws CloneNotSupportedException {
        // Simula un problema de BPP
        ILoadingProblems bppProblem = mock(ILoadingProblems.class);

        // Ejecuta simulatedAnnealingBPP
        BPPcontainerView.simulatedAnnealingBPP(bppProblem);

        // Verifica la salida esperada
        assertTrue(systemOutRule.getLog().contains("Metaheurística: Simulated Annealing Search"));
    }

    @Test
    public void testGreedyBPP() throws CloneNotSupportedException {
        // Simula un problema de BPP
        ILoadingProblems bppProblem = mock(ILoadingProblems.class);

        // Ejecuta greedyBPP
        BPPcontainerView.greedyBPP(bppProblem);

        // Verifica la salida esperada
        assertTrue(systemOutRule.getLog().contains("Metaheurística: Greedy Search"));
    }

    @Test
    public void testGraspBPP() throws CloneNotSupportedException {
        // Simula un problema de BPP
        ILoadingProblems bppProblem = mock(ILoadingProblems.class);

        // Ejecuta graspBPP
        BPPcontainerView.graspBPP(bppProblem);

        // Verifica la salida esperada
        assertTrue(systemOutRule.getLog().contains("Metaheurística: Grasp Search"));
    }
}
