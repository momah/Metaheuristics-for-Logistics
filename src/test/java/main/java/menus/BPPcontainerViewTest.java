package main.java.menus;

import java.util.Scanner;
import main.java.abstracts.problem.ILoadingProblems;
import org.junit.jupiter.api.*;

public class BPPcontainerViewTest {
	@Test
	public void graspBPP() {
		ILoadingProblems bppProblem = null;
		BPPcontainerView.graspBPP(bppProblem);
	}

	@Test
	public void greedyBPP() {
		ILoadingProblems bppProblem = null;
		BPPcontainerView.greedyBPP(bppProblem);
	}

	@Test
	public void hillClimbingBPP() {
		ILoadingProblems bppProblem = null;
		BPPcontainerView.hillClimbingBPP(bppProblem);
	}

	@Test
	public void run() throws CloneNotSupportedException {
		Scanner sc = null;
		String dataFile = "abc";
		BPPcontainerView.run(sc, dataFile);
	}

	@Test
	public void simulatedAnnealingBPP() {
		ILoadingProblems bppProblem = null;
		BPPcontainerView.simulatedAnnealingBPP(bppProblem);
	}
}
