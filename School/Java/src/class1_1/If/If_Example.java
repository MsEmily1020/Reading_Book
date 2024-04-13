package class1_1.If;

import java.util.*;

public class If_Example {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 입력:");
		int num = sc.nextInt();
		
		if(num == 1) {
			System.out.println("1입니다.");
		} 
		else if(num == 2) {
			System.out.println("2입니다.");
		}
		else if(num == 3) {
			System.out.println("3입니다.");
		}
		else {
			System.out.println("그 외의 숫자입니다.");
		}

	}
}