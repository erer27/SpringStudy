package com.sist.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.vo.SawonVO;

@RestController
public class SawonRestController {
	@RequestMapping(value="sawon/list.do",produces="text/plain;charset=UTF-8")
	public String sawon_list() throws Exception
	{
		List<SawonVO> list=new ArrayList<SawonVO>();
				SawonVO vo=new SawonVO();
		vo.setSabun(1);
		vo.setName("홍길동");
		vo.setDept("개발부");
		vo.setLoc("부산");
		vo.setJob("개발");
		vo.setPay(3000);
		
		ObjectMapper mapper=new ObjectMapper();
		String s=mapper.writeValueAsString(list);
		return s;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
