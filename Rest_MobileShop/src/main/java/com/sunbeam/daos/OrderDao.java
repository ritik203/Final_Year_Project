

package com.sunbeam.daos;

import java.util.List;

import com.sunbeam.entities.Order;

public interface OrderDao {
	int save(Order order);
	int deleteById(int id);
	List<Order> findByUserId(int userId);
	List<Order> findAll();
	Order findById(int orderId);
	int update(Order order);
}
