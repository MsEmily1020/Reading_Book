package class2_1.file_ex.file01;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx {
	public static void main(String[] args) {
		// fin : FIleReader클래스를 가리키는 객체변수로, 할당된 메모리는 없음
		FileReader fin = null;
		
		// try ~ catch : try 문장 실행 -> 오류 발생(없을 시 catch x) -> catch 문장 실행
		try {
			fin = new FileReader("C:\\windows\\system.ini");
			int c;
			// fin 한 문장씩 읽어 c에 저장 및 -1은 파일의 끝.
			// true을 반환하다가 -1 만나면 false만나고 종료함
			while ((c = fin.read()) != -1) {
				System.out.print((char)c);
			}
			fin.close();
		} catch (IOException e) {
			System.out.println("입출력 오류");
		}
	}
}
