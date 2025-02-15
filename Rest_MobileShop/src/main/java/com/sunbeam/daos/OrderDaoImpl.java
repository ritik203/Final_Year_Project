
package com.sunbeam.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sunbeam.entities.Order;

@Repository
public class OrderDaoImpl implements OrderDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private OrderRowMapper orderRowMapper;
	
	@Override
	public int save(Order order) {
		String sql = "INSERT INTO orders(uid, mid) VALUES(?, ?)";
		int count = jdbcTemplate.update(sql, order.getUserId(), order.getMobileId());
		return count;
	}

	@Override
	public int deleteById(int id) {
		String sql = "DELETE FROM orders WHERE id = ?";
		int count = jdbcTemplate.update(sql, id);
		return count;
	}

	@Override
	public Order findById(int orderId) {
		String sql = "SELECT * FROM orders WHERE id = ?";
		List<Order> list = jdbcTemplate.query(sql, orderRowMapper, orderId);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public List<Order> findByUserId(int userId) {
		String sql = "SELECT * FROM orders WHERE uid = ?";
		List<Order> list = jdbcTemplate.query(sql, orderRowMapper, userId);
		return list;
	}

	@Override
	public List<Order> findAll() {
		String sql = "SELECT * FROM orders";
		List<Order> list = jdbcTemplate.query(sql, orderRowMapper);
		return list;
	}
	
	@Override
	public int update(Order order) {
		String sql = "UPDATE orders SET uid=?, mid=? WHERE id=?";
		int count = jdbcTemplate.update(sql, order.getUserId(), order.getMobileId(), order.getId());
		return count;
	}
}
