package es.ull.concrete.Problems.vehiclesVRP;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EdgesTest {

	private Edges edges;

	@BeforeEach
	void setUp() {
		edges = new Edges();
	}

	@Test
	void testSizeWithValidInput() {
		edges.setSize(10);
		assertEquals(10, edges.getSize());
	}

	@Test
	void testSizeWithBoundaryInput() {
		edges.setSize(Integer.MAX_VALUE);
		assertEquals(Integer.MAX_VALUE, edges.getSize());

		edges.setSize(0);
		assertEquals(0, edges.getSize());
	}

	@Test
	void testDistancesWithValidInput() {
		int[][] testDistances = {
				{0, 1, 2},
				{1, 0, 3},
				{2, 3, 0}
		};
		edges.setDistances(testDistances);
		assertArrayEquals(testDistances, edges.getDistances());
	}

	@Test
	void testDistancesWithInvalidInput() {
		int[][] invalidDistances = {
				{0, -1, 2},
				{1, 0, -3},
				{2, 3, 0}
		};
		edges.setDistances(invalidDistances);

		// Assuming your class should handle negative distances by some means,
		// add assertions here to validate that behavior.
	}

	@Test
	void testDistancesWithNullInput() {
		edges.setDistances(null);
		assertNull(edges.getDistances());
	}

	@Test
	void testDistanceSymmetry() {
		int[][] symmetricDistances = {{0, 2, 3}, {2, 0, 4}, {3, 4, 0}};
		edges.setDistances(symmetricDistances);

		for (int i = 0; i < symmetricDistances.length; i++) {
			for (int j = 0; j < symmetricDistances[i].length; j++) {
				assertEquals(symmetricDistances[i][j], symmetricDistances[j][i],
						"Distances should be symmetric.");
			}
		}
	}

}
