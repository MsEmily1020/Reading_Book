package setting;

import java.io.File;
import java.io.FileInputStream;
import java.sql.DriverManager;

import project.BaseFrame;

public class Setting {
	public Setting() throws Exception {
		var con = DriverManager.getConnection("jdbc:mysql://localhost/?serverTimezone=UTC&allowLoadLocalInfile=true", "root", "1234");
		var stmt = con.createStatement();
		
		stmt.execute("set global local_infile = 1");
		stmt.execute("drop schema if exists `2023전국_3`");
		stmt.execute("CREATE SCHEMA `2023전국_3` DEFAULT CHARACTER SET utf8 ;\r\n"
				+ "");
		
		stmt.execute("CREATE TABLE `2023전국_3`.`category` (\r\n"
				+ "  `c_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `c_division` VARCHAR(5) NULL,\r\n"
				+ "  `c_name` VARCHAR(20) NULL,\r\n"
				+ "  PRIMARY KEY (`c_no`));\r\n"
				+ "");
		
		stmt.execute("CREATE TABLE `2023전국_3`.`user` (\r\n"
				+ "  `u_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `u_name` VARCHAR(20) NULL,\r\n"
				+ "  `id` VARCHAR(20) NULL,\r\n"
				+ "  `pw` VARCHAR(20) NULL,\r\n"
				+ "  `birth` DATE NULL,\r\n"
				+ "  `height` INT NULL,\r\n"
				+ "  `weight` INT NULL,\r\n"
				+ "  PRIMARY KEY (`u_no`));\r\n"
				+ "");
		
		stmt.execute("CREATE TABLE `2023전국_3`.`product` (\r\n"
				+ "  `p_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `p_division` VARCHAR(20) NULL,\r\n"
				+ "  `p_name` VARCHAR(20) NULL,\r\n"
				+ "  `c_no` INT NULL,\r\n"
				+ "  `price` INT NULL,\r\n"
				+ "  `S` INT NULL,\r\n"
				+ "  `M` INT NULL,\r\n"
				+ "  `L` INT NULL,\r\n"
				+ "  `XL` INT NULL,\r\n"
				+ "  `image` LONGBLOB NULL,\r\n"
				+ "  PRIMARY KEY (`p_no`),\r\n"
				+ "  INDEX `fk_p_category_idx` (`c_no` ASC) VISIBLE,\r\n"
				+ "  CONSTRAINT `fk_p_category`\r\n"
				+ "    FOREIGN KEY (`c_no`)\r\n"
				+ "    REFERENCES `2023전국_3`.`category` (`c_no`)\r\n"
				+ "    ON DELETE CASCADE\r\n"
				+ "    ON UPDATE CASCADE);\r\n"
				+ "");
		
		stmt.execute("CREATE TABLE `2023전국_3`.`purchase` (\r\n"
				+ "  `ph_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `u_no` INT NULL,\r\n"
				+ "  `p_no` INT NULL,\r\n"
				+ "  `date` DATE NULL,\r\n"
				+ "  `size` VARCHAR(20) NULL,\r\n"
				+ "  `state` INT NULL,\r\n"
				+ "  PRIMARY KEY (`ph_no`));\r\n"
				+ "");
		
		stmt.execute("CREATE TABLE `2023전국_3`.`review` (\r\n"
				+ "  `r_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `ph_no` INT NULL,\r\n"
				+ "  `detail` VARCHAR(500) NULL,\r\n"
				+ "  `grade` INT NULL,\r\n"
				+ "  PRIMARY KEY (`r_no`),\r\n"
				+ "  INDEX `fk_r_purchase_idx` (`ph_no` ASC) VISIBLE,\r\n"
				+ "  CONSTRAINT `fk_r_purchase`\r\n"
				+ "    FOREIGN KEY (`ph_no`)\r\n"
				+ "    REFERENCES `2023전국_3`.`purchase` (`ph_no`)\r\n"
				+ "    ON DELETE CASCADE\r\n"
				+ "    ON UPDATE CASCADE);\r\n"
				+ "");
		
		stmt.execute("CREATE TABLE `2023전국_3`.`basket` (\r\n"
				+ "  `b_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `u_no` INT NULL,\r\n"
				+ "  `p_no` INT NULL,\r\n"
				+ "  `szdiv` VARCHAR(30) NULL,\r\n"
				+ "  PRIMARY KEY (`b_no`),\r\n"
				+ "  INDEX `fk_b_user_idx` (`u_no` ASC) VISIBLE,\r\n"
				+ "  INDEX `fk_p_idx` (`p_no` ASC) VISIBLE,\r\n"
				+ "  CONSTRAINT `fk_b_user`\r\n"
				+ "    FOREIGN KEY (`u_no`)\r\n"
				+ "    REFERENCES `2023전국_3`.`user` (`u_no`)\r\n"
				+ "    ON DELETE CASCADE\r\n"
				+ "    ON UPDATE CASCADE,\r\n"
				+ "  CONSTRAINT `fk_b_product`\r\n"
				+ "    FOREIGN KEY (`p_no`)\r\n"
				+ "    REFERENCES `2023전국_3`.`product` (`p_no`)\r\n"
				+ "    ON DELETE CASCADE\r\n"
				+ "    ON UPDATE CASCADE);\r\n"
				+ "");

		stmt.execute("use `2023전국_3`");
		stmt.execute("drop user if exists 'user'@'localhost'");
		stmt.execute("create user 'user'@'localhost' identified by '1234'");
		stmt.execute("grant select, insert, update, delete on `2023전국_3`.* to 'user'@'localhost'");
		
		String[] tables = "category,user,product,purchase,review,basket".split(",");
		for(String table : tables) {
			stmt.execute("load data local infile 'datafiles/" + table + ".txt'"
					+ " into table " + table
					+ " fields terminated by '\\t'"
					+ " lines terminated by '\\r\n'"
					+ " ignore 1 lines");
		}
		
		var pst = con.prepareStatement("UPDATE product SET image = ? WHERE p_no = ?");
		
		for (int i = 1; i <= 100; i++) {
			pst.setBlob(1, new FileInputStream(new File("datafiles/product/" + i + ".jpg")));
			pst.setInt(2, i);
			pst.executeUpdate();
		}
	}
	
	public static void main(String[] args) {
		try {
			new Setting();
			BaseFrame.showInfo("셋팅 성공");
		} catch (Exception e) {
			BaseFrame.showErr("셋팅 실패");
			e.printStackTrace();
		}
	}
}
