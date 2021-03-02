package com.system.service;

import com.system.entity.pojo.CrwlCategory;
import com.system.entity.pojo.CrwlResult;

public interface CrawleService {

	int startCrawl(CrwlCategory crwlCategory);

	String startCrawlContent(CrwlResult crwlResult);

}
