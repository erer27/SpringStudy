package com.sist.dao;
import java.util.List;

import com.sist.mapper.*;
import com.sist.vo.*;
public class StudentDAO2 {
	private StudentMapper1 mapper;

	public void setMapper(StudentMapper1 mapper) {
		this.mapper = mapper;
	}
	
	public List<StudentVO> studentListData()
	{
		return mapper.studentListData();
	}
	public StudentVO studentDetailData(int hakbun)
	{
		return mapper.studentDetailData(hakbun);
	}
	public void studentInsert(StudentVO vo)
	{
		mapper.studentInsert(vo);
	}
	public void StudentDelete(int hakbun)
	{
		mapper.StudentDelete(hakbun);
	}
	public void studentUpdate(StudentVO vo)
	{
		mapper.studentUpdate(vo);
	}
}
