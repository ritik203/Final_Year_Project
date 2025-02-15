
package com.sunbeam.daos;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.sunbeam.entities.Order;



@Component
public class OrderRowMapper implements RowMapper<Order> {
	@Override
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		int id = rs.getInt("id");
		int userId = rs.getInt("uid");
		int mobileId = rs.getInt("mid");
		Order o = new Order(id, userId, mobileId);
		return o;
	}	
}
