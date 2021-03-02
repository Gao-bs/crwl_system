package com.system.controller.manage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.util.StringUtil;
import com.system.entity.dto.CrwlResultDto;
import com.system.entity.dto.PageDto;
import com.system.entity.pojo.CrwlResult;
import com.system.entity.vo.ResultVo;
import com.system.service.CrawleService;
import com.system.service.CrwlResultListService;
import com.system.util.ResultUtil;
import com.system.util.bayes.NBMain;

/**
 * 控制器
 * 
 * @author 555
 */
@Controller
@RequestMapping("web/manage")
public class CrwlResultController {

	@Autowired
	private CrwlResultListService CrwlResultService;

	@Autowired
	private CrawleService crawleService;

	/**
	 * 到管理
	 * 
	 * @param view
	 * @return
	 */
	@RequestMapping(value = "/toCrwlResultList")
	public ModelAndView toCrwlResultList(ModelAndView view) {
		view.setViewName("manage/CrwlResultList");
		return view;

	}

	/**
	 * 舆情分析
	 * 
	 * @param view
	 * @return
	 */
	@RequestMapping(value = "/toCrwlResultFenxi")
	public ModelAndView toCrwlResultFenxi(ModelAndView view) {

		// view.addObject(attributeName, attributeValue);
		view.setViewName("manage/CrwlResultFenxi");
		return view;

	}

	/**
	 * @param sysOrder
	 * @return
	 */
	@RequestMapping(value = "/getCrwlResultList")
	@ResponseBody
	public ResultVo getCrwlResultList(CrwlResult CrwlResult, PageDto<CrwlResult> cpsPageDto) {
		try {

			PageDto<CrwlResult> pageDto = CrwlResultService.getCrwlResultList(CrwlResult, cpsPageDto);

			return ResultUtil.success(pageDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.exception();
		}
	}

	/**
	 * @param sysOrder
	 * @return
	 */
	@RequestMapping(value = "/getStaticsCrwlResultList")
	@ResponseBody
	public ResultVo getStaticsCrwlResultList(CrwlResultDto CrwlResultDto, PageDto<CrwlResultDto> cpsPageDto) {
		try {

			PageDto<CrwlResultDto> pageDto = CrwlResultService.getStaticsCrwlResultList(CrwlResultDto, cpsPageDto);

			return ResultUtil.success(pageDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.exception();
		}
	}

	@RequestMapping(value = "/getStaticsCrwlResultListEcharts")
	@ResponseBody
	public ResultVo getStaticsCrwlResultListEcharts(String userName) {
		try {
			CrwlResult crwlResultVo = new CrwlResult();
			crwlResultVo.setUserName(userName);
			if(StringUtil.isEmpty(userName)) {
				return ResultUtil.exception();
			}
			List<Map<String, Object>> mpasList = new ArrayList<Map<String,Object>>();
			List<CrwlResult> selectAll = CrwlResultService.selectAll(crwlResultVo);
			for (CrwlResult crwlResult : selectAll) {
				//每行数据
				Map<String, Object> map = new HashMap<String, Object>();
				String title = crwlResult.getTitle();
				if(StringUtil.isEmpty(title) || StringUtil.isEmpty(crwlResult.getUserName()) ) {
					continue;
				}
				List<Word> words = WordSegmenter.seg(title);
				List<String> list = new ArrayList<String>();
				for (Word word : words) {
					list.add(word.getText());
				}
				int result = NBMain.tenology(list);
				map.put("key", crwlResult.getUserName());
				map.put("count", result);
				mpasList.add(map);
			}
			return ResultUtil.success(mpasList);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.exception();
		}
	}

	@RequestMapping(value = "/startCrawlContent")
	@ResponseBody
	public ResultVo startCrawlContent(CrwlResult CrwlResult) {
		try {

			String content = crawleService.startCrawlContent(CrwlResult);

			return ResultUtil.success(content);
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
	@RequestMapping(value = "/saveOrUpdateCrwlResultList")
	@ResponseBody
	public ResultVo saveOrUpdateCrwlResultList(CrwlResult CrwlResult) {
		try {

			int result = CrwlResultService.saveOrUpdateCrwlResult(CrwlResult);
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
	@RequestMapping(value = "/deleteCrwlResultList")
	@ResponseBody
	public ResultVo deleteCrwlResultList(CrwlResult CrwlResult) {
		try {
			int result = CrwlResultService.deleteCrwlResult(CrwlResult);
			return ResultUtil.success(result);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.exception();
		}

	}

}
