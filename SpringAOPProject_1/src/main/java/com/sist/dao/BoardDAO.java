package com.sist.dao;
/*
 * 		���ռ��� ���� ���α׷� => �������� �����ڰ� ���� ���� 
 * 		---------------- Container / POJO / DI
 * 											| Ŭ���� �޸� �Ҵ��
 * 											 �ʿ��� ��쿡 ������� �ʱ�ȭ
 * 									| �ٸ� Ŭ������ ������ ���� ���� Ŭ����
 * 										=> �������̽� / ����� ������� �ʴ� �Ϲ� �ڹ� Ŭ����
 * 						| Ŭ������ ������ ��Ƽ� ����
 * 		=> ���� �ҽ��� ���� �߻� => �������� ���Ǵ� �ҽ��� ��Ƽ� ����
 * 							   ===========================
 * 								| ������ => AOP (Ⱦ������ ���α׷�)
 * 								  => �ݺ� �ڵ��� ���� �ʴ´�
 * 								| OOP VS AOP
 * 		�⺻
 * 		=> �ڵ� �ҽ�
 * 		   -------
 * 			���� ���Ǵ� �ҽ�
 * 			�ٽ� ���Ǵ� �ҽ�
 */
public class BoardDAO {
	public void getConnection()
	{
		System.out.println("����Ŭ ����!!");
	}
	public void disConnection()
	{
		System.out.println("����Ŭ �ݱ�!!");
	}
	
	public void boardListData(int page)
	{
		//getConnection();
		System.out.println(page+"������ ��� ���");
		//disConnection();
	}
	public String boardDetailData(String name)
	{
		//getConnection();
		System.out.println(name+"�� ���� �󼼺���");
		//disConnection();
		return name;
	}
	public void boardInsert()
	{
		//getConnection();
		System.out.println("�Խù� �߰� �Ϸ�");
		//disConnection();
	}
	public void boardUpdate()
	{
		//getConnection();
		System.out.println("�Խù� ���� �Ϸ�");
		//disConnection();
	}
	public void boardDelete()
	{
		//getConnection();
		System.out.println("�Խù� ���� �Ϸ�");
		//disConnection();
	}
	public void print()
	{
		System.out.println("���α׷� ����");
	}
	
}
