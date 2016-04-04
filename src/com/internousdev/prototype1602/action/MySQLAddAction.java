/**
 *
 */
package com.internousdev.prototype1602.action;

import com.internousdev.prototype1602.dao.MySQLDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ユーザーをデータベースへ追加するActionクラス
 * @author SHOUGO TOOI
 * @version 1.0
 * @since 1.0
 */
public class MySQLAddAction extends ActionSupport{

    /**
     * 生成されたシリアルナンバー
     */
    private static final long serialVersionUID = -3702786559657479634L;

    public String execute(){
        String msg = ERROR;
        MySQLDAO dao = new MySQLDAO();
        
        


        return msg;
    }

}
