package kr.or.ddit.board.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kr.or.ddit.board.model.BoardVo;

public class BoardService implements BoardServiceInf{

	@Override
	public List<BoardVo> getBoardList() {
		List<BoardVo> boardList = new ArrayList<BoardVo>();
		//db에서 조회가 되었다고 가정하고 임의의 값을 리턴
		boardList.add(new BoardVo("1번", "asfasfasf, ", "brown", "곰", new Date()));
		boardList.add(new BoardVo("2번", "hndb4b4, ", "sally", "병아리", new Date()));
		boardList.add(new BoardVo("3번", "sdfgb5, ", "cony", "토끼", new Date()));
		boardList.add(new BoardVo("4번", "asfasrty34fasf, ", "james", "사람", new Date()));
		boardList.add(new BoardVo("5번", "fgh35, ", "moon", "달", new Date()));
		return boardList;
	}

}
