package class2_1.file_ex.file06;

import java.io.IOException;

public class WritingDatasMain {
	public static void main(String[] args) {
		sungDataRWExam wd = new sungDataRWExam();
		try {
			wd.readingData("c:\\Temp\\writed.txt");
			wd.writingData("c:\\Temp\\writing.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}