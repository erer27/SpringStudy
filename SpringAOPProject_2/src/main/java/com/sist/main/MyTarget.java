package com.sist.main;

public class MyTarget {
	private My my;
	public MyTarget(My my)
	{
		this.my=my;
		
	}
	
	public void execute()
	{
		// Target을 모아서 처리 => 위빙
		System.out.println("my수행전"); // Before
		my.execute();
		System.out.println("my수행gn"); // After
	}
}
