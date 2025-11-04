package ch20.oracle.sec06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardWithFileInsertExample {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/orcl", 
					"java", 
					"1111"
			);
			System.out.println("연결 성공");
			
			//1. SQL문 만들고
			String sql = "" +
					"INSERT INTO boards " + 
					"(bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata) " +
					"VALUES (SEQ_BNO.NEXTVAL, ?, ?, ?, SYSDATE, ?, ?)";
			
			//2. Prepared Statement 준비하고
			PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"bno"});
			pstmt.setString(1, "봄의 정원");
			pstmt.setString(2, "정원의 꽃이  예쁘네요");
			pstmt.setString(3, "spring");
			pstmt.setString(4, "spring.jpg");
			pstmt.setBlob(5,BoardWithFileInsertExample.class.getResourceAsStream("spring.jpg"));
			
			//3. Prepared Statement 실행하고
			int rows = pstmt.executeUpdate();
			
			//4. 결과 확인
			System.out.println("저장된 행 수: " + rows);
			if (rows == 1) {
				ResultSet rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					int bno = rs.getInt(1);
					System.out.println("저장된 bno: " + bno);
				}
				rs.close();
			}
			
			pstmt.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
					System.out.println("연결 끊김");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
