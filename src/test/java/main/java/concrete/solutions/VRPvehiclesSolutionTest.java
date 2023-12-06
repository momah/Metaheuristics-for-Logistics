package main.java.concrete.solutions;

import java.util.ArrayList;
import main.java.abstracts.metaheuristics.RoutingAbstractMHeuristics;
import main.java.abstracts.problem.IRoutingProblems;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class VRPvehiclesSolutionTest {
	@Test
	public void VRPvehiclesSolution() {
		int[] solution = { -123, 0, 123 };
		RoutingAbstractMHeuristics methode = null;
		VRPvehiclesSolution expected = new VRPvehiclesSolution(123, null);
		VRPvehiclesSolution actual = new VRPvehiclesSolution(solution, methode);

		assertEquals(expected, actual);
	}

	@Test
	public void VRPvehiclesSolutionTODO() {
		VRPvehiclesSolution expected = new VRPvehiclesSolution(123, null);
		VRPvehiclesSolution actual = new VRPvehiclesSolution();

		assertEquals(expected, actual);
	}

	@Test
	public void VRPvehiclesSolutionTODOTODO() {
		int size = 123;
		RoutingAbstractMHeuristics metaheuristics = null;
		VRPvehiclesSolution expected = new VRPvehiclesSolution(123, null);
		VRPvehiclesSolution actual = new VRPvehiclesSolution(size, metaheuristics);

		assertEquals(expected, actual);
	}

	@Test
	public void cloneTODO() throws CloneNotSupportedException {
		VRPvehiclesSolution v = new VRPvehiclesSolution(123, null);
		Object expected = new Object();
		Object actual = v.clone();

		assertEquals(expected, actual);
	}

	@Test
	public void compareTo() {
		VRPvehiclesSolution v = new VRPvehiclesSolution(123, null);
		Object obj = new Object();
		int expected = 123;
		int actual = v.compareTo(obj);

		assertEquals(expected, actual);
	}

	@Test
	public void equals() {
		VRPvehiclesSolution v = new VRPvehiclesSolution(123, null);
		Object obj = new Object();
		boolean expected = true;
		boolean actual = v.equals(obj);

		assertEquals(expected, actual);
	}

	@Test
	public void getCostPath() {
		VRPvehiclesSolution v = new VRPvehiclesSolution(123, null);
		IRoutingProblems vrpProblem = null;
		int expected = 123;
		int actual = v.getCostPath(vrpProblem);

		assertEquals(expected, actual);
	}

	@Test
	public void getIndice() {
		VRPvehiclesSolution v = new VRPvehiclesSolution(123, null);
		int i = 123;
		int expected = 123;
		int actual = v.getIndice(i);

		assertEquals(expected, actual);
	}

	@Test
	public void getNeighbour() throws CloneNotSupportedException {
		VRPvehiclesSolution v = new VRPvehiclesSolution(123, null);
		int i = 123;
		VRPvehiclesSolution expected = new VRPvehiclesSolution(123, null);
		VRPvehiclesSolution actual = v.getNeighbour(i);

		assertEquals(expected, actual);
	}

	@Test
	public void getNeighbours() throws CloneNotSupportedException {
		VRPvehiclesSolution v = new VRPvehiclesSolution(123, null);
		ArrayList<VRPvehiclesSolution> expected = null;
		ArrayList<VRPvehiclesSolution> actual = v.getNeighbours();

		assertEquals(expected, actual);
	}

	@Test
	public void getSize() {
		VRPvehiclesSolution v = new VRPvehiclesSolution(123, null);
		int expected = 123;
		int actual = v.getSize();

		assertEquals(expected, actual);
	}

	@Test
	public void initialiserSolution() {
		VRPvehiclesSolution v = new VRPvehiclesSolution(123, null);
		v.initialiserSolution();
	}

	@Test
	public void randomSolution() {
		VRPvehiclesSolution v = new VRPvehiclesSolution(123, null);
		v.randomSolution();
	}

	@Test
	public void randomSolutionModified() {
		VRPvehiclesSolution v = new VRPvehiclesSolution(123, null);
		v.randomSolutionModified();
	}

	@Test
	public void setSize() {
		VRPvehiclesSolution v = new VRPvehiclesSolution(123, null);
		int size = 123;
		v.setSize(size);
	}

	@Test
	public void setSolution() {
		VRPvehiclesSolution v = new VRPvehiclesSolution(123, null);
		Object[] array = { new Object(), new Object(), new Object() };
		v.setSolution(array);
	}

	@Test
	public void toStringTODO() {
		VRPvehiclesSolution v = new VRPvehiclesSolution(123, null);
		String expected = "abc";
		String actual = v.toString();

		assertEquals(expected, actual);
	}

	@Test
	public void toStringTODOTODO() {
		VRPvehiclesSolution v = new VRPvehiclesSolution(123, null);
		IRoutingProblems Problem = null;
		String expected = "abc";
		String actual = v.toString(Problem);

		assertEquals(expected, actual);
	}
}
