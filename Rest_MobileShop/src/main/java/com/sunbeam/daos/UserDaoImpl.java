
package com.sunbeam.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sunbeam.entities.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private UserRowMapper userRowMapper;
	@Override
	public User findByEmail(String email) {
		String sql = "SELECT * FROM users WHERE email = ?";
		List<User> list = jdbcTemplate.query(sql, userRowMapper, email);
		return list.isEmpty() ? null : list.get(0);
	}
	@Override
	public User findById(int id) {
		String sql = "SELECT * FROM users WHERE id = ?";
		List<User> list = jdbcTemplate.query(sql, userRowMapper, id);
		return list.isEmpty() ? null : list.get(0);
	}
	@Override
	public List<User> findAll() {
		String sql = "SELECT * FROM users";
		List<User> list = jdbcTemplate.query(sql, userRowMapper);
		return list;
	}
	@Override
	public int save(User c) {
		String sql = "INSERT INTO users(uname, email, mobile, password) VALUES(?, ?, ?, ?)";
		int count = jdbcTemplate.update(sql, c.getName(), c.getEmail(), c.getMobile(), c.getPassword());
		return count;
	}
	@Override
	public int update(User c) {
		String sql = "UPDATE users SET uname=?, email=?, mobile=?, password=? WHERE id=?";
		int count = jdbcTemplate.update(sql, c.getName(), c.getEmail(), c.getMobile(), c.getPassword(), c.getId());
		return count;
	}
}



