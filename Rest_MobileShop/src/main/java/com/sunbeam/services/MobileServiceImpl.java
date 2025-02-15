package com.sunbeam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.MobileDaoImpl;
import com.sunbeam.entities.Mobile;

@Service
public class MobileServiceImpl  implements MobileService{
	@Autowired
	private MobileDaoImpl dao;
	
	@Override
	public List<Mobile> findAllMobiles() {
		List<Mobile> list = dao.findAll();
		return list;
	}

	public Mobile findById(int id) {
		Mobile m=dao.findById(id);
		return m;
	}

	@Override
	public int saveMobile(Mobile m) {
		int id = dao.save(m);
		return id;
	}

	

}
