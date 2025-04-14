package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;

@Repository
public class VueDAO {
	@Autowired
	private VueMapper mapper;
	
	/*
	 * @Select("SELECT fno,name,poster,num "
			+ "FROM (SELECT fno,name,poster,num,poster,rownum as num "
			+ "FROM (SELECT fno,name,poster "
			+ "FROM project_food ORDER BY fno ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodListData(Map map);
	 */
	public List<FoodVO> foodListData(Map map)
	{
		return mapper.foodListData(map);
	}
	
	/*
	 * @Select("SELECT CEIL(COUNT(*)/12.0) FROM project_food")
	public int foodTotalPage();
	 */
	public int foodTotalPage()
	{
		return mapper.foodTotalPage();
	}
	
	public FoodVO foodDetailData(int fno)
	{
		return mapper.foodDetailData(fno);
	}
	
	/*
	 * @Select("SELECT no,goods_name,goods_poster,num "
			+ "FROM (SELECT no,goods_name,goods_poster,rownum as num "
			+ "FROM (SELECT no,goods_name,goods_poster "
			+ "FROM goods_all ORDER BY no ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<GoodVO> goodsListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM goods_all")
	public int goodsTotalPage();
	 */
	public List<GoodVO> goodsListData(Map map)
	{
		return mapper.goodsListData(map);
	}
	public int goodsTotalPage()
	{
		return mapper.goodsTotalPage();
	}
	
	public GoodVO goodsDetailData(int no)
	{
		return mapper.goodsDetailData(no);
	}
}
