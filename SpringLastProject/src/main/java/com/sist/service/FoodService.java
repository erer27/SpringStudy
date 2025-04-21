package com.sist.service;

import java.util.List;

import com.sist.vo.FoodVO;
/*
 * 		Model(Controller) ==== Service ==== DAO
 * 								
 */
public interface FoodService {
	public List<FoodVO> busanFoodListData(int start,int end);
	public int busanFoodTotalPage();
	public FoodVO busanFoodDetailData(int fno);
}
