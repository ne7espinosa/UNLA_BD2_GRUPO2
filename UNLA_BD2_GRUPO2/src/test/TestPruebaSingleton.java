package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.*;
import com.mongodb.client.MongoClient;

import dataaccess.MongoConnection;

import com.google.gson.Gson;
import com.mongodb.*;

import modelo.Cliente;
import modelo.Domicilio;
import modelo.Empleado;
import modelo.ItemVenta;
import modelo.Producto;
import modelo.Sucursal;
import modelo.Venta;

public class TestPruebaSingleton {

	public static void main(String[] args) {

		// Se crean diez clientes
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();

		clientes.add(new Cliente("Perez", "Juan Carlos", 22222222, 1111,
				new Domicilio("Av. Alsina", 123, "Burzaco", "Buenos Aires")));
		clientes.add(new Cliente("Rodriguez", "Mariano", 33333333, 1111,
				new Domicilio("25 de Mayo", 1515, "Ministro Rivadavia", "Buenos Aires")));
		clientes.add(new Cliente("Gonzalez", "Julieta", 44444444, 1111,
				new Domicilio("Posadas", 456, "Longchamps", "Buenos Aires")));
		clientes.add(new Cliente("Garcia", "Roman", 12345678, 1111,
				new Domicilio("Alberti", 696, "Burzaco", "Buenos Aires")));

		// Se crean tres sucursales
		Sucursal suc1 = new Sucursal(new Domicilio("Av. Siempreviva", 482, "Springfield", "Oregon"), 001);
		Sucursal suc2 = new Sucursal(new Domicilio("Calle Cordoba", 1562, "CABA", "Buenos Aires"), 002);
		Sucursal suc3 = new Sucursal(new Domicilio("Gral. Villegas", 908, "Lanus", "Buenos Aires"), 003);

		// se generan tres empleados por sucursal
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		empleados.add(new Empleado("Rodriguez", "Gerardo", 11111111, 11111111, "Galeno", 1,
				new Domicilio("Calle 1", 123, "Lanus", "Buenos Aires"), "cajero", "encargado", suc1));
		empleados.add(new Empleado("De La Vega", "Diego", 22222222, 22222222, "OSPF", 2,
				new Domicilio("Calle 1", 123, "Lanus", "Buenos Aires"), "vendedor", "empleado", suc1));
		empleados.add(new Empleado("Torres", "Alvaro", 33333333, 33333333, "PAMI", 3,
				new Domicilio("Calle 1", 123, "Lanus", "Buenos Aires"), "vendedor", "empleado", suc1));

		empleados.add(new Empleado("Valenzuela", "Gabriel", 44444444, 44444444, "Galeno", 4,
				new Domicilio("Calle 1", 123, "Lanus", "Buenos Aires"), "cajero", "encargado", suc2));
		empleados.add(new Empleado("De La Vega", "Diego", 55555555, 55555555, "OSPF", 5,
				new Domicilio("Calle 1", 123, "Lanus", "Buenos Aires"), "vendedor", "empleado", suc2));
		empleados.add(new Empleado("Torres", "Alvaro", 66666666, 66666666, "PAMI", 6,
				new Domicilio("Calle 1", 123, "Lanus", "Buenos Aires"), "vendedor", "empleado", suc2));

		empleados.add(new Empleado("Valenzuela", "Gabriel", 77777777, 77777777, "Galeno", 7,
				new Domicilio("Calle 1", 123, "Lanus", "Buenos Aires"), "cajero", "encargado", suc3));
		empleados.add(new Empleado("De La Vega", "Diego", 88888888, 88888888, "OSPF", 8,
				new Domicilio("Calle 1", 123, "Lanus", "Buenos Aires"), "vendedor", "empleado", suc3));
		empleados.add(new Empleado("Torres", "Alvaro", 99999999, 99999999, "PAMI", 9,
				new Domicilio("Calle 1", 123, "Lanus", "Buenos Aires"), "vendedor", "empleado", suc3));
		
		// se crean diez productos
		ArrayList<Producto> productos = new ArrayList<Producto>();
		Producto pro1 = new Producto("Ibuprofeno", 1010, 2.50, "Medicamento", "BAYER");
		
		// se crean 10 itemventa
		
		ItemVenta item1 = new ItemVenta(1, 3.00, pro1);
		
		// se crean 30 ventas por sucursal
		
		ArrayList<Venta> ventas = new ArrayList<Venta>();
		ArrayList<ItemVenta> itemventas = new ArrayList<ItemVenta>();
		itemventas.add(item1);
		ArrayList<Empleado> emplventa1 = new ArrayList<Empleado>();
		emplventa1.add(new Empleado("Rodriguez", "Gerardo", 11111111, 11111111, "Galeno", 1,
				new Domicilio("Calle 1", 123, "Lanus", "Buenos Aires"), "cajero", "encargado", suc1));
		emplventa1.add(new Empleado("De La Vega", "Diego", 22222222, 22222222, "OSPF", 2,
				new Domicilio("Calle 1", 123, "Lanus", "Buenos Aires"), "vendedor", "empleado", suc1));
		
		ventas.add(new Venta(1, LocalDate.now(), 22.22, "Efectivo", suc1, clientes.get(0), itemventas, emplventa1));
		

		MongoConnection mc = new MongoConnection();

		ArrayList<String> jsonsCliente = new ArrayList<String>();
		
		Gson gson = new Gson();
		
		for(Cliente cl : clientes)
		{
			jsonsCliente.add(gson.toJson(cl));
		}

		mc.addDocumentsToCollection("cliente", jsonsCliente);
		
		ArrayList<String> jsonsSucursal = new ArrayList<String>();
		jsonsSucursal.add(gson.toJson(suc1));
		jsonsSucursal.add(gson.toJson(suc2));
		jsonsSucursal.add(gson.toJson(suc3));
		mc.addDocumentsToCollection("sucursal", jsonsSucursal);
		
		ArrayList<String> jsonsEmpleado = new ArrayList<String>();
		
		for(Empleado em : empleados)
		{
			jsonsEmpleado.add(gson.toJson(em));
		}
		
		mc.addDocumentsToCollection("empleado", jsonsEmpleado);
		
	}
}