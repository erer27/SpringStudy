package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sist.commons.CommonsPagination;
import com.sist.service.GoodsService;
import com.sist.vo.GoodsVO;

import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("main/")
public class GoodsController {
	@Autowired
	private GoodsService service;
	
	@GetMapping("main.do")
	public String goods_list(String page, Model model)
	{
		Map map=CommonsPagination.pageConfig(page, 12);
		List<GoodsVO> list=service.goodsListData(map);
		int totalpage=service.goodsTotalPage();
		int curpage=(int)map.get("curpage");
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		
		model.addAttribute("list",list);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage",totalpage);
		
		model.addAttribute("main_jsp","../goods/goods_list.jsp");
		return "main/main";
	}
	
	@GetMapping("goods_detail_before.do")
	public String goods_detail_before(int no,HttpServletResponse response, RedirectAttributes ra)
	{
		Cookie cookie=new Cookie("spring_"+no,String.valueOf(no));
		
		cookie.setPath("/");
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);
		
		ra.addAttribute("no",no);
		
		return "redirect:goods_detail.do";
	}
	
	@GetMapping("goods_detail.do")
	public String goods_detail(int no,Model model)
	{
		GoodsVO vo=service.goodsDetailData(no);
		model.addAttribute("vo",vo);
		model.addAttribute("main_jsp","../goods/goods_detail.jsp");
		
		return "main/main";
	}
	
	@RequestMapping("find.do")
	public String goods_find(String page,String fd, Model model)
	{
		Map map=CommonsPagination.pageConfig(page, 12);
		
		int curpage=(int)map.get("curpage");
		if(fd==null)
			fd="감자";
		map.put("fd", fd);
		List<GoodsVO> list=service.goodsFindData(map);
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		int totalpage=service.goodsFindTotalPage(map);
		if(endPage>totalpage)
			endPage=totalpage;
		
		model.addAttribute("list",list);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("fd",fd);
		
		model.addAttribute("main_jsp","../goods/find.jsp");
		return "main/main";
		
	}
}
