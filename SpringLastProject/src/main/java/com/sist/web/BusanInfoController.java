package com.sist.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.service.BusanInfoService;
import com.sist.vo.BusanInfoVO;

@Controller
public class BusanInfoController {
	//@Autowired => 전역에서 설정이 가능
	//필요한 객체 => 스프링에서 메모리 할당한 경우
	@Autowired
	private BusanInfoService service;
	
	private String[] titles= {"","명소","음식","쇼핑"};
	// HandlerMapping이 찾기 => 기능 설정
	@GetMapping("busan/info.do")
	public String busan_info(String page,int cno,Model model)
	{
		System.out.println(cno);
		model.addAttribute("cno",cno);
		model.addAttribute("titles",titles[cno]);
		model.addAttribute("main_jsp","../busan/info_list.jsp");
		return "main/main";
	}
	@GetMapping("busan/detail.do")
	public String busan_detail(int no,Model model,HttpSession session)
	{
		String id=(String)session.getAttribute("userid");
		BusanInfoVO vo=service.busanInfoDetailData(no);
		String addr1=vo.getAddress();
		addr1=addr1.substring(addr1.indexOf(" "));
		String addr2=addr1.trim();
		addr2=addr2.substring(0,addr2.indexOf(" "));
		model.addAttribute("vo",vo);
		model.addAttribute("sessionId",id);
		model.addAttribute("addr", addr2);
		model.addAttribute("main_jsp","../busan/info_detail.jsp");
		return "main/main";
	}
}
