package ch20.oracle.ex.problem9;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

import ch20.oracle.sec09.exam01.Board;
import ch20.oracle.sec09.exam01.User;

public class BoardExample8 {
	private String hr = "----------------------------------------------------------------------";
	private String sharp = "#############";
	private Scanner scanner = new Scanner(System.in);
	private Connection conn;
	private String loginId;
	
	public BoardExample8() {
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
		System.out.println("[게시물 목록] " + ((loginId != null)? ("사용자: " + loginId) : ("")));
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
		if (loginId == null) {
			System.out.println("메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Join | 5.Login | 6.Exit");
			System.out.print("메뉴 선택: ");
			System.out.println();
			
			String menuNo = scanner.nextLine();
			System.out.println();
			
			switch (menuNo) {
				case "1" -> create();
				case "2" -> read();
				case "3" -> clear();
				case "4" -> join();
				case "5" -> login();
				case "6" -> exit();
			}
		} else {
			System.out.println("메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Join | 5.Logout | 6.Exit");
			System.out.print("메뉴 선택: ");
			System.out.println();
			
			String menuNo = scanner.nextLine();
			System.out.println();
			
			switch (menuNo) {
				case "1" -> create();
				case "2" -> read();
				case "3" -> clear();
				case "4" -> join();
				case "5" -> logout();
				case "6" -> exit();
			}
		}
	}

	private void logout() {
		loginId = null;
		list();
	}

	private void login() {
		User user = new User();
		System.out.println("[로그인]");
		System.out.print("아이디: ");
		user.setUserId(scanner.nextLine());
		System.out.print("비밀번호: ");
		user.setUserPassword(scanner.nextLine());
		//보조 메뉴
		System.out.println(hr);
		System.out.println("보조 메뉴: 1.OK | 2.Cancel");
		System.out.print("메뉴 선택: ");
		String menuNo = scanner.nextLine();
		if (menuNo.equals("1")) {
			try {
				String sql = "" +
						"SELECT userpassword " +
						"FROM users " +
						"WHERE userid=?";
				
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, user.getUserId());
				
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					if (user.getUserPassword().equals(rs.getString("userpassword"))) {
						loginId = user.getUserId();
					} else {
						System.out.println("비밀 번호가 일치하지 않습니다.");
					}
				} else {
					System.out.println("아이디가 존재하지 않습니다.");
				}
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		list();
	}

	private void join() {
		User user = new User();
		System.out.println("[새 사용자 입력]");
		System.out.print("아이디: ");
		user.setUserId(scanner.nextLine());
		System.out.print("이름: ");
		user.setUserName(scanner.nextLine());;
		System.out.print("비밀번호: ");
		user.setUserPassword(scanner.nextLine());
		System.out.print("나이: ");
		user.setUserAge(Integer.parseInt(scanner.nextLine()));
		System.out.print("이메일: ");
		user.setUserEmail(scanner.nextLine());
		//보조 메뉴
		System.out.println(hr);
		System.out.println("보조 메뉴: 1.OK | 2.Cancel");
		System.out.print("메뉴 선택: ");
		String menuNo = scanner.nextLine();
		if (menuNo.equals("1")) {
			try {
				String sql = "" +
						"INSERT INTO users (userid, username, userpassword, userage, useremail) " +
						"VALUES (?, ?, ?, ?, ?)";
				
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, user.getUserId());
				pstmt.setString(2, user.getUserName());
				pstmt.setString(3, user.getUserPassword());
				pstmt.setInt(4, user.getUserAge());
				pstmt.setString(5, user.getUserEmail());
				
				pstmt.executeUpdate();
				pstmt.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				exit();
			}
		}
		list();
	}

	private void create() {
		//입력 받고
		Board board = new Board();
		System.out.println("[새 게시물 입력]");
		System.out.print("제목: ");
		board.setBtitle(scanner.nextLine());
		System.out.print("내용: ");
		board.setBcontent(scanner.nextLine());;
		if (loginId == null) {
			System.out.print("작성자: ");
			board.setBwriter(scanner.nextLine());
		} else {
			board.setBwriter(loginId);
		}
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
				//보조 메뉴
				if (loginId != null && loginId.equals(board.getBwriter())) {
					System.out.println(hr);
					System.out.println("보조 메뉴: 1.Update | 2.Delete | 3.List");
					System.out.print("메뉴 선택: ");
					String menuNo = scanner.nextLine();
					if (menuNo.equals("1")) {
						update(board);
					} else if (menuNo.equals("2")) {
						delete(board);
					}
				}
			}
			
			rs.close();
			pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			exit();
		}
		
		list();
	}

	private void delete(Board board) {
		try {
			String sql = "DELETE FROM boards WHERE bno=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board.getBno());
			pstmt.executeUpdate();
			
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			exit();
		}

		list();
	}

	private void update(Board board) {
		System.out.println("[수정 내용 입력]");
		System.out.print("제목: ");
		board.setBtitle(scanner.nextLine());
		System.out.print("내용: ");
		board.setBcontent(scanner.nextLine());;
		System.out.println(hr);
		System.out.println("보조 메뉴: 1.OK | 2.Cancel");
		System.out.print("메뉴 선택: ");
		String menuNo = scanner.nextLine();
		if (menuNo.equals("1")) {
			try {
				//1. SQL문 만들고
				String sql = new StringBuilder()
						.append("UPDATE boards SET ")
						.append("btitle=?, bcontent=? ")
						.append("WHERE bno=?")
						.toString();
				
				//2. Prepared Statement 준비하고
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, board.getBtitle());
				pstmt.setString(2, board.getBcontent());
				pstmt.setInt(3, board.getBno());
				
				//3. Prepared Statement 실행하고
				pstmt.executeUpdate();

				//5. Prepared Statement 종료
				pstmt.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				exit();
			}
		}
		list();
	}

	private void clear() {
		System.out.println("[게시물 전체 삭제]");
		//보조 메뉴
		System.out.println(hr);
		System.out.println("보조 메뉴: 1.OK | 2.Cancel");
		System.out.print("메뉴 선택: ");
		String menuNo = scanner.nextLine();
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (menuNo.equals("1")) {
			try {
				String sql = "TRUNCATE TABLE boards";	//이건 conn.setAutoCommit(false)도 안먹는다...주의!! 
//				String sql = "DELETE FROM boards";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.executeUpdate();
				
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				exit();
			}
		}
		//다시 메인 화면으로 계속 돌아가기...
		list();
	}

	private void exit() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("게시판 종료 **");
		System.exit(0);
	}

	public static void main(String[] args) {
		BoardExample8 boardExample = new BoardExample8();
		boardExample.list();
	}
}
