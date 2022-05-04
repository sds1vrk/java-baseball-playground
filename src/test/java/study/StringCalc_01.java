package study;

import java.util.Scanner;
import static org.junit.Assert.assertEquals;

import org.junit.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
public class StringCalc_01 {
	Calculator cal;
	
	@Before
	public void setUp() {
		cal=new Calculator();
	}
	
	
	@Test
	public void calc() {
//		cal=new Calculator();
		String str="1 2 4";
		String strArr[]=cal.seperate(str);
		System.out.println(cal.calculateString(strArr));
	}

}
