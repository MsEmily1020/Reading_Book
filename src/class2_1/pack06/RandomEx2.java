/*
 * 주사위의 눈의 수는 1~6사이
 * 주사위 10번 던져 전체 금액 계산
 * 
 * 1 : 500원
 * 2 : 700원
 * 3 : 1200원
 * 4 : 1800원
 * 5 : 2100원
 * 6 : 3000원 
 */

package class2_1.pack06;

public class RandomEx2 {
	public static void main(String[] args) {
		int[] price = { 500, 700, 1200, 1800, 2100, 3000 };
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			int random = (int)(Math.random() * 6 + 1);
			System.out.print(random + " ");
			sum += price[random - 1];
		}
		System.out.println();
		System.out.println(sum);
	}
}
