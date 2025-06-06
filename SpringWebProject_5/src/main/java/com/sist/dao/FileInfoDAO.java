package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.mapper.*;
import com.sist.vo.*;

@Repository
public class FileInfoDAO {
	@Autowired
	private FileInfoMapper mapper;
	@Insert("INSERT INTO springFileInfo VALUES("
			+"#{no}, #{filename},#{filesize})")
	public void boardFileInsert(FileInfoVO vo)
	{
		mapper.boardFileInsert(vo);
	}
	
	/*
	 * @Select("SELECT * FROM springfileinfo fileinfo "
			+ "WHERE no=#{no}")
	public List<FileInfoVO> fileListData(int no);
	 */
	
	public List<FileInfoVO> fileListData(int no)
	{
		return mapper.fileListData(no);
	}
	
	/*
	 * @Delete("DELETE FROM springfileInfo "
			+"WHERE no=#{no}")
	public void fileInfoDelete(int no);
	 */
	public void fileInfoDelete(int no)
	{
		mapper.fileInfoDelete(no);
	}
}
