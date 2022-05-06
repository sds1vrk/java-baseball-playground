package baseball;
import java.util.*;
public class BaseBallGame {
	
	private static Scanner scan=new Scanner(System.in);
	private boolean visit[]=new boolean[11]; // 사용한 숫자
	private Integer com[]=new Integer[3];		// 채워진 자리수
	private int MAX=3;
	Integer user[]=new Integer[MAX];
	
	// 자리수가 다른 3자리 랜덤 메소드
	public void randomValue() {
		Random r=new Random();
		int value=r.nextInt(9)+1;
		System.out.println(value);
		int idx=0;
		visit[value]=true;
		com[idx]=value;
		
		
		while (true) {
			
			value=r.nextInt(9)+1;
			// 만약 앞에
			if (!visit[value]) {
				idx++;
				visit[value]=true;
				com[idx]=value;
			}
			
			// idx==2이라면 다 채워짐 -> break
			if (idx==(MAX-1)) break;
			
		}
		
		System.out.println("RANDOM VALUE"+Arrays.toString(com));		
		
	}
	
	public boolean validationCheck(String input) {
		// 자리수가 다르면 return 
		if (input.length()!=MAX) {
			return false;
		}
		
		// 숫자가 아닐 경우 return
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
		System.out.println("숫자를 입력해 주세요 : ");
		String inputValue=scan.next();
		// inputValue 
		
		boolean check=validationCheck(inputValue);
		// 후에 check()로 3자리 넘어가거나 문자열 입력했을 경우 못 돌게 해야 함
		// 다른 숫자만 입력 가능하게 해야 함
		
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
		
		// String -> int[]로 변경
//		String arr[]=inputValue.split("");
//		Integer user[]=new Integer[MAX];
//		for (int i=0;i<user.length;i++) {
//			user[i]=Integer.parseInt(arr[i]);
//		}
		
		
		
	}
	
	// com값과 user 값 비교
	public boolean compare(Integer user[]) {
		
		System.out.println("user:"+Arrays.toString(user));
		
		// com값과 user값 비교
		int strike=0;
		int ball=0;
		
		for (int i=0;i<MAX;i++) {
			if (com[i]==user[i]) strike++;
		}
		
		// contains로 비교
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
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
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
		
		// com값과 user 값 비교
	
		
		// new Game

		
		
		while(true) {
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
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
