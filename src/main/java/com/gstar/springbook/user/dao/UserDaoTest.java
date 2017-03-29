package com.gstar.springbook.user.dao;

import java.sql.SQLException;

import com.gstar.springbook.user.domain.User;

public class UserDaoTest {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ConnectionMaker connectionMaker = new NConnectionMaker();
		UserDao dao = new UserDao(connectionMaker);
		// 1. UserDao 생성
		// 2. 사용할 ConnectionMaker 타입의 오브젝트 제공
		// --> 결국 두 오브젝트 사이의 의존관계 설정 효과!
		
		User user = new User();
		user.setId("cjfrtt1234");
		user.setName("김지별");
		user.setPassword("password");
		
		dao.add(user);
		
		System.out.println(user.getId() + "등록 성공");
		
		User user2 = dao.get(user.getId());
		System.out.println(user2.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		
		System.out.println(user2.getId() + "조회 성공");
	}

}
