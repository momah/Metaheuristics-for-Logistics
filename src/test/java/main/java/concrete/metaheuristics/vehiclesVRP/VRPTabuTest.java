package main.java.concrete.metaheuristics.vehiclesVRP;

import main.java.abstracts.problem.IRoutingProblems;
import main.java.abstracts.solution.IRoutingSolutions;
import main.java.concrete.solutions.VRPvehiclesSolution;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class VRPTabuTest {
	@Test
	public void VRPTabu() {
		IRoutingProblems rProblem = null;
		VRPTabu expected = new VRPTabu(null);
		VRPTabu actual = new VRPTabu(rProblem);

		assertEquals(expected, actual);
	}

	@Test
	public void getMinNeighbour() throws CloneNotSupportedException {
		VRPTabu v = new VRPTabu(null);
		VRPvehiclesSolution expected = null;
		VRPvehiclesSolution actual = v.getMinNeighbour();

		assertEquals(expected, actual);
	}

	@Test
	public void randomNeighbour() throws CloneNotSupportedException {
		VRPTabu v = new VRPTabu(null);
		IRoutingSolutions expected = null;
		IRoutingSolutions actual = v.randomNeighbour();

		assertEquals(expected, actual);
	}

	@Test
	public void solve() throws CloneNotSupportedException {
		VRPTabu v = new VRPTabu(null);
		v.solve();
	}
}
