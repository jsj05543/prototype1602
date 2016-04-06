package com.internousdev.prototype1602.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport implements SessionAware{
	private int goodsId;
	private int goodsNum;
	private Map<String, ArrayList<Map<Integer,Integer>>> session;
	private ArrayList<Map<Integer, Integer>> tempList;
	private Map<Integer, Integer> goodsSes;

	public String insertCart(){
		String ret = ERROR;
		if(session.containsKey("temp_key") == false){
			goodsSes.put(goodsId, goodsNum);
			tempList.add(goodsSes);
			session.put("temp_key", tempList);
			ret = SUCCESS;
		}else{

		}


		return ret;
	}

}
