package com.sist.service;

import java.util.List;
import java.util.Map;

import com.sist.vo.BoardVO;

public interface BoardService {
	public List<BoardVO> boardListData(Map map);
	public int boardRowCount();
	public void boardInsert(BoardVO vo);
	public void boardHitIncrement(int no);
	public BoardVO boardDetailData(int no);

}
