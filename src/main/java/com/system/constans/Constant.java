package com.system.constans;

import java.util.ArrayList;
import java.util.List;

import com.system.entity.pojo.CrwlResult;

public class Constant {
	
	
	public static List<CrwlResult> resultList = new ArrayList<CrwlResult>();
	
	public static String tiebacontent = null;
	/**
	 * 统一返回状态码
	 * 
	 * @author
	 *
	 */
	public static enum RESULT_STATE {
		/**
		 * 200-成功
		 */
		OK("200"),
		/**
		 * 500-异常
		 */
		EXCEPTION("500"),
		/**
		 * 400-失败
		 */
		FAIL("400"),
		/**
		 * 没登录
		 */
		NOT_LOGIN("401");
		
		private String resultState;

		RESULT_STATE(String resultState) {
			this.resultState = resultState;
		}

		public String getResultState() {
			return resultState;
		}
	}

}
