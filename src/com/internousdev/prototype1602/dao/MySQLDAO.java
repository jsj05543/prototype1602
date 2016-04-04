/**
 *
 */
package com.internousdev.prototype1602.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.prototype1602.dto.MySQLDTO;
import com.internousdev.prototype1602.util.DBConnector;

/**
 * ユーザー情報を取得、追加、更新、削除するDAOクラス
 *
 * @author SHOUGO TOOI
 * @since 1.0
 * @version 1.0
 *
 */
public class MySQLDAO {

    private Connection conn = DBConnector.getConnection("prototype");
    private String sql = null;
    private MySQLDTO dto = null;

    /**
     * idからユーザー情報を取得するメソッド
     *
     * @param id ユーザーID
     * @return ArrayList 取得に成功すればユーザー情報を格納したDTO、失敗すればnullを返す。
     */
    public List<MySQLDTO> select(String id) {
        ArrayList<MySQLDTO> list = new ArrayList<>();
        sql = "select id,password from login_table where id = ?";

        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                dto = new MySQLDTO();
                dto.setId(rs.getString("id"));
                dto.setPassword(rs.getString("password"));
                list.add(dto);
            }
        } catch (SQLException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 全てのユーザー情報を取得するメソッド
     *
     * @param id ユーザーID
     * @return ArrayList 取得に成功すればユーザー情報を格納したDTO、失敗すればnullを返す。
     */
    public List<MySQLDTO> selectAll() {
        ArrayList<MySQLDTO> list = new ArrayList<>();
        sql = "select id,password from login_table";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dto = new MySQLDTO();
                dto.setId(rs.getString("id"));
                dto.setPassword(rs.getString("password"));
                list.add(dto);
            }
        } catch (SQLException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
        return list;
    }

    /**
     * @param id ユーザーID
     * @param password パスワード
     * @return 追加に成功すればtrue、失敗すればfalseを返す。
     */
    public boolean insert(String id, String password) {
        boolean ret = false;
        sql = "insert into login_table" + "(id,password)values" + " (?,?)";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, password);
            if (ps.executeUpdate() != 0) {
                ret = true;
            }

        } catch (SQLException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }

        return ret;
    }

    /**
     * @param id ユーザーID
     * @param password パスワード
     * @return 更新に成功すればtrue、失敗すればfalseを返す。
     */
    public boolean update(String id, String password) {
        boolean ret = false;
        sql = "update login_table set id=?, password=? where id = ?";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, password);
            ps.setString(3, id);
            if (ps.executeUpdate() != 0) {
                ret = true;
            }

        } catch (SQLException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * @param id ユーザーID
     * @return 削除に成功すればtrue、失敗すればfalseを返す。
     */
    public boolean delete(String id) {
        boolean ret = false;
        sql = "delete from login_table where id = ?";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            if (ps.executeUpdate() != 0) {
                ret = true;
            }

        } catch (SQLException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
        return ret;
    }

}
