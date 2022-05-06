package baseball;
import java.util.*;
public class BaseBallGame {
	
	private static Scanner scan=new Scanner(System.in);
	private boolean visit[]=new boolean[11]; // ����� ����
	private Integer com[]=new Integer[3];		// ä���� �ڸ���
	private int MAX=3;
	Integer user[]=new Integer[MAX];
	
	// �ڸ����� �ٸ� 3�ڸ� ���� �޼ҵ�
	public void randomValue() {
		Random r=new Random();
		int value=r.nextInt(9)+1;
		System.out.println(value);
		int idx=0;
		visit[value]=true;
		com[idx]=value;
		
		
		while (true) {
			
			value=r.nextInt(9)+1;
			// ���� �տ�
			if (!visit[value]) {
				idx++;
				visit[value]=true;
				com[idx]=value;
			}
			
			// idx==2�̶�� �� ä���� -> break
			if (idx==(MAX-1)) break;
			
		}
		
		System.out.println("RANDOM VALUE"+Arrays.toString(com));		
		
	}
	
	public boolean validationCheck(String input) {
		// �ڸ����� �ٸ��� return 
		if (input.length()!=MAX) {
			return false;
		}
		
		// ���ڰ� �ƴ� ��� return
		char [] data=input.toCharArray();
		for (char ch:data) {
			if (!Character.isDigit(ch)) {
				return false;
			}
		}
		
		return true;
	}
			
	// input Method
	public Integer[] input() {
		System.out.println("���ڸ� �Է��� �ּ��� : ");
		String inputValue=scan.next();
		// inputValue 
		
		boolean check=validationCheck(inputValue);
		// �Ŀ� check()�� 3�ڸ� �Ѿ�ų� ���ڿ� �Է����� ��� �� ���� �ؾ� ��
		// �ٸ� ���ڸ� �Է� �����ϰ� �ؾ� ��
		
		if (check) {
			String arr[]=inputValue.split("");
			
			for (int i=0;i<user.length;i++) {
				user[i]=Integer.parseInt(arr[i]);
			}
			
//			return user;
		}
		
		else {
			input();
		}
		
		return user;
		
		// String -> int[]�� ����
//		String arr[]=inputValue.split("");
//		Integer user[]=new Integer[MAX];
//		for (int i=0;i<user.length;i++) {
//			user[i]=Integer.parseInt(arr[i]);
//		}
		
		
		
	}
	
	// com���� user �� ��
	public boolean compare(Integer user[]) {
		
		System.out.println("user:"+Arrays.toString(user));
		
		// com���� user�� ��
		int strike=0;
		int ball=0;
		
		for (int i=0;i<MAX;i++) {
			if (com[i]==user[i]) strike++;
		}
		
		// contains�� ��
		int temp=0;
		HashSet<Integer>comSet=new HashSet<Integer>(Arrays.asList(com));
//		HashSet<Integer>userSet=new HashSet<Integer>(Arrays.asList(user));
		for (int i=0;i<MAX;i++) {
			if (comSet.contains(user[i]))  {
				temp++;
			}
		}
		ball=temp-strike;
		
		System.out.println("Strike:"+strike);
		System.out.println("ball:"+ball);
		
		if (strike==MAX) {
			System.out.println("3���� ���ڸ� ��� �����̽��ϴ�! ���� ����");
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public void init(BaseBallGame bs) {
		
		
		bs.randomValue();
		boolean check;
		do {
			check=bs.compare(bs.input());
		}
		while (!check);
	}
	
	
	public static void main(String[] args) {
	
		BaseBallGame bs=new BaseBallGame();
		bs.init(bs);
		
		// com���� user �� ��
	
		
		// new Game

		
		
		while(true) {
			System.out.println("������ ���� �����Ϸ��� 1, �����Ϸ��� 2�� �Է��ϼ���.");
			int nextGame=scan.nextInt();
			if (nextGame==1 ) {
				bs=new BaseBallGame();
				bs.init(bs);
			}
			else {
				System.exit(0);
			}
		}

		
	}
	
	

}
