package com.internousdev.prototype1602.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.prototype1602.dto.TempDTO;
import com.internousdev.prototype1602.util.DBConnector;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author RYUNOSUKE MATSUURA
 * @version 1.0
 * @since 1.0r
 *
 */
public class CartMysqlDAO extends ActionSupport {
	/**
	 * 生成されたシリアルナンバー
	 */
	private static final long serialVersionUID = -4064505317697641162L;
	private String goodsId;
	private String goodsNum;
	private String userId;
	private PreparedStatement ps;
	private Connection conn = null;

	/**
	 * @param database データベース名
	 * @param table テーブル名
	 * @return
	 */
	public String insertSQL (String database, String table){
		try{
			conn = (Connection)DBConnector.getConnection(database);
			String sql = "INSERT INTO ? VALUES (?, ?, ?) ";
			PreparedStatement ps = (PreparedStatement)conn.prepareStatement(sql);
			ps.setString(1, table);
			ps.setString(2, goodsId);
			ps.setString(3, goodsNum);
			ps.setString(4, userId);
			ps.executeUpdate();
//			conn.commit();
			return SUCCESS;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(conn != null){
				try{
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		return ERROR;
	}

	/**
	 * @param database
	 * @param table
	 * @return
	 */
	public String updateSQL (String database, String table){
		try{
			conn = (Connection)DBConnector.getConnection(database);
			String sql = "UPDATE ? set goods_num = ? WHERE good_id = ? AND user_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, table);
			ps.setString(2, goodsNum);
			ps.setString(3, goodsId);
			ps.setString(4, userId);
			ps.executeUpdate();
			return SUCCESS;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(conn != null){
				try{
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		return ERROR;
	}

	/**
	 * @param database
	 * @param table
	 * @return
	 */
	public ArrayList<TempDTO> selectSQL(String database, String table){
		try{
			ArrayList<TempDTO> list = new ArrayList<TempDTO>();
			conn = (Connection)DBConnector.getConnection(database);
			String sql = "SELECT goods_id, goods_num FROM ? WHERE user_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, table);
			ps.setString(2, userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				list.add(rs.getString("goods_id"), rs.getString("goods_num"));

//				setGoodsId(rs.getString("goods_id"));
//				setGoodsNum(rs.getString("goods_num"));
				return list;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(conn != null){
				try{
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * @param database
	 * @param table
	 * @return
	 */
	public String deleteSQL(String database, String table){
		try{
			conn = (Connection)DBConnector.getConnection(database);
			String sql = "DELETE FROM ? WHERE goods_id = ? AND user_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, table);
			ps.setString(2, goodsId);
			ps.setString(3, userId);
			ps.executeUpdate();
			return SUCCESS;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(conn != null){
				try{
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		return ERROR;
	}

	/**
	 * @return
	 */
	public String getGoodsId() {
		return goodsId;
	}

	/**
	 * @param goodsId
	 */
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	/**
	 * @return
	 */
	public String getGoodsNum() {
		return goodsNum;
	}

	/**
	 * @param goodsNum
	 */
	public void setGoodsNum(String goodsNum) {
		this.goodsNum = goodsNum;
	}

	/**
	 * @return
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
