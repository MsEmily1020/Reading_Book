package class2_1.file_ex.file01;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReadHangulSuccess {
	public static void main(String[] args) {
		FileInputStream fin = null;
		InputStreamReader in = null;
		
		try {
			// system.ini파일을 가리킴, 데이터 charset : UTF-8
			fin = new FileInputStream("C:\\windows\\system.ini");
			// UTF-8 -> MS949 형식으로 변환시킨 파일
			in = new InputStreamReader(fin, "MS949");
			// in = new InputStreamReader(fin, "US-ASCII");
			int c;
			
			// 결과 : MS949 인코딩
			System.out.println("인코딩 문자 집합은 " + in.getEncoding());
			while ((c = in.read()) != -1) {
				System.out.print((char)c);
			}
			in.close();	// 객체 생성 역순으로 닫음
			fin.close();
		} catch (IOException e) {
			System.out.println("입출력 오류");
		}
	}
}
