package class1_1.StudentProgram;

import java.util.Scanner;

public class Grade_Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 명의 학생을 입력하시겠습니까 : ");
		int stu_num = sc.nextInt();

		for(int i = 1; i <= stu_num; i++) {
			System.out.println(i + "번째 학생 입력");
			String name_Num, name;
			System.out.print("학번 : ");
			name_Num = sc.next();
			System.out.print("이름 : ");
			name = sc.next();

			int korea, english, math, java;

			do {
				System.out.print("국어 : ");
				korea = sc.nextInt();
				// if(korea >= 0 && korea <= 100) break;

			} while(korea < 0 || korea > 100);

			do {
				System.out.print("영어 : ");
				english = sc.nextInt();
				// if(english >= 0 && english <= 100) break;

			} while(english < 0 || english > 100);

			do {
				System.out.print("수학 : ");
				math = sc.nextInt();
 				// if(math >= 0 && math <= 100) break;

			} while(math < 0 || math > 100);

			do {
				System.out.print("자바 : ");
				java = sc.nextInt();
				// if(java >= 0 && java <= 100) break;

			} while(java < 0 || java > 100);

			int sum = korea + english + math + java;
			double avg = (double)sum / 4;
	
			char result;
			switch((int)avg / 10) {
				case 10 : case 9 : 
					result ='A'; 
					break;
				case 8 : 
					result ='B';
					break;
				case 7 : 
					result ='C';
					break;
				case 6 :
					result ='D';
					break;
				default : 
					result = 'E';
			}

			System.out.print(name_Num + " " + name + " " + korea + " " + english + " " + math + " "+ java + " " + sum);
			System.out.printf(" %.2f %c\n", avg, result);
		}
	}
}




