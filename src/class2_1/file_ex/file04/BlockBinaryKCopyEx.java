package class2_1.file_ex.file04;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BlockBinaryKCopyEx {
	public static void main(String[] args) {
		File src = new File("./src/class2_1/file_ex/file03/forest.jpg");
		File dest = new File("./src/class2_1/file_ex/file04/blockcopyforest.jpg");
		try {
			FileInputStream fi = new FileInputStream(src);
			FileOutputStream fo = new FileOutputStream(dest);
			byte[] buf = new byte[1024 * 10]; // 1024 = 1KB -> 1024 * 10 = 10KB
			while(true) {
				int n = fi.read(buf);
				fo.write(buf, 0, n);
				System.out.println("n = " + n + ", buf.length = " + buf.length + "\n");
				if(n < buf.length) break;
			}
			fo.close();
			fi.close();
			System.out.println(src.getPath() + "를 " + dest.getPath() + "로 복사함");
		} catch(IOException e) {
			System.out.println("파일 오류");
		}
	}
}
