package main.java.concrete.Problems.containerBPP;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {

    private main.java.concrete.Problems.containerBPP.Item item;

    @BeforeEach
    void setUp() {
        item = new main.java.concrete.Problems.containerBPP.Item(100, 5); // Ejemplo: área de 100 y prioridad de 5
    }

    @Test
    @DisplayName("Obtener área del ítem")
    void obtenerAreaDelItem() {
        assertEquals(100, item.getWeight(), "El área del ítem debe ser 100");
    }

    @Test
    @DisplayName("Obtener prioridad del ítem")
    void obtenerPrioridadDelItem() {
        assertEquals(5, item.getItemPriority(), "La prioridad del ítem debe ser 5");
    }

    @Test
    @DisplayName("Calcular factor de prioridad del ítem")
    void calcularFactorDePrioridad() {
        assertEquals(0.05, item.getFator(), 0.01, "El factor de prioridad debe ser 0.05");
    }

    @Test
    @DisplayName("Verificar la representación String del ítem")
    void verificarToString() {
        String esperado = "[ Item Area = 100, Priority = 5 ]";
        assertEquals(esperado, item.toString(), "La representación String del ítem no es la esperada");
    }
}
