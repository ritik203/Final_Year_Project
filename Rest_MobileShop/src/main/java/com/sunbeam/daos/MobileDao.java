

package com.sunbeam.daos;

import java.util.List;

import com.sunbeam.entities.Mobile;


public interface MobileDao {
	int save(Mobile m);
	Mobile findById(int id);
	List<Mobile> findAll();
	int update(Mobile c);
	int deleteById(int id);
	int getLastId();
}
