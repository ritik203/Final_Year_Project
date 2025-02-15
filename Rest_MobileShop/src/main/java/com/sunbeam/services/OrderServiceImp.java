package com.sunbeam.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.MobileDaoImpl;
import com.sunbeam.daos.OrderDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.Mobile;
import com.sunbeam.entities.Order;
import com.sunbeam.entities.OrderDto;
import com.sunbeam.entities.User;

@Service
public class OrderServiceImp implements OrderService {
	
	
	@Autowired
	private MobileDaoImpl mdao;
	
	@Autowired
	private UserDaoImpl udao;
	
	@Autowired
	private OrderDao odao;

	@Override
	public List<OrderDto> findOrderByUserId(int userId) {
		List<OrderDto> list = new ArrayList<OrderDto>();
		List<Order> orderList = odao.findByUserId(userId);
		for (Order order : orderList) {
			int orderId = order.getId();
			Mobile mobile = mdao.findById(order.getMobileId());
			User user = udao.findById(order.getUserId());
			OrderDto dto = new OrderDto(orderId, user, mobile);
			list.add(dto);
		}
		return list;
	}

}
