package class2_1.file_ex.file02;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyEx {
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("C:\\Temp\\test.txt");
			FileWriter fw = new FileWriter("c:\\Temp\\test.out");
			int c;

			while ((c = fr.read()) != -1) {
				fw.write((char)c);
			}
			fr.close();
			fw.close();
		} catch (IOException e) {
			System.out.println("입출력 오류");
			return;
		}
		System.out.println("입출력 성공");
	}
}
