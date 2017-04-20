package com.gstar.springbook.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gstar.springbook.user.domain.User;

public class UserDao {
	
	// 초기에 설정하면 사용 중에는 바뀌지 않는 읽기 전용 인스턴스 변수
	private ConnectionMaker connectionMaker;
	
	// 매번 새로운 값으로 바뀌는 정보를 담는 인스턴스 변수
	// 심각한 문제가 발생한다. -- 어디서든 값을 바꿀 수 있음.
	private Connection c;
	private User user;
	
	public UserDao (ConnectionMaker connectionMaker){
		this.connectionMaker = connectionMaker;
	}

	public void add(User user) throws ClassNotFoundException, SQLException {
		Connection c = connectionMaker.makeNewConnection();
		PreparedStatement ps = c.prepareStatement("insert into users(id, name, password) values(?, ?, ?)");;
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		
		ps.executeUpdate();
		
		ps.close();
		c.close();
	}
	
	public User get(String id) throws ClassNotFoundException, SQLException {
		this.c = connectionMaker.makeNewConnection();
		PreparedStatement ps = c.prepareStatement("select * from users where id = ?");
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		rs.close();
		ps.close();
		c.close();
		return user;
		/*Connection c = connectionMaker.makeNewConnection();
		PreparedStatement ps = c.prepareStatement("select * from users where id = ?");
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		User user = new User();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		rs.close();
		ps.close();
		c.close();
		return user;*/
	}
}
