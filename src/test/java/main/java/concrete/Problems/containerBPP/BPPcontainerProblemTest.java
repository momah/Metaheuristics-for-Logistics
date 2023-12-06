package main.java.concrete.Problems.containerBPP;

import java.util.ArrayList;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class BPPcontainerProblemTest {
	@Test
	public void BPPcontainerProblem() {
		int capacity = 123;
		ArrayList<Item> items = null;
		BPPcontainerProblem expected = new BPPcontainerProblem("abc");
		BPPcontainerProblem actual = new BPPcontainerProblem(capacity, items);

		assertEquals(expected, actual);
	}

	@Test
	public void BPPcontainerProblemTODO() {
		BPPcontainerProblem expected = new BPPcontainerProblem("abc");
		BPPcontainerProblem actual = new BPPcontainerProblem();

		assertEquals(expected, actual);
	}

	@Test
	public void BPPcontainerProblemTODOTODO() {
		String filename = "abc";
		BPPcontainerProblem expected = new BPPcontainerProblem("abc");
		BPPcontainerProblem actual = new BPPcontainerProblem(filename);

		assertEquals(expected, actual);
	}

	@Test
	public void LoadDataFromFile() {
		BPPcontainerProblem b = new BPPcontainerProblem("abc");
		String filename = "abc";
		String expected = "abc";
		String actual = b.LoadDataFromFile(filename);

		assertEquals(expected, actual);
	}

	@Test
	public void getCapacity() {
		BPPcontainerProblem b = new BPPcontainerProblem("abc");
		int expected = 123;
		int actual = b.getCapacity();

		assertEquals(expected, actual);
	}

	@Test
	public void getItem() {
		BPPcontainerProblem b = new BPPcontainerProblem("abc");
		int index = 123;
		Item expected = new Item(123, 123);
		Item actual = b.getItem(index);

		assertEquals(expected, actual);
	}

	@Test
	public void getItems() {
		BPPcontainerProblem b = new BPPcontainerProblem("abc");
		ArrayList<Item> expected = null;
		ArrayList<Item> actual = b.getItems();

		assertEquals(expected, actual);
	}

	@Test
	public void getNumItems() {
		BPPcontainerProblem b = new BPPcontainerProblem("abc");
		int expected = 123;
		int actual = b.getNumItems();

		assertEquals(expected, actual);
	}

	@Test
	public void instancesFromText() {
		BPPcontainerProblem b = new BPPcontainerProblem("abc");
		b.instancesFromText();
	}

	@Test
	public void pesoItems() {
		BPPcontainerProblem b = new BPPcontainerProblem("abc");
		double expected = 123.4D;
		double actual = b.pesoItems();

		assertEquals(expected, actual, 0.0000001D);
	}

	@Test
	public void toStringTODO() {
		BPPcontainerProblem b = new BPPcontainerProblem("abc");
		boolean outputitems = true;
		String expected = "abc";
		String actual = b.toString(outputitems);

		assertEquals(expected, actual);
	}

	@Test
	public void toStringTODOTODO() {
		BPPcontainerProblem b = new BPPcontainerProblem("abc");
		String expected = "abc";
		String actual = b.toString();

		assertEquals(expected, actual);
	}
}
