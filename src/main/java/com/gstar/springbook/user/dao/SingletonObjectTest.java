package com.gstar.springbook.user.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonObjectTest {

	public static void main(String[] args){
		DaoFactory factory = new DaoFactory();
		UserDao dao1ByFactory = factory.userDao();
		UserDao dao2ByFactory = factory.userDao();
		
		System.out.println(dao1ByFactory);
		System.out.println(dao2ByFactory);
		
		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
		UserDao dao1ByContext = context.getBean("userDao", UserDao.class);
		UserDao dao2ByContext = context.getBean("userDao", UserDao.class);

		System.out.println(dao1ByContext);
		System.out.println(dao2ByContext);
	}
	
}
