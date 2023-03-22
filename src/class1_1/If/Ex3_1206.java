package class1_1.If;

import java.util.Scanner;

public class Ex3_1206 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		System.out.print("학생 수 입력 : ");
		int student_num = sc.nextInt();
		int sum_90_up = 0, sum_80 = 0, sum_70 = 0, sum_60 = 0, sum_60_down = 0;
	
		for(int i = 1; i <= student_num; i++) {
			System.out.print(i + "번 점수 입력 : ");
			int grade = sc.nextInt();
			
			if(grade >= 90) {
				sum_90_up += 1;
			}
			
			else if(grade >= 80) {
				sum_80 += 1;
			}
		
			else if(grade >= 70) {
				sum_70 += 1;
			}

			else if(grade >= 60) {
				sum_60 += 1;
			}

			else {
				sum_60_down += 1;
			}
		}
			
		System.out.println("90점 이상 : " + sum_90_up);
		System.out.println("80점 대 : " + sum_80);
		System.out.println("70점 대 : " + sum_70);
		System.out.println("60점 대 : " + sum_60);
		System.out.println("60점 미만 : " + sum_60_down);
	}
}
		