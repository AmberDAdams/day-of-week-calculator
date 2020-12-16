import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestCalc {

	@Test
	void testDayOfWeek() {
		assertEquals(Calculator.dayOfWeek(16, 10, 2020), "Friday");
		assertEquals(Calculator.dayOfWeek(5, 8, 2007), "Sunday");
		assertEquals(Calculator.dayOfWeek(12, 5, 1784), "Wednesday");
	}
	
	@Test
	void testIsProperFormat() {
		assertFalse(Calculator.isProperFormat("December 12th, 2012"));
		assertFalse(Calculator.isProperFormat("12-12-12"));
		assertTrue(Calculator.isProperFormat("12-12-2012"));
	}

	@Test
	void testCalcMonthCode() {
		assertEquals(Calculator.calcMonthCode(12, 2020), 6);
		assertEquals(Calculator.calcMonthCode(1, 2020), 0);
		assertEquals(Calculator.calcMonthCode(8, 2019), 3);
		assertEquals(Calculator.calcMonthCode(2, 2018), 4);
	}

	@Test
	void testIsLeapYear() {
		assertTrue(Calculator.isLeapYear(2020));
		assertFalse(Calculator.isLeapYear(2019));
		assertTrue(Calculator.isLeapYear(2000));
		assertFalse(Calculator.isLeapYear(1900));
	}
	
	@Test
	void testCalcYearCode() {
		assertEquals(Calculator.calcYearCode(1492), 117);
		assertEquals(Calculator.calcYearCode(1945), 56);
		assertEquals(Calculator.calcYearCode(2020), 31);
	}

	@Test
	void testCalcCenturyCode() {
		assertEquals(Calculator.calcCenturyCode(2020), 6);
		assertEquals(Calculator.calcCenturyCode(2178), 4);
		assertEquals(Calculator.calcCenturyCode(1776), 4);
	}
}
