package com.sist.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.BoardDAO;
import com.sist.dao.GoodsDAO;
import com.sist.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDAO bDao;
	
	@Override
	public List<BoardVO> boardListData(Map map) {
		// TODO Auto-generated method stub
		return bDao.boardListData(map);
	}

	@Override
	public int boardRowCount() {
		// TODO Auto-generated method stub
		return bDao.boardRowCount();
	}

	@Override
	public void boardInsert(BoardVO vo) {
		// TODO Auto-generated method stub
		bDao.boardInsert(vo);
	}

	@Override
	public void boardHitIncrement(int no) {
		// TODO Auto-generated method stub
		bDao.boardHitIncrement(no);
	}

	@Override
	public BoardVO boardDetailData(int no) {
		// TODO Auto-generated method stub
		return bDao.boardDetailData(no);
	}

}
