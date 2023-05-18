package class2_1.file_ex.file03;

import java.io.BufferedOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BufferedIOEx {
	public static void main(String[] args) {
		FileReader fin = null;
		int c;
		try {
			fin = new FileReader("c:\\Temp\\test2.txt");
			// 5바이트로 지정 (default 값 : 8192바이트)
			BufferedOutputStream out = new BufferedOutputStream(System.out, 5);
			while((c = fin.read()) != -1) {
				out.write(c);
			}
			
			new Scanner(System.in).nextLine();
			out.flush();
			fin.close();
			out.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
