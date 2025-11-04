package ch20.oracle.sec12;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import ch20.oracle.sec06.BoardWithFileInsertExample;
import ch20.oracle.sec09.exam01.Board;

public class BoardExample5 {
	private String hr = "----------------------------------------------------------------------";
	private String sharp = "#############";
	private Scanner scanner = new Scanner(System.in);
	private Connection conn;
	
	public BoardExample5() {
		//생성자에서는 연결 객체만 만들고, 실제 쿼리는 필요한 메소드에서...
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/orcl", 
					"java", 
					"1111"
			);
		} catch (Exception e) {
			e.printStackTrace();
			exit();
		}
	}

	public void list() {
		System.out.println();
		System.out.println("[게시물 목록]");
		System.out.println(hr);
		System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "writer", "date", "title");
		System.out.println(hr);
		
		//board 테이블의 게시물 정보
		try {
			String sql = "" +
					"SELECT bno, btitle, bcontent, bwriter, bdate " +
					"FROM boards " +
					"ORDER BY bno DESC";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				System.out.printf("%-6s%-12s%-16s%-40s\n", 
						board.getBno(), 
						board.getBwriter(), 
						board.getBdate(), 
						board.getBtitle());
			}
			
			rs.close();
			pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			exit();
		}
		// 아래에 메인 메뉴 출력
		mainMenu();
	}
	
	private void mainMenu() {
		System.out.println();
		System.out.println(hr);
		System.out.println("메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit");
		System.out.print("메뉴 선택: ");
		System.out.println();
		
		String menuNo = scanner.nextLine();
		System.out.println();
		
		switch (menuNo) {
			case "1" -> create();
			case "2" -> read();
			case "3" -> clear();
			case "4" -> exit();
		}
	}

	private void create() {
		//입력 받고
		Board board = new Board();
		System.out.println("[새 게시물 입력]");
		System.out.print("제목: ");
		board.setBtitle(scanner.nextLine());
		System.out.print("내용: ");
		board.setBcontent(scanner.nextLine());;
		System.out.print("작성자: ");
		board.setBwriter(scanner.nextLine());
		//보조 메뉴
		System.out.println(hr);
		System.out.println("보조 메뉴: 1.OK | 2.Cancel");
		System.out.print("메뉴 선택: ");
		String menuNo = scanner.nextLine();
		if (menuNo.equals("1")) {
			//새 항목 생성
			try {
				String sql = "" +
						"INSERT INTO boards " + 
						"(bno, btitle, bcontent, bwriter, bdate) " +
						"VALUES (SEQ_BNO.NEXTVAL, ?, ?, ?, SYSDATE)";
				
				//2. Prepared Statement 준비하고
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, board.getBtitle());
				pstmt.setString(2, board.getBcontent());
				pstmt.setString(3, board.getBwriter());
				int rows = pstmt.executeUpdate();
				if (rows != 1) {
					System.out.println("알 수 없는 DB 오류");
					exit();
				}
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				exit();
			}
		}
		//다시 메인 화면으로 계속 돌아가기...
		list();
	}

	private void read() {
		System.out.println("[게시물 읽기]");
		System.out.print("bno: ");
		int bno = Integer.parseInt(scanner.nextLine());
		//board 테이블의 게시물 정보
		try {
			String sql = "" +
					"SELECT bno, btitle, bcontent, bwriter, bdate " +
					"FROM boards " +
					"WHERE bno=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				System.out.println(sharp);
				System.out.println("번호: " + board.getBno());
				System.out.println("제목: " + board.getBtitle());
				System.out.println("내용: " + board.getBcontent());
				System.out.println("작성자: " + board.getBwriter());
				System.out.println("날짜: " + board.getBdate());
				System.out.println(sharp);
			}
			rs.close();
			pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			exit();
		}
		
		list();
	}

	private void clear() {
		System.out.println("*** clear() 메소드 실행");
	}

	private void exit() {
		System.exit(0);;
	}

	public static void main(String[] args) {
		BoardExample5 boardExample = new BoardExample5();
		boardExample.list();
	}
}
