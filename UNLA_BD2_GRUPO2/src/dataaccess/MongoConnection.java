package dataaccess;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.*;






public class MongoConnection {

	private static MongoClient client = null;
	
	// Singleton for MongoClient
	// Creates a single connection pool internally
	
	public static MongoClient getMongoClient()
	{
		if(client == null)
		{
			MongoClient mongoClient = MongoClients.create();
			client = mongoClient;
		}
		return client;
	}
	
	// Utility method to get database instance
	public MongoDatabase getDB()
	{
		return getMongoClient().getDatabase("test");
	}
	
	// Utility method to get user collection
	
	public MongoCollection<Document> getUserCollection(String collection)
	{
		return getDB().getCollection(collection);
	}
	
	// Return all documents from user collection
	 
    public void returnDocuments(String collection)
    {
    	MongoCollection<Document> mCollection = getUserCollection(collection);
    	List<Document> documents = (List<Document>) mCollection.find().into(new ArrayList<Document>());

		for (Document document : documents) {
			System.out.println(document);
		}
    }
	
    // Insert document non-repetitive to collection
    
    public void addDocumentsToCollection(String collection, ArrayList<String> jsonList)
    {
    	MongoCollection<Document> mCollection = getUserCollection(collection);
    	
    	for(String json : jsonList)
    	{
    		mCollection.insertOne(Document.parse(json));
    	}
    }
    
    public void listAllCollectionsWithDocuments()
    {
    	for(String collection : getDB().listCollectionNames())
    	{
    		System.out.println(collection);
    		MongoCollection<Document> col = getDB().getCollection(collection);
    		List<Document> documents = (List<Document>) col.find().into(new ArrayList<Document>());
    		for (Document document : documents) {
				System.out.println(document);
			}
    		
    	}
    }
    
    
}
