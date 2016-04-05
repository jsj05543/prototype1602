package com.internousdev.prototype1602.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.prototype1602.dao.CartMysqlDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * カート操作をするクラス
 *
 * @author RYUNOSUKE MATSUURA
 * @version 1.0
 * @since 1.0
 *
 */
public class CartAction extends ActionSupport implements SessionAware {
	/**
	 * 生成されたシリアルナンバー
	 */
	private static final long serialVersionUID = 6564301791905828778L;
	private String goodsName;
	private String goodsNum;
	private String userId;
	private Map<String, ArrayList<Map<String, String>>> cartSesssion;
	private Map<String, Object> session;
	private Map<String, String> goodsMap;
	private ArrayList<Map<String, String>> orderList;

	/**
	 * カートに注文情報を登録するメソッド
	 *
	 * @return
	 */
	public String addCart() {
		/**
		 * 非ログイン時にセッションに注文情報を格納するためのメソッド
		 */
		if (session.containsKey("id_key") == false) {
			goodsMap.put(goodsName, goodsNum);
			orderList.add(goodsMap);
			session.put("temp_key", orderList);
			return SUCCESS;
			/**
			 * ログイン時に一時テーブルに注文情報を格納するためのメソッド
			 */
		} else {
			CartMysqlDAO dao = new CartMysqlDAO();
			if (dao.findTemp(goodsName)) {
				String result = dao.updateTemp(goodsName, goodsNum);
				return result;
			} else {
				String result = dao.insertTemp(goodsName, goodsNum);
				return result;
			}
		}
	}

	/**
	 * カートの注文情報を削除するメソッド
	 *
	 * @return
	 */
	public String deleteCart() {
		if (session.containsKey("id_key") == false) {
			session.get("temp_key");
		} else {
			CartMysqlDAO dao = new CartMysqlDAO();
			String result = dao.deleteSQL("prototype", "temp");
			return result;
		}
	}

	/**
	 * @return goodsName
	 */
	public String getGoodsName() {
		return goodsName;
	}

	/**
	 * @param goodsName
	 *            セットする goodsName
	 */
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	/**
	 * @return goodsNum
	 */
	public String getGoodsNum() {
		return goodsNum;
	}

	/**
	 * @param goodsNum
	 *            セットする goodsNum
	 */
	public void setGoodsNum(String goodsNum) {
		this.goodsNum = goodsNum;
	}

	/**
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            セットする userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return cartSesssion
	 */
	public Map<String, ArrayList<Map<String, String>>> getCartSesssion() {
		return cartSesssion;
	}

	/**
	 * @param cartSesssion
	 *            セットする cartSesssion
	 */
	public void setCartSesssion(Map<String, ArrayList<Map<String, String>>> cartSesssion) {
		this.cartSesssion = cartSesssion;
	}

	/**
	 * @return session
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * @param session
	 *            セットする session
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * @return goodsMap
	 */
	public Map<String, String> getGoodsMap() {
		return goodsMap;
	}

	/**
	 * @param goodsMap
	 *            セットする goodsMap
	 */
	public void setGoodsMap(Map<String, String> goodsMap) {
		this.goodsMap = goodsMap;
	}

	/**
	 * @return orderList
	 */
	public ArrayList<Map<String, String>> getOrderList() {
		return orderList;
	}

	/**
	 * @param orderList
	 *            セットする orderList
	 */
	public void setOrderList(ArrayList<Map<String, String>> orderList) {
		this.orderList = orderList;
	}

}
