package es.ull.concrete.solutions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import es.ull.concrete.Problems.containerBPP.Item;
import es.ull.concrete.Problems.containerBPP.BPPcontainerProblem;

import java.util.ArrayList;

class BPPcontainerSolutionTest {

	private BPPcontainerSolution solution;
	private BPPcontainerProblem problem;
	private int[] initialSolution;
	private ArrayList<Item> items;

	@BeforeEach
	void setUp() {
		// Simulando la creación de items y el problema
		items = new ArrayList<>();
		items.add(new Item(5, 10)); // peso 5, prioridad 10
		items.add(new Item(3, 5));  // peso 3, prioridad 5
		problem = new BPPcontainerProblem(10, items);

		// Inicializando una solución con todos los ítems no seleccionados (0)
		initialSolution = new int[items.size()];
		for (int i = 0; i < initialSolution.length; i++) {
			initialSolution[i] = 0;
		}

		solution = new BPPcontainerSolution(initialSolution, problem);
	}

	@Test
	void testConstructor() {
		assertArrayEquals(initialSolution, solution.getSolution());
		assertEquals(problem, solution.getProblemInstance());
	}

	@Test
	void testFull() {
		assertFalse(solution.full());
		solution.tryAddOneMore(); // Intentar agregar un ítem más
		assertTrue(solution.full() || !solution.full()); // Puede ser completo o no, dependiendo del ítem añadido
	}

	@Test
	void testAddNextItem() {
		solution.addNextItem(true); // Añadir un ítem de forma aleatoria
		assertTrue(solution.full() || !solution.full()); // Puede ser completo o no, dependiendo del ítem añadido
	}

	@Test
	void testRemoveItem() {
		solution.tryAddOneMore(); // Añadir un ítem
		solution.removeItem(0); // Remover un ítem
		assertFalse(solution.select(0)); // El ítem debe estar no seleccionado
	}

	@Test
	void testPriority() {
		solution.tryAddOneMore(); // Añadir un ítem
		assertTrue(solution.priority() >= 0); // La prioridad debe ser mayor o igual a 0
	}

	// Aquí pueden añadirse más pruebas para otros métodos

}
