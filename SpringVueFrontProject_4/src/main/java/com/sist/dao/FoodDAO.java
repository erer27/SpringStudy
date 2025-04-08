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
	private FoodMapper mapper;
	
	public List<FoodVO> foodListData(int start, int end)
	{
		return mapper.foodListData(start, end);
	}
	
	public int foodTotalPage()
	{
		return mapper.foodTotalPage();
	}
	
	/*
	 * @Select("SELECT fno,poster,name,num "
			+ "FROM (SELECT fno,poster,name,rownum as num "
			+ "FROM (SELECT fno,poster,name "
			+ "FROM project_food ORDER BY fno desc WHERE name LIKE '%'||#{fd}||'%')) "
			+ "WHERE num BETWEEN #{start} AND #{end} ")
	public List<FoodVO> foodFindListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM project_food "
			+ "WHERE name LIKE '%'||#{fd}||'%'")
	public int foodFindTotalPage();
	 */
	public List<FoodVO> foodFindListData(Map map)
	{
		return mapper.foodFindListData(map);
	}
	public int foodFindTotalPage(String fd)
	{
		return mapper.foodFindTotalPage(fd);
	}
	
}
