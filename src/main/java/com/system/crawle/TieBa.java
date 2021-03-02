package com.system.crawle;

import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.system.constans.Constant;
import com.system.entity.dto.TieBaDto;
import com.system.entity.pojo.CrwlResult;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.utils.HttpConstant;

public class TieBa implements PageProcessor {

	private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

	private String targetUrl;

	private String key;

	private Integer pageNum;

	private String type;

	public TieBa() {

	}

	public TieBa(String targetUrl, String key, Integer pageNum, String type) {

		this.key = key;
		this.targetUrl = targetUrl;
		this.pageNum = pageNum;
		this.type = type;
	}

	public void zXPC(String targetUrl, String key, Integer pageNum, String type) {

		Request request = new Request(targetUrl + new Date().getTime());
		request.setMethod(HttpConstant.Method.GET);
		Spider.create(new TieBa(targetUrl, key, pageNum, type)).addRequest(request).thread(5).run();

	}

	public static void main(String[] args) {

	}

	public Site getSite() {
		return site;
	}

	public void process(Page page) {
		try {
			System.out.println(page.getRawText());
			String url = page.getRequest().getUrl();
			Document document = Jsoup.connect(url).get();
			Element postList = document.getElementsByClass("s_post_list").get(0);
			Elements elementsByClass = postList.getElementsByClass("s_post");
			for (Element element : elementsByClass) {
				Elements userEle = element.getElementsByClass("p_violet");
				if (userEle.size() < 1) {
					continue;
				}
				String user = userEle.get(1).text();
				System.err.println("user:" + user);
				Elements elementsByTag = element.getElementsByTag("a");
				Element topicRec = elementsByTag.get(0);
				String text = topicRec.text();
				System.out.println(text);
				CrwlResult crwlResult = new CrwlResult();
				crwlResult.setUrl("https://tieba.baidu.com"+topicRec.attr("href").toString());
				crwlResult.setCreateTime(new Date());
				crwlResult.setGjc(this.key);
				crwlResult.setUserName(user);
				crwlResult.setTitle(text);
				crwlResult.setType(this.type);
				Constant.resultList.add(crwlResult);
			}
			/*
			 * JSONObject jSONObject = JSON.parseObject(page.getRawText()); String data =
			 * jSONObject.getString("data"); JSONObject dataObject = JSON.parseObject(data);
			 * String LocalNews = dataObject.getString("LocalNews"); JSONObject
			 * localNewsObject = JSON.parseObject(LocalNews); String localNewsObjectdata =
			 * localNewsObject.getString("data"); JSONObject localNewsObjectdataO =
			 * JSON.parseObject(localNewsObjectdata); String rows =
			 * localNewsObjectdataO.getString("rows"); JSONObject rowso =
			 * JSON.parseObject(rows); String result = rowso.getString("first");
			 * List<TieBaDto> list = JSON.parseArray(result, TieBaDto.class); for (TieBaDto
			 * tieBaDto : list) { if (tieBaDto.getTitle().contains(this.key)) { CrwlResult
			 * crwlResult = new CrwlResult(); crwlResult.setUrl(tieBaDto.getUrl());
			 * crwlResult.setCreateTime(new Date()); crwlResult.setGjc(this.key);
			 * crwlResult.setTitle(tieBaDto.getTitle()); crwlResult.setType(this.type);
			 * Constant.resultList.add(crwlResult); }
			 * 
			 * }
			 */
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
