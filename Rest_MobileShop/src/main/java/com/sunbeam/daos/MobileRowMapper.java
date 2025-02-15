

package com.sunbeam.daos;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.sunbeam.entities.Mobile;


@Component
public class MobileRowMapper implements RowMapper<Mobile> {
	@Override
	public Mobile mapRow(ResultSet rs, int rowNum) throws SQLException {
		int id = rs.getInt("id");
		String name = rs.getString("mname");
		int ram = rs.getInt("ram");
		int storage = rs.getInt("storage");
		String company = rs.getString("Company");
		double price = rs.getDouble("price");
		String image = rs.getString("image");
		Mobile m = new Mobile(id, name, ram, storage, company, price, image);
		return m;
	}	
}
