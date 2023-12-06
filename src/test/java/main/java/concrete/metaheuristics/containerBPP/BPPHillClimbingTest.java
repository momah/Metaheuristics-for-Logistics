package main.java.concrete.metaheuristics.containerBPP;

import main.java.abstracts.problem.ILoadingProblems;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class BPPHillClimbingTest {
	@Test
	public void BPPHillClimbing() {
		ILoadingProblems instancia = null;
		BPPHillClimbing expected = new BPPHillClimbing(null);
		BPPHillClimbing actual = new BPPHillClimbing(instancia);

		assertEquals(expected, actual);
	}

	@Test
	public void printBestSolution() {
		BPPHillClimbing b = new BPPHillClimbing(null);
		b.printBestSolution();
	}

	@Test
	public void solve() {
		BPPHillClimbing b = new BPPHillClimbing(null);
		b.solve();
	}
}
