package class1_1.While;
import java.util.Scanner;

public class Currency_12061 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int money = sc.nextInt();
	
		int won = 50000;
		boolean flag = true;

		while(true) {
			System.out.println(won + "원권" + (money/won) + "매");
			money = (money % won);
			if(flag == true) won = won / 5;
		
			else won = won/2;
			flag = !flag;
			if(won == 0) break;

		}	
	}
}