

package com.sunbeam.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sunbeam.entities.Mobile;


@Repository
public class MobileDaoImpl implements MobileDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private MobileRowMapper mobileRowMapper;
	
	@Override
	public int save(Mobile m) {
		String sql = "INSERT INTO mobiles(mname, ram, storage, Company, price, image) VALUES(?, ?, ?, ?, ?, ?)";
		int count = jdbcTemplate.update(sql, m.getName(), m.getRam(), m.getStorage(), m.getCompany(), m.getPrice(), m.getImage());
		if(count == 1)
			return getLastId();
		return count;
	}

	@Override
	public Mobile findById(int id) {
		String sql = "SELECT * FROM mobiles WHERE id = ?";
		List<Mobile> list = jdbcTemplate.query(sql, mobileRowMapper, id);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public List<Mobile> findAll() {
		String sql = "SELECT * FROM mobiles";
		List<Mobile> list = jdbcTemplate.query(sql, mobileRowMapper);
		return list;
	}

	@Override
	public int update(Mobile m) {
		String sql = "UPDATE mobiles SET mname=?, ram=?, storage=?, Company=?, price=?, image=? WHERE id=?";
		int count = jdbcTemplate.update(sql, m.getName(), m.getRam(), m.getStorage(), m.getCompany(), m.getPrice(), m.getImage(), m.getId());
		return count;
	}

	@Override
	public int deleteById(int id) {
		String sql = "DELETE FROM mobiles WHERE id=?";
		int count = jdbcTemplate.update(sql, id);
		return count;
	}
	
	@Override
	public int getLastId() {
		String sql = "SELECT LAST_INSERT_ID() id";
		int id = jdbcTemplate.queryForObject(sql, Integer.class);
		return id;
	}
}
