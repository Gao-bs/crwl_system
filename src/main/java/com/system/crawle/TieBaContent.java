package com.system.crawle;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.system.constans.Constant;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;
import us.codecraft.webmagic.utils.HttpConstant;

public class TieBaContent implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);
    
    private  String targetUrl;
    
    
    
    
  public  TieBaContent(){
    	
    	
    	
    }
    public  TieBaContent(String targetUrl){
    	
    	this.targetUrl=targetUrl;
    }
    
    public  void  zXPC(String targetUrl){
    	
    	  Request request = new Request(targetUrl);
          request.setMethod(HttpConstant.Method.GET);
          Spider.create(new TieBaContent(targetUrl)).addRequest(request).thread(5).run();
    	
    }
    

   
    public Site getSite() {
        return site;
    }
    public void process(Page page) {
    	try{
    		String url = page.getRequest().getUrl();
    		Document document = Jsoup.connect(url).get();
			String title = document.title();
			 
    		Constant.tiebacontent = title ;
    	
    	}catch(Exception e){
    		
    		e.printStackTrace();
    	}
    }



}

