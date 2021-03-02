package com.system.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.entity.pojo.User;
import com.system.mapper.UserMapper;
import com.system.service.LoginService;
import com.system.util.MD5Util;
import com.system.util.SessionUtil;




@Service
public class LoginServiceImpl implements LoginService{


	@Autowired
	private UserMapper userMapper;


	/**
	 * 用户登录
	 */
	public Map<String, Object> userLogin(User cspUser,HttpSession session) {
		Map<String, Object>  map=new HashMap<String,Object>();
		cspUser.setUserPassword(MD5Util.encode(cspUser.getUserPassword()));
		User cspUser1=userMapper.selecUser(cspUser);
		if(cspUser1!=null){
			SessionUtil.setUserDetail(session, cspUser1);
			map.put("flag", true);
			map.put("user", cspUser1);

		}else{
			map.put("flag", false);
			map.put("resultMsg", "账号或密码输入错误");
		}

		return map;
	}


	public static void main(String[] args) {
		System.out.println(MD5Util.encode("admin"));

	}





}