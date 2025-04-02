package com.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import com.sist.dao.GoodsDAO;
import com.sist.vo.GoodsVO;

@Service
public class GoodsServiceImpl implements GoodsService{
	@Autowired
	private GoodsDAO gDao;

	@Override
	public GoodsVO goodsDetailData(int no) {
		// TODO Auto-generated method stub
		return gDao.goodsDetailData(no);
	}

	@Override
	public List<GoodsVO> goodsListData(Map map) {
		// TODO Auto-generated method stub
		return gDao.goodsListData(map);
	}

	@Override
	public int goodsTotalPage() {
		// TODO Auto-generated method stub
		return gDao.goodsTotalPage();
	}
	
	
}
