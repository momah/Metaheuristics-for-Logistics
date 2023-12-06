package main.java.concrete.metaheuristics.containerBPP;

import main.java.abstracts.problem.ILoadingProblems;
import main.java.abstracts.solution.ILoadingSolutions;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class BPPGraspTest {
	@Test
	public void BPPGrasp() {
		ILoadingProblems instance = null;
		double alpha = 123.4D;
		int interations = 123;
		BPPGrasp expected = new BPPGrasp(null, 123.4D, 123);
		BPPGrasp actual = new BPPGrasp(instance, alpha, interations);

		assertEquals(expected, actual);
	}

	@Test
	public void initialSolution() {
		BPPGrasp b = new BPPGrasp(null, 123.4D, 123);
		ILoadingSolutions expected = null;
		ILoadingSolutions actual = b.initialSolution();

		assertEquals(expected, actual);
	}

	@Test
	public void printBestSolution() {
		BPPGrasp b = new BPPGrasp(null, 123.4D, 123);
		b.printBestSolution();
	}

	@Test
	public void solve() {
		BPPGrasp b = new BPPGrasp(null, 123.4D, 123);
		b.solve();
	}
}
