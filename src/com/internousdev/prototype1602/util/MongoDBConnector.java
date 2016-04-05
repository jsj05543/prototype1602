package com.internousdev.prototype1602.util;

import java.net.UnknownHostException;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 * @author RYUNOSUKE MATSUURA
 * @version 1.0
 * @since 1.0
 */
public class MongoDBConnector {
	/**
	 * Mongoクライアント
	 */
	private MongoClient mc;

	/**
	 * MongoDBに接続するためのメソッド
	 *
	 * @return database 指定したデータベースへの接続情報
	 * @throws UnknownHostException
	 *             ホスト解決に失敗したときの例外
	 */
	public MongoDatabase getConnection() throws UnknownHostException {
		MongoDatabase database = null;
		mc = new MongoClient("localhost", 27017);
		database = mc.getDatabase("goods");
		return database;
	}

	/**
	 * MongoDBの接続を開放するためのメソッド
	 *
	 */
	public void closeConnection() {
		mc.close();
	}
}
