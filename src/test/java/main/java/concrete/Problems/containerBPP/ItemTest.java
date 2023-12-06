package main.java.concrete.Problems.containerBPP;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {
	@Test
	public void Item() {
		int itemArea = 123;
		int priority = 123;
		Item expected = new Item(123, 123);
		Item actual = new Item(itemArea, priority);

		assertEquals(expected, actual);
	}

	@Test
	public void getFator() {
		Item i = new Item(123, 123);
		double expected = 123.4D;
		double actual = i.getFator();

		assertEquals(expected, actual, 0.0000001D);
	}

	@Test
	public void getItemPriority() {
		Item i = new Item(123, 123);
		int expected = 123;
		int actual = i.getItemPriority();

		assertEquals(expected, actual);
	}

	@Test
	public void getWeight() {
		Item i = new Item(123, 123);
		int expected = 123;
		int actual = i.getWeight();

		assertEquals(expected, actual);
	}

	@Test
	public void toStringTODO() {
		Item i = new Item(123, 123);
		String expected = "abc";
		String actual = i.toString();

		assertEquals(expected, actual);
	}
}
