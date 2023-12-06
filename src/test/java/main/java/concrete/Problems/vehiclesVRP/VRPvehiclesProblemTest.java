package main.java.concrete.Problems.vehiclesVRP;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class VRPvehiclesProblemTest {
	@Test
	public void LoadDataFromFile() {
		VRPvehiclesProblem v = new VRPvehiclesProblem(123);
		String filename = "abc";
		String expected = "abc";
		String actual = v.LoadDataFromFile(filename);

		assertEquals(expected, actual);
	}

	@Test
	public void VRPvehiclesProblem() {
		int size = 123;
		int[][] distances = null;
		VRPvehiclesProblem expected = new VRPvehiclesProblem(123);
		VRPvehiclesProblem actual = new VRPvehiclesProblem(size, distances);

		assertEquals(expected, actual);
	}

	@Test
	public void VRPvehiclesProblemTODO() {
		int size = 123;
		VRPvehiclesProblem expected = new VRPvehiclesProblem(123);
		VRPvehiclesProblem actual = new VRPvehiclesProblem(size);

		assertEquals(expected, actual);
	}

	@Test
	public void VRPvehiclesProblemTODOTODO() {
		VRPvehiclesProblem expected = new VRPvehiclesProblem(123);
		VRPvehiclesProblem actual = new VRPvehiclesProblem();

		assertEquals(expected, actual);
	}

	@Test
	public void VRPvehiclesProblemTODOTODOTODO() {
		String filename = "abc";
		VRPvehiclesProblem expected = new VRPvehiclesProblem(123);
		VRPvehiclesProblem actual = new VRPvehiclesProblem(filename);

		assertEquals(expected, actual);
	}

	@Test
	public void closestNode() {
		VRPvehiclesProblem v = new VRPvehiclesProblem(123);
		int i = 123;
		int[] tab = { -123, 0, 123 };
		int expected = 123;
		int actual = v.closestNode(i, tab);

		assertEquals(expected, actual);
	}

	@Test
	public void getDistance() {
		VRPvehiclesProblem v = new VRPvehiclesProblem(123);
		int i = 123;
		int j = 123;
		int expected = 123;
		int actual = v.getDistance(i, j);

		assertEquals(expected, actual);
	}

	@Test
	public void getDistances() {
		VRPvehiclesProblem v = new VRPvehiclesProblem(123);
		int[][] expected = null;
		int[][] actual = v.getDistances();

		assertArrayEquals(expected, actual);
	}

	@Test
	public void getInstance() {
		VRPvehiclesProblem v = new VRPvehiclesProblem(123);
		v.getInstance();
	}

	@Test
	public void getSize() {
		VRPvehiclesProblem v = new VRPvehiclesProblem(123);
		int expected = 123;
		int actual = v.getSize();

		assertEquals(expected, actual);
	}

	@Test
	public void getTextInstances() {
		VRPvehiclesProblem v = new VRPvehiclesProblem(123);
		String expected = "abc";
		String actual = v.getTextInstances();

		assertEquals(expected, actual);
	}

	@Test
	public void instancesfromFile() {
		VRPvehiclesProblem v = new VRPvehiclesProblem(123);
		v.instancesfromFile();
	}

	@Test
	public void randomInstances() {
		VRPvehiclesProblem v = new VRPvehiclesProblem(123);
		v.randomInstances();
	}

	@Test
	public void setDistances() {
		VRPvehiclesProblem v = new VRPvehiclesProblem(123);
		int[][] distances = null;
		v.setDistances(distances);
	}

	@Test
	public void setInstance() {
		VRPvehiclesProblem v = new VRPvehiclesProblem(123);
		int[][] instance = null;
		v.setInstance(instance);
	}

	@Test
	public void setSize() {
		VRPvehiclesProblem v = new VRPvehiclesProblem(123);
		int size = 123;
		v.setSize(size);
	}

	@Test
	public void setTextInstances() {
		VRPvehiclesProblem v = new VRPvehiclesProblem(123);
		String textInstances = "abc";
		v.setTextInstances(textInstances);
	}

	@Test
	public void toStringTODO() {
		VRPvehiclesProblem v = new VRPvehiclesProblem(123);
		String expected = "abc";
		String actual = v.toString();

		assertEquals(expected, actual);
	}
}
