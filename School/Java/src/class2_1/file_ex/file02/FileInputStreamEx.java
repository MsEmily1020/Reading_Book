package class2_1.file_ex.file02;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamEx {
	public static void main(String[] args) {
		byte[] b = new byte[6];
		try {
			FileInputStream fin = new FileInputStream("c:\\Temp\\test.out");
			int n = 0, c;
			while((c = fin.read()) != -1) {
				b[n] = (byte)c;
				n++;
			}
			System.out.println("읽은 배열을 출력합니다.");
			for (int i = 0; i < b.length; i++) 
				System.out.print(b[i] + " ");
			System.out.println();
			fin.close();
		} catch(IOException e) {
			System.out.println("읽지 못했습니다");
		}
 	}
}
