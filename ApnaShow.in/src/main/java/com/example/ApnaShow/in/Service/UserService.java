package com.example.ApnaShow.in.Service;

import java.util.List;

import com.example.ApnaShow.in.Bean.UserBean;
import com.example.ApnaShow.in.Entity.UserEntity;

public interface UserService {

	public String UserData(UserBean request);

	public List<UserEntity> getUserdata();

}
