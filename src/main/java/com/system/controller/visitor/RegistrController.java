package com.system.controller.visitor;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.system.entity.pojo.User;
import com.system.entity.vo.ResultVo;
import com.system.service.UserService;
import com.system.util.MD5Util;
import com.system.util.ResultUtil;

@Controller
@RequestMapping("web/visitor")
public class RegistrController {
	
	@Autowired
	private   UserService userService;

	@Autowired
	private UserService UserService;
	
	@RequestMapping(value = "/toRegister")
	public ModelAndView toRegister(ModelAndView view,HttpSession session){
		view.setViewName("visitor/register");
		return view;
		
	}

	
	
	@RequestMapping(value = "/updatePass")
	@ResponseBody
	public ResultVo updatePass(User user){
		   try{
			   User  users=UserService.selectByUserId(user);
			 
			   user.setUserId(users.getUserId());
			   user.setUserPassword( MD5Util.encode(user.getUserPassword()));
		     	int result=UserService.updatePass(user);
		     	 return  ResultUtil.success(result);
			    }catch(Exception e){
				e.printStackTrace();
				return  ResultUtil.exception();
			   }
		
	}
	
	
	/**
	 * 更新
	 * @param view
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/saveOrUpdateUser")
	@ResponseBody
	public ResultVo saveOrUpdateUser(User user){
		   try{
		     	int result=userService.saveOrUpdateUser(user);
		     	 return  ResultUtil.success(result);
			    }catch(Exception e){
				e.printStackTrace();
				return  ResultUtil.exception();
			   }
		
	}
	
	@RequestMapping(value = "/getUser")
	@ResponseBody
	public ResultVo getUser(User user){
		   try{
			   User result=userService.getUser(user);
		     	 return  ResultUtil.success(result);
			    }catch(Exception e){
				e.printStackTrace();
				return  ResultUtil.exception();
			   }
		
	}

}
