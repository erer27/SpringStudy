package com.sist.member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sist.sawon.*;

@Component
public class Member {
	@Autowired
	private Sawon sawon;

	public void setSawon(Sawon sawon) {
		this.sawon = sawon;
	}
	
	public void display()
	{
		System.out.println("sawon:"+sawon);
		System.out.println("���:"+sawon.getSabun());
		System.out.println("�̸�:"+sawon.getName());
	}
}
