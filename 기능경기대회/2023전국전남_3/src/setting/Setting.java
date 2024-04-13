package setting;

import java.sql.DriverManager;

import project.BaseFrame;

public class Setting {
	public Setting() throws Exception {
		var con = DriverManager.getConnection("jdbc:mysql://localhost/?serverTimezone=UTC&allowLoadLocalInfile=true", "root", "1234");
		var stmt = con.createStatement();
		
		stmt.execute("set global local_infile = 1");
		
		stmt.execute("drop schema if exists `rider`");
		stmt.execute("CREATE SCHEMA `rider` DEFAULT CHARACTER SET utf8 ;\r\n"
				+ "");

		stmt.execute("CREATE TABLE `rider`.`customer` (\r\n"
				+ "  `c_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `c_id` VARCHAR(10) NULL,\r\n"
				+ "  `c_pw` VARCHAR(10) NULL,\r\n"
				+ "  `c_name` VARCHAR(5) NULL,\r\n"
				+ "  PRIMARY KEY (`c_no`));\r\n"
				+ "");
		
		stmt.execute("CREATE TABLE `rider`.`rider` (\r\n"
				+ "  `ri_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `ri_id` VARCHAR(10) NULL,\r\n"
				+ "  `ri_pw` VARCHAR(10) NULL,\r\n"
				+ "  `ri_name` VARCHAR(5) NULL,\r\n"
				+ "  PRIMARY KEY (`ri_no`));\r\n"
				+ "");
		
		stmt.execute("CREATE TABLE `rider`.`view` (\r\n"
				+ "  `v_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `v_start` INT NULL,\r\n"
				+ "  `v_end` INT NULL,\r\n"
				+ "  `v_view` INT NULL,\r\n"
				+ "  PRIMARY KEY (`v_no`));\r\n"
				+ "");
		
		stmt.execute("CREATE TABLE `rider`.`restaurant` (\r\n"
				+ "  `r_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `r_name` VARCHAR(20) NULL,\r\n"
				+ "  `r_mini` INT NULL,\r\n"
				+ "  `r_take` VARCHAR(5) NULL,\r\n"
				+ "  `r_info` VARCHAR(100) NULL,\r\n"
				+ "  `r_num` INT NULL,\r\n"
				+ "  `x` INT NULL,\r\n"
				+ "  `y` INT NULL,\r\n"
				+ "  PRIMARY KEY (`r_no`));\r\n"
				+ "");
		
		stmt.execute("CREATE TABLE `rider`.`map` (\r\n"
				+ "  `ma_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `x` INT NULL,\r\n"
				+ "  `y` INT NULL,\r\n"
				+ "  PRIMARY KEY (`ma_no`));\r\n"
				+ "");
		
		stmt.execute("CREATE TABLE `rider`.`orderlist` (\r\n"
				+ "  `o_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `c_no` INT NULL,\r\n"
				+ "  `r_no` INT NULL,\r\n"
				+ "  `o_menu` VARCHAR(500) NULL,\r\n"
				+ "  `o_price` INT NULL,\r\n"
				+ "  `o_date` DATE NULL,\r\n"
				+ "  `o_add` INT NULL,\r\n"
				+ "  `o_badal` INT NULL,\r\n"
				+ "  `o_address` INT NULL,\r\n"
				+ "  PRIMARY KEY (`o_no`),\r\n"
				+ "  INDEX `fk_o_customer_idx` (`c_no` ASC) VISIBLE,\r\n"
				+ "  INDEX `fk_o_restaurant_idx` (`r_no` ASC) VISIBLE,\r\n"
				+ "  CONSTRAINT `fk_o_customer`\r\n"
				+ "    FOREIGN KEY (`c_no`)\r\n"
				+ "    REFERENCES `rider`.`customer` (`c_no`)\r\n"
				+ "    ON DELETE CASCADE\r\n"
				+ "    ON UPDATE CASCADE,\r\n"
				+ "  CONSTRAINT `fk_o_restaurant`\r\n"
				+ "    FOREIGN KEY (`r_no`)\r\n"
				+ "    REFERENCES `rider`.`restaurant` (`r_no`)\r\n"
				+ "    ON DELETE CASCADE\r\n"
				+ "    ON UPDATE CASCADE);\r\n"
				+ "");
		
		stmt.execute("CREATE TABLE `rider`.`menu` (\r\n"
				+ "  `m_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `r_no` INT NULL,\r\n"
				+ "  `m_menu` VARCHAR(20) NULL,\r\n"
				+ "  `m_sub1` VARCHAR(100) NULL,\r\n"
				+ "  `m_sub2` VARCHAR(100) NULL,\r\n"
				+ "  `m_sub3` VARCHAR(100) NULL,\r\n"
				+ "  `m_price` INT NULL,\r\n"
				+ "  `m_num` INT NULL,\r\n"
				+ "  PRIMARY KEY (`m_no`),\r\n"
				+ "  INDEX `fk_m_restaurant_idx` (`r_no` ASC) VISIBLE,\r\n"
				+ "  CONSTRAINT `fk_m_restaurant`\r\n"
				+ "    FOREIGN KEY (`r_no`)\r\n"
				+ "    REFERENCES `rider`.`restaurant` (`r_no`)\r\n"
				+ "    ON DELETE CASCADE\r\n"
				+ "    ON UPDATE CASCADE);\r\n"
				+ "");
		
		stmt.execute("CREATE TABLE `rider`.`information` (\r\n"
				+ "  `i_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `c_no` INT NULL,\r\n"
				+ "  `i_phone` VARCHAR(13) NULL,\r\n"
				+ "  `i_coupon` VARCHAR(100) NULL,\r\n"
				+ "  `i_mine` VARCHAR(100) NULL,\r\n"
				+ "  `i_address1` VARCHAR(100) NULL,\r\n"
				+ "  `i_address2` VARCHAR(100) NULL,\r\n"
				+ "  `x1` INT NULL,\r\n"
				+ "  `y1` INT NULL,\r\n"
				+ "  `x2` INT NULL,\r\n"
				+ "  `y2` INT NULL,\r\n"
				+ "  PRIMARY KEY (`i_no`),\r\n"
				+ "  INDEX `fk_i_customer_idx` (`c_no` ASC) VISIBLE,\r\n"
				+ "  CONSTRAINT `fk_i_customer`\r\n"
				+ "    FOREIGN KEY (`c_no`)\r\n"
				+ "    REFERENCES `rider`.`customer` (`c_no`)\r\n"
				+ "    ON DELETE CASCADE\r\n"
				+ "    ON UPDATE CASCADE);\r\n"
				+ "");
		
		stmt.execute("CREATE TABLE `rider`.`review` (\r\n"
				+ "  `re_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `o_no` INT NULL,\r\n"
				+ "  `re_detail` VARCHAR(200) NULL,\r\n"
				+ "  `re_store` INT NULL,\r\n"
				+ "  `re_date` DATE NULL,\r\n"
				+ "  PRIMARY KEY (`re_no`),\r\n"
				+ "  INDEX `fk_r_orderlist_idx` (`o_no` ASC) VISIBLE,\r\n"
				+ "  CONSTRAINT `fk_r_orderlist`\r\n"
				+ "    FOREIGN KEY (`o_no`)\r\n"
				+ "    REFERENCES `rider`.`orderlist` (`o_no`)\r\n"
				+ "    ON DELETE CASCADE\r\n"
				+ "    ON UPDATE CASCADE);\r\n"
				+ "");
		
		stmt.execute("CREATE TABLE `rider`.`cart` (\r\n"
				+ "  `ca_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `m_no` INT NULL,\r\n"
				+ "  `c_no` INT NULL,\r\n"
				+ "  `ca_add` VARCHAR(200) NULL,\r\n"
				+ "  `ca_price` INT NULL,\r\n"
				+ "  PRIMARY KEY (`ca_no`),\r\n"
				+ "  INDEX `fk_c_menu_idx` (`m_no` ASC) VISIBLE,\r\n"
				+ "  INDEX `fk_c_customer_idx` (`c_no` ASC) VISIBLE,\r\n"
				+ "  CONSTRAINT `fk_c_menu`\r\n"
				+ "    FOREIGN KEY (`m_no`)\r\n"
				+ "    REFERENCES `rider`.`menu` (`m_no`)\r\n"
				+ "    ON DELETE CASCADE\r\n"
				+ "    ON UPDATE CASCADE,\r\n"
				+ "  CONSTRAINT `fk_c_customer`\r\n"
				+ "    FOREIGN KEY (`c_no`)\r\n"
				+ "    REFERENCES `rider`.`customer` (`c_no`)\r\n"
				+ "    ON DELETE CASCADE\r\n"
				+ "    ON UPDATE CASCADE);\r\n"
				+ "");
		
		stmt.execute("use `rider`");
		
		stmt.execute("drop user if exists 'user'@'localhost'");
		stmt.execute("create user 'user'@'localhost' identified by '1234'");
		stmt.execute("grant select, insert, update, delete on `rider`.* to 'user'@'localhost'");
		
		String[] tables = "customer,rider,view,restaurant,map,orderlist,menu,information,review,cart".split(",");
		for (String table : tables) {
			stmt.execute("load data local infile 'datafiles/" + table + ".txt'"
					+ " into table " + table 
					+ " fields terminated by '\\t'"
					+ " lines terminated by '\\r\n'"
					+ " ignore 1 lines");
		}
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
