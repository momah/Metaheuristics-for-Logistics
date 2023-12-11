package es.ull.concrete.Problems.containerBPP;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import es.ull.concrete.Problems.containerBPP.BPPcontainerProblem;
import es.ull.concrete.Problems.containerBPP.Item;
import static org.junit.jupiter.api.Assertions.*;

class BPPcontainerProblemTest {
	private BPPcontainerProblem problem;
	private ArrayList<Item> items;

	@BeforeEach
	void setUp() {
		items = new ArrayList<>();
		items.add(new Item(5, 10));
		items.add(new Item(3, 5));
		problem = new BPPcontainerProblem(10, items);
	}

	@Test
	void testConstructorWithParameters() {
		// Aquí no necesitamos assertNotNull porque estamos probando la inicialización a través del constructor
		assertEquals(10, problem.getCapacity());
		assertEquals(items.size(), problem.getItems().size()); // Compara tamaño de las listas, no las listas directamente
		assertEquals(items.get(0).getWeight(), problem.getItem(0).getWeight()); // Compara valores de los items
	}

	@Test
	void testGetCapacity() {
		assertEquals(10, problem.getCapacity());
	}

	@Test
	void testGetItem() {
		Item item = problem.getItem(0);
		assertEquals(5, item.getWeight()); // Verifica que el peso del item sea el esperado
		assertEquals(10, item.getItemPriority()); // Verifica que la prioridad del item sea la esperada
	}

	@Test
	void testGetItems() {
		assertEquals(items.size(), problem.getItems().size()); // De nuevo, compara el tamaño
	}

	@Test
	void testGetNumItems() {
		assertEquals(2, problem.getNumItems());
	}

	@Test
	void testToString() {
		String expected = "{ CAPACITY = 10 }";
		assertEquals(expected, problem.toString());
	}
}