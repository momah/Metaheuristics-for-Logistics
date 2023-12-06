package main.java.concrete.solutions;

import main.java.abstracts.problem.ILoadingProblems;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class BPPcontainerSolutionTest {
	@Test
	public void BPPcontainerSolution() {
		int[] solution = { -123, 0, 123 };
		ILoadingProblems bppProblem = null;
		BPPcontainerSolution expected = new BPPcontainerSolution(new BPPcontainerSolution({ -123, 0, 123 }, null), 123);
		BPPcontainerSolution actual = new BPPcontainerSolution(solution, bppProblem);

		assertEquals(expected, actual);
	}

	@Test
	public void BPPcontainerSolutionTODO() {
		BPPcontainerSolution bPPcontainerSolution = new BPPcontainerSolution(new BPPcontainerSolution({ -123, 0, 123 }, null), 123);
		int index = 123;
		BPPcontainerSolution expected = new BPPcontainerSolution(new BPPcontainerSolution({ -123, 0, 123 }, null), 123);
		BPPcontainerSolution actual = new BPPcontainerSolution(bPPcontainerSolution, index);

		assertEquals(expected, actual);
	}

	@Test
	public void addNextBestItem() {
		BPPcontainerSolution b = new BPPcontainerSolution(new BPPcontainerSolution({ -123, 0, 123 }, null), 123);
		b.addNextBestItem();
	}

	@Test
	public void addNextItem() {
		BPPcontainerSolution b = new BPPcontainerSolution(new BPPcontainerSolution({ -123, 0, 123 }, null), 123);
		boolean isRandom = true;
		b.addNextItem(isRandom);
	}

	@Test
	public void compareTo() {
		BPPcontainerSolution b = new BPPcontainerSolution(new BPPcontainerSolution({ -123, 0, 123 }, null), 123);
		Object o = new Object();
		int expected = 123;
		int actual = b.compareTo(o);

		assertEquals(expected, actual);
	}

	@Test
	public void full() {
		BPPcontainerSolution b = new BPPcontainerSolution(new BPPcontainerSolution({ -123, 0, 123 }, null), 123);
		boolean expected = true;
		boolean actual = b.full();

		assertEquals(expected, actual);
	}

	@Test
	public void getProblemInstance() {
		BPPcontainerSolution b = new BPPcontainerSolution(new BPPcontainerSolution({ -123, 0, 123 }, null), 123);
		ILoadingProblems expected = null;
		ILoadingProblems actual = b.getProblemInstance();

		assertEquals(expected, actual);
	}

	@Test
	public void isFull() {
		BPPcontainerSolution b = new BPPcontainerSolution(new BPPcontainerSolution({ -123, 0, 123 }, null), 123);
		boolean expected = true;
		boolean actual = b.isFull();

		assertEquals(expected, actual);
	}

	@Test
	public void priority() {
		BPPcontainerSolution b = new BPPcontainerSolution(new BPPcontainerSolution({ -123, 0, 123 }, null), 123);
		int expected = 123;
		int actual = b.priority();

		assertEquals(expected, actual);
	}

	@Test
	public void removeItem() {
		BPPcontainerSolution b = new BPPcontainerSolution(new BPPcontainerSolution({ -123, 0, 123 }, null), 123);
		int index = 123;
		b.removeItem(index);
	}

	@Test
	public void select() {
		BPPcontainerSolution b = new BPPcontainerSolution(new BPPcontainerSolution({ -123, 0, 123 }, null), 123);
		int index = 123;
		boolean expected = true;
		boolean actual = b.select(index);

		assertEquals(expected, actual);
	}

	@Test
	public void size() {
		BPPcontainerSolution b = new BPPcontainerSolution(new BPPcontainerSolution({ -123, 0, 123 }, null), 123);
		int expected = 123;
		int actual = b.size();

		assertEquals(expected, actual);
	}

	@Test
	public void toStringTODO() {
		BPPcontainerSolution b = new BPPcontainerSolution(new BPPcontainerSolution({ -123, 0, 123 }, null), 123);
		String expected = "abc";
		String actual = b.toString();

		assertEquals(expected, actual);
	}

	@Test
	public void toStringTODOTODO() {
		BPPcontainerSolution b = new BPPcontainerSolution(new BPPcontainerSolution({ -123, 0, 123 }, null), 123);
		boolean printPeso = true;
		boolean printValue = true;
		String expected = "abc";
		String actual = b.toString(printPeso, printValue);

		assertEquals(expected, actual);
	}

	@Test
	public void tryAddOneMore() {
		BPPcontainerSolution b = new BPPcontainerSolution(new BPPcontainerSolution({ -123, 0, 123 }, null), 123);
		b.tryAddOneMore();
	}
}
