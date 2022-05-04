package study;

import javax.management.RuntimeErrorException;

import org.assertj.core.util.Arrays;

public class Calculator {
	
	String values[];
	
	// ^라인의 시작, $라인의 끝
	String pattern="^[0-9]*$";
	
	String operationType[]= {"+","/","*","-"};
	
	int add(int i, int j) {
		return i+j;
	}
	
	
	int substract(int i, int j) {
		return i-j;
	}
	
	int multiply(int i, int j) {
		return i*j;
	}
	
	int div(int i, int j) {
		try {
			return i/j;
		}
		catch(Exception ex) {
			System.out.println("0으로 나눌수 없습니다. ");
		}
		return 0;
	}
	
	
	// calculate 
	int calculate(int a, int b, String op) {
		if (op.equals("+")) {
			return add(a,b);
		}
		else if (op.equals("-")){
			return substract(a, b);
		}
		else if (op.equals("*")) {
			return multiply(a, b);
		}
		else if (op.equals("/")){
			return div(a, b);
		}
		else {
			System.out.println("Wrong Input");
			throw new RuntimeException();
		}
		
	}
	
	// 공백 단위로 나누기
	String[] seperate(String str) {
		return str.split(" ");
	}
	
	int toInt(String str) {
		return Integer.parseInt(str);
	}
	
	int calculateString(String[] str) {
		int res=toInt(str[0]);
		String operation="";
		
		for (int i=1;i<str.length;i++) {
			// 짝수 
			if (i%2==0) {
				int value=toInt(checkNum(str[i]));
				res=calculate(res, value, operation);
				
			}
			else {
				// 사칙연산인지확인
				operation=checkOperation(str[i]);
			}
			
		}
		
		return res;
		
	}
	
	// chekcNum - 숫자인지 확인하기
	private String checkNum(String num) {
		if (!pattern.matches(num)) {
			new IllegalAccessException("숫자가 아닙니다");
		}
		return num;
	}
	
	
	private String checkOperation(String op) {
		if (Arrays.asList(operationType).contains(op)) {
			return op;
		}
		else {
			System.out.println("here");
			System.out.println(new IllegalAccessException("사칙연산 수식이 아닙니다"));
			
		}
		return null;
	}

}
