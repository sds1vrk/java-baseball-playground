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
	
	// �䱸���� 1 
	// split�� �̿��� �и� �� contains & containsExactly Ȯ��
	@Test
	void splitTest() {
		String test="1,2";
		String testArr[]=test.split(",");
		assertThat(testArr).contains("1"); // ���ڿ� Ȯ��
		assertThat(testArr).containsExactly("1","2"); // ��Ȯ�� ���� �������� Ȯ�� containsExactly
	}
	
	// �䱸���� 2
	// subString()�޼ҵ带 Ȱ���� ()�� �����ϰ� 1,2�� ��ȯ�ϵ��� ����
	@Test
	void subStringTest() {
		String test="(1,2)";
		String value=test.substring(1, test.length()-1);
		assertThat(value).contains("1,2");
	}
	
	// �䱸���� 3
	@DisplayName("�䱸���� 3")
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
//			throw new Exception("�����ʰ�");
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
