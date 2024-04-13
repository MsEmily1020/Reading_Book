package jdbc_practice;

import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTest {
	public static void main(String[] args) throws SQLException {
		//데이터베이스 -> 네트워크 연결(자원 만들기)
		//localhost = 내 컴퓨터 연결(그 밖. ip주소)
		var con = DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root", "1234");
		//sql전송기
		//var stmt = con.createStatement();
		//""문을 실행(김씨만 출력)
		//var rs = stmt.executeQuery(a lot 문제)("SELECT * FROM patient" + "WHERE p_id = '123' AND p_pw = '123'");
		var pstmt = con.prepareStatement("SELECT * FROM patient WHERE p_id = ? AND p_pw = ?");
		
		pstmt.setString(1, "patient1");
		pstmt.setString(2, "1001");
		
		var rs = pstmt.executeQuery();
		
		if(rs.next()) {
			System.out.println("로그인 성공");
		}
		
		else {
			System.out.println("로그인 실패");
		}
		
		//커서 이동...(데이터 true(false까지 데이터x) -> p_no++)
		//while 모든 데이터 출력
		//get(String, Int)("원하는 column 내용 갖고오기");
		/*
		while(rs.next()) {
			System.out.println(rs.getString("p_name"));
		}
		*/
		
		//GROUP BY : 기준 (기준 묶기) ------- COUNT(개수 세기), SUM(합계), AVG(평균)
		//JOIN -> 관계성이 있는 여러 테이블로 쿼리 실행
	}
}