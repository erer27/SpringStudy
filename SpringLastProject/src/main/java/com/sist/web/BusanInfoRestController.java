package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import com.sist.service.BusanInfoService;
import com.sist.vo.BusanInfoVO;
/*
 * 
 * 		7:3 => 6:4
 * 		=> 검색 , 페이지 , 댓글 , 결제 , 예약
 * 		
 * 		= 데이터베이스 연동
 * 		= 브라우저 연동 => Model (화면,데이터만 전송)
 * 	
 * 						| 등록 : web.xml
 * 						  => HandlerMapping 생성
 * 						  => 클래스 등록 => xml을 전송
 * 						| 자동 설정 / 톰캣 자동 설정 => Spring-Boot
 * 		사용자 요청 (.do) ==> DispatcherServlet
 * 								|
 * 							HandlerMapping : Model을 찾아서
 * 								|
 * 							ViewResolver : JSP를 찾아서 res
 * 								| 경로명 / 확장자
 * 							  JSP
 */
@RestController
public class BusanInfoRestController {
	@Autowired
	private BusanInfoService service;
	
	@GetMapping("busan/info_vue.do")
	public Map busan_info(int page,int cno)
	{
		// 데이터베이스에 설정할 변수
		Map map=new HashMap();
		map.put("cno", cno);
		map.put("start", (page-1)*12);
		map.put("end", (page*12));
		
		List<BusanInfoVO> list=service.busanInfoListData(map);
		int totalpage=service.busanInfoTotalPage(cno);
		
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage=totalpage;
		
		// Vue로 전송
		map=new HashMap();
		map.put("list", list);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		
		return map;
	}
}
