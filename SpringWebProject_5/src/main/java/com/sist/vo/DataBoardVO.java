package com.sist.vo;

import java.util.*;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

/*
 * 
 */

// 일반 JDBC => 컬럼명과 VO의 변수명이 일치하지 않을 수 있다
// MyBatis / JPA => 1. 변수/컬럼 일치
// 					   ----------- as / resultMap
// int fc; select filecount as fc

/*
 * 		1. 유지보수 => 한번에 처리
 * 			1) 공통으로 적용하는 코드 => @Aspect
 * 			2) 공통으로 처리하는 예외처리 => @ControllerAdvice
 * 		2. DAO / SQL
 * 		3. Model에서 전송
 * 		   ------ 사용자값 받기 / 전송하는 값
 * 				  | 매개변수	   | Model
 *		4. JSP는 변경이 없다
 *		   -------------- Front (VueJS)
 *		name="name"=><input type=file name="file[0]">
 */

@Data
public class DataBoardVO {
	private int no, hit, filecount;
	private String name, subject, content, pwd, dbday;
	private Date regdate;
	private List<MultipartFile> files=new ArrayList<MultipartFile>();
}
