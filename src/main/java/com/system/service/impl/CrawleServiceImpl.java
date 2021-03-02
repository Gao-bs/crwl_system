package com.system.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.constans.Constant;
import com.system.crawle.ReMen;
import com.system.crawle.TieBa;
import com.system.crawle.TieBaContent;
import com.system.entity.pojo.CrwlCategory;
import com.system.entity.pojo.CrwlResult;
import com.system.mapper.CrwlCategoryMapper;
import com.system.mapper.CrwlResultMapper;
import com.system.service.CrawleService;

@Service
public class CrawleServiceImpl implements CrawleService {

	@Autowired
	private CrwlResultMapper crwlResultMapper;

	@Autowired
	private CrwlCategoryMapper CrwlCategoryMapper;

	@Override
	public int startCrawl(CrwlCategory crwlCategory) {
		Constant.resultList = new ArrayList<CrwlResult>();
		CrwlCategory crw = CrwlCategoryMapper.selectByPrimaryKey(crwlCategory);

		crwlCategory.setCategoryUrl(crw.getCategoryUrl());
		crwlCategory.setCategoryName(crw.getCategoryName());

		if (StringUtils.equals(crwlCategory.getCategoryName(), "贴吧")) {
			new TieBa(crwlCategory.getCategoryUrl(), crwlCategory.getKey(), crwlCategory.getPageNum(),
					crwlCategory.getCategoryName()).zXPC(crwlCategory.getCategoryUrl(), crwlCategory.getKey(),
							crwlCategory.getPageNum(), crwlCategory.getCategoryName());

		}
		List<CrwlResult> list = Constant.resultList;
		for (CrwlResult CrwlResult : list) {
			CrwlResult.setId(UUID.randomUUID().toString());
			crwlResultMapper.insertSelective(CrwlResult);

		}

		return 1;
	}

	/**
	 * 爬取内容
	 */
	public String startCrawlContent(CrwlResult crwlResult) {

		new TieBaContent(crwlResult.getUrl()).zXPC(crwlResult.getUrl());
		crwlResult.setContents(Constant.tiebacontent.getBytes());
		crwlResultMapper.updateByPrimaryKeySelective(crwlResult);
		return Constant.tiebacontent;
	}

}
