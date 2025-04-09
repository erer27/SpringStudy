package com.sist.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.sist.*"})
@MapperScan(basePackages = {"com.sist.mapper"})
// <tx:annotation-driven/>
@EnableTransactionManagement
@EnableWebMvc
// xml / 자바 => xml+자바
public class MvcConfig implements WebMvcConfigurer {

/*
	// HandlerMapping, HandlerAdapter 초기화
	// DispatcherServlet === HandlerMapping
//								| @GetMapping(URL)
//								  @PostMapping(URI)
//						Model(@Controller,@RestController) <=> DAO
//										 | request/model
//									DispatcherServlet
//										| JSP를 역할
//										  => return "main/main"
//									ViewResolver
//										| request
//									   JSP
 *
 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// TODO Auto-generated method stub
		configurer.enable();
		
	}
	
	@Bean("viewResolver")
	public ViewResolver viewResolver()
	{
		InternalResourceViewResolver ir=new InternalResourceViewResolver();
		ir.setPrefix("/");
		ir.setSuffix(".jsp");
		return ir;
	}
	
	// BasicDataSource
	@Bean("ds")
	public DataSource dataSource()
	{
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUsername("hr");
		ds.setPassword("happy");
		return ds;
	}
	// SqlSessionFactory
	@Bean("ssf")
	public SqlSessionFactory sqlSessionFactory() throws Exception
	{
		SqlSessionFactoryBean ssf=new SqlSessionFactoryBean();
		ssf.setDataSource(dataSource());
		return ssf.getObject();
	}
	// Transaction
	@Bean("transactionManager")
	public PlatformTransactionManager transactionManager()
	{
		DataSourceTransactionManager tx=new DataSourceTransactionManager();
		tx.setDataSource(dataSource());
		return tx;
	}
	// Mapper구현
}
