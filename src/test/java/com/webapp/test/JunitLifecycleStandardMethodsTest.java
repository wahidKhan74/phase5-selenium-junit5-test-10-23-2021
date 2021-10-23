package com.webapp.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JunitLifecycleStandardMethodsTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("-- Before all ---");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("-- After all ---");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("-- Before each setup ---");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("-- After each cleanup ---");
	}

	@Test
	void testOne() {
		System.out.println("Test 1 is executed !");
	}
	
	@Test
	void testTwo() {
		System.out.println("Test 2 is executed !");
	}

	@Test
	void testThree() {
		System.out.println("Test 3 is executed !");
	}
}
