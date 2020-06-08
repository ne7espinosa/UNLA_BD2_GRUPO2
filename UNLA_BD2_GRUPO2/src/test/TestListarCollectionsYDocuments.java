package test;

import dataaccess.MongoConnection;

public class TestListarCollectionsYDocuments {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MongoConnection mc = new MongoConnection();
		
		mc.listAllCollectionsWithDocuments();

	}

}
