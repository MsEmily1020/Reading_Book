package setting;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.DriverManager;
import java.util.List;
import java.util.Map;

import javax.script.ScriptEngineManager;

import project.BaseFrame;

public class Setting {
	public Setting() throws Exception {
		var con = DriverManager.getConnection("jdbc:mysql://localhost/?serverTimezone=UTC&allowLoadLocalInfile=true", "root", "1234");
		var stmt = con.createStatement();
		
		stmt.execute("set global local_infile= 1");
		stmt.execute("drop schema if exists `store`");
		stmt.execute("CREATE SCHEMA `store` DEFAULT CHARACTER SET utf8 ;\r\n"
				+ "");
		
		stmt.execute("CREATE TABLE `store`.`declaration` (\r\n"
				+ "  `d_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `d_word` VARCHAR(100) NULL,\r\n"
				+ "  PRIMARY KEY (`d_no`));\r\n"
				+ "");
		
		stmt.execute("CREATE TABLE `store`.`genre` (\r\n"
				+ "  `g_no` INT NOT NULL,\r\n"
				+ "  `g_name` VARCHAR(10) NULL,\r\n"
				+ "  PRIMARY KEY (`g_no`));\r\n"
				+ "");
		
		stmt.execute("CREATE TABLE `store`.`picture` (\r\n"
				+ "  `p_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `p_picture` LONGBLOB NULL,\r\n"
				+ "  PRIMARY KEY (`p_no`));\r\n"
				+ "");
		
		stmt.execute("CREATE TABLE `store`.`word` (\r\n"
				+ "  `w_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `w_word` VARCHAR(4) NULL,\r\n"
				+ "  PRIMARY KEY (`w_no`));\r\n"
				+ "");
		
		stmt.execute("CREATE TABLE `store`.`company` (\r\n"
				+ "  `c_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `c_name` VARCHAR(20) NULL,\r\n"
				+ "  `p_no` INT NULL,\r\n"
				+ "  PRIMARY KEY (`c_no`),\r\n"
				+ "  INDEX `fk_company_picture_idx` (`p_no` ASC) VISIBLE,\r\n"
				+ "  CONSTRAINT `fk_company_picture`\r\n"
				+ "    FOREIGN KEY (`p_no`)\r\n"
				+ "    REFERENCES `store`.`picture` (`p_no`)\r\n"
				+ "    ON DELETE CASCADE\r\n"
				+ "    ON UPDATE CASCADE);\r\n"
				+ "");
		
		stmt.execute("CREATE TABLE `store`.`user` (\r\n"
				+ "  `u_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `u_name` VARCHAR(3) NULL,\r\n"
				+ "  `u_id` VARCHAR(15) NULL,\r\n"
				+ "  `u_pw` VARCHAR(15) NULL,\r\n"
				+ "  `u_phone` VARCHAR(14) NULL,\r\n"
				+ "  `u_birth` DATE NULL,\r\n"
				+ "  `p_no` INT NULL,\r\n"
				+ "  `c_no` INT NULL,\r\n"
				+ "  `u_point` INT NULL,\r\n"
				+ "  PRIMARY KEY (`u_no`),\r\n"
				+ "  INDEX `fk_user_picture_idx` (`p_no` ASC) VISIBLE,\r\n"
				+ "  INDEX `fk_user_company_idx` (`c_no` ASC) VISIBLE,\r\n"
				+ "  CONSTRAINT `fk_user_picture`\r\n"
				+ "    FOREIGN KEY (`p_no`)\r\n"
				+ "    REFERENCES `store`.`picture` (`p_no`)\r\n"
				+ "    ON DELETE CASCADE\r\n"
				+ "    ON UPDATE CASCADE,\r\n"
				+ "  CONSTRAINT `fk_user_company`\r\n"
				+ "    FOREIGN KEY (`c_no`)\r\n"
				+ "    REFERENCES `store`.`company` (`c_no`)\r\n"
				+ "    ON DELETE CASCADE\r\n"
				+ "    ON UPDATE CASCADE);\r\n"
				+ "");
		
		stmt.execute("CREATE TABLE `store`.`application` (\r\n"
				+ "  `a_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `a_name` VARCHAR(15) NULL,\r\n"
				+ "  `u_no` INT NULL,\r\n"
				+ "  `a_description` VARCHAR(300) NULL,\r\n"
				+ "  `a_price` INT NULL,\r\n"
				+ "  `a_use` VARCHAR(10) NULL,\r\n"
				+ "  `game_or_app` VARCHAR(5) NULL,\r\n"
				+ "  `p_no` INT NULL,\r\n"
				+ "  `a_genre` VARCHAR(100) NULL,\r\n"
				+ "  `a_recommend` INT NULL,\r\n"
				+ "  PRIMARY KEY (`a_no`),\r\n"
				+ "  INDEX `fk_application_user_idx` (`u_no` ASC) VISIBLE,\r\n"
				+ "  INDEX `fk_application_picture_idx` (`p_no` ASC) VISIBLE,\r\n"
				+ "  CONSTRAINT `fk_application_user`\r\n"
				+ "    FOREIGN KEY (`u_no`)\r\n"
				+ "    REFERENCES `store`.`user` (`u_no`)\r\n"
				+ "    ON DELETE CASCADE\r\n"
				+ "    ON UPDATE CASCADE,\r\n"
				+ "  CONSTRAINT `fk_application_picture`\r\n"
				+ "    FOREIGN KEY (`p_no`)\r\n"
				+ "    REFERENCES `store`.`picture` (`p_no`)\r\n"
				+ "    ON DELETE CASCADE\r\n"
				+ "    ON UPDATE CASCADE);\r\n"
				+ "");
		
		stmt.execute("CREATE TABLE `store`.`purchase` (\r\n"
				+ "  `ph_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `u_no` INT NULL,\r\n"
				+ "  `a_no` INT NULL,\r\n"
				+ "  PRIMARY KEY (`ph_no`),\r\n"
				+ "  INDEX `fk_purdchase_user_idx` (`u_no` ASC) VISIBLE,\r\n"
				+ "  INDEX `fk_purchase_application_idx` (`a_no` ASC) VISIBLE,\r\n"
				+ "  CONSTRAINT `fk_purchase_user`\r\n"
				+ "    FOREIGN KEY (`u_no`)\r\n"
				+ "    REFERENCES `store`.`user` (`u_no`)\r\n"
				+ "    ON DELETE CASCADE\r\n"
				+ "    ON UPDATE CASCADE,\r\n"
				+ "  CONSTRAINT `fk_purchase_application`\r\n"
				+ "    FOREIGN KEY (`a_no`)\r\n"
				+ "    REFERENCES `store`.`application` (`a_no`)\r\n"
				+ "    ON DELETE CASCADE\r\n"
				+ "    ON UPDATE CASCADE);\r\n"
				+ "");
		
		stmt.execute("CREATE TABLE `store`.`review` (\r\n"
				+ "  `r_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `u_no` INT NULL,\r\n"
				+ "  `a_no` INT NULL,\r\n"
				+ "  `r_star` INT NULL,\r\n"
				+ "  `r_review` VARCHAR(50) NULL,\r\n"
				+ "  PRIMARY KEY (`r_no`),\r\n"
				+ "  INDEX `fk_review_user_idx` (`u_no` ASC) VISIBLE,\r\n"
				+ "  INDEX `fk_review_application_idx` (`a_no` ASC) VISIBLE,\r\n"
				+ "  CONSTRAINT `fk_review_user`\r\n"
				+ "    FOREIGN KEY (`u_no`)\r\n"
				+ "    REFERENCES `store`.`user` (`u_no`)\r\n"
				+ "    ON DELETE CASCADE\r\n"
				+ "    ON UPDATE CASCADE,\r\n"
				+ "  CONSTRAINT `fk_review_application`\r\n"
				+ "    FOREIGN KEY (`a_no`)\r\n"
				+ "    REFERENCES `store`.`application` (`a_no`)\r\n"
				+ "    ON DELETE CASCADE\r\n"
				+ "    ON UPDATE CASCADE);\r\n"
				+ "");
		
		stmt.execute("ALTER TABLE `store`.`genre` \r\n"
				+ "CHANGE COLUMN `g_no` `g_no` INT NOT NULL AUTO_INCREMENT ;\r\n"
				+ "");
		
		stmt.execute("drop user if exists 'user'@'localhost'");
		stmt.execute("create user 'user'@'localhost' identified by '1234'");
		stmt.execute("grant select, insert, update, delete on `store`.* to 'user'@'localhost'");
		
		stmt.execute("use `store`");

		String[] tables = "declaration,genre,picture,word,company,user,application,purchase,review".split(",");

		for(var table : tables) {
			String json = new String(Files.readAllBytes(Paths.get("datafiles/" + table + ".json")));
			List list = (List)new ScriptEngineManager().getEngineByName("javascript").eval("Java.asJSONCompatible(" + json + ")");
			for(var item: list) {
				Map<String, String> map = (Map)item; 
				StringBuilder build = new StringBuilder("insert into " + table + "(");
				for(String key: map.keySet()) build.append(key + ", ");
				build.replace(build.length() - 2, build.length() - 1, ") values (");
				
				for(String key: map.keySet()) build.append((map.get(key) == "") ? "null, " : "\"" + map.get(key) +"\", ");
				build.replace(build.length() - 2, build.length() - 1, ")");
				System.out.println(build.toString());
				BaseFrame.update(build.toString());
			}
		}
	}

	public static void main(String[] args) {
		try {
			new Setting();
			BaseFrame.showInfo("셋팅 성공");
		} catch (Exception e) {
			e.printStackTrace();
			BaseFrame.showErr("셋팅 실패");
		}
	}
}
