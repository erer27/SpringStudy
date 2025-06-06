package com.sist.aop;

import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sist.dao.*;
import com.sist.vo.*;
@Aspect
@Component
public class MusicAspect {
	@Autowired
	private MusicDAO dao;
	// finally => 정상 / 오류 상관없이 무조건 수행
	@After("execution(* com.sist.web.*Controller.*(..))")
	public void after()
	{
		HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		MusicVO vo=dao.musicTop();
		System.out.println("title:"+vo.getTitle());
		//String key = youtubeGetKey(vo.getTitle());
		//request.setAttribute("key", key);
	}
	public String youtubeGetKey(String title)
	{
		String key="";
		try
		{
			String url="https://www.youtube.com/results?search_query=" + URLEncoder.encode(title,"UTF-8");
			Document doc=Jsoup.connect(url).get();
			Pattern p=Pattern.compile("/watch\\?v=[^가-힣]+");
			Matcher m=p.matcher(doc.toString());
			// (().().().())
			while(m.find())
			{
				String s=m.group();
				System.out.println(s);
				key=s.substring(s.indexOf("=")+1,s.indexOf("\""));
				break;
			}
		}catch(Exception ex) {}
		return key;
	}
}
