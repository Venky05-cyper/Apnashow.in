package com.example.ApnaShow.in.ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.ApnaShow.in.Bean.UserBean;
import com.example.ApnaShow.in.Entity.UserEntity;
import com.example.ApnaShow.in.Repository.UserRepository;
import com.example.ApnaShow.in.Service.UserService;

@Service
public class userImpService implements UserService {

	@Autowired
	UserRepository userRepo;

	@Autowired
	PasswordEncoder pass;

	@Override
	public String UserData(UserBean request) {
		// TODO Auto-generated method stub
		UserEntity user = new UserEntity();
		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user.setPassword(pass.encode(request.getPassword()));
		userRepo.save(user);
		return "user data saved";
	}

	@Override
	public List<UserEntity> getUserdata() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}
}
