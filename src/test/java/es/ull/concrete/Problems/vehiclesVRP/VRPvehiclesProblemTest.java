package es.ull.concrete.Problems.vehiclesVRP;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VRPvehiclesProblemTest {

	private VRPvehiclesProblem problem;
	private int[][] distances;

	@BeforeEach
	void setUp() {
		int size = 3;
		distances = new int[][]{{0, 1, 2}, {1, 0, 3}, {2, 3, 0}};
		problem = new VRPvehiclesProblem(size, distances);
	}

	@Test
	void testConstructorWithSizeAndDistances() {
		assertEquals(3, problem.getSize());
		assertArrayEquals(distances, problem.getDistances());
	}

	@Test
	void testGetSize() {
		assertEquals(3, problem.getSize());
	}

	@Test
	void testSetDistances() {
		int[][] newDistances = {{0, 4, 5}, {4, 0, 6}, {5, 6, 0}};
		problem.setDistances(newDistances);
		assertArrayEquals(newDistances, problem.getDistances());
	}

	@Test
	void testInstancesFromFile() {
		// Simulación de carga de datos desde un "archivo"
		String simulatedFileData = "Header\nA\t0\t1\t2\nB\t1\t0\t3\nC\t2\t3\t0";
		problem.setTextInstances(simulatedFileData);
		problem.instancesfromFile();

		// Verificación de que los datos se hayan cargado correctamente
		int[][] expectedDistances = {{0, 1, 2}, {1, 0, 3}, {2, 3, 0}};
		assertArrayEquals(expectedDistances, problem.getDistances());
	}

	@Test
	void testRandomInstances() {
		problem.randomInstances();
		int size = problem.getSize();
		int[][] randomDistances = problem.getDistances();

		// Verificar que la matriz de distancias se haya llenado con valores aleatorios
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i != j) {
					assertTrue(randomDistances[i][j] >= 0 && randomDistances[i][j] < 100);
				} else {
					assertEquals(0, randomDistances[i][j]);
				}
			}
		}
	}


}
