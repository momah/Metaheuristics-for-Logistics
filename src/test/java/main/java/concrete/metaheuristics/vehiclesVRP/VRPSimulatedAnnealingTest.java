package main.java.concrete.metaheuristics.vehiclesVRP;

import main.java.abstracts.problem.IRoutingProblems;
import main.java.abstracts.solution.IRoutingSolutions;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class VRPSimulatedAnnealingTest {
	@Test
	public void VRPSimulatedAnnealing() {
		IRoutingProblems rProblem = null;
		VRPSimulatedAnnealing expected = new VRPSimulatedAnnealing(null);
		VRPSimulatedAnnealing actual = new VRPSimulatedAnnealing(rProblem);

		assertEquals(expected, actual);
	}

	@Test
	public void randomNeighbour() throws CloneNotSupportedException {
		VRPSimulatedAnnealing v = new VRPSimulatedAnnealing(null);
		IRoutingSolutions expected = null;
		IRoutingSolutions actual = v.randomNeighbour();

		assertEquals(expected, actual);
	}

	@Test
	public void solve() throws CloneNotSupportedException {
		VRPSimulatedAnnealing v = new VRPSimulatedAnnealing(null);
		v.solve();
	}
}
