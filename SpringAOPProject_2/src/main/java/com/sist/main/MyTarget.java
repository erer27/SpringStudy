package com.sist.main;

public class MyTarget {
	private My my;
	public MyTarget(My my)
	{
		this.my=my;
		
	}
	
	public void execute()
	{
		// Target�� ��Ƽ� ó�� => ����
		System.out.println("my������"); // Before
		my.execute();
		System.out.println("my����gn"); // After
	}
}
