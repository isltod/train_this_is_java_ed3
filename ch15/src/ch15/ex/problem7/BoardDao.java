package ch15.ex.problem7;

import java.util.ArrayList;
import java.util.List;

public class BoardDao {
	private List<Board> boards = new ArrayList<>();
	public BoardDao() {
		// TODO Auto-generated constructor stub
		boards.add(new Board("제목1", "내용1"));
		boards.add(new Board("제목2", "내용2"));
		boards.add(new Board("제목3", "내용3"));
	}
	public List<Board> getBoardList() {
		return boards;
	}
}
