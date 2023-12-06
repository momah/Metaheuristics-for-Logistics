package main.java;

import org.junit.jupiter.api.*;

public class MainTest {
	@Test
	public void main() {
		String[] args = { "abc", "abc", "abc" };
		Main.main(args);
	}

	@Test
	public void printMenu() {
		Main.printMenu();
	}
}
