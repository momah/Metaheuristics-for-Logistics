package test.java.concrete.Problems.vehiclesVRP;

import static org.junit.jupiter.api.Assertions.*;

import main.java.concrete.Problems.vehiclesVRP.Edges;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestEdges {

    private Edges edges;

    @BeforeEach
    void setUp() {
        // Inicializa los objetos necesarios para las pruebas
        edges = new Edges();
    }

    @Test
    void testGetSize() {
        // Establece un valor aleatorio para size y verifica si se recupera correctamente
        int size = 5;
        edges.setSize(size);
        assertEquals(size, edges.getSize());
    }

    @Test
    void testGetDistances() {
        // Crea una matriz de distancias de ejemplo y verifica si se recupera correctamente
        int[][] distances = {{0, 1, 2}, {1, 0, 3}, {2, 3, 0}};
        edges.setDistances(distances);
        assertArrayEquals(distances, edges.getDistances());
    }

    @Test
    void testSetSize() {
        // Establece un valor aleatorio para size y verifica si se establece correctamente
        int size = 8;
        edges.setSize(size);
        assertEquals(size, edges.getSize());
    }

    @Test
    void testSetDistances() {
        // Crea una matriz de distancias de ejemplo y verifica si se establece correctamente
        int[][] distances = {{0, 2, 4}, {2, 0, 6}, {4, 6, 0}};
        edges.setDistances(distances);
        assertArrayEquals(distances, edges.getDistances());
    }
}
