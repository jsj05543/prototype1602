package com.internousdev.prototype1602.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;

import com.internousdev.prototype1602.util.MongoDBConnector;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.InsertOneModel;
import com.mongodb.client.model.WriteModel;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author RYUNOSUKE MATSUURA
 * @version 1.0
 * @since 1.0
 *
 */
public class MongoDBDAO extends ActionSupport {
	/**
	 * 生成されたシリアルナンバー
	 */
	private static final long serialVersionUID = -3313638948441998068L;

	/**
	 * MongoDBに登録するためのメソッド
	 *
	 * @return
	 */
	public String mongoInsert(Document fruitsName, String fruitsPrice, String fruitsText) {
		MongoDatabase database = null;
		MongoDBConnector conn = new MongoDBConnector();
		try {
			database = conn.getConnection();
			MongoCollection<Document> colls = database.getCollection("fruits");
			List<WriteModel<Document>> list = new ArrayList<WriteModel<Document>>();

			list.add();



			list = Arrays.<WriteModel<Document>>asList(
					new InsertOneModel<Document>(
							new Document()
							)
					);

//			List<WriteModel<Document>> inserts = Arrays.<WriteModel<Document>>asList(
//					new InsertOneModel<Document>(
//							new Document()
//							)
//					);

			colls.bulkWrite(list);

//			colls.bulkWrite([insertOne:{"document":{"fruits_id":,"fruits_name":fruitsName,"fruits_price":fruitsPrice,"fruits_text":fruitsText}}]);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ERROR;
	}

	/**
	 * MongoDBに登録されている内容を削除するメソッド
	 *
	 * @return
	 */
	public String mongoDelete() {
		return null;

	}

	/**
	 * MongoDBに登録されている内容を検索するメソッド
	 *
	 * @return
	 */
	public String mongoFind() {
		return null;

	}
}
