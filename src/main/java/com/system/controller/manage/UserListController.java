package com.system.controller.manage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.system.entity.dto.PageDto;
import com.system.entity.pojo.User;
import com.system.entity.vo.ResultVo;
import com.system.service.UserListService;
import com.system.service.UserService;
import com.system.util.ResultUtil;


/**
 * 控制器
 * @author 555
 */
@Controller
@RequestMapping("web/manage")
public class UserListController {
	
	@Autowired
	private   UserListService UserService;
	
	
	
	/**
	 * 到管理
	 * @param view
	 * @return
	 */
	@RequestMapping(value = "/toUserList")
	public ModelAndView toUserList(ModelAndView view){
		view.setViewName("manage/UserList");
		return view;
		
	}
	
	@RequestMapping(value = "/toUserAudit")
	public ModelAndView toUserAudit(ModelAndView view){
		view.setViewName("manage/UserAudit");
		return view;
		
	}
	
	/**
	 * @param sysOrder
	 * @return
	 */
	@RequestMapping(value = "/getUserList")
	@ResponseBody
	public ResultVo getUserList(User User,PageDto<User> cpsPageDto){
		  try{
			
			    PageDto<User> pageDto =  UserService.getUserList(User, cpsPageDto);
			    return  ResultUtil.success(pageDto);
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
	@RequestMapping(value = "/saveOrUpdateUserList")
	@ResponseBody
	public ResultVo saveOrUpdateUserList(User User
		){
		   try{
			  
		     	int result=UserService.saveOrUpdateUser(User);
		     	 return  ResultUtil.success(result);
			    }catch(Exception e){
				e.printStackTrace();
				return  ResultUtil.exception();
			   }
		
	}
	
	
	/**
	 * 删除
	 * @param view
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/deleteUserList")
	@ResponseBody
	public ResultVo deleteUserList(User User){
		   try{
		     	int result=UserService.deleteUser(User);
		     	 return  ResultUtil.success(result);
			    }catch(Exception e){
				e.printStackTrace();
				return  ResultUtil.exception();
			   }
		
	}
	

}
