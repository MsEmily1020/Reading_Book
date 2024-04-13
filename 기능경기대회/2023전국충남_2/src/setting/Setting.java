package setting;

import java.sql.DriverManager;

import project.BaseFrame;

public class Setting {
	public Setting() throws Exception {
		var con = DriverManager.getConnection("jdbc:mysql://localhost/?serverTimezone=UTC&allowLoadLocalInfile=true", "root", "1234");
		var stmt = con.createStatement();
		stmt.execute("set global local_infile = 1");
		stmt.execute("drop schema if exists `2023전국_2`");
		stmt.execute("CREATE SCHEMA `2023전국_2` DEFAULT CHARACTER SET utf8 ;\r\n"
				+ "");
		
		stmt.execute("CREATE TABLE `2023전국_2`.`user` (\r\n"
				+ "  `u_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `u_id` VARCHAR(20) NULL,\r\n"
				+ "  `u_pw` VARCHAR(20) NULL,\r\n"
				+ "  `u_name` VARCHAR(10) NULL,\r\n"
				+ "  `u_gender` INT NULL,\r\n"
				+ "  `u_like` VARCHAR(30) NULL,\r\n"
				+ "  `u_point` INT NULL,\r\n"
				+ "  `u_logindate` DATE NULL,\r\n"
				+ "  PRIMARY KEY (`u_no`));\r\n"
				+ "");
		
		stmt.execute("CREATE TABLE `2023전국_2`.`categories` (\r\n"
				+ "  `c_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `c_name` VARCHAR(20) NULL,\r\n"
				+ "  `c_saletime` TIME NULL,\r\n"
				+ "  `c_discount` DOUBLE NULL,\r\n"
				+ "  PRIMARY KEY (`c_no`));\r\n"
				+ "");
	
		stmt.execute("CREATE TABLE `2023전국_2`.`goods` (\r\n"
				+ "  `g_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `g_name` VARCHAR(30) NULL,\r\n"
				+ "  `g_date` DATE NULL,\r\n"
				+ "  `c_no` INT NULL,\r\n"
				+ "  `g_gender` INT NULL,\r\n"
				+ "  `g_price` INT NULL,\r\n"
				+ "  `g_people` INT NULL,\r\n"
				+ "  `g_stock` INT NULL,\r\n"
				+ "  `g_advertisement` VARCHAR(100) NULL,\r\n"
				+ "  `g_sale` DOUBLE NULL,\r\n"
				+ "  `g_img` LONGBLOB NULL,\r\n"
				+ "  PRIMARY KEY (`g_no`),\r\n"
				+ "  INDEX `fk_goods_categories_idx` (`c_no` ASC) VISIBLE,\r\n"
				+ "  CONSTRAINT `fk_goods_categories`\r\n"
				+ "    FOREIGN KEY (`c_no`)\r\n"
				+ "    REFERENCES `2023전국_2`.`categories` (`c_no`)\r\n"
				+ "    ON DELETE CASCADE\r\n"
				+ "    ON UPDATE CASCADE);\r\n"
				+ "");
		
		stmt.execute("CREATE TABLE `2023전국_2`.`account` (\r\n"
				+ "  `a_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `u_no` INT NULL,\r\n"
				+ "  `restore` INT NULL,\r\n"
				+ "  PRIMARY KEY (`a_no`),\r\n"
				+ "  INDEX `fk_account_user_idx` (`u_no` ASC) VISIBLE,\r\n"
				+ "  CONSTRAINT `fk_account_user`\r\n"
				+ "    FOREIGN KEY (`u_no`)\r\n"
				+ "    REFERENCES `2023전국_2`.`user` (`u_no`)\r\n"
				+ "    ON DELETE CASCADE\r\n"
				+ "    ON UPDATE CASCADE);\r\n"
				+ "");
		
		stmt.execute("CREATE TABLE `2023전국_2`.`groupbying` (\r\n"
				+ "  `gb_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `u_no` INT NULL,\r\n"
				+ "  `g_no` INT NULL,\r\n"
				+ "  PRIMARY KEY (`gb_no`),\r\n"
				+ "  INDEX `fk_g_user_idx` (`u_no` ASC) VISIBLE,\r\n"
				+ "  INDEX `fk_g_g_idx` (`g_no` ASC) VISIBLE,\r\n"
				+ "  CONSTRAINT `fk_g_user`\r\n"
				+ "    FOREIGN KEY (`u_no`)\r\n"
				+ "    REFERENCES `2023전국_2`.`user` (`u_no`)\r\n"
				+ "    ON DELETE CASCADE\r\n"
				+ "    ON UPDATE CASCADE,\r\n"
				+ "  CONSTRAINT `fk_g_g`\r\n"
				+ "    FOREIGN KEY (`g_no`)\r\n"
				+ "    REFERENCES `2023전국_2`.`goods` (`g_no`)\r\n"
				+ "    ON DELETE CASCADE\r\n"
				+ "    ON UPDATE CASCADE);\r\n"
				+ "");
		
		stmt.execute("CREATE TABLE `2023전국_2`.`purchase` (\r\n"
				+ "  `p_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `u_no` INT NULL,\r\n"
				+ "  `g_no` INT NULL,\r\n"
				+ "  `p_quantity` INT NULL,\r\n"
				+ "  `p_amount` INT NULL,\r\n"
				+ "  `p_state` INT NULL,\r\n"
				+ "  PRIMARY KEY (`p_no`),\r\n"
				+ "  INDEX `fk_p_user_idx` (`u_no` ASC) VISIBLE,\r\n"
				+ "  INDEX `fk_p_goods_idx` (`g_no` ASC) VISIBLE,\r\n"
				+ "  CONSTRAINT `fk_p_user`\r\n"
				+ "    FOREIGN KEY (`u_no`)\r\n"
				+ "    REFERENCES `2023전국_2`.`user` (`u_no`)\r\n"
				+ "    ON DELETE CASCADE\r\n"
				+ "    ON UPDATE CASCADE,\r\n"
				+ "  CONSTRAINT `fk_p_goods`\r\n"
				+ "    FOREIGN KEY (`g_no`)\r\n"
				+ "    REFERENCES `2023전국_2`.`goods` (`g_no`)\r\n"
				+ "    ON DELETE CASCADE\r\n"
				+ "    ON UPDATE CASCADE);\r\n"
				+ "");
		
		stmt.execute("CREATE TABLE `2023전국_2`.`secession` (\r\n"
				+ "  `s_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `u_no` INT NULL,\r\n"
				+ "  `s_reason` VARCHAR(300) NULL,\r\n"
				+ "  PRIMARY KEY (`s_no`),\r\n"
				+ "  INDEX `fk_s_user_idx` (`u_no` ASC) VISIBLE,\r\n"
				+ "  CONSTRAINT `fk_s_user`\r\n"
				+ "    FOREIGN KEY (`u_no`)\r\n"
				+ "    REFERENCES `2023전국_2`.`user` (`u_no`)\r\n"
				+ "    ON DELETE CASCADE\r\n"
				+ "    ON UPDATE CASCADE);\r\n"
				+ "");
		
		stmt.execute("CREATE TABLE `2023전국_2`.`shoppingbasket` (\r\n"
				+ "  `b_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `u_no` INT NULL,\r\n"
				+ "  `g_no` INT NULL,\r\n"
				+ "  PRIMARY KEY (`b_no`),\r\n"
				+ "  INDEX `fk_s_user_idx` (`u_no` ASC) VISIBLE,\r\n"
				+ "  INDEX `fk_s_goods_idx` (`g_no` ASC) VISIBLE,\r\n"
				+ "  CONSTRAINT `fk_sh_user`\r\n"
				+ "    FOREIGN KEY (`u_no`)\r\n"
				+ "    REFERENCES `2023전국_2`.`user` (`u_no`)\r\n"
				+ "    ON DELETE CASCADE\r\n"
				+ "    ON UPDATE CASCADE,\r\n"
				+ "  CONSTRAINT `fk_s_goods`\r\n"
				+ "    FOREIGN KEY (`g_no`)\r\n"
				+ "    REFERENCES `2023전국_2`.`goods` (`g_no`)\r\n"
				+ "    ON DELETE CASCADE\r\n"
				+ "    ON UPDATE CASCADE);\r\n"
				+ "");

		stmt.execute("drop user if exists 'user'@'localhost'");
		stmt.execute("create user 'user'@'localhost' identified by '1234'");
		stmt.execute("grant select, insert, update, delete on `2023전국_2`.* to 'user'@'localhost'");
		
		stmt.execute("use `2023전국_2`");
		
		String[] tables = "user,categories,goods,account,groupbying,purchase,secession,shoppingbasket".split(",");
		
		for(var table : tables) {
			stmt.execute("load data local infile 'datafiles/" + table + ".txt'"
					+ " into table " + table
					+ " fields terminated by '\\t'"
					+ " lines terminated by '\\r\n'"
					+ " ignore 1 lines");
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
