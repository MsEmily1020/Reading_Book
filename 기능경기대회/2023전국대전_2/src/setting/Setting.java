package setting;

import java.io.File;
import java.io.FileInputStream;
import java.sql.DriverManager;

import project.BaseFrame;

public class Setting {
	public Setting() throws Exception {
		var con = DriverManager.getConnection("jdbc:mysql://localhost/?serverTimezone=UTC&allowLoadLocalInfile=true", "root", "1234");
		var stmt = con.createStatement();
		
		stmt.execute("SET GLOBAL local_infile = 1");
		
		stmt.execute("DROP SCHEMA IF EXISTS `에더랜드`");
		stmt.execute("CREATE SCHEMA `에더랜드` DEFAULT CHARACTER SET utf8 ;");
		
		stmt.execute("CREATE TABLE `에더랜드`.`user` (\r\n"
				+ "  `UNO` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `id` VARCHAR(10) NULL,\r\n"
				+ "  `pw` VARCHAR(10) NULL,\r\n"
				+ "  `uname` VARCHAR(10) NULL,\r\n"
				+ "  `height` INT NULL,\r\n"
				+ "  `weight` INT NULL,\r\n"
				+ "  `birth` DATE NULL,\r\n"
				+ "  `email` VARCHAR(50) NULL,\r\n"
				+ "  `phone` VARCHAR(20) NULL,\r\n"
				+ "  PRIMARY KEY (`UNO`));\r\n"
				+ "");
		
		System.out.println("user 생성");
		
		stmt.execute("CREATE TABLE `에더랜드`.`rides` (\r\n"
				+ "  `RNO` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `Ridesname` VARCHAR(20) NULL,\r\n"
				+ "  `age` INT NULL,\r\n"
				+ "  `height1` INT NULL,\r\n"
				+ "  `weight1` INT NULL,\r\n"
				+ "  `weight2` INT NULL,\r\n"
				+ "  `closed` INT NULL,\r\n"
				+ "  `x` INT NULL,\r\n"
				+ "  `y` INT NULL,\r\n"
				+ "  `explanation` VARCHAR(100) NULL,\r\n"
				+ "  `image` LONGBLOB NULL,\r\n"
				+ "  PRIMARY KEY (`RNO`));\r\n"
				+ "");
		
		System.out.println("rides 생성");
		
		stmt.execute("CREATE TABLE `에더랜드`.`reservation` (\r\n"
				+ "  `RVNO` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `UNO` INT NULL,\r\n"
				+ "  `RNO` INT NULL,\r\n"
				+ "  `date` DATE NULL,\r\n"
				+ "  PRIMARY KEY (`RVNO`))\r\n"
				+ "");
		
		System.out.println("reservation 생성");
		
		stmt.execute("CREATE TABLE `에더랜드`.`ticket` (\r\n"
				+ "  `TNO` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `UNO` INT NULL,\r\n"
				+ "  `date` DATE NULL,\r\n"
				+ "  `division` INT NULL,\r\n"
				+ "  PRIMARY KEY (`TNO`));\r\n"
				+ "");
		
		System.out.println("ticket 생성");
		
		stmt.execute("CREATE TABLE `에더랜드`.`facilities` (\r\n"
				+ "  `FNO` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `division` INT NULL,\r\n"
				+ "  `x` INT NULL,\r\n"
				+ "  `y` INT NULL,\r\n"
				+ "  PRIMARY KEY (`FNO`));\r\n"
				+ "");
		
		System.out.println("facilities 생성");
		
		stmt.execute("ALTER TABLE `에더랜드`.`reservation` \r\n"
				+ "ADD INDEX `fk_reservation_user_idx` (`UNO` ASC) VISIBLE;\r\n"
				+ ";\r\n");
		
		stmt.execute("ALTER TABLE `에더랜드`.`reservation` \r\n"
				+ "ADD CONSTRAINT `fk_reservation_user`\r\n"
				+ "  FOREIGN KEY (`UNO`)\r\n"
				+ "  REFERENCES `에더랜드`.`user` (`UNO`)\r\n"
				+ "  ON DELETE CASCADE\r\n"
				+ "  ON UPDATE CASCADE;\r\n"
				+ "");
		
		stmt.execute("ALTER TABLE `에더랜드`.`reservation` \r\n"
				+ "ADD INDEX `fk_reservation_rides_idx` (`RNO` ASC) VISIBLE;\r\n"
				+ ";\r\n");
		
		stmt.execute("ALTER TABLE `에더랜드`.`reservation` \r\n"
				+ "ADD CONSTRAINT `fk_reservation_rides`\r\n"
				+ "  FOREIGN KEY (`RNO`)\r\n"
				+ "  REFERENCES `에더랜드`.`rides` (`RNO`)\r\n"
				+ "  ON DELETE CASCADE\r\n"
				+ "  ON UPDATE CASCADE;\r\n"
				+ "");
		
		stmt.execute("ALTER TABLE `에더랜드`.`ticket` \r\n"
				+ "ADD INDEX `fk_ticket_user_idx` (`UNO` ASC) VISIBLE;\r\n"
				+ ";\r\n");
		
		stmt.execute("ALTER TABLE `에더랜드`.`ticket` \r\n"
				+ "ADD CONSTRAINT `fk_ticket_user`\r\n"
				+ "  FOREIGN KEY (`UNO`)\r\n"
				+ "  REFERENCES `에더랜드`.`user` (`UNO`)\r\n"
				+ "  ON DELETE CASCADE\r\n"
				+ "  ON UPDATE CASCADE;\r\n"
				+ "");
		
		stmt.execute("DROP USER IF EXISTS 'user'@'localhost'");
		stmt.execute("CREATE USER 'user'@'localhost' IDENTIFIED BY '1234'");
		stmt.execute("GRANT SELECT, INSERT, UPDATE, DELETE ON `에더랜드`.* TO 'user'@'localhost'");
		
		stmt.execute("USE `에더랜드`");
		
		String[] tables = "user,facilities,rides,reservation,ticket".split(",");
		
		for (String table : tables) {
			stmt.execute("LOAD DATA LOCAL INFILE 'datafiles/" + table + ".txt'"
					+ " INTO TABLE " + table
					+ " fields TERMINATED BY '\\t'"
					+ " LINES TERMINATED BY '\\r\n'"
					+ " IGNORE 1 LINES");
		}
		
		var pst = con.prepareStatement("UPDATE rides SET image = ? WHERE RNO = ?");
		
		for (int i = 1; i <= 20; i++) {
			pst.setBlob(1, new FileInputStream(new File("datafiles/어트랙션/" + i + ".jpg")));
			pst.setInt(2, i);
			pst.executeUpdate();
		}

		System.out.println("data 셋팅");
	}
	
	public static void main(String[] args) {
		try {
			BaseFrame.showInfo("셋팅 성공");
			new Setting();
		} catch (Exception e) {
			BaseFrame.showErr("셋팅 실패");
			e.printStackTrace();
		}
	}
}
