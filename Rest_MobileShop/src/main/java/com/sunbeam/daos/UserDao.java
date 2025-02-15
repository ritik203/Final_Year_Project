

package com.sunbeam.daos;

import java.util.List;

import com.sunbeam.entities.User;



public interface UserDao {
	User findByEmail(String email);
	int save(User c);
	User findById(int id);
	List<User> findAll();
	int update(User c);
}
