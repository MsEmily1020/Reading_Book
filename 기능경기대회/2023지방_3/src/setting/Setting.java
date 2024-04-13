package setting;

import java.sql.DriverManager;

import project.BaseFrame;

public class Setting {
	static void initDB() throws Exception {
		var con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/?serverTimezone=UTC&allowLoadLocalInfile=true", "root", "1234");
		var stmt = con.createStatement();
		
		stmt.execute("SET GLOBAL local_infile = 1");
		stmt.execute("DROP SCHEMA IF EXISTS `2023지방_3`");
		stmt.execute("CREATE SCHEMA `2023지방_3` DEFAULT CHARACTER SET utf8 ;");
		
		stmt.execute("CREATE TABLE `2023지방_3`.`user` (\r\n"
				+ "  `u_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `id` VARCHAR(20) NULL,\r\n"
				+ "  `pw` VARCHAR(20) NULL,\r\n"
				+ "  `name1` VARCHAR(20) NULL,\r\n"
				+ "  `name2` VARCHAR(20) NULL,\r\n"
				+ "  `birth` DATE NULL,\r\n"
				+ "  `mileage` INT NULL,\r\n"
				+ "  PRIMARY KEY (`u_no`));");
		
		System.out.println("user 생성");
		
		stmt.execute("CREATE TABLE `2023지방_3`.`continent` (\r\n"
				+ "  `c_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `c_name` VARCHAR(50) NULL,\r\n"
				+ "  `x` INT NULL,\r\n"
				+ "  `y` INT NULL,\r\n"
				+ "  PRIMARY KEY (`c_no`));\r\n"
				+ "");
		
		System.out.println("continent 생서");
		
		stmt.execute("CREATE TABLE `2023지방_3`.`nation` (\r\n"
				+ "  `n_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `c_no` INT NULL,\r\n"
				+ "  `code` VARCHAR(3) NULL,\r\n"
				+ "  `n_name` VARCHAR(20) NULL,\r\n"
				+ "  `x` INT NULL,\r\n"
				+ "  `y` INT NULL,\r\n"
				+ "  PRIMARY KEY (`n_no`));");
		
		System.out.println("nation 생성");
		
		stmt.execute("CREATE TABLE `2023지방_3`.`schedule` (\r\n"
				+ "  `s_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `date` DATE NULL,\r\n"
				+ "  `depart` INT NULL,\r\n"
				+ "  `arrival` INT NULL,\r\n"
				+ "  `departTime` TIME NULL,\r\n"
				+ "  `timeTaken` TIME NULL,\r\n"
				+ "  `price` INT NULL,\r\n"
				+ "  PRIMARY KEY (`s_no`));");
		System.out.println("schedule 생성");
		
		stmt.execute("CREATE TABLE `2023지방_3`.`reservation` (\r\n"
				+ "  `r_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `u_no` INT NULL,\r\n"
				+ "  `s_no` INT NULL,\r\n"
				+ "  `income` INT NULL,\r\n"
				+ "  `expense` INT NULL,\r\n"
				+ "  PRIMARY KEY (`r_no`));");
		
		System.out.println("reservation 생성");
		
		stmt.execute("CREATE TABLE `2023지방_3`.`boarding` (\r\n"
				+ "  `b_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `r_no` INT NULL,\r\n"
				+ "  `agegroup` INT NULL,\r\n"
				+ "  `b_name` VARCHAR(50) NULL,\r\n"
				+ "  `birth` DATE NULL,\r\n"
				+ "  `seat` VARCHAR(3) NULL,\r\n"
				+ "  PRIMARY KEY (`b_no`));");
		
		System.out.println("boarding 생성");
		
		stmt.execute("ALTER TABLE `2023지방_3`.`boarding` \r\n"
				+ "ADD INDEX `fk_boarding_reservation_idx` (`r_no` ASC) VISIBLE;\r\n"
				+ ";\r\n");
		
		stmt.execute("ALTER TABLE `2023지방_3`.`boarding` \r\n"
				+ "ADD CONSTRAINT `fk_boarding_reservation`\r\n"
				+ "  FOREIGN KEY (`r_no`)\r\n"
				+ "  REFERENCES `2023지방_3`.`reservation` (`r_no`)\r\n"
				+ "  ON DELETE CASCADE\r\n"
				+ "  ON UPDATE CASCADE;");
		
		stmt.execute("ALTER TABLE `2023지방_3`.`nation` \r\n"
				+ "ADD INDEX `fk_nation_continent_idx` (`c_no` ASC) VISIBLE;\r\n"
				+ ";\r\n");
		
		stmt.execute("ALTER TABLE `2023지방_3`.`nation` \r\n"
				+ "ADD CONSTRAINT `fk_nation_continent`\r\n"
				+ "  FOREIGN KEY (`c_no`)\r\n"
				+ "  REFERENCES `2023지방_3`.`continent` (`c_no`)\r\n"
				+ "  ON DELETE CASCADE\r\n"
				+ "  ON UPDATE CASCADE;");
				
		stmt.execute("ALTER TABLE `2023지방_3`.`reservation` \r\n"
				+ "ADD INDEX `fk_reservation_user_idx` (`u_no` ASC) VISIBLE,\r\n"
				+ "ADD INDEX `fk_reservation_schedule_idx` (`s_no` ASC) VISIBLE;\r\n"
				+ ";\r\n");
		
		stmt.execute("ALTER TABLE `2023지방_3`.`reservation` \r\n"
				+ "ADD CONSTRAINT `fk_reservation_user`\r\n"
				+ "  FOREIGN KEY (`u_no`)\r\n"
				+ "  REFERENCES `2023지방_3`.`user` (`u_no`)\r\n"
				+ "  ON DELETE CASCADE\r\n"
				+ "  ON UPDATE CASCADE,\r\n"
				+ "ADD CONSTRAINT `fk_reservation_schedule`\r\n"
				+ "  FOREIGN KEY (`s_no`)\r\n"
				+ "  REFERENCES `2023지방_3`.`schedule` (`s_no`)\r\n"
				+ "  ON DELETE CASCADE\r\n"
				+ "  ON UPDATE CASCADE;\r\n"
				+ "");
		
		stmt.execute("ALTER TABLE `2023지방_3`.`schedule` \r\n"
				+ "ADD INDEX `fk_schedule_depart_idx` (`depart` ASC) VISIBLE,\r\n"
				+ "ADD INDEX `fk_schedule_arrival_idx` (`arrival` ASC) VISIBLE;\r\n"
				+ ";\r\n");
		
		stmt.execute("ALTER TABLE `2023지방_3`.`schedule` \r\n"
				+ "ADD CONSTRAINT `fk_schedule_depart`\r\n"
				+ "  FOREIGN KEY (`depart`)\r\n"
				+ "  REFERENCES `2023지방_3`.`nation` (`n_no`)\r\n"
				+ "  ON DELETE CASCADE\r\n"
				+ "  ON UPDATE CASCADE,\r\n"
				+ "ADD CONSTRAINT `fk_schedule_arrival`\r\n"
				+ "  FOREIGN KEY (`arrival`)\r\n"
				+ "  REFERENCES `2023지방_3`.`nation` (`n_no`)\r\n"
				+ "  ON DELETE CASCADE\r\n"
				+ "  ON UPDATE CASCADE;");
		
		stmt.execute("DROP USER IF EXISTS 'user'@'127.0.0.1'");
		stmt.execute("CREATE USER 'user'@'127.0.0.1' IDENTIFIED BY '1234'");
		stmt.execute("GRANT SELECT, INSERT, UPDATE, DELETE ON `2023지방_3`.* TO 'user'@'127.0.0.1'");
		stmt.execute("USE `2023지방_3`");
		
		String[] tables = {
			"user",
			"continent",
			"nation",
			"schedule",
			"reservation",
			"boarding"
		};
		
		for (String table : tables) {
			stmt.execute("LOAD DATA LOCAL INFILE 'datafiles/" + table + ".txt'"
					+ " INTO TABLE " + table
					+ " character set 'utf8'"
					+ " LINES TERMINATED BY '\\r\\n'"
					+ " IGNORE 1 LINES");
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
