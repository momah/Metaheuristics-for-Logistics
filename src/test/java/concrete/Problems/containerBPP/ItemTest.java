package main.java.concrete.Problems.containerBPP;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {

    @Test
    public void testItemConstructor() {
        int itemArea = 123;
        int priority = 123;
        Item expected = new Item(123, 123);
        Item actual = new Item(itemArea, priority);

        assertEquals(expected.getWeight(), actual.getWeight());
        assertEquals(expected.getItemPriority(), actual.getItemPriority());
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void testGetFator() {
        Item i = new Item(123, 123);
        double expected = 1.0D;
        double actual = i.getFator();

        assertEquals(expected, actual, 0.0000001D);
    }

    @Test
    public void testGetItemPriority() {
        Item i = new Item(123, 123);
        int expected = 123;
        int actual = i.getItemPriority();

        assertEquals(expected, actual);
    }

    @Test
    public void testGetWeight() {
        Item i = new Item(123, 123);
        int expected = 123;
        int actual = i.getWeight();

        assertEquals(expected, actual);
    }

    @Test
    public void testToString() {
        Item i = new Item(123, 123);
        String expected = "[ Item Area = 123, Priority = 123 ]";
        String actual = i.toString();

        assertEquals(expected, actual);
    }
}
