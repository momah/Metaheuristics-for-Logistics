package test.java.concrete.Problems.containerBPP;

import static org.junit.jupiter.api.Assertions.*;

import main.java.concrete.Problems.containerBPP.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestItem {
    private Item item;

    @BeforeEach
    void setUp() {
        // Inicializa los atributos según sea necesario antes de cada prueba
        int itemArea = 10;
        int priority = 5;
        item = new Item(itemArea, priority);
    }

    @Test
    void getWeight() {
        assertEquals(10, item.getWeight());
    }

    @Test
    void getItemPriority() {
        assertEquals(5, item.getItemPriority());
    }

    @Test
    void getFator() {
        assertEquals(0.5, item.getFator(), 0.001); // Utiliza delta para comparación de números de punto flotante
    }

    @Test
    void testToString() {
        String expectedToString = "[ Item Area = 10, Priority = 5 ]";
        assertEquals(expectedToString, item.toString());
    }
}