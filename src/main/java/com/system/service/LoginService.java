package com.system.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.system.entity.pojo.User;


public interface LoginService {

	Map<String, Object> userLogin(User igUser, HttpSession session);


}
