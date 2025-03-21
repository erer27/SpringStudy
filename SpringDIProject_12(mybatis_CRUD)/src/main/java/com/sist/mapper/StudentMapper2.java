package com.sist.mapper;

import java.util.List;

import com.sist.vo.StudentVO;

public interface StudentMapper2 {
	public List<StudentVO> studentListData();
	public StudentVO studentDetailData(int hakbun);
	public void studentInsert(StudentVO vo);
	public void StudentDelete(int hakbun);
	public void studentUpdate(StudentVO vo);
}
