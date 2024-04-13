package class2_1.file_ex.file04;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryCopyEx {
	public static void main(String[] args) {
		File src = new File("./src/class2_1/file_ex/file03/forest.jpg");
		File dest = new File("./src/class2_1/file_ex/file04/copyforest.jpg");
		int c;
		try {
			FileInputStream fi = new FileInputStream(src);
			FileOutputStream fo = new FileOutputStream(dest);
			while((c = fi.read()) != -1) {
				fo.write((byte)c);
			}
			fo.close();
			fi.close();
			System.out.println(src.getPath() + "를 " + dest.getParent() + "로 복사함");
		} catch(IOException e) {
			e.printStackTrace();
			System.out.println("파일 오류");
		}
	}
}
