package com.system.controller.manage;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("web/manage")
public class WebCommonController {
	

	
	/**
	 * @return
	 */
	@RequestMapping(value = "/logout")
	public ModelAndView invalidateSession(HttpSession session,ModelAndView view) {
		session.invalidate();
		view.setViewName("visitor/login");
		return view;
	}
	
	

    

}
