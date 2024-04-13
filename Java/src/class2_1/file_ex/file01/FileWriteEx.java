package class2_1.file_ex.file01;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriteEx {
	public static void main(String[] args) {
		// Scanner : 키보드로 부터 데이터 입력받기
		Scanner sc = new Scanner(System.in);
		FileWriter fout = null;
		try {
			fout = new FileWriter("c:\\Temp\\test.txt");
			while(true) {
				String line = sc.nextLine();	// 줄 단위로 데이터 입력
				if(line.length() == 0) break;	// 콘솔창에서 데이터 입력x, 엔터 -> 종료
				fout.write(line, 0, line.length());
				fout.write("\r\n", 0, 2);
			}
			fout.close();
		} catch (IOException e) {
			System.out.println("입출력 오류");
		}
		sc.close();
	}
}
