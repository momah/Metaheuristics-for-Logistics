package main.java.concrete.metaheuristics.vehiclesVRP;

import main.java.abstracts.problem.IRoutingProblems;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class VRPHillClimbingModifiedTest {
	@Test
	public void VRPHillClimbingModified() {
		IRoutingProblems rProblem = null;
		VRPHillClimbingModified expected = new VRPHillClimbingModified(null);
		VRPHillClimbingModified actual = new VRPHillClimbingModified(rProblem);

		assertEquals(expected, actual);
	}

	@Test
	public void initialSolution() {
		VRPHillClimbingModified v = new VRPHillClimbingModified(null);
		long expected = 123L;
		long actual = v.initialSolution();

		assertEquals(expected, actual);
	}
}
