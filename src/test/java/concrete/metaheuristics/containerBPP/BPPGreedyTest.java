package main.java.concrete.metaheuristics.containerBPP;

import main.java.abstracts.problem.ILoadingProblems;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class BPPGreedyTest {
	@Test
	public void BPPGreedy() {
		ILoadingProblems instancia = null;
		BPPGreedy expected = new BPPGreedy(null);
		BPPGreedy actual = new BPPGreedy(instancia);

		assertEquals(expected, actual);
	}

	@Test
	public void printBestSolution() {
		BPPGreedy b = new BPPGreedy(null);
		b.printBestSolution();
	}

	@Test
	public void solve() {
		BPPGreedy b = new BPPGreedy(null);
		b.solve();
	}
}
