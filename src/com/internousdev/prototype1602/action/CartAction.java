package com.internousdev.prototype1602.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.prototype1602.dao.CartMysqlDAO;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport implements SessionAware{
	private int goodsId;
	private String goodsNum;
	private String userId;
	private Map<String, ArrayList> session;
	private ArrayList list;

	public String addCart(){
		if(session.containsKey("id_key") == null){
			list.add(goodsId, goodsNum);
			session.put("temp_key", list);
		}else{
			CartMysqlDAO dao = new CartMysqlDAO();
			if(list.contains("goods_id")){
				String result = dao.updateSQL(データベース名, テーブル名);
				return result;
			}else{
				String result = dao.insertSQL(データベース名, テーブル名);
				return result;
			}
		}
	}

	public String deleteCart(){
		if(session.containsKey("id_key") == null){
			session.get("temp_key");
			list.remove(goodsId);
		}else{
			CartMysqlDAO dao = new CartMysqlDAO();
			String result = dao.deleteSQL(データベース名, テーブル名);
			return result;
		}
	}


	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(String goodsNum) {
		this.goodsNum = goodsNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
