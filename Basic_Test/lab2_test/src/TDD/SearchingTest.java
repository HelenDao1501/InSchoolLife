package TDD;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SearchingTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	@Test
	void test1() {
		int arr[] = {1, 4, 8, 10, 20, 30, 78};
		int num = 8;
		assertTrue(Searching.binSearch(arr, num));
	}
	@Test
	void test2() {
		int arr[] = {1, 3, 4, 8, 11};
		int num = 5;
		assertFalse(Searching.binSearch(arr, num));
	}
	@Test
	void test3() {
		int arr[] = {2, 5, 7, 8, 12};
		int num = 15;
		assertFalse(Searching.binSearch(arr, num));
	}
	@Test
	void test4() {
		int arr[] = {2, 7, 5, 11, 12};
		int num = -1;
		assertFalse(Searching.binSearch(arr, num));
	}
	@Test
	void test5() {
		int arr[] = {};
		int num = 5;
		assertFalse(Searching.binSearch(arr, num));
	}
	@Test
	void test6() {
		int arr[] = {5};
		int num = 5;
		assertTrue(Searching.binSearch(arr, num));
	}
	@Test
	void test7() {
		int arr[] = {1, 3, 7, 11};
		int num = 3;
		assertTrue(Searching.binSearch(arr, num));
	}
	@Test
	void test8() {
		int arr[] = {5, 5, 5, 5, 5, 5};
		int num = 5;
		assertTrue(Searching.binSearch(arr, num));
	}
	@Test
	void test9() {
		int arr[] = null;
		int num = 5;
		assertFalse(Searching.binSearch(arr, num));
	}
}
