package com.sists.spring3;

public class MainClass {
	public static void main(String[] args) {
		Container c=new Container();
		A a=(A)c.getBean("a");
		System.out.println("a="+a);
		a.sayHello();
		A a1=(A)c.getBean("a"); // ��ü ã�� => DL
		System.out.println("a1="+a1);
		a1.sayHello();
		
		B b=(B)c.getBean("b");
		System.out.println("b="+b);
		b.sayHello();
	}
}
