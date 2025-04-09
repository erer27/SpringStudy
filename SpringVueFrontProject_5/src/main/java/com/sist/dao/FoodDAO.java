package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.FoodMapper;
import com.sist.vo.FoodVO;

@Repository
public class FoodDAO {
	@Autowired
	FoodMapper mapper;
	/*@Select("SELECT fno,name,poster,type,num "
			+ "FROM (SELECT fno,name,poster,type,rownum as num"
			+ "FROM (SELECT fno,name,poster,type"
			+ "FROM project_food WHERE type LIKE '%'||#{type}||'%' ORDER BY fno desc))"
			+ "WHERE num BETWEEN #{start} AND #{end} ")
	public List<FoodVO> foodListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0 FROM project_food "
			+ "WHERE type LIKE '%'||#{type}||'%'")
	public int foodTotalPage(String type);
	*/
	public List<FoodVO> foodListData(Map map)
	{
		return mapper.foodListData(map);
	}
	
	public int foodTotalPage(String type)
	{
		return mapper.foodTotalPage(type);
	}
	
	public FoodVO foodDetailData(int fno)
	{
		return mapper.foodDetailData(fno);
	}
	
}
