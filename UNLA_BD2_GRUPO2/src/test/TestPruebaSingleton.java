package test;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.*;
import com.mongodb.client.MongoClient;
import com.google.gson.Gson;
import com.mongodb.*;

import modelo.Cliente;
import modelo.Domicilio;

public class TestPruebaSingleton {

	public static void main(String[] args) {
		
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		
		clientes.add(new Cliente("Perez", "Pepito", 12345678, 1111, new Domicilio("Calle falsa", 123, "Longchamps", "Buenos Aires" )));
		clientes.add(new Cliente("Perez1", "Pepito", 12345678, 1111, new Domicilio("Calle falsa", 123, "Longchamps", "Buenos Aires" )));	
		clientes.add(new Cliente("Perez2", "Pepito", 12345678, 1111, new Domicilio("Calle falsa", 123, "Longchamps", "Buenos Aires" )));
		clientes.add(new Cliente("Perez3", "Pepito", 12345678, 1111, new Domicilio("Calle falsa", 123, "Longchamps", "Buenos Aires" )));
		
		MongoClient mongoClient = MongoClients.create();
		
		MongoDatabase database = mongoClient.getDatabase("test");

		Gson gson = new Gson();
		
		MongoCollection<Document> collection = database.getCollection("cliente");
		
		//Si no hay collections se agrega
		if(collection.countDocuments() == 0)
		{
		
			MongoIterable<String> collections = database.listCollectionNames();
	
			for(Cliente cl : clientes)
			{
				String json = gson.toJson(cl);
				collection.insertOne(Document.parse(json));
			}
			
			// Muestra la collections en consola
			for (String collectionName : collections) {
				System.out.println(collectionName);
			}
		}

		// Muestra los documentos
		List<Document> documents = (List<Document>) collection.find().into(new ArrayList<Document>());

		for (Document document : documents) {
			System.out.println(document);
		}
	}

}