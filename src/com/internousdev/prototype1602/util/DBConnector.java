/**
 *
 */
package com.internousdev.prototype1602.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author internous
 *mysqlへ接続する、conオブジェクトを返すためのメソッドを提供するクラス
 */
public class DBConnector {

    /**
     * MySQLのドライバー名
     */
    private static String driverName = "com.mysql.jdbc.Driver";

    /**
     * MySQLのデータベースのURL
     */
    private static String url = "jdbc:mysql://localhost/";

    /**
     * MySQLのユーザー名
     */
    private static String user = "root";

    /**
     * MySQLのパスワード
     */
    private static String pass = "mysql";

    /**
     * MySQLの指定したデータベースに接続するメソッド
     * @param database データベース
     * @return con 指定したデータベースへのコネクション情報を返します。
     */
    public static Connection getConnection(String database){
        url += database;
        Connection con = null;
        try{
            Class.forName(driverName);
            con = (Connection) DriverManager.getConnection(url,user,pass);
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        url = "jdbc:mysql://localhost/";
        return con;
    }
}
