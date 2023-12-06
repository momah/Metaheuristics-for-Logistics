package main.java.menus;

import java.util.Scanner;
import main.java.abstracts.problem.IRoutingProblems;
import org.junit.jupiter.api.*;

public class VRPvehiclesViewTest {
	@Test
	public void hillClimbingModifiedVRP() throws CloneNotSupportedException {
		IRoutingProblems vrpProblem = null;
		VRPvehiclesView.hillClimbingModifiedVRP(vrpProblem);
	}

	@Test
	public void hillClimbingVRP() throws CloneNotSupportedException {
		IRoutingProblems vrpProblem = null;
		VRPvehiclesView.hillClimbingVRP(vrpProblem);
	}

	@Test
	public void run() throws CloneNotSupportedException {
		Scanner sc = null;
		String dataFile = "abc";
		VRPvehiclesView.run(sc, dataFile);
	}

	@Test
	public void simulatedAnnealingVRP() throws CloneNotSupportedException {
		IRoutingProblems vrpProblem = null;
		VRPvehiclesView.simulatedAnnealingVRP(vrpProblem);
	}

	@Test
	public void tabuVRP() throws CloneNotSupportedException {
		IRoutingProblems vrpProblem = null;
		VRPvehiclesView.tabuVRP(vrpProblem);
	}
}
