package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.RecipeDAO;
import java.util.*;
import com.sist.vo.*;
@RestController
/*
 *  Rest API 
 *  = GET => @GetMapping ==> SELECT
 *  = POST => @PostMapping ==> INSERT
 *  ------------------- web
 *  = PUT  => @PutMapping  ==> UPDATE
 *  = DELETE => @DeleteMapping ==> DELETE
 *  
 *  => 화면이동이 불가능 
 *  => JavaScript연동 => 처리 결과값을 전송 
 *     ------------- JSON
 *     일반 문자열 => 그냥 전송 
 *     VO => {} => 자바스크립트의 객체 표현법 
 *     List => []
 *     ------------------------------ 자동 처리 jackson
 *  => @ResponseBody => @RestController 
 *     -------------    ---------------
 *     메소드에서 처리         클래스 단위 처리 
 *     
 *     스프링 : web파일을 관리하지 않는다 => 서버의 역할만 수행 
 *                                 -------------
 *                                 Back-End / Front-End
 *                                    |           |
 *                                  자바:스프링      jquery
 *                                  c# :ASP.net   vue
 *                                  파이썬: 장고      react
 *                                  NodeJS = php  next/nest/nust
 *    
 */
// Vue로 데이터 전송 
/*
 *   1.jsp 생성 
 *   2.vo 
 *   3.mapper
 *   4.dao
 *   5.@RestController
 *   6.jsp에서 vue를 이용해서 출력 
 */
public class RecipeRestController {
   // 1. 필요한 객체 읽기 => RecipeDAO 
   @Autowired
   private RecipeDAO dao;
   
   @GetMapping(value="recipe/list_vue.do",
		      produces = "text/plain;charset=UTF-8")
   public String list_vue(int page) throws Exception
   {
	   int rowSize=12;
	   int start=(rowSize*page)-(rowSize-1);
	   int end=rowSize*page;
	   List<RecipeVO> list=dao.recipeListData(start, end);
	   int totalpage=dao.recipeTotalPage();
	   
	   Map map=new HashMap();
	   map.put("list", list);
	   map.put("curpage", page);
	   map.put("totalpage", totalpage);
	   
	   // JSON변환 => 자바스크립트에서 인식 
	   ObjectMapper mapper=new ObjectMapper();
	   String json=mapper.writeValueAsString(map);
	   
	   return json;
   }
   @GetMapping(value="recipe/find_vue.do",
		   produces = "text/plain;charset=UTF-8")
   public String find_vue(int page,String fd)throws Exception
   {
	   int rowSize=12;
	   int start=(rowSize*page)-(rowSize-1);
	   int end=rowSize*page;
	   Map map=new HashMap();
	   map.put("start", start);
	   map.put("end", end);
	   map.put("fd", fd);
	   List<RecipeVO> list=dao.recipeFindListData(map);
	   int totalpage=dao.recipeFindTotalPage(fd);
	   
	   map=new HashMap();
	   map.put("curpage", page);
	   map.put("totalpage", totalpage);
	   map.put("list", list);
	   
	   ObjectMapper mapper=new ObjectMapper();
	   String json=mapper.writeValueAsString(map);
	   return json;
   }
   /*
    *   params:{
				   no:this.no
			   }
    */
   @GetMapping(value="recipe/detail_vue.do",
		   produces = "text/plain;charset=UTF-8")
   public String recipe_detail(int no) throws Exception
   {
	   RecipeDetailVO vo=dao.recipeDetailData(no);
	   List<String> mList=new ArrayList<String>();
	   List<String> iList=new ArrayList<String>();
	   
	   // 문장^image\n문장^image\n문장^image\n
	   String[] makes=vo.getFoodmake().split("\n");
	   for(String m:makes)
	   {
		   StringTokenizer st=new StringTokenizer(m,"^");
		   mList.add(st.nextToken());
		   iList.add(st.nextToken());
	   }
	   
	   Map map=new HashMap();
	   map.put("vo", vo);
	   map.put("mList", mList);
	   map.put("iList", iList);
	   
	   ObjectMapper mapper=new ObjectMapper();
	   String json=mapper.writeValueAsString(map);
	   
	   return json;
   }
}




