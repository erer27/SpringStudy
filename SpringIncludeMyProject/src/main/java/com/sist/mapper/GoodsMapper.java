package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.GoodsVO;

/*
 * 
 * NO                NOT NULL NUMBER         
GOODS_NAME        NOT NULL VARCHAR2(1000) 
GOODS_SUB                  VARCHAR2(1000) 
GOODS_PRICE       NOT NULL VARCHAR2(50)   
GOODS_DISCOUNT             NUMBER         
GOODS_FIRST_PRICE          VARCHAR2(20)   
GOODS_DELIVERY    NOT NULL VARCHAR2(20)   
GOODS_POSTER               VARCHAR2(260)  
HIT                        NUMBER         
LIKECOUNT                  NUMBER         
REPLYCOUNT                 NUMBER         

 */

public interface GoodsMapper {
	@Update("UPDATE goods_all SET "
			+"hit=hit+1 "
			+"WHERE no=#{no}")
	public void hitIncrement(int no);
	
	@Select("SELECT * FROM goods_all "
			+"WHERE no=#{no}")
	public GoodsVO goodsDetailData(int no);
	
	@Select("SELECT no,goods_poster,goods_name,num "
			+ "FROM (SELECT no,goods_poster,goods_name,rownum as num "
			+ "FROM (SELECT /*+ INDEX_ASC(goods_all ga_no_pk)*/no,goods_poster,goods_name "
			+ "FROM goods_all)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<GoodsVO> goodsListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM goods_all")
	public int goodsTotalPage();
	
	/*
	 * <select id="goodsFindData" resultType="com.sist.vo.GoodsVO" parameterType="hashmap">
		SELECT no,goods_poster,goods_name,num
		FROM (SELECT no,goods_poster,goods_name,rownum as num
		FROM (SELECT + INDEX_ASC(goods_all ga_no_pk)no,goods_poster,goods_name
		FROM goods_all WHERE goods_name LIKE '%'||#{fd}||'%'))
		WHERE num BETWEEN #{start} AND #{end}
	</select>
	<select id="goodsFindTotalPage" resultType="int" parameterType="hashmap">
		SELECT CEIL(COUNT(*)/12.0) FROM goods_all
		WHERE REGEXP_LIKE(goods_name,#{fd})
	</select>
	 */
	
	public List<GoodsVO> goodsFindData(Map map);
	
	public int goodsFindTotalPage(Map map);
}
