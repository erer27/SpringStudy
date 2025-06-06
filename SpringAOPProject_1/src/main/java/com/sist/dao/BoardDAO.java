package com.sist.dao;
/*
 * 		결합성이 낮은 프로그램 => 여러명의 개발자가 동시 개발 
 * 		---------------- Container / POJO / DI
 * 											| 클래스 메모리 할당시
 * 											 필요한 경우에 멤버변수 초기화
 * 									| 다른 클래스에 영향이 없는 독립 클래스
 * 										=> 인터페이스 / 상속을 사용하지 않는 일반 자바 클래스
 * 						| 클래스를 여러개 모아서 관리
 * 		=> 동일 소스가 많이 발생 => 공통으로 사용되는 소스를 모아서 관리
 * 							   ===========================
 * 								| 공통모듈 => AOP (횡단지향 프로그램)
 * 								  => 반복 코딩을 하지 않는다
 * 								| OOP VS AOP
 * 		기본
 * 		=> 코딩 소스
 * 		   -------
 * 			공통 사용되는 소스
 * 			핵심 사용되는 소스
 */
public class BoardDAO {
	public void getConnection()
	{
		System.out.println("오라클 연결!!");
	}
	public void disConnection()
	{
		System.out.println("오라클 닫기!!");
	}
	
	public void boardListData(int page)
	{
		//getConnection();
		System.out.println(page+"페이지 목록 출력");
		//disConnection();
	}
	public String boardDetailData(String name)
	{
		//getConnection();
		System.out.println(name+"에 대한 상세보기");
		//disConnection();
		return name;
	}
	public void boardInsert()
	{
		//getConnection();
		System.out.println("게시물 추가 완료");
		//disConnection();
	}
	public void boardUpdate()
	{
		//getConnection();
		System.out.println("게시물 수정 완료");
		//disConnection();
	}
	public void boardDelete()
	{
		//getConnection();
		System.out.println("게시물 삭제 완료");
		//disConnection();
	}
	public void print()
	{
		System.out.println("프로그램 종료");
	}
	
}
