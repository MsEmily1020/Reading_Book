package class1_2.Array;

import java.util.Scanner;

public class Grade_Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 명의 학생을 입력하시겠습니까 : ");
		int stu_num = sc.nextInt();
		System.out.print("몇 과목을 입력하시겠습니까 : ");
		int sub = sc.nextInt();

		String[] name_Num = new String[stu_num], name = new String[stu_num];
		int[][] subject = new int[stu_num][sub + 1];
		double[] avg = new double[stu_num];
		char[] result = new char[stu_num];
		int[] rank = new int[stu_num];
		for(int i = 0; i < rank.length; i++) rank[i] = 1;
		
		String[] sub_name = {"국어", "영어", "수학", "자바", "C", "과학", "사회", "기가", "한국사", "일본어"};
		for(int i = 0; i < stu_num; i++) {
			System.out.println((i+1) + "번째 학생 입력");
			System.out.print("학번 : ");
			name_Num[i] = sc.next();
			System.out.print("이름 : ");
			name[i] = sc.next();

			for(int j = 0; j < subject[i].length - 1; j++) {
				do {
					System.out.print(sub_name[j] + " : ");
					subject[i][j] = sc.nextInt();
				} while(subject[i][j] < 0 || subject[i][j] > 100);

				subject[i][sub] += subject[i][j];
			}
			
			avg[i] = (double)subject[i][sub] / sub;

			switch((int)avg[i] / 10) {
			case 10 : case 9 : 
				result[i] ='A'; 
				break;
			case 8 : 
				result[i] ='B';
				break;
			case 7 : 
				result[i] ='C';
				break;
			case 6 :
				result[i] ='D';
				break;
			default : 
				result[i] = 'E';
			}
		}
		
		for(int i = 0; i < subject.length; i++) {
			for(int j = i+1; j < rank.length; j++) {
				if(subject[i][sub] < subject[j][sub]) rank[i]++;
				else if(subject[i][sub] > subject[j][sub]) rank[j]++;
			}
		}

		for(int i = 0; i < stu_num; i++) {
			System.out.printf("%4s %6s ",name_Num[i], name[i]);
			for(int j = 0; j < subject[i].length; j++)
				System.out.printf("%7d ", subject[i][j]);
			System.out.printf(" %9.2f %4c %4d\n", avg[i], result[i], rank[i]);
		}
	}
}