package studentTuition;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StudentTuitionTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTuitionCost() {
	//JUnit test for TuitionCost() method in main class
		StudentTuition s = new StudentTuition();
		s.setTuition(10000);
		s.setPerIncr(2.5);
		assertEquals("The two are not equal", s.tuitionCost(), 41525.16, 1);
		
		s.setTuition(12520);
		s.setPerIncr(4.5);
		
		//Will work because tuition is not exactly 53563 and is therefore false
		assertFalse("This statement is true, not false", s.tuitionCost() == 53563);
		
		//Will work due to the +/- 1
		assertEquals("The two are not equal", s.tuitionCost(), 53563, 1);
	}

	@Test
	public void testLoanAmount() {
	//JUnit test for LoanAmount() method in main class
		StudentTuition s = new StudentTuition();
		s.setTuition(10000);
		s.setPerIncr(2.5);
		s.setAPR(2.5);
		s.setLoanTerm(20);
		//Is true
		assertEquals("The two are not equal", s.loanAmount(), 220.04, 1);
		
		//boolean is False so test will succeed (283.83 is not the exact value)
		s.setTuition(12520);
		assertFalse("This statement is true, not false", s.loanAmount() == 283.83);
	}

}
