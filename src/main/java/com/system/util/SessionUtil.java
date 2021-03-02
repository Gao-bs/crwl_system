package com.system.util;

import javax.servlet.http.HttpSession;

import com.system.entity.pojo.User;



public class SessionUtil {
	
	
	

	 public static void setUserDetail(HttpSession session,User cspUser) {
		 session.setAttribute("user",cspUser);
	 }
	 
	 
	
    public static User getUserDetail(HttpSession session) {
			return  (User) session.getAttribute("user");
		 }

}
