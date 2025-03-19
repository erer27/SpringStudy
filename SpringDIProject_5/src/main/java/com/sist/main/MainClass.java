package com.sist.main;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * 
 * 
 * 		Spring => Basic : 여러명이 동시 개발
 * 			유지보수 기반
 * 		= DI => 70%
 * 		= AOP => 반복 제거 (공통기반의 클래스)
 * 		= ORM => 데이터베이스 연동 (MyBatis, JPA, Hibernate)
 * 		= MVC
 * 		= Security 
 * 
 * 		1) DI => 주입
 * 		   -- IoC => DI
 * 			  --- 제어의 역전 (마틴파울러) => AI
 * 			  범위 => 클래스와 클래스의 연관관계를 설정 (클래스 다이어그램)
 * 					=> p:객체명-ref="id명"
 * 					클래스에 필요한 데이터를 주입 
 * 					----------------------
 * 					=> p:변수명="값"
 * 					   -----------
 * 						setter / constructor
 * 						-------------------- XML에서만 가능
 * 						어노테이션에서는 사용이 불가능
 * 		클래스 한개 메모리 할당
 * 			<bean>
 * 		클래스 여러개를 한번에 메모리 할당
 * 			<context:component-scan basepackage="">
 * 			=> 선별해서 메모리 할당 요청
 * 					 -------------- 메모리에 할당된 객체만 스프링이 관리
 * 				@Controller : Model 클래스 / 요청처리 => Web
 * 				@Component : 일반 클래스 => MainClass ..
 * 				@Repository	: 저장소 => DAO
 * 				@Service : BI => 통합 (DAO를 여러개를 한번 통합시에 주로 사용)
 * 						   EmpDAO / DeptDAO 
 * 						   ---------------- 조인 / 서브쿼리
 * 				@ResController : 다른 프로그램 연동
 * 								 ---------- 자바스크립트 (JSON) => WEB
 * 											---------------
 * 											| VueJS
 * 				@ControllerAdvice : 공통 예외처리 
 * 				@RestControllerAdvice : 공통 예외처리
 * 				@Bean : 자바로 클래스 설정
 * 				 <bean>
 * 				----------------------
 * 		
 * 				1. 클래스를 한개씩 방식 <bean> 
 * 					XML
 * 				2. 모든 클래스를 한번에 등록 : 패키지 단위
 * 					Annotation
 * 				3. XML + Annotation : 실제 사용
 * 							| 개별 클래스 (사용자 정의 클래스)
 * 					| 공통 적용되는 클래스 (라이브러리 클래스) => DAO / 보안
 */
import com.sist.goods.*;
import com.sist.member.*;
import com.sist.sawon.*;
public class MainClass {
	public static void main(String[] args) {
		//등록한 XML을 컨테이너로 전송
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		// 클래스 찾기 => 활용
		SawonManager sa=(SawonManager)app.getBean("sa");
		sa.display();
		MemberManager mem=(MemberManager)app.getBean("mem");
		mem.display();
		GoodsManager goods=(GoodsManager)app.getBean("goods");
		goods.display();
	}
}
