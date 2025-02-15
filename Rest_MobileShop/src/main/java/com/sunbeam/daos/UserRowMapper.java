

package com.sunbeam.daos;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.sunbeam.entities.User;



@Component
public class UserRowMapper implements RowMapper<User> {
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		int id = rs.getInt("id");
		String name = rs.getString("uname");
		String mobile = rs.getString("mobile");
		String password = rs.getString("password");
		String email = rs.getString("email");
		User c = new User(id, name, password, email, mobile);
		return c;
	}	
}
