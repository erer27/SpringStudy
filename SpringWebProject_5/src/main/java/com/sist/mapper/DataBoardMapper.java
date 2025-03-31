package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.vo.*;

public interface DataBoardMapper {
	@Select("SELECT no, subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday, num "
			+ "FROM (SELECT no,subject,name,regdate, hit,rownum as num "
			+ "FROM (SELECT no,subject,name,regdate, hit "
			+ "FROM springDataBoard ORDER BY no DESC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<DataBoardVO> boardListData(@Param("start") int start, 
			@Param("end") int end);
	// boardListData(1,10)
	@Select("SELECT COUNT(*) FROM springDataBoard")
	public int boardRowCount();
	
	@Insert("INSERT INTO springDataBoard VALUES("
			+"sdb_no_seq.nextval,#{name},"
			+"#{subject},#{content},#{pwd},"
			+"SYSDATE,0,#{filecount})")
	public void boardInsert(DataBoardVO vo);
	
	
	@Select("SELECT sdb_no_seq.currval FROM DUAL")
	public int boardCurentNoData();
	
	@Update("UPDATE springDataBoard SET "
			+"hit=hit+1 "
			+ "WHERE  no=#{no}")
	public void hitIncrement(int no);
	
	@Select("Select * From springdataboard "
			+ "WHERE no=#{no}")
	public DataBoardVO databoardDetailData(int no);
	
}
