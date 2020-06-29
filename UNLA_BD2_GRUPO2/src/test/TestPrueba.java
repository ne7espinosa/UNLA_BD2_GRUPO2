package test;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.*;
import com.google.gson.Gson;

import modelo.Cliente;
import modelo.Domicilio;
import modelo.Empleado;
import modelo.Sucursal;

public class TestPrueba {

	public static void main(String[] args) {
		
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		
		clientes.add(new Cliente("Perez", "Pepito", 12345678, "PAMI", 1111, new Domicilio("Calle falsa", 123, "Longchamps", "Buenos Aires" )));
		clientes.add(new Cliente("Perez1", "Pepito", 12345678, "PAMI", 1111, new Domicilio("Calle falsa", 123, "Longchamps", "Buenos Aires" )));	
		clientes.add(new Cliente("Perez2", "Pepito", 12345678, "PAMI", 1111, new Domicilio("Calle falsa", 123, "Longchamps", "Buenos Aires" )));
		clientes.add(new Cliente("Perez3", "Pepito", 12345678, "PAMI", 1111, new Domicilio("Calle falsa", 123, "Longchamps", "Buenos Aires" )));
		
		
		//Se crean tres sucursales
		Sucursal suc1 = new Sucursal(new Domicilio("Av. Siempreviva", 482, "Springfield", "Oregon" ), 001);
		Sucursal suc2 = new Sucursal(new Domicilio("Calle Cordoba", 1562, "CABA", "Buenos Aires" ), 002);
		Sucursal suc3 = new Sucursal(new Domicilio("Gral. Villegas", 908, "Lanus", "Buenos Aires" ), 003);
				
		//se generan tres empleados por sucursal
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		empleados.add(new Empleado("Rodriguez", "Gerardo", 11111111, 11111111, "Galeno", 1,
				new Domicilio("Calle 1", 123, "Lanus", "Buenos Aires" ), "vendedor", "empleado", suc1));
		empleados.add(new Empleado("De La Vega", "Diego", 22222222, 22222222, "OSPF", 2,
				new Domicilio("Calle 1", 123, "Lanus", "Buenos Aires" ), "vendedor", "empleado", suc1));
		empleados.add(new Empleado("Torres", "Alvaro", 33333333, 33333333, "PAMI", 3,
				new Domicilio("Calle 1", 123, "Lanus", "Buenos Aires" ), "vendedor", "empleado", suc1));
		
		empleados.add(new Empleado("Valenzuela", "Gabriel", 44444444, 44444444, "Galeno", 4,
				new Domicilio("Calle 1", 123, "Lanus", "Buenos Aires" ), "vendedor", "empleado", suc2));
		empleados.add(new Empleado("De La Vega", "Diego", 55555555, 55555555, "OSPF", 5,
				new Domicilio("Calle 1", 123, "Lanus", "Buenos Aires" ), "vendedor", "empleado", suc2));
		empleados.add(new Empleado("Torres", "Alvaro", 66666666, 66666666, "PAMI", 6,
				new Domicilio("Calle 1", 123, "Lanus", "Buenos Aires" ), "vendedor", "empleado", suc2));
		
		empleados.add(new Empleado("Valenzuela", "Gabriel", 77777777, 77777777, "Galeno", 7,
				new Domicilio("Calle 1", 123, "Lanus", "Buenos Aires" ), "vendedor", "empleado", suc3));
		empleados.add(new Empleado("De La Vega", "Diego", 88888888, 88888888, "OSPF", 8,
				new Domicilio("Calle 1", 123, "Lanus", "Buenos Aires" ), "vendedor", "empleado", suc3));
		empleados.add(new Empleado("Torres", "Alvaro", 99999999, 99999999, "PAMI", 9,
				new Domicilio("Calle 1", 123, "Lanus", "Buenos Aires" ), "vendedor", "empleado", suc3));
		
		
		
		
		
		MongoClient mongoClient = MongoClients.create();
		
		MongoDatabase database = mongoClient.getDatabase("test");

		Gson gson = new Gson();
		
		MongoCollection<Document> collectionCliente = database.getCollection("cliente");
		MongoCollection<Document> collectionSucursal = database.getCollection("sucursal");
		MongoCollection<Document> collectionEmpleado = database.getCollection("empleado");
		
		//Si no hay collections se agrega
		if(collectionCliente.countDocuments() == 0)
		{
		
			MongoIterable<String> collections = database.listCollectionNames();
	
			//Se cargan clientes
			for(Cliente cl : clientes)
			{
				String jsonCl = gson.toJson(cl);
				collectionCliente.insertOne(Document.parse(jsonCl));
			}
			
			//Se cargan sucursales
			String jsonSuc1 = gson.toJson(suc1);
			String jsonSuc2 = gson.toJson(suc2);
			String jsonSuc3 = gson.toJson(suc3);
			collectionSucursal.insertOne(Document.parse(jsonSuc1));
			collectionSucursal.insertOne(Document.parse(jsonSuc2));
			collectionSucursal.insertOne(Document.parse(jsonSuc3));
			
			//Se cargan empleados
			
			for(Empleado emp : empleados)
			{
				String jsonEmp = gson.toJson(emp);
				collectionEmpleado.insertOne(Document.parse(jsonEmp));
			}
			
			//muestra colecciones en consola
			for (String colection:collections ) {
				System.out.println(colection);
			}
		}

		// Muestra los documentos
		List<Document> documents = (List<Document>) collectionCliente.find().into(new ArrayList<Document>());
		documents.addAll((List<Document>) collectionSucursal.find().into(new ArrayList<Document>()));
		documents.addAll((List<Document>) collectionEmpleado.find().into(new ArrayList<Document>()));
		
		
		for (Document document : documents) {
			System.out.println(document);
		}
	}

}