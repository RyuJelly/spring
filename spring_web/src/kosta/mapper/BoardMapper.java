package kosta.mapper;

import java.util.List;
import java.util.Map;

import kosta.model.Board;



public interface BoardMapper {
	int insertBoard(Board board);
	List<Board> listBoard();
	Board detailBoard(int seq);
//	int updateBoard(Board board);
}