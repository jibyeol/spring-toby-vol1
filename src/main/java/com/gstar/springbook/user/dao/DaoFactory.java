package com.gstar.springbook.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration	// 스프링이 빈 팩토리를 위한 오브젝트 설정을 담당하는 
				// 클래스라고 인식할 수 있도록 이 애노테이션 추가함
				// 
				// 애플리케이션 컨텍스트 또는 빈 팩도리가 사용할 설정정보라는 표시
public class DaoFactory {

	@Bean	// 오브젝트 생성을 담당하는 IoC용 메소드라는 표시
	public UserDao userDao(){
		UserDao userDao = new UserDao(connectionMaker());
		return userDao;
	}

	@Bean
	public ConnectionMaker connectionMaker(){
		return new DConnectionMaker();
	}
	
}
