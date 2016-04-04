/**
 *
 */
package com.internousdev.prototype1602.dao;

import com.internousdev.prototype1602.dto.MySQLDTO;

/**
 * ユーザー情報を取得、追加、更新、削除するDAOクラス
 * @author SHOUGO TOOI
 * @since 1.0
 * @version 1.0
 *
 */
public class MySQLDAO {
    /**
     * idからユーザー情報を取得するメソッド
     * @param id ユーザーID
     * @return MySQLDTO 取得に成功すればユーザー情報を格納したDTO、失敗すればnullを返す。
     */
    public MySQLDTO select(int id){
        MySQLDTO dto = new MySQLDTO();


        return dto;
    }
    /**
     * @param id ユーザーID
     * @param password パスワード
     * @return 追加に成功すればtrue、失敗すればfalseを返す。
     */
    public boolean insert(int id,String password){
        boolean ret = false;


        return ret;
    }

    /**
     * @param id ユーザーID
     * @param password パスワード
     * @return 更新に成功すればtrue、失敗すればfalseを返す。
     */
    public boolean update(int id,String password){
        boolean ret = false;


        return ret;
    }
    /**
     * @param id ユーザーID
     * @return 削除に成功すればtrue、失敗すればfalseを返す。
     */
    public boolean delete(int id){
        boolean ret = false;


        return ret;
    }

}
