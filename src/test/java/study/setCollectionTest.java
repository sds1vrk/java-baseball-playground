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
	
	// Test Case 1 - Set Size�� Ȯ��
	// isEqualsTo�� Ȯ��
	@Test
	void case1() {
		assertThat(numbers.size()).isEqualTo(3);
	}
	
	// contains() �޼ҵ带 Ȱ���� 1,2,3�� ���� �����ϴ��� Ȯ���ϴ� �н� ������ ����
	// 
	@Test
	void case2() {
		assertThat(numbers.contains(1)).isTrue();
		assertThat(numbers.contains(2)).isTrue();
		assertThat(numbers.contains(3)).isTrue();
	}
	
	// case2 �� �ϸ� �ߺ� �ڵ� �߻� -> @ParameterizedTest�� Ȱ���� �ߺ��ڵ� ����
	// @ParameterizedTest -> �ߺ� �ڵ� ����
	// @ValueSource -> input�� �̸� ���� ���� (�������� int -> ints, �������� string -> strings ���)
	// assertTrue -> �־��� ��ü�� ������ �������� �Ǻ� ���� ( input ���� ����
	@ParameterizedTest
	@ValueSource(ints= {1,2,3}) // �Է� �� 
	void isBlank(int input) {
		assertTrue(numbers.contains(input));
	}
	
	/*
	 * case 3 : �Է°��� ���� ��� �� ����
	 * @CsvSource : �Է°��� ���� ������� ������ ���� 
	 */
	@ParameterizedTest
	@CsvSource(value= {"1:true","2:true","3:true","4:false"},delimiter = ':')
	void testCase3(int input, boolean expected) {
		assertThat(numbers.contains(input)).isEqualTo(expected);
	}
	
	

}
