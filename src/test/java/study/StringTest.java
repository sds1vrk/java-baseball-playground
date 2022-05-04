package study;


import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
	
	@Test
	void replace() {
		String act="abc".replace("b", "d");
		assertThat(act).isEqualTo("adc");
	}
	
	@Test
	void splitTest() {
		String test="1,2";
		String testArr[]=test.split(",");
		
	}
	

}
