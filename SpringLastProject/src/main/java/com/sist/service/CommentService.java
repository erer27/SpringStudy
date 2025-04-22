package com.sist.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sist.vo.CommentVO;

public interface CommentService {
	public List<CommentVO> commentListData(Map map);
	
	public int commentTotalPage(@Param("start") int cno, @Param("type") int type);
	
	public void commenInsert(CommentVO vo);
}
