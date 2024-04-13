package codingtest;

import java.util.Scanner;

class SectorForm90 {
	public double area(double r) {
		return 3.14 * r * r * 90/360;
	}
	
	public double circum(double r) {
		return 2 * 3.14 * r * 90/360 + r * 2;
	}
}

public class SectorForm {
	public static void main(String[] args) {
		SectorForm90 sectorForm = new SectorForm90();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("반지름 입력 : ");
		double r = sc.nextDouble();
		
		System.out.printf("반지름 %f인 부채꼴의 면적 : %f , 둘레 : %f", r, sectorForm.area(r), sectorForm.circum(r));
		
	}
}
