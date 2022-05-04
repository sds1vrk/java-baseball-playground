package study;

import org.assertj.core.internal.Strings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class setCollectionTest {
	
	private Set<Integer> numbers;
	
	
	@BeforeEach
	void setup() {
		numbers=new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		
	}
	
	// Test Case 1 - Set Size를 확인
	// isEqualsTo로 확인
	@Test
	void case1() {
		assertThat(numbers.size()).isEqualTo(3);
	}
	
	// contains() 메소드를 활용해 1,2,3의 값이 존재하는지 확인하는 학습 페이지 구현
	// 
	@Test
	void case2() {
		assertThat(numbers.contains(1)).isTrue();
		assertThat(numbers.contains(2)).isTrue();
		assertThat(numbers.contains(3)).isTrue();
	}
	
	// case2 로 하면 중복 코드 발생 -> @ParameterizedTest를 활용해 중복코드 제거
	// @ParameterizedTest -> 중복 코드 제거
	// @ValueSource -> input값 미리 지정 가능 (여러개의 int -> ints, 여러개의 string -> strings 사용)
	// assertTrue -> 주어진 객체가 참인지 거짓인지 판별 가능 ( input 값을 토대로
	@ParameterizedTest
	@ValueSource(ints= {1,2,3}) // 입력 값 
	void isBlank(int input) {
		assertTrue(numbers.contains(input));
	}
	
	/*
	 * case 3 : 입력값에 따른 결과 값 구분
	 * @CsvSource : 입력값에 따른 결과값이 나오게 가능 
	 */
	@ParameterizedTest
	@CsvSource(value= {"1:true","2:true","3:true","4:false"},delimiter = ':')
	void testCase3(int input, boolean expected) {
		assertThat(numbers.contains(input)).isEqualTo(expected);
	}
	
	

}
