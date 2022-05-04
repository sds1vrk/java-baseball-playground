package study;

import static org.junit.Assert.assertEquals;

import org.junit.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class CalculatorTest {
	
	Calculator cal;
	
	@BeforeEach
	public void setUp() {
		cal=new Calculator();
	}
	
	@Test
	public void add() {
		assertEquals(7, cal.add(3, 4));
	}
	
	
	@AfterEach
	public void tearDwon() {
		cal=null;
	}

}
