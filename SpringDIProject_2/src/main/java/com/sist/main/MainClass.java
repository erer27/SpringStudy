package com.sist.main;
/*
 *		** Component : Ŭ���� �Ѱ� (����� ������ �ִ� Ŭ����)
 *						JButton / JTextField
 *						~Model / ~Manager / ~DAO => ��ǰ
 *						=> CPU / �޸� / �ϵ��ũ ...
 *		** Container : ������ => Ŭ���� �����ϴ� ����
 *						=> ���� ����
 *			| Ŭ���� ����
 *			  --------
 *				1) ��ü ����
 *				<bean id="a" class="com.sist.main.A">
 *					=> Class clsName=Class.forName("com.sist.main.A")
 *						Object obj=clsName.newInstance()
 *						=> map.put("a",obj) => ������
 *				2) �����ÿ� ��������� ���� �ʱ�ȭ
 *					---------------------- DI
 *					 | setXxx() => setter DI
 *					 | ������ �Ű����� => constructor DI
 *					 | ������ / �Ҹ�ÿ� �޼ҵ� ȣ�� => method DI
 *				3) ��ü�� ã�� => DL => getBean()
 *				4) ��ü �Ҹ� 
 *			| ��� 3��
 *			  Ŭ���� ��� / DI 
 *			  1) XML : ���� ���
 *			  2) Annotaion : ����
 *			  3) XML+Annotation => �� / �ǹ�
 *				 --- ----------
 *					 | ����� ���� Ŭ����
 *				 | ������Ʈ���� ���� ���Ǵ� �κ� / ���̺귯�� Ŭ����
 *											 -------------
 *											MyBatis / Transaction
 *			=> �������� ���Ǵ� Ŭ������ �޼ҵ带 ��Ƽ� ���� : ������
 *				=> com.sist.commons 
 *				=> �ڵ� ȣ���� ���� (AOP)
 *			=> �� => MVC
 *				=> �߰� (Task,Security / Batch / SI / Spring-Data)
 *			=> �����ӿ�ũ VS ���̺귯��
 *			   -------	  --------
 *			   | ����		   | ����ǰ
 *			   => �⺻ ������ ���� Ʋ�� ��������ִ�
 *							   --
 *				  ���Ŀ� �°� ������ ��� 
 *				  --- XML/Annotation
 *						  | �̹� ������� �ִ� = @Controller / @RequestMapping
 *					  | �̹� �±װ� ������� �ִ� (�Ӽ�) => DTD/��Ű��
 *				  --- ���̺귯�� �߰� : pom.xml / gradle(Spring-Boot)
 *			
 *			���������� �����ϴ� ���̺귯��
 *				= spring-core : Container/DI
 *				= spring-aop : AOP => ������
 *				= spring-orm : Mybatis / JPA
 *				= spring-dao : JDBC
 *				= spring-web / spring-webmvc
 *			������ ��� ����
 *				= ���꼺 => ���̺귯���� �پ�� / �ŷڼ��� ���� / ���� ����
 *				= ���� ������ / Ȯ�强 => �ٸ� ���α׷� ���� ����
 *				= ���� / �������� ����
 * 
 * 
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
