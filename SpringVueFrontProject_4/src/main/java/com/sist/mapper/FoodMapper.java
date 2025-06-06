package com.sist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.*;
import com.sist.vo.FoodVO;

public interface FoodMapper {
	@Select("SELECT fno,poster,name,num "
			+ "FROM (SELECT fno,poster,name,rownum as num "
			+ "FROM (SELECT fno,poster,name "
			+ "FROM project_food ORDER BY fno desc)) "
			+ "WHERE num BETWEEN #{start} AND #{end} ")
	public List<FoodVO> foodListData(@Param("start") int start, @Param("end") int end);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM project_food")
	public int foodTotalPage();
	
	@Select("SELECT fno,poster,name,num "
			+ "FROM (SELECT fno,poster,name,rownum as num "
			+ "FROM (SELECT fno,poster,name "
			+ "FROM project_food WHERE name LIKE '%'||#{fd}||'%' ORDER BY fno desc))   "
			+ "WHERE num BETWEEN #{start} AND #{end} ")
	public List<FoodVO> foodFindListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM project_food "
			+ "WHERE name LIKE '%'||#{fd}||'%'")
	public int foodFindTotalPage(String fd);
}
