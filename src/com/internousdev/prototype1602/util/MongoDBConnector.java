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
	private MongoClient mc;
	/**
	 * @return
	 * @throws UnknownHostException
	 */
	public MongoDatabase getConnection()throws UnknownHostException{
		MongoDatabase database = null;
		mc = new MongoClient("localhost", 27017);
		database = mc.getDatabase("fruits");
		return database;
	}
	/**
	 *
	 */
	public void closeConnection(){
		mc.close();
	}
}
