package es.ull.concrete.Problems.containerBPP;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
	import es.ull.concrete.Problems.containerBPP.Item;

public class ItemTest {

	@Test
	public void testConstructor() {
		Item item = new Item(10, 5);
		assertEquals(10, item.getWeight());
		assertEquals(5, item.getItemPriority());
	}

	@Test
	public void testGetWeight() {
		Item item = new Item(20, 10);
		assertEquals(20, item.getWeight());
	}

	@Test
	public void testGetItemPriority() {
		Item item = new Item(15, 7);
		assertEquals(7, item.getItemPriority());
	}

	@Test
	public void testGetFactor() {
		Item item = new Item(25, 5);
		double expectedFactor = 5.0 / 25.0;
		assertEquals(expectedFactor, item.getFator(), 0.001);
	}

	@Test
	public void testToString() {
		Item item = new Item(30, 10);
		String expectedString = "[ Item Area = 30, Priority = 10 ]";
		assertEquals(expectedString, item.toString());
	}
}
