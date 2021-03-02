package com.system.crawle;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.system.constans.Constant;
import com.system.entity.pojo.CrwlResult;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.JsonPathSelector;

public class ReMen implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);
    
    private  String targetUrl;
    
    private String key;
    
    private String type;
    
    private Integer pageNum;
    
 
    public  ReMen(String targetUrl,String key,Integer pageNum,String type ){
    	
    	this.key=key;
    	this.targetUrl=targetUrl;
    	this.pageNum=pageNum;
    	this.type=type;
    	
    }
    
    public  void  zXPC(String targetUrl,String key,Integer pageNum,String type){
    	
    	Spider.create(new ReMen(targetUrl,key,pageNum,type))
        .addUrl(targetUrl)
        .run();
    	
    }
    

    public static void main(String[] args) {
       /* Spider.create(new ReMen())
                .addUrl("https://m.weibo.cn/api/container/getIndex?containerid=102803_ctg1_8999_-_ctg1_8999_home")

                .run();*/
    }
    public Site getSite() {
        return site;
    }
    public void process(Page page) {
        List<String> urls = new ArrayList<String>();
        urls.add(this.targetUrl);
        page.addTargetRequests(urls);
        String pagestring = page.getRawText();
        if (pagestring.length()>100) {
            List<String> links = new ArrayList<String>();
            links = new JsonPathSelector("$.data.cards[*].scheme").selectList(pagestring);
            List<String> username = new ArrayList<String>();
        /*    List<String> page_title = new ArrayList<String>();
              page_title = new JsonPathSelector("$.data.cards[*].page_title").selectList(pagestring);
*/
            username = new JsonPathSelector("$.data.cards[*].mblog.user.screen_name").selectList(pagestring);

            List<String> content = new ArrayList<String>();
            content = new JsonPathSelector("$.data.cards[*].mblog.text").selectList(pagestring);
            
            
            for (int i = 0; i < links.size(); i++) {
            	if(content.get(i).contains(this.key)){
            		CrwlResult crwlResult=new CrwlResult();
            		crwlResult.setUserName(username.get(i));
            		crwlResult.setUrl(links.get(i));
            		crwlResult.setContents(content.get(i).getBytes());
            		crwlResult.setCreateTime(new Date());
            		crwlResult.setGjc(this.key);
            		crwlResult.setType(this.type);
            		Constant.resultList.add(crwlResult);
            	}
            }
        }
    }



}

