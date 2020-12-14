import static org.junit.jupiter.api.Assertions.*;
//import org.junit.Before;
import org.junit.jupiter.api.Test;

class TestCalc {
	
//	private Calculator calc;
//	
//    @Before // setup()
//    public void before() throws Exception {
//        System.out.println("Setting it up!");
//        calc = new Calculator();
//    }

	@Test
	void testDayOfWeek() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testCalcDayCode() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testCalcMonthCode() {
		fail("Not yet implemented"); // TODO
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
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testCalcDayOfWeek() {
		fail("Not yet implemented"); // TODO
	}

}
