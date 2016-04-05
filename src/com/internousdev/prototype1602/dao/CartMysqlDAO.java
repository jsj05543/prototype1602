package com.internousdev.prototype1602.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.internousdev.prototype1602.dto.TempDTO;
import com.internousdev.prototype1602.util.DBConnector;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author RYUNOSUKE MATSUURA
 * @version 1.0
 * @since 1.0
 *
 */
public class CartMysqlDAO extends ActionSupport {
	/**
	 * 生成されたシリアルナンバー
	 */
	private static final long serialVersionUID = -4064505317697641162L;
	private String goodsName;
	private String goodsNum;
	private String userId;
	private PreparedStatement ps;
	private Connection conn = null;
	private Map<String, Object> session;

	/**カートに商品と個数を登録するためのメソッド
	 * @param goodsName
	 * @param goodsNum
	 * @return
	 */
	public String insertTemp(String goodsName, String goodsNum) {
		try {
			conn = (Connection) DBConnector.getConnection("prototype");
			String sql = "INSERT INTO temp VALUES (?, ?, ?) ";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, goodsName);
			ps.setString(2, goodsNum);
			ps.setString(3, userId);
			ps.executeUpdate();
			// conn.commit();
			return SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return ERROR;
	}

	/**カートに入っている商品の個数を変更するためのメソッド
	 * @param goodsName
	 * @param goodsNum
	 * @return
	 */
	public String updateTemp(String goodsName, String goodsNum) {
		try {
			conn = (Connection) DBConnector.getConnection("prototype");
			String sql = "UPDATE temp SET goods_num = ? WHERE goods_name = ? AND user_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, goodsNum);
			ps.setString(2, goodsName);
			ps.setString(3, userId);
			ps.executeUpdate();
			return SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return ERROR;
	}

	/**カートに入っている商品を取得するためのメソッド
	 * @param
	 * @param
	 * @return
	 */
	public ArrayList<TempDTO> selectTemp(String userId) {
		try {
			ArrayList<TempDTO> list = new ArrayList<TempDTO>();
			conn = (Connection) DBConnector.getConnection("prototype");
			String sql = "SELECT goods_name, goods_num FROM temp WHERE user_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(rs.getString("goods_id"), rs.getString("goods_num"));

				// setGoodsId(rs.getString("goods_id"));
				// setGoodsNum(rs.getString("goods_num"));
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * カート内に重複している商品の有無を調べるためのメソッド
	 *
	 * @param goodsName
	 * @return
	 */
	public boolean findTemp(String goodsName) {
		try {
			conn = (Connection) DBConnector.getConnection("prototype");
			String sql = "SELECT goods_id, goods_num FROM temp WHERE user_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(rs.getString("goods_id"), rs.getString("goods_num"));

				// setGoodsId(rs.getString("goods_id"));
				// setGoodsNum(rs.getString("goods_num"));
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
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
	public String deleteTemp(String goodsName) {
		try {
			conn = (Connection) DBConnector.getConnection("prototype");
			String sql = "DELETE FROM temp WHERE goods_name = ? AND user_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, goodsName);
			ps.setString(2, userId);
			ps.executeUpdate();
			return SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return ERROR;
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

}
