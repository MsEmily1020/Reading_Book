package setting;

import java.io.File;
import java.io.FileInputStream;
import java.sql.DriverManager;

import project.BaseFrame;

public class Setting {
	public Setting() throws Exception {
		var con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/?serverTimezone=UTC&allowLoadLocalInfile=true", "root", "1234");
		var stmt = con.createStatement();
		
		stmt.execute("set global local_infile = 1");
		
		stmt.execute("drop schema if exists `vitamin`");
		stmt.execute("CREATE SCHEMA `vitamin` DEFAULT CHARACTER SET utf8 ;\r\n"
				+ "");
		
		stmt.execute("CREATE TABLE `vitamin`.`category` (\r\n"
				+ "  `c_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `c_name` VARCHAR(10) NULL,\r\n"
				+ "  PRIMARY KEY (`c_no`));\r\n"
				+ "");
		
		System.out.println("category 생성");
		
		stmt.execute("CREATE TABLE `vitamin`.`drugstore` (\r\n"
				+ "  `d_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `d_id` VARCHAR(10) NULL,\r\n"
				+ "  `d_pw` VARCHAR(10) NULL,\r\n"
				+ "  `d_name` VARCHAR(20) NULL,\r\n"
				+ "  `d_address` VARCHAR(100) NULL,\r\n"
				+ "  `d_x` INT NULL,\r\n"
				+ "  `d_y` INT NULL,\r\n"
				+ "  `d_img` LONGBLOB NULL,\r\n"
				+ "  PRIMARY KEY (`d_no`));\r\n"
				+ "");
		
		System.out.println("drugstore 생성");
		
		stmt.execute("CREATE TABLE `vitamin`.`food` (\r\n"
				+ "  `f_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `f_name` VARCHAR(10) NULL,\r\n"
				+ "  `f_tag` VARCHAR(100) NULL,\r\n"
				+ "  `division` VARCHAR(2) NULL,\r\n"
				+ "  PRIMARY KEY (`f_no`));\r\n"
				+ "");
		
		System.out.println("food 생성");
		
		stmt.execute("CREATE TABLE `vitamin`.`question` (\r\n"
				+ "  `q_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `q_detail` VARCHAR(100) NULL,\r\n"
				+ "  `division` VARCHAR(2) NULL,\r\n"
				+ "  `q_gender` INT NULL,\r\n"
				+ "  PRIMARY KEY (`q_no`));\r\n"
				+ "");
		
		System.out.println("question 생성");
		
		stmt.execute("CREATE TABLE `vitamin`.`user` (\r\n"
				+ "  `u_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `u_id` VARCHAR(10) NULL,\r\n"
				+ "  `u_pw` VARCHAR(10) NULL,\r\n"
				+ "  `u_name` VARCHAR(5) NULL,\r\n"
				+ "  `u_gender` INT NULL,\r\n"
				+ "  `u_age` INT NULL,\r\n"
				+ "  PRIMARY KEY (`u_no`));\r\n"
				+ "");
		
		System.out.println("user 생성");
		
		stmt.execute("CREATE TABLE `vitamin`.`product` (\r\n"
				+ "  `p_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `p_name` VARCHAR(30) NULL,\r\n"
				+ "  `p_detail` VARCHAR(500) NULL,\r\n"
				+ "  `c_no` INT NULL,\r\n"
				+ "  `p_price` INT NULL,\r\n"
				+ "  `p_discount` INT NULL,\r\n"
				+ "  `p_num` INT NULL,\r\n"
				+ "  PRIMARY KEY (`p_no`));\r\n"
				+ "");
		
		System.out.println("product 생성");
		
		stmt.execute("CREATE TABLE `vitamin`.`holding` (\r\n"
				+ "  `h_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `d_no` INT NULL,\r\n"
				+ "  `p_no` INT NULL,\r\n"
				+ "  PRIMARY KEY (`h_no`));\r\n"
				+ "");
		
		System.out.println("holding 생성");
		
		stmt.execute("CREATE TABLE `vitamin`.`item` (\r\n"
				+ "  `i_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `q_no` INT NULL,\r\n"
				+ "  `p_no` INT NULL,\r\n"
				+ "  `i_detail` VARCHAR(100) NULL,\r\n"
				+ "  `division` VARCHAR(2) NULL,\r\n"
				+ "  PRIMARY KEY (`i_no`));\r\n"
				+ "");
		
		System.out.println("item 생성");
		
		stmt.execute("CREATE TABLE `vitamin`.`orderlist` (\r\n"
				+ "  `o_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `u_no` INT NULL,\r\n"
				+ "  `p_no` INT NULL,\r\n"
				+ "  `o_count` INT NULL,\r\n"
				+ "  `d_no` INT NULL,\r\n"
				+ "  `o_find` INT NULL,\r\n"
				+ "  `o_push` INT NULL,\r\n"
				+ "  `o_date` DATE NULL,\r\n"
				+ "  PRIMARY KEY (`o_no`));\r\n"
				+ "");
		
		System.out.println("orderlist 생성");
		
		stmt.execute("CREATE TABLE `vitamin`.`result` (\r\n"
				+ "  `re_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `i_no` INT NULL,\r\n"
				+ "  `p_no` INT NULL,\r\n"
				+ "  `division` VARCHAR(2) NULL,\r\n"
				+ "  `u_no` INT NULL,\r\n"
				+ "  PRIMARY KEY (`re_no`));\r\n"
				+ "");
		
		System.out.println("result 생성");
		
		stmt.execute("CREATE TABLE `vitamin`.`review` (\r\n"
				+ "  `r_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `p_no` INT NULL,\r\n"
				+ "  `u_no` INT NULL,\r\n"
				+ "  `r_detail` VARCHAR(100) NULL,\r\n"
				+ "  `r_score` FLOAT NULL,\r\n"
				+ "  `r_incense` INT NULL,\r\n"
				+ "  `r_taste` INT NULL,\r\n"
				+ "  `r_effect` INT NULL,\r\n"
				+ "  `r_money` INT NULL,\r\n"
				+ "  `r_throat` INT NULL,\r\n"
				+ "  `r_open` INT NULL,\r\n"
				+ "  `r_date` DATE NULL,\r\n"
				+ "  PRIMARY KEY (`r_no`));\r\n"
				+ "");
		
		System.out.println("review 생성");
		
		stmt.execute("CREATE TABLE `vitamin`.`cart` (\r\n"
				+ "  `ca_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `p_no` INT NULL,\r\n"
				+ "  `u_no` INT NULL,\r\n"
				+ "  `ca_count` INT NULL,\r\n"
				+ "  PRIMARY KEY (`ca_no`));\r\n"
				+ "");
		
		System.out.println("cart 생성");
		
		stmt.execute("ALTER TABLE `vitamin`.`product` \r\n"
				+ "ADD INDEX `fk_product_category_idx` (`c_no` ASC) VISIBLE;\r\n"
				+ ";\r\n");
		
		stmt.execute("ALTER TABLE `vitamin`.`product` \r\n"
				+ "ADD CONSTRAINT `fk_product_category`\r\n"
				+ "  FOREIGN KEY (`c_no`)\r\n"
				+ "  REFERENCES `vitamin`.`category` (`c_no`)\r\n"
				+ "  ON DELETE CASCADE\r\n"
				+ "  ON UPDATE CASCADE;\r\n"
				+ "");
		
		stmt.execute("ALTER TABLE `vitamin`.`holding` \r\n"
				+ "ADD INDEX `fk_holding_drugstore_idx` (`d_no` ASC) VISIBLE,\r\n"
				+ "ADD INDEX `fk_holding_product_idx` (`p_no` ASC) VISIBLE;\r\n"
				+ ";\r\n");
		
		stmt.execute("ALTER TABLE `vitamin`.`holding` \r\n"
				+ "ADD CONSTRAINT `fk_holding_drugstore`\r\n"
				+ "  FOREIGN KEY (`d_no`)\r\n"
				+ "  REFERENCES `vitamin`.`drugstore` (`d_no`)\r\n"
				+ "  ON DELETE CASCADE\r\n"
				+ "  ON UPDATE CASCADE,\r\n"
				+ "ADD CONSTRAINT `fk_holding_product`\r\n"
				+ "  FOREIGN KEY (`p_no`)\r\n"
				+ "  REFERENCES `vitamin`.`product` (`p_no`)\r\n"
				+ "  ON DELETE CASCADE\r\n"
				+ "  ON UPDATE CASCADE;\r\n"
				+ "");
		
		stmt.execute("ALTER TABLE `vitamin`.`item` \r\n"
				+ "ADD INDEX `fk_item_question_idx` (`q_no` ASC) VISIBLE,\r\n"
				+ "ADD INDEX `fk_item_product_idx` (`p_no` ASC) VISIBLE;\r\n"
				+ ";\r\n");
		
		stmt.execute("ALTER TABLE `vitamin`.`item` \r\n"
				+ "ADD CONSTRAINT `fk_item_question`\r\n"
				+ "  FOREIGN KEY (`q_no`)\r\n"
				+ "  REFERENCES `vitamin`.`question` (`q_no`)\r\n"
				+ "  ON DELETE CASCADE\r\n"
				+ "  ON UPDATE CASCADE,\r\n"
				+ "ADD CONSTRAINT `fk_item_product`\r\n"
				+ "  FOREIGN KEY (`p_no`)\r\n"
				+ "  REFERENCES `vitamin`.`product` (`p_no`)\r\n"
				+ "  ON DELETE CASCADE\r\n"
				+ "  ON UPDATE CASCADE;\r\n"
				+ "");
		
		stmt.execute("ALTER TABLE `vitamin`.`orderlist` \r\n"
				+ "ADD INDEX `fk_orderlist_user_idx` (`u_no` ASC) VISIBLE,\r\n"
				+ "ADD INDEX `fk_orderlist_product_idx` (`p_no` ASC) VISIBLE,\r\n"
				+ "ADD INDEX `fk_orderlist_drugstore_idx` (`d_no` ASC) VISIBLE;\r\n"
				+ ";\r\n");
		
		stmt.execute("ALTER TABLE `vitamin`.`orderlist` \r\n"
				+ "ADD CONSTRAINT `fk_orderlist_user`\r\n"
				+ "  FOREIGN KEY (`u_no`)\r\n"
				+ "  REFERENCES `vitamin`.`user` (`u_no`)\r\n"
				+ "  ON DELETE CASCADE\r\n"
				+ "  ON UPDATE CASCADE,\r\n"
				+ "ADD CONSTRAINT `fk_orderlist_product`\r\n"
				+ "  FOREIGN KEY (`p_no`)\r\n"
				+ "  REFERENCES `vitamin`.`product` (`p_no`)\r\n"
				+ "  ON DELETE CASCADE\r\n"
				+ "  ON UPDATE CASCADE,\r\n"
				+ "ADD CONSTRAINT `fk_orderlist_drugstore`\r\n"
				+ "  FOREIGN KEY (`d_no`)\r\n"
				+ "  REFERENCES `vitamin`.`drugstore` (`d_no`)\r\n"
				+ "  ON DELETE CASCADE\r\n"
				+ "  ON UPDATE CASCADE;\r\n"
				+ "");
		
		stmt.execute("ALTER TABLE `vitamin`.`result` \r\n"
				+ "ADD INDEX `fk_result_item_idx` (`i_no` ASC) VISIBLE,\r\n"
				+ "ADD INDEX `fk_result_product_idx` (`p_no` ASC) VISIBLE,\r\n"
				+ "ADD INDEX `fk_result_user_idx` (`u_no` ASC) VISIBLE;\r\n"
				+ ";\r\n");
		
		stmt.execute("ALTER TABLE `vitamin`.`result` \r\n"
				+ "ADD CONSTRAINT `fk_result_item`\r\n"
				+ "  FOREIGN KEY (`i_no`)\r\n"
				+ "  REFERENCES `vitamin`.`item` (`i_no`)\r\n"
				+ "  ON DELETE CASCADE\r\n"
				+ "  ON UPDATE CASCADE,\r\n"
				+ "ADD CONSTRAINT `fk_result_product`\r\n"
				+ "  FOREIGN KEY (`p_no`)\r\n"
				+ "  REFERENCES `vitamin`.`product` (`p_no`)\r\n"
				+ "  ON DELETE CASCADE\r\n"
				+ "  ON UPDATE CASCADE,\r\n"
				+ "ADD CONSTRAINT `fk_result_user`\r\n"
				+ "  FOREIGN KEY (`u_no`)\r\n"
				+ "  REFERENCES `vitamin`.`user` (`u_no`)\r\n"
				+ "  ON DELETE CASCADE\r\n"
				+ "  ON UPDATE CASCADE;\r\n"
				+ "");
		
		stmt.execute("ALTER TABLE `vitamin`.`review` \r\n"
				+ "ADD INDEX `fk_review_product_idx` (`p_no` ASC) VISIBLE,\r\n"
				+ "ADD INDEX `fk_review_user_idx` (`u_no` ASC) VISIBLE;\r\n"
				+ ";\r\n");
		
		stmt.execute("ALTER TABLE `vitamin`.`review` \r\n"
				+ "ADD CONSTRAINT `fk_review_product`\r\n"
				+ "  FOREIGN KEY (`p_no`)\r\n"
				+ "  REFERENCES `vitamin`.`product` (`p_no`)\r\n"
				+ "  ON DELETE CASCADE\r\n"
				+ "  ON UPDATE CASCADE,\r\n"
				+ "ADD CONSTRAINT `fk_review_user`\r\n"
				+ "  FOREIGN KEY (`u_no`)\r\n"
				+ "  REFERENCES `vitamin`.`user` (`u_no`)\r\n"
				+ "  ON DELETE CASCADE\r\n"
				+ "  ON UPDATE CASCADE;\r\n"
				+ "");
		
		stmt.execute("ALTER TABLE `vitamin`.`cart` \r\n"
				+ "ADD INDEX `fk_cart_product_idx` (`p_no` ASC) VISIBLE,\r\n"
				+ "ADD INDEX `fk_cart_user_idx` (`u_no` ASC) VISIBLE;\r\n"
				+ ";\r\n");
		
		stmt.execute("ALTER TABLE `vitamin`.`cart` \r\n"
				+ "ADD CONSTRAINT `fk_cart_product`\r\n"
				+ "  FOREIGN KEY (`p_no`)\r\n"
				+ "  REFERENCES `vitamin`.`product` (`p_no`)\r\n"
				+ "  ON DELETE CASCADE\r\n"
				+ "  ON UPDATE CASCADE,\r\n"
				+ "ADD CONSTRAINT `fk_cart_user`\r\n"
				+ "  FOREIGN KEY (`u_no`)\r\n"
				+ "  REFERENCES `vitamin`.`user` (`u_no`)\r\n"
				+ "  ON DELETE CASCADE\r\n"
				+ "  ON UPDATE CASCADE;\r\n"
				+ "");
		
		stmt.execute("drop user if exists 'user'@'localhost'");
		stmt.execute("create user 'user'@'localhost' identified by '1234'");
		stmt.execute("grant select, insert, update, delete on `vitamin`.* to 'user'@'localhost'");
		
		System.out.println("user 생성");
		
		stmt.execute("use `vitamin`");
		
		String[] tables = "category,drugstore,food,question,user,product,holding,item,orderlist,result,review,cart".split(",");
		
		for(var table : tables) {
			stmt.execute("load data local infile 'datafiles/" + table + ".txt'"
					+ " into table " + table
					+ " fields terminated by '\\t'"
					+ " lines terminated by '\\r\n'"
					+ " ignore 1 lines");
		}
		
		var pst = con.prepareStatement("update drugstore set d_img = ? where d_no = ?");
		
		for(int i = 1; i <= 10; i++) {
			pst.setBlob(1, new FileInputStream(new File("datafiles/약국/" + i + ".PNG")));
			pst.setInt(2, i);
			pst.executeUpdate();
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
