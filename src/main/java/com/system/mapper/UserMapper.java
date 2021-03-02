package com.system.mapper;

import java.util.List;

import com.github.pagehelper.PageRowBounds;
import com.system.entity.pojo.User;
import com.system.util.MyMapper;

public interface UserMapper extends MyMapper<User> {

	User selecUser(User cspUser);
	
	User selecUserByUserName(User cspUser);

	List<User> selectBySelective(User user, PageRowBounds pageRowBounds);
}