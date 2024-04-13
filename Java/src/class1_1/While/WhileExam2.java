package class1_1.While;
import java.util.Scanner;

public class WhileExam2{
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("몇까지의 숫자를 돌리겠습니까?");
		int final_num = sc.nextInt();
	
		int i= 1, sum = 0;
		while(i <= final_num) {
			if(i % 2 == 0) {
				sum -= i;
				System.out.print((i == final_num)?("-"+i):("-" + i + "+"));
				
			} else {
				sum += i;	
				System.out.print(i);
			}
			i++;
		}

		System.out.println("=" + sum);
	}
}