package com.system.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageRowBounds;
import com.system.entity.dto.PageDto;
import com.system.entity.pojo.CrwlCategory;
import com.system.entity.pojo.User;
import com.system.mapper.UserMapper;
import com.system.service.UserListService;

@Service
public class UserListServiceImpl implements UserListService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public PageDto<User> getUserList(User user, PageDto<User> pageDto) {
		PageRowBounds pageRowBounds = new PageRowBounds(pageDto.getPageNum(), pageDto.getPageSize());
		List<User> data = userMapper.selectBySelective(user, pageRowBounds);
		pageDto.setTotal(pageRowBounds.getTotal());
		pageDto.setResult(data);
		return pageDto;
	}

	@Override
	public int saveOrUpdateUser(User user) {
		if(StringUtils.isNotEmpty(user.getUserId())){
			return userMapper.updateByPrimaryKeySelective(user);
		}else{
			user.setCreateTime(new Date());
			userMapper.insertSelective(user);
			return 1;
		    
		}
	}

	@Override
	public int deleteUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.deleteByPrimaryKey(user);
	}

}
