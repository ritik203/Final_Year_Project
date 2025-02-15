package com.sunbeam.services;

import java.util.List;

import com.sunbeam.entities.Mobile;

public interface MobileService {

	List<Mobile> findAllMobiles();
	Mobile findById(int id);
	int saveMobile(Mobile m);
	
	
}
