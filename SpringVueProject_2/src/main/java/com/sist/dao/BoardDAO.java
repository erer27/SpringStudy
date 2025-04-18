package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sist.mapper.BoardMapper;
import com.sist.vo.*;

@Repository
public class BoardDAO {
	@Autowired
	private BoardMapper mapper;
	
	/*
	 * @Select("SELECT no,subject,name,TO_CHAR(regdate,'yyyy-mm-dd') as dbday,hit,num "
			+ "FROM (SELECT no,subject,name,regdate,hit,rownum as num "
			+ "FROM (SELECT no,subject,name,regdate,hit "
			+ "FROM vueBoard ORDER BY no DESC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<BoardVO> boardListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/10.0 FROM vueBoard")
	public int boardTotalPage();
	
	DI => XML (p:~ c:~) @Autowired
	AOP
	MVC
	ORM : MyBatis
	Front 추가
	============================
	WebSocket / Security
	URL = 일반 주소 *.do / PathVariable
	=================================
	Spring-Boot
	 */
	
	public List<BoardVO> boardListData(Map map)
	{
		return mapper.boardListData(map);
	}
	
	public int boardTotalPage()
	{
		return mapper.boardTotalPage();
	}
	
	/*
	 *  @Insert("INSERT INTO vueBoard(no,name,vueBoard(no,name,subject,content, "
  		+ "VALUES(vue_no_seq.nextval,#{name},#{subject},"
  		+ "#{content},#{pwd})")
  public void boardInsert(BoardVO vo);
	 */
	public void boardInsert(BoardVO vo)
	{
		mapper.boardInsert(vo);
	}
	
	/*
	 * @Select("SELECT no,name,subject,content,hit,"
  		+ "TO_CHAR(regdate,'yyyy-mm-dd hh24:mi:ss') as dbday"
  		+ "FROM vueBoard "
  		+ "WHERE no=#{no}")
  public BoardVO boardDetailData(int no);
	 */
	public BoardVO boardDetailData(int no)
	{
		mapper.hitIncrement(no);
		return mapper.boardDetailData(no);
	}
	public BoardVO boardUpdateData(int no)
	{
		return mapper.boardDetailData(no);
	}
	public String boardUPdate(BoardVO vo)
	{
		String result="no";
		String db_pwd=mapper.boardGetPassword(vo.getNo());
		if(db_pwd.equals(vo.getPwd()))
		{
			result="yes";
			mapper.boardUPdate(vo);
		}
		return result;
	}
	
	
	/*
	 * @Delete("DELETE FROM vueBoard "
  		+ "WHERE no=#{no}")
  public void boardDelete(int no);
	 */
	public String boardDelete(int no,String pwd)
	{
		String result="no";
		String db_pwd=mapper.boardGetPassword(no);
		if(db_pwd.equals(pwd))
		{
			result="yes";
			mapper.boardDelete(no);
		}
		return result;
	}
	
	
}
