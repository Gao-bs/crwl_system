package com.system.service;

import com.system.entity.dto.PageDto;
import com.system.entity.pojo.User;

public interface UserListService {

	PageDto<com.system.entity.pojo.User> getUserList(User user, PageDto<User> cpsPageDto);

	int saveOrUpdateUser(User user);

	int deleteUser(User user);

}
