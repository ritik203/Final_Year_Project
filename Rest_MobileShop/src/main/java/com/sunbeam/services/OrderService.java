package com.sunbeam.services;

import java.util.List;

import com.sunbeam.entities.OrderDto;

public interface OrderService {
	
	List<OrderDto> findOrderByUserId(int userId);

}
