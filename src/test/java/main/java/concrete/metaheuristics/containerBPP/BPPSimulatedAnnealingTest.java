package main.java.concrete.metaheuristics.containerBPP;

import main.java.abstracts.problem.ILoadingProblems;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class BPPSimulatedAnnealingTest {
	@Test
	public void BPPSimulatedAnnealing() {
		ILoadingProblems instancia = null;
		BPPSimulatedAnnealing expected = new BPPSimulatedAnnealing(null);
		BPPSimulatedAnnealing actual = new BPPSimulatedAnnealing(instancia);

		assertEquals(expected, actual);
	}

	@Test
	public void printBestSolution() {
		BPPSimulatedAnnealing b = new BPPSimulatedAnnealing(null);
		b.printBestSolution();
	}

	@Test
	public void solve() {
		BPPSimulatedAnnealing b = new BPPSimulatedAnnealing(null);
		b.solve();
	}
}
