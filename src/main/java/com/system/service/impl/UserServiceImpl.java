package com.system.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.entity.pojo.User;
import com.system.mapper.UserMapper;
import com.system.service.UserService;
import com.system.util.MD5Util;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private  UserMapper UserMapper;

	@Override
	public int updatePass(User User) {
		
		return UserMapper.updateByPrimaryKeySelective(User);
	}
	@Override
	public int saveOrUpdateUser(User User) {
		User Users=new  User();
		Users.setAccount(User.getAccount());
		User Userf=UserMapper.selectOne(Users);
		if(Userf!=null){
			return -1;
		}
		 User.setUserPassword( MD5Util.encode(User.getUserPassword()));
		User.setCreateTime(new Date());
		 UserMapper.insertSelective(User);
		 
		
		 return 1;
		 
		 
	}
	
	@Override
	public User selectByUserId(User users) {
		// TODO Auto-generated method stub
		return UserMapper.selectByPrimaryKey(users.getUserId());
	}
	@Override
	public int saveOrUpdateUserInfo(User user) {
		user.setCreateTime(new Date());
			UserMapper.updateByPrimaryKeySelective(user);
		return 1;
	}
	@Override
	public User getUser(User user) {
		// TODO Auto-generated method stub
		return UserMapper.selectOne(user);
	}

}
