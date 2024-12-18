package com.example.ApnaShow.in.ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.ApnaShow.in.Entity.UserEntity;
import com.example.ApnaShow.in.Repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository usersRepo;

	public CustomUserDetailsService(UserRepository usersRepo) {
		super();
		this.usersRepo = usersRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserEntity user = usersRepo.findByEmail(email);
		if (user != null) {
			return user;
		}
		throw new UsernameNotFoundException("User not found with email: " + email);

	}

}
