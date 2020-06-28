package test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import dataaccess.MongoConnection;

import com.google.gson.Gson;

import modelo.Cliente;
import modelo.Domicilio;
import modelo.Empleado;
import modelo.ItemVenta;
import modelo.Producto;
import modelo.Sucursal;
import modelo.Venta;

public class AgregaYListaDatosDePrueba {

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
		clientes.add(new Cliente("Martinez", "jose", 55555555, 1111,
				new Domicilio("Laprida", 394, "Lomas de Zamora", "Buenos Aires")));
		clientes.add(new Cliente("Lopez", "Josefa", 66666666, 1111,
				new Domicilio("Antartida Argentina", 799, "Llavallol", "Buenos Aires")));
		clientes.add(new Cliente("Gomez", "Carmen", 77777777, 1111,
				new Domicilio("Leandro N. Alem", 299, "Monte Grande", "Buenos Aires")));
		clientes.add(new Cliente("Moreno", "Angel", 88888888, 1111,
				new Domicilio("Maipu", 351, "Banfield", "Buenos Aires")));
		clientes.add(new Cliente("Jimenez", "Dolores", 99999999, 1111,
				new Domicilio("Monteagudo", 3083, "Florencio Varela", "Buenos Aires")));
		clientes.add(new Cliente("Navarro", "Ana", 11112222, 1111,
				new Domicilio("Rivadavia", 170, "Quilmes", "Buenos Aires")));

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
		
		Producto pro1 = new Producto("Ibuprofeno", 1010, 2.50, "Medicamento", "BAYER");
		Producto pro2 = new Producto("Amoxicilina", 2020, 4.50, "Medicamento", "GADOR");
		Producto pro3 = new Producto("Losartan", 3030, 3, "Medicamento", "BAGO");
		Producto pro4 = new Producto("Morfina", 4040, 6.25, "Medicamento", "BAYER");
		Producto pro5 = new Producto("Alplax", 5050, 5, "Medicamento", "GLAXO");
		Producto pro6 = new Producto("Aspirina", 6060, 2, "Medicamento", "BAYER");
		Producto pro7 = new Producto("Paracetamol", 7070, 4.25, "Medicamento", "BAGO");
		Producto pro8 = new Producto("Perfume", 1111, 2.50, "Perfumeria", "SYRCH");
		Producto pro9 = new Producto("Cepillo de dientes", 2222, 2.50, "Perfumeria", "GUM");
		Producto pro10 = new Producto("Crema cosmetica", 3333, 2.50, "Perfumeria", "BAYER");

		
		ArrayList<Venta> ventasSuc3 = new ArrayList<Venta>();
		Venta ven = new Venta(221, LocalDateTime.now(), "Efectivo", suc1, clientes.get(1));
		ven.addItemVenta(new ItemVenta(2, pro4));
		ven.addEmpleado(empleados.get(6));
		ven.addEmpleado(empleados.get(7));
		ventasSuc3.add(ven);

		ven = new Venta(222, LocalDateTime.now(), "Efectivo", suc2, clientes.get(2));
		ven.addItemVenta(new ItemVenta(3, pro5));
		ven.addItemVenta(new ItemVenta(2, pro6));
		ven.addEmpleado(empleados.get(6));
		ven.addEmpleado(empleados.get(7));
		ventasSuc3.add(ven);

		ven = new Venta(223, LocalDateTime.now(), "Tarjeta de Debito", suc3, clientes.get(3));
		ven.addItemVenta(new ItemVenta(1, pro5));
		ven.addItemVenta(new ItemVenta(2, pro7));
		ven.addEmpleado(empleados.get(6));
		ven.addEmpleado(empleados.get(7));
		ventasSuc3.add(ven);

		ven = new Venta(224, LocalDateTime.now(), "Tarjeta de Credito", suc1, clientes.get(4));
		ven.addItemVenta(new ItemVenta(6, pro5));
		ven.addItemVenta(new ItemVenta(5, pro7));
		ven.addItemVenta(new ItemVenta(1, pro3));
		ven.addItemVenta(new ItemVenta(1, pro4));
		ven.addItemVenta(new ItemVenta(1, pro6));
		ven.addEmpleado(empleados.get(6));
		ven.addEmpleado(empleados.get(7));
		ventasSuc3.add(ven);

		ven = new Venta(225, LocalDateTime.now(), "Efectivo", suc2, clientes.get(5));
		ven.addItemVenta(new ItemVenta(4, pro1));
		ven.addEmpleado(empleados.get(6));
		ven.addEmpleado(empleados.get(7));
		ventasSuc3.add(ven);

		ven = new Venta(226, LocalDateTime.now(), "Efectivo", suc3, clientes.get(6));
		ven.addItemVenta(new ItemVenta(1, pro7));
		ven.addEmpleado(empleados.get(6));
		ven.addEmpleado(empleados.get(8));
		ventasSuc3.add(ven);

		ven = new Venta(227, LocalDateTime.now(), "Efectivo", suc1, clientes.get(7));
		ven.addItemVenta(new ItemVenta(1, pro5));
		ven.addEmpleado(empleados.get(6));
		ven.addEmpleado(empleados.get(8));
		ventasSuc3.add(ven);

		ven = new Venta(228, LocalDateTime.now(), "Efectivo", suc2, clientes.get(8));
		ven.addItemVenta(new ItemVenta(2, pro1));
		ven.addItemVenta(new ItemVenta(1, pro5));
		ven.addEmpleado(empleados.get(6));
		ven.addEmpleado(empleados.get(7));
		ventasSuc3.add(ven);

		ven = new Venta(229, LocalDateTime.now(), "Efectivo", suc3, clientes.get(9));
		ven.addItemVenta(new ItemVenta(1, pro2));
		ven.addItemVenta(new ItemVenta(1, pro5));
		ven.addEmpleado(empleados.get(6));
		ven.addEmpleado(empleados.get(7));
		ventasSuc3.add(ven);

		ven = new Venta(230, LocalDateTime.now(), "Efectivo", suc1, clientes.get(0));
		ven.addItemVenta(new ItemVenta(1, pro3));
		ven.addItemVenta(new ItemVenta(1, pro5));
		ven.addEmpleado(empleados.get(6));
		ven.addEmpleado(empleados.get(8));
		ventasSuc3.add(ven);

		MongoConnection mc = new MongoConnection();
		Gson gson = new Gson();

		// Guardar Clientes en la base
		ArrayList<String> jsonsCliente = new ArrayList<String>();

		for (Cliente cl : clientes) {
			jsonsCliente.add(gson.toJson(cl));
		}

		mc.addDocumentsToCollection("cliente", jsonsCliente);

		// Guardar Productos en la base

		ArrayList<String> jsonsProductos = new ArrayList<String>();
		jsonsProductos.add(gson.toJson(pro1));
		jsonsProductos.add(gson.toJson(pro2));
		jsonsProductos.add(gson.toJson(pro3));
		jsonsProductos.add(gson.toJson(pro4));
		jsonsProductos.add(gson.toJson(pro5));
		jsonsProductos.add(gson.toJson(pro6));
		jsonsProductos.add(gson.toJson(pro7));
		jsonsProductos.add(gson.toJson(pro8));
		jsonsProductos.add(gson.toJson(pro9));
		jsonsProductos.add(gson.toJson(pro10));

		mc.addDocumentsToCollection("producto", jsonsProductos);
		// Guardar Sucursales en la base

		ArrayList<String> jsonsSucursal = new ArrayList<String>();
		jsonsSucursal.add(gson.toJson(suc1));
		jsonsSucursal.add(gson.toJson(suc2));
		jsonsSucursal.add(gson.toJson(suc3));
		mc.addDocumentsToCollection("sucursal", jsonsSucursal);

		// Guardar Empleados en la base

		ArrayList<String> jsonsEmpleado = new ArrayList<String>();

		for (Empleado em : empleados) {
			jsonsEmpleado.add(gson.toJson(em));
		}

		mc.addDocumentsToCollection("empleado", jsonsEmpleado);

		// Guardar Ventas en la base

		ArrayList<String> jsonsVentas = new ArrayList<String>();
		for (Venta cl : ventasSuc3) {
			jsonsVentas.add(gson.toJson(cl));
		}
		mc.addDocumentsToCollection("venta", jsonsVentas);

		// Listar todos las collections y documentos

		mc.listAllCollectionsWithDocuments();
	}
}