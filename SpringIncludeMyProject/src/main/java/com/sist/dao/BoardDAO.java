package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.BoardMapper;
import com.sist.mapper.GoodsMapper;
import com.sist.vo.BoardVO;

@Repository
public class BoardDAO {
	@Autowired
	private BoardMapper mapper;
	

	public List<BoardVO> boardListData(Map map)
	{
		return mapper.boardListData(map);
	}
	

	public int boardRowCount()
	{
		return mapper.boardRowCount();
	}
	
	
	public void boardInsert(BoardVO vo)
	{
		mapper.boardInsert(vo);
	}
	

	public void boardHitIncrement(int no)
	{
		mapper.boardHitIncrement(no);
	}
	

	public BoardVO boardDetailData(int no)
	{
		return mapper.boardDetailData(no);
	}
}
