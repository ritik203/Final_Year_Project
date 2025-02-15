package com.sunbeam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	private UserDaoImpl daoImpl;

	@Override
	public List<User> findAll() {
		List<User> list=daoImpl.findAll();
		return list;
	}
	
	

	
	
	
	
}
