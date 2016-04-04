package com.internousdev.prototype1602.dao;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;

import org.bson.Document;

import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.WriteModel;
import com.mongodb.util.JSON;
import com.opensymphony.xwork2.ActionSupport;

import util.MongoDBConnector;

public class MongoDBDAO extends ActionSupport{
	public String mongoInsert(){
		MongoDatabase database = null;
		MongoDBConnector conn = new MongoDBConnector();
		try{
			database = conn.getConnection();
		}catch(UnknownHostException e){
			e.printStackTrace();
		}
		MongoCollection<Document> colls = database.getCollection("goods");
		List<WriteModel> list;
		colls.bulkWrite([
   { insertOne : { "document" : <document> } }
] ));
		
		
		
		try{
//			database = conn.getConnection();
//			MongoCollection<Document> colls = database.getCollection("goods");
//			Document doc = Document.parse(JSON.parse("{'goods':'" + goods + "'," + "'price':'" + price + "',"
//	                + "'text':'" + text + "'," + "'limit':'" + limit + "'," + "'day':'" + day "'}").toString());
			colls.bulkWrite(List<? extends WriteModel<? extends Document>> arg0);
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				conn.closeConnection();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return ERROR;
	}
}
