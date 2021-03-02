package com.system.controller.manage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.system.entity.dto.PageDto;
import com.system.entity.pojo.CrwlCategory;
import com.system.entity.vo.ResultVo;
import com.system.service.CrawleService;
import com.system.service.CrwlCategoryService;
import com.system.util.ResultUtil;

/**
 * 控制器
 * 
 * @author 555
 */
@Controller
@RequestMapping("web/manage")
public class CrwlCategoryController {

	@Autowired
	private CrwlCategoryService CrwlCategoryService;

	@Autowired
	private CrawleService crawleService;

	/**
	 * 到管理
	 * 
	 * @param view
	 * @return
	 */
	@RequestMapping(value = "/toCrwlCategory")
	public ModelAndView toCrwlCategory(ModelAndView view) {
		view.setViewName("manage/CrwlCategory");
		return view;

	}

	/**
	 * @param sysOrder
	 * @return
	 */
	@RequestMapping(value = "/getCrwlCategoryList")
	@ResponseBody
	public ResultVo getCrwlCategoryList(CrwlCategory CrwlCategory, PageDto<CrwlCategory> cpsPageDto) {
		try {

			PageDto<CrwlCategory> pageDto = CrwlCategoryService.getCrwlCategoryList(CrwlCategory, cpsPageDto);
			return ResultUtil.success(pageDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.exception();
		}
	}

	/**
	 * 更新
	 * 
	 * @param view
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/saveOrUpdateCrwlCategory")
	@ResponseBody
	public ResultVo saveOrUpdateCrwlCategory(CrwlCategory CrwlCategory) {
		try {

			int result = CrwlCategoryService.saveOrUpdateCrwlCategory(CrwlCategory);
			return ResultUtil.success(result);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.exception();
		}

	}

	/**
	 * 删除
	 * 
	 * @param view
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/deleteCrwlCategory")
	@ResponseBody
	public ResultVo deleteCrwlCategory(CrwlCategory CrwlCategory) {
		try {
			int result = CrwlCategoryService.deleteCrwlCategory(CrwlCategory);
			return ResultUtil.success(result);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.exception();
		}

	}

	/**
	 * 开始爬取
	 * 
	 * @param CrwlCategory
	 * @return
	 */
	@RequestMapping(value = "/startCrawl")
	@ResponseBody
	public ResultVo startCrawl(CrwlCategory CrwlCategory) {
		try {
			int result = crawleService.startCrawl(CrwlCategory);
			return ResultUtil.success(result);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.exception();
		}

	}

}
