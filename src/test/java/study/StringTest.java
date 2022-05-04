package study;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.*;

public class StringTest {
	
	@Test
	void replace() {
		String act="abc".replace("b", "d");
		assertThat(act).isEqualTo("adc");
	}
	
	// 요구사항 1 
	// split을 이용한 분리 및 contains & containsExactly 확인
	@Test
	void splitTest() {
		String test="1,2";
		String testArr[]=test.split(",");
		assertThat(testArr).contains("1"); // 문자열 확인
		assertThat(testArr).containsExactly("1","2"); // 정확한 값이 무엇인지 확인 containsExactly
	}
	
	// 요구사항 2
	// subString()메소드를 활용해 ()를 제거하고 1,2를 반환하도록 구현
	@Test
	void subStringTest() {
		String test="(1,2)";
		String value=test.substring(1, test.length()-1);
		assertThat(value).contains("1,2");
	}
	
	// 요구사항 3
	@DisplayName("요구사항 3")
	@Test
	void charAtTest() {
		// Given
		String test="abc";
		
		assertThat(test.charAt(0)).isEqualTo('a');
		assertThat(test.charAt(1)).isEqualTo('b');
		assertThat(test.charAt(2)).isEqualTo('c');
		
		
		
		// When, Then
//		assertThatThrownBy(()-> {
//			test.charAt(3);
//			throw new Exception("범위초과");
//		}).isInstanceOf(IndexOutOfBoundsException.class)
//		.hasMessageContaining("idx:2, size:2");
		
		assertThatExceptionOfType(IndexOutOfBoundsException.class)
		.isThrownBy(()-> {
			char val=test.charAt(100);
			System.out.println(val);
			throw new Exception();
		}).withMessageMatching("idx:2, size:2");
		
	}
	
	

}
