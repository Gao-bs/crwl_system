package com.system.service;

import com.system.entity.pojo.User;

public interface UserService {

	int updatePass(User User);

	int saveOrUpdateUser(User User);

	User selectByUserId(User users);

	int saveOrUpdateUserInfo(User user);

	User getUser(User user);

}
