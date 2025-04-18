package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface FoodMapper {
	@Select("SELECT fno,poster,name,replycount,likecount,hit,num "
			+ "FROM (SELECT fno,poster,name,replycount,likecount,hit,rownum as num "
			+ "FROM (SELECT fno,poster,name,replycount,like,hit "
			+"FROM busan_food ORDER BY fno ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> busanFoodListData(
			@Param("start") int start,
			@Param("end") int end);
	@Select("SELECT CEIL(COLUMN(*)/20.0) FROM busan_food")
	public int busanFoodTotalPage();
}
