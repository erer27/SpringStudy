package com.sist.auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
/*
 * 		POJO
 * 		----- �Ϲ� �ڹ�     => �������̽�/���� ���� ����� Ŭ����
 */
@Component
public class MainClass {
	// �ǹ� => @Autowired+@quallicire = @Resource
	@Autowired
	// �ݵ�� ���������� �޸𸮰� �Ҵ��� �Ǵ� ��쿡�� ����� ����
	@Qualifier(value="oracle")
	// ���� ������ Ŭ������ �������� ��쿡 Ư�� ��ü ����
	private DAO dao;
	
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("app2.xml");
		MainClass mc=(MainClass)app.getBean("mainClass");
		mc.dao.connection();
	}
}
