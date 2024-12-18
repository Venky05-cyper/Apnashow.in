package com.example.ApnaShow.in.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ApnaShow.in.Bean.UserBean;
import com.example.ApnaShow.in.Entity.UserEntity;
import com.example.ApnaShow.in.Service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

	@Autowired
	UserService userser;

	@PostMapping("/userDetails")
	public String UserData(@RequestBody UserBean request) {
		return userser.UserData(request);
	}

	@GetMapping("/getUserData")
	public List<UserEntity> getUserdata() {
		return userser.getUserdata();
	}
}
