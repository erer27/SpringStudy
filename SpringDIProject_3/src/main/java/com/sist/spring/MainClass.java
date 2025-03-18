package com.sist.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String[] xml= {"app-member.xml","app-sawon.xml","app-student.xml"};
		ApplicationContext app=new ClassPathXmlApplicationContext("app-*.xml");
		Sawon sa=(Sawon)app.getBean("sa");
		System.out.println(sa.getSabun());
		System.out.println(sa.getName());
		System.out.println(sa.getDept());
		System.out.println("==============");
		Student st=(Student)app.getBean("std");
		System.out.println(st.getHakbun());
		System.out.println(st.getName());
		System.out.println(st.getSubject());
		System.out.println("==============");
		Member mb=(Member)app.getBean("mem");
		System.out.println(mb.getAddress());
		System.out.println(mb.getMno());
		System.out.println(mb.getName());
	}

}
