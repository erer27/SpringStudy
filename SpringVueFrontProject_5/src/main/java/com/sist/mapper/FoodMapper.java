package com.sist.mapper;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.FoodVO;

import java.util.*;

public interface FoodMapper {
	@Select("SELECT fno,name,poster,type,num "
			+ "FROM (SELECT fno,name,poster,type,rownum as num "
			+ "FROM (SELECT fno,name,poster,type "
			+ "FROM project_food WHERE type LIKE '%'||#{type}||'%' ORDER BY fno desc))"
			+ "WHERE num BETWEEN #{start} AND #{end} ")
	public List<FoodVO> foodListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM project_food "
			+ "WHERE type LIKE '%'||#{type}||'%'")
	public int foodTotalPage(String type);
	
	@Select("SELECT * FROM project_food "
			+ "WHERE fno=#{fno}")
	public FoodVO foodDetailData(int fno);
}
