package class2_1.pack06;

public class MathEx {
	public static void main(String[] args) {
		System.out.println(Math.PI);
		System.out.println(Math.ceil(3.14));		// 올림값 (4)
		System.out.println(Math.floor(3.14));		// 내림값 (3)
		System.out.println(Math.sqrt(9));			// 제곱근 (3)
		System.out.println(Math.exp(2));			// 2.718282을 index만큼 제곱
		System.out.println(Math.round(3.14));		// 소수점 이하 첫째 자리에서 반올림
		
		System.out.print("이번주 행운의 번호는 ");
		for (int i = 0; i < 5; i++) {
			System.out.print((int)(Math.random() * 45 + 1) + " ");
		}
	}
}
