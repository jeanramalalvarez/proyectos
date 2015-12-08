package com.util;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class MongoUtil {
	
	MongoClient mongo;
	
	public MongoUtil() {
		
		try {
			mongo = new MongoClient( "localhost" , 27017 );
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<String> getDataBaseNames(){
		return mongo.getDatabaseNames();
	}
	
	public DB getDB(String database){
		return mongo.getDB(database);
	}
	
	public DBCollection getCollection(String database, String collection){
		DB db = mongo.getDB(database);
		return db.getCollection(collection);
	}
	
	
	
	public static void main(String[] args) throws UnknownHostException {
		
		
		
		
		
		// Old version, uses Mongo
		//Mongo mongo0 = new Mongo("localhost", 27017);
	 
		// Since 2.10.0, uses MongoClient
		MongoClient mongo = new MongoClient( "localhost" , 27017 );
		
		//DB db = mongo.getDB("database name");
		
		
		
		
		
		DB db = mongo.getDB("testdb");
		Set<String> tables = db.getCollectionNames();
	 
		for(String coll : tables){
			System.out.println(coll);
		}
		
	}

}
