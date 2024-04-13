package setting;

import java.io.File;
import java.io.FileInputStream;
import java.sql.DriverManager;

import pro.BaseFrame;

public class Setting {
	static void initDB() throws Exception {
		var con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/?serverTimezone=UTC&allowLoadLocalInfile=true", "root", "1234");
		var stmt = con.createStatement();
		
		stmt.execute("SET GLOBAL local_infile = 1");
		stmt.execute("DROP SCHEMA IF EXISTS `2023지방_2`");
		stmt.execute("CREATE SCHEMA `2023지방_2` DEFAULT CHARACTER SET utf8 ;");
		
		stmt.execute("CREATE TABLE `2023지방_2`.`division` (\r\n"
				+ "  `d_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `d_name` VARCHAR(50) NULL,\r\n"
				+ "  PRIMARY KEY (`d_no`));\r\n"   
				+ "");
		
		System.out.println("division 생성");
		
		stmt.execute("CREATE TABLE `2023지방_2`.`user` (\r\n"
				+ "  `u_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `u_name` VARCHAR(5) NULL,\r\n"
				+ "  `u_id` VARCHAR(10) NULL,\r\n"
				+ "  `u_pw` VARCHAR(10) NULL,\r\n"
				+ "  PRIMARY KEY (`u_no`));\r\n"
				+ "");
		
		System.out.println("user 생성");
		
		stmt.execute("CREATE TABLE `2023지방_2`.`book` (\r\n"
				+ "  `b_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `b_name` VARCHAR(50) NULL,\r\n"
				+ "  `d_no` INT NULL,\r\n"
				+ "  `b_author` VARCHAR(50) NULL,\r\n"
				+ "  `b_count` INT NULL,\r\n"
				+ "  `b_page` INT NULL,\r\n"
				+ "  `b_exp` VARCHAR(500) NULL,\r\n"
				+ "  `b_img` LONGBLOB NULL,\r\n"
				+ "  PRIMARY KEY (`b_no`));\r\n"
				+ "");
		
		System.out.println("book 생성");
		
		stmt.execute("CREATE TABLE `2023지방_2`.`likebook` (\r\n"
				+ "  `l_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `u_no` INT NULL,\r\n"
				+ "  `b_no` INT NULL,\r\n"
				+ "  PRIMARY KEY (`l_no`));\r\n"
				+ "");
		
		System.out.println("likebook 생성");
		
		stmt.execute("CREATE TABLE `2023지방_2`.`rental` (\r\n"
				+ "  `r_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `u_no` INT NULL,\r\n"
				+ "  `b_no` INT NULL,\r\n"
				+ "  `r_date` DATE NULL,\r\n"
				+ "  `r_count` INT NULL,\r\n"
				+ "  `r_reading` INT NULL,\r\n"
				+ "  `r_returnday` DATE NULL,\r\n"
				+ "  PRIMARY KEY (`r_no`));");
		
		System.out.println("rental 생성");
	
		stmt.execute("ALTER TABLE `2023지방_2`.`book` \r\n"
				+ "ADD INDEX `fk_book_division_idx` (`d_no` ASC) VISIBLE;\r\n"
				+ ";\r\n");
		
		stmt.execute("ALTER TABLE `2023지방_2`.`book` \r\n"
				+ "ADD CONSTRAINT `fk_book_division`\r\n"
				+ "  FOREIGN KEY (`d_no`)\r\n"
				+ "  REFERENCES `2023지방_2`.`division` (`d_no`)\r\n"
				+ "  ON DELETE CASCADE\r\n"
				+ "  ON UPDATE CASCADE;\r\n"
				+ "");
		
		stmt.execute("ALTER TABLE `2023지방_2`.`likebook` \r\n"
				+ "ADD INDEX `fk_likebook_user_idx` (`u_no` ASC) VISIBLE;\r\n"
				+ ";\r\n");
		
		stmt.execute("ALTER TABLE `2023지방_2`.`likebook` \r\n"
				+ "ADD CONSTRAINT `fk_likebook_user`\r\n"
				+ "  FOREIGN KEY (`u_no`)\r\n"
				+ "  REFERENCES `2023지방_2`.`user` (`u_no`)\r\n"
				+ "  ON DELETE CASCADE\r\n"
				+ "  ON UPDATE CASCADE;");
		
		stmt.execute("ALTER TABLE `2023지방_2`.`likebook` \r\n"
				+ "ADD INDEX `fk_likebook_book_idx` (`b_no` ASC) VISIBLE;\r\n"
				+ ";\r\n");
		
		stmt.execute("ALTER TABLE `2023지방_2`.`likebook` \r\n"
				+ "ADD CONSTRAINT `fk_likebook_book`\r\n"
				+ "  FOREIGN KEY (`b_no`)\r\n"
				+ "  REFERENCES `2023지방_2`.`book` (`b_no`)\r\n"
				+ "  ON DELETE CASCADE\r\n"
				+ "  ON UPDATE CASCADE;");
		
		stmt.execute("ALTER TABLE `2023지방_2`.`rental` \r\n"
				+ "ADD INDEX `fk_rental_user_idx` (`u_no` ASC) VISIBLE,\r\n"
				+ "ADD INDEX `fk_rental_book_idx` (`b_no` ASC) VISIBLE;\r\n"
				+ ";\r\n");
		
		stmt.execute("ALTER TABLE `2023지방_2`.`rental` \r\n"
				+ "ADD CONSTRAINT `fk_rental_user`\r\n"
				+ "  FOREIGN KEY (`u_no`)\r\n"
				+ "  REFERENCES `2023지방_2`.`user` (`u_no`)\r\n"
				+ "  ON DELETE CASCADE\r\n"
				+ "  ON UPDATE CASCADE,\r\n"
				+ "ADD CONSTRAINT `fk_rental_book`\r\n"
				+ "  FOREIGN KEY (`b_no`)\r\n"
				+ "  REFERENCES `2023지방_2`.`book` (`b_no`)\r\n"
				+ "  ON DELETE CASCADE\r\n"
				+ "  ON UPDATE CASCADE;");
		
		stmt.execute("DROP USER IF EXISTS 'user'@'127.0.0.1'");
		stmt.execute("CREATE USER 'user'@'127.0.0.1' IDENTIFIED BY '1234'");
		stmt.execute("GRANT SELECT, INSERT, UPDATE, DELETE ON `2023지방_2`.* TO 'user'@'127.0.0.1'");
		
		stmt.execute("USE `2023지방_2`");
		
		String[] tables = {
				"division",
				"user",
				"book",
				"likebook",
				"rental"
		};
		
		for (String table : tables) {
			stmt.execute("LOAD DATA LOCAL INFILE 'datafiles/" + table + ".txt'"
					+ " INTO TABLE " + table
					+ " LINES TERMINATED BY '\\r\\n'"
					+ " IGNORE 1 LINES");
		}
		
		var pst = con.prepareStatement("UPDATE book SET b_img = ? WHERE b_no = ?");
		
		for (int i = 1; i <= 100; i++) {
			pst.setBlob(1, new FileInputStream(new File("datafiles/book/" + i + ".jpg")));
			pst.setInt(2, i);
			pst.executeUpdate();
		}
	}
	
	public static void main(String[] args) {
		try {
			BaseFrame.showInfo("셋팅 성공");
			initDB();
		} catch (Exception e) {
			BaseFrame.showErr("셋팅 실패");
			e.printStackTrace();
		}
	}
}
