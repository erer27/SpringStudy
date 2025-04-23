package com.sist.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sist.vo.GoodsVO;

public interface GoodsService {
	public List<GoodsVO> busanGoodsListData( int start,int end);

	
	public int busanGoodsTotalPage();

	
	public GoodsVO busanGoodsDetailData(int no);

}
