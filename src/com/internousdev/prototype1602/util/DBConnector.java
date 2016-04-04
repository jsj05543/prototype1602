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



	private static String driverName = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost/prototype";

	//適宜各自の環境に応じた設定にしてください（特にいじっていないのであればこのままでOK）
	private static String user = "root";
	private static String password = "mysql";


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
            con = (Connection) DriverManager.getConnection(url,user,password);
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
