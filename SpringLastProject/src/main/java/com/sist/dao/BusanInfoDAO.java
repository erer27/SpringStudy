package com.sist.dao;

import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;

@Repository
/*
 * 		스프링 메모리 할당
 * 		=> 패키지 단위
 * 			<context:component-scan basepackage="com.sist.*">
 * 			=> 선택적으로 메모리 할당
 * 			=> 어노테이션
 * 		=> @Component
 * 			@Repository
 * 			@Service
 * 			@Controller
 * 			@RestController
 * 			@ControllerAdvice
 * 			@RestControllerAdvice
 */
public class BusanInfoDAO {
	@Autowired
	private BusanInfoMapper mapper;
	
	// 구현
	/*
	 * 		MyBatis : XML , Annotation
	 * 				=> XML + Annotation	
	 * 						 === 간단한 SQL
	 * 				   === 동적 쿼리 / SQL 문장이 긴 경우
	 * 				=> <select> @Select()
	 * 				=> id resultType parameterType
	 * 					|	|				|
	 * 				 메소드명 리턴형		   매개변수 
	 * 						====
	 * 						 VO / List
	 * 						  |		|
	 * 								selectList
	 * 						selectOne
	 * 				=> getConnection / disConnection 처리
	 * 		=> ORM => 관계형 데이터베이스에 대한 라이브러리 (데이터베이스)
	 * 			| MyBatis (IBatis)
	 * 			| JPA	(Hibernate) => DataSet => LinQ
	 * 						selectOne
	 */
	
	/*
	 * @Select("SELECT no,poster,title,num "
			+ "FROM (SELECT no,poster,title,rownum as num "
			+ "FROM (SELECT + INDEX_ASC(busan_info bi_no_pk)no,poster,title "
			+ "FROM busan_info WHERE cno=#{cno})) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<BusanInfoVO> busanInfoListData(Map mpa);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM busan_info "
			+ "WHERE cno=#{cno}")
	public int busanInfoTotalPage(int cno);
	 */
	public List<BusanInfoVO> busanInfoListData(Map map)
	{
		return mapper.busanInfoListData(map);
	}
	
	public int busanInfoTotalPage(int cno)
	{
		return mapper.busanInfoTotalPage(cno);
	}
	
	public BusanInfoVO busanInfoDetailData(int no)
	{
		return mapper.busanInfoDetailData(no);
	}
}
