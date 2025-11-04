package ch20.oracle.sec07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BoardUpdateExample {
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
			String sql = new StringBuilder()
					.append("UPDATE boards SET ")
					.append("btitle=?, bcontent=?, bfilename=?, bfiledata=? ")
					.append("WHERE bno=?")
					.toString();
			
			//2. Prepared Statement 준비하고
			PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"bno"});
			pstmt.setString(1, "눈사람");
			pstmt.setString(2, "눈으로 만든 사람");
			pstmt.setString(3, "snowman.jpg");
			pstmt.setBlob(4,BoardUpdateExample.class.getResourceAsStream("snowman.jpg"));
			pstmt.setInt(5, 2);
			
			//3. Prepared Statement 실행하고
			int rows = pstmt.executeUpdate();
			
			//4. 결과 확인
			System.out.println("수정된 행 수: " + rows);
			
			//5. Prepared Statement 종료
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
