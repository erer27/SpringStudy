package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class ReplyDAO {
	@Autowired
	private ReplyMapper mapper;
	
	/*
	 * @Select("SELECT no,bno,id,name,msg,group_tab "
			+ "FROM vueReply "
			+ "WHERE bno=#{bno} "
			+ "ORDER BY group_id DESC,group_step ASC")
	public List<ReplyVO> replyListData(int bno);
	
	@SelectKey(keyProperty = "no",resultType = int.class,
			before = true , 
			statement = "SELECT NVL(MAX(no)+1,1) as no FROM vueReply")
	@Insert("INSERT INTO vueReply(no,bno,id,name,msg,group_id) "
			+ "VALUES(#{no},#{bno},#{id},#{name},#{msg},"
			+ "(SELECT NVL(MAX(group_id)+1,1) FROM vueReply))")
	public void replyInsert(ReplyVO vo);
	 */
	public List<ReplyVO> replyListData(int bno)
	{
		return mapper.replyListData(bno);
	}
	public void replyInsert(ReplyVO vo)
	{
		mapper.replyInsert(vo);
	}
	public void replyUpdate(ReplyVO vo)
	{
		mapper.replyUpdate(vo);
	}
	public void replyDelete(int no)
	{
		ReplyVO vo=mapper.replyInfoData(no);
		mapper.replyDelete(vo);
	}
	@Transactional
	public void replyReplyInsert(int pno,ReplyVO vo)
	{
		ReplyVO pvo=mapper.replyParentInfoData(pno);
		mapper.replyGroupStepIncrement(pvo);
		vo.setGroup_id(pvo.getGroup_id());
		vo.setGroup_step(pvo.getGroup_step()+1);
		vo.setGroup_tab(pvo.getGroup_tab()+1);
		mapper.replyReplyInsert(vo);
	}
}
