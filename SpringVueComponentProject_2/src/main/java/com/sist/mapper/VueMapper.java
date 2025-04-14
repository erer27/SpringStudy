package com.sist.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.sist.vo.FoodVO;
import com.sist.vo.GoodVO;

import java.util.*;

/*
 * 		Component / computed / watch
 * 		Spring-Boot => gradle
 * 		--------------------- 
 */

@Repository
public interface VueMapper {
	// Food
	@Select("SELECT fno,name,poster,num "
			+ "FROM (SELECT fno,name,poster,rownum as num "
			+ "FROM (SELECT fno,name,poster "
			+ "FROM project_food ORDER BY fno ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM project_food")
	public int foodTotalPage();
	
	@Select("SELECT * FROM project_food "
			+ "WHERE fno=#{fno}")
	public FoodVO foodDetailData(int fno);
	// Goods
	@Select("SELECT no,goods_name,goods_poster,num "
			+ "FROM (SELECT no,goods_name,goods_poster,rownum as num "
			+ "FROM (SELECT no,goods_name,goods_poster "
			+ "FROM goods_all ORDER BY no ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<GoodVO> goodsListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM goods_all")
	public int goodsTotalPage();
	
	@Select("SELECT * FROM goods_all "
			+ "WHERE no=#{no}")
	public GoodVO goodsDetailData(int no);
	// Recipe
}
