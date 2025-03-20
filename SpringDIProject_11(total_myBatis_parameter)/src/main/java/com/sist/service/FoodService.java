package com.sist.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.sist.vo.FoodVO;

public interface FoodService {
	public List<FoodVO> foodListData(int start, int end);
	public int foodTotalPage();
}
