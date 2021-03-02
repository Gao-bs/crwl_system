package com.system.controller.manage;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
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
import com.system.util.SessionUtil;

/**
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("web/manage")
public class UserController {

	@Autowired
	private UserService UserService;
	
	
	@RequestMapping(value = "/updatePass")
	@ResponseBody
	public ResultVo updatePass(HttpSession httpSession,User user,String orinPass){
		   try{
			   User users=  SessionUtil.getUserDetail(httpSession);
			   if(!StringUtils.equals(users.getUserPassword(), MD5Util.encode(orinPass))){
				   return  ResultUtil.success(-1);
			   }
			   user.setUserId(users.getUserId());
			   user.setUserPassword( MD5Util.encode(user.getUserPassword()));
		     	int result=UserService.updatePass(user);
		     	 return  ResultUtil.success(result);
			    }catch(Exception e){
				e.printStackTrace();
				return  ResultUtil.exception();
			   }
		
	}

	@RequestMapping(value = "/toUserInfo")
	public ModelAndView toUserInfo(ModelAndView view) {
		view.setViewName("manage/UserInfo");
		return view;
	}

	/**
	 * 更新
	 * 
	 * @param view
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/saveOrUpdateUser")
	@ResponseBody
	public ResultVo saveOrUpdateUser(HttpSession httpSession,User User) {
		try {
			User users = SessionUtil.getUserDetail(httpSession);
			User.setUserId(users.getUserId());
		

			int result = UserService.saveOrUpdateUserInfo(User);
			return ResultUtil.success(result);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.exception();
		}

	}

	/**
	 * 得到用户信息
	 * 
	 * @param User
	 * @return
	 */
	@RequestMapping(value = "/getUserInfo")
	@ResponseBody
	public ResultVo getUserInfo(HttpSession httpSession, User User) {
		try {
			User users = SessionUtil.getUserDetail(httpSession);
			User userss = UserService.selectByUserId(users);
		
			return ResultUtil.success(userss);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.exception();
		}

	}

}
