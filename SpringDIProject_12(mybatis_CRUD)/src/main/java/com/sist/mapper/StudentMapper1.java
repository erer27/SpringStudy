package com.sist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.StudentVO;

public interface StudentMapper1 {
	/*
	 * <insert id="studentInsert" parameterType="StudentVO">
	 	<!-- @SelectKey -->
	 	<selectKey keyProperty="hakbun" resultType="int" order="BEFORE">
	 		SELECT NVL(MAX(hakbun)+1,1) as hakbun FROM student
	 	</selectKey>
	 		INSERT INTO student VALUES(
	 			#{hakbun},#{name},#{kor},#{eng},#{math}
	 		)
	 	</insert>
	 */
	/*
	 * <delete id="studentDelete" parameterType="int">
	 	DELETE FROM student
	 	WHERE hakbun=#{hakbun}
	 </delete>
	 */
	/*
	 * <update id="studentUpdate" parameterType="StudentVO">
	 	UPDATE student SET
	 	name=#{name},kor=#{kor},eng=#{eng},math=#{math}
	 	WHERE hakbun=#{hakbun}
	 </update>
	 */
	// Sequence / subquery
	
	
	@Select("SELECT * FROM student")
	public List<StudentVO> studentListData();
	
	@Select("SELECT * FROM student "
			+ "WHERE hakbun=#{hakbun}")
	public StudentVO studentDetailData(int hakbun);
	
	@SelectKey(keyProperty = "hakbun",resultType = int.class,before = true, statement = "SELECT NVL(MAX(hakbun)+1,1) as hakbun FROM student")
	@Insert("INSERT INTO student VALUES("
			+ "#{hakbun},#{name},#{kor},#{eng},#{math}")
	public void studentInsert(StudentVO vo);
	
	
	@Delete("DELETE FROM student"
			+ "WHERE hakbun=#{hakbun}")
	public void StudentDelete(int hakbun);
	
	@Update("UPDATE student SET"
			+ "name=#{name},kor=#{kor},eng=#{eng},math=#{math}"
			+ "WHERE hakbun=#{hakbun}")
	public void studentUpdate(StudentVO vo);
	
}
