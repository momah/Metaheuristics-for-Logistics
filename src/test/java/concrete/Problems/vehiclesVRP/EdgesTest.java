package main.java.concrete.Problems.vehiclesVRP;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class EdgesTest {
	@Test
	public void Edges() {
		Edges expected = new Edges();
		Edges actual = new Edges();

		assertEquals(expected, actual);
	}

	@Test
	public void getDistances() {
		Edges e = new Edges();
		int[][] expected = null;
		int[][] actual = e.getDistances();

		assertArrayEquals(expected, actual);
	}

	@Test
	public void getSize() {
		Edges e = new Edges();
		int expected = 123;
		int actual = e.getSize();

		assertEquals(expected, actual);
	}

	@Test
	public void setDistances() {
		Edges e = new Edges();
		int[][] distances = null;
		e.setDistances(distances);
	}

	@Test
	public void setSize() {
		Edges e = new Edges();
		int size = 123;
		e.setSize(size);
	}
}
