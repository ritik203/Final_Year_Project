package com.sunbeam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.entities.Result;
import com.sunbeam.entities.User;
import com.sunbeam.services.UserService;

@RestController
public class UserController {
@Autowired
private UserService userService;

@GetMapping("/users")
public Result getAllUsers() {
	List<User> list=userService.findAll();
	return Result.success(list);
}





}
