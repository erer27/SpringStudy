package com.sist.main;
// Proxy => �븮�� => AOP
/*
 * 	���α׷� => �ٽ� �ڵ�
 * 			  -------
 * 			   �ΰ����� �ڵ� => ��Ƽ� ���� => ������ / AOP
 * 				 | �����ͺ��̽� ���� / �����ͺ��̽� ����
 * 				 | ���� (�ΰ� => ����)
 * 				 | Ʈ����� => commit / rollback
 * 				 | �α�
 * 				 | ���� �����
 * 				 ------------------------ AOP ���̺귯��
 * 				 | ����� ���� AOP (�ѵι�)
 * 				   ------------- ���ͼ�Ʈ (�ڵ� �α���), AOP 
 * 		�ߺ� ���� => �޼ҵ�ȭ ó��
 * 		---------------------- CallBack
 * 		AOP�� ���
 * 		1. Aspect : �������� ����ȵ� ����� ��Ƶ� ��� => ���� ���
 * 		2. Target : �����ϴ� �� => ����ִ� ���� (����)
 * 		3. Advice : ��� ��� ����� �߰��� ��
 * 					JoinPoint + PointCut
 * 		4. JoinPoint : ���� => ��� ȣ�� 
 * 					   Before
 * 					   After
 * 					   After-Returning
 * 					   After-Throwing
 * 					   Around 
 * 		
 * 					   public void display()
 * 					   {
 * 							try
 * 							{
 * 								---------Around start
 * 								  => �α�
 * 								  => � �޼ҵ带 ��û
 * 								  => setAutoCommit(false)
 * 								 �ٽ� �ڵ� => �޼ҵ� ȣ��
 * 								---------Around end
 * 									=> �ɸ� �ð� Ȯ��
 * 									=> commit
 * 							}catch(Exception ex)
 * 							{
 * 								After-Throwing => �����߻��� ó��
 * 							}
 * 							finally
 * 							{
 * 								=> ������ ���� : After	
 * 							}
 * 							return => After-Throwing ��������
 * 					   }
 * 		5. PointCut : � �޼ҵ� => execution("������ ��Ű��.Ŭ������.�޼ҵ��(..)")
 * 											  *						 ----
 * 																| �Ű������� 0�� �̻�
 * 
 * 				=> �޼ҵ忡 ���� �����ϴ� �ҽ��� ��Ƶд� : Aspect
 * 				--------------------------------------------
 * 				=> �޼ҵ尡 ȣ��ɶ�	==> PointCut
 * 				=> �޼ҵ� � ��ġ�� ���������� ���� ==> JoinPoint
 * 				-------------------------------------------- Advice
 * 								 -------- Weaving
 * 				=> include�� ���� : ����ø��� �ڵ� ȣ��
 * 				   ------- ���� ���� 
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		My m=new My();
		m.execute();
		
		MyTarget mt=new MyTarget(m);
		mt.execute();
	}

}
