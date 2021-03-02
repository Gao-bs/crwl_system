package com.system.controller.visitor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.system.entity.pojo.User;
import com.system.service.LoginService;
import com.system.util.SessionUtil;


/**
 * 登录控制器
 * @author 555
 *
 */
@Controller
@RequestMapping("web/visitor")
public class LoginController {

	@Autowired
	private LoginService igLoginService;

	
	@RequestMapping(value = "/toLogin")
	public ModelAndView toLogin(ModelAndView view,HttpSession session){
		view.setViewName("visitor/login");
		return view;
		
	}
	
	@RequestMapping(value = "/toForgetPwd")
	public ModelAndView toForgetPwd(ModelAndView view){
		view.setViewName("visitor/forgetPwd");
		return view;
		
	}


	/**
	 * 用户登录
	 */
	@RequestMapping(value = "/userLogin")
	public @ResponseBody Map<String,Object> userLogin(User cspUser,HttpSession session) {
		Map<String,Object>  map=new HashMap<String,Object>();
		User igUser1=SessionUtil.getUserDetail(session);
		if(igUser1!=null){
			map.put("flag", true);
			map.put("user", igUser1);
			return map;
		}
		try{
			 map=igLoginService.userLogin(cspUser,session);
		}catch(Exception e){
			map.put("flag", false);
			map.put("resultMsg", "系统异常");
		}
		
		return map;
	}
	
	
	


}
