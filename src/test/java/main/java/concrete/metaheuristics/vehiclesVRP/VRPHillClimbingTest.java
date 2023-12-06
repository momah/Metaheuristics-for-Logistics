package main.java.concrete.metaheuristics.vehiclesVRP;

import main.java.abstracts.problem.IRoutingProblems;
import main.java.concrete.solutions.VRPvehiclesSolution;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class VRPHillClimbingTest {
	@Test
	public void VRPHillClimbing() {
		IRoutingProblems rProblem = null;
		VRPHillClimbing expected = new VRPHillClimbing(null);
		VRPHillClimbing actual = new VRPHillClimbing(rProblem);

		assertEquals(expected, actual);
	}

	@Test
	public void getBestNeighbour() throws CloneNotSupportedException {
		VRPHillClimbing v = new VRPHillClimbing(null);
		VRPvehiclesSolution expected = null;
		VRPvehiclesSolution actual = v.getBestNeighbour();

		assertEquals(expected, actual);
	}

	@Test
	public void initialSolution() {
		VRPHillClimbing v = new VRPHillClimbing(null);
		long expected = 123L;
		long actual = v.initialSolution();

		assertEquals(expected, actual);
	}

	@Test
	public void solve() throws CloneNotSupportedException {
		VRPHillClimbing v = new VRPHillClimbing(null);
		v.solve();
	}
}
