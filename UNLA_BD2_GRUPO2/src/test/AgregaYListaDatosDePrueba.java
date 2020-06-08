package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.*;
import com.mongodb.client.MongoClient;

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

		ItemVenta item1 = new ItemVenta(1, pro1);
		ItemVenta item100 = new ItemVenta(2, pro2);
		ItemVenta item101 = new ItemVenta(2, pro3);
		ItemVenta item102 = new ItemVenta(1, pro1);
		ItemVenta item103 = new ItemVenta(3, pro3);
		ItemVenta item104 = new ItemVenta(1, pro2);
		ItemVenta item105 = new ItemVenta(3, pro1);
		ItemVenta item106 = new ItemVenta(2, pro3);
		ItemVenta item107 = new ItemVenta(1, pro1);
		ItemVenta item108 = new ItemVenta(10, pro3);

		// se crean 30 ventas por sucursal uno

		ArrayList<Venta> VentaSucursal1 = new ArrayList<Venta>();
		Venta venSucu101 = new Venta(101, LocalDate.now(), "Efectivo", suc1, clientes.get(2));
		venSucu101.addItemVenta(item1);
		venSucu101.addItemVenta(item104);
		venSucu101.addEmpleado(empleados.get(0));
		venSucu101.addEmpleado(empleados.get(1));
		VentaSucursal1.add(venSucu101);

		Venta venSucu102 = new Venta(102, LocalDate.now(), "Efectivo", suc1, clientes.get(3));
		venSucu102.addItemVenta(item103);
		venSucu102.addItemVenta(item1);
		venSucu102.addEmpleado(empleados.get(0));
		venSucu102.addEmpleado(empleados.get(2));
		VentaSucursal1.add(venSucu102);

		Venta venSucu103 = new Venta(103, LocalDate.now(), "Tarjeta de Credito", suc1, clientes.get(1));
		venSucu103.addItemVenta(item102);
		venSucu103.addItemVenta(item103);
		venSucu103.addEmpleado(empleados.get(0));
		venSucu103.addEmpleado(empleados.get(2));
		VentaSucursal1.add(venSucu103);

		Venta venSucu104 = new Venta(104, LocalDate.now(), "Efectivo", suc1, clientes.get(3));
		venSucu104.addItemVenta(item108);
		venSucu104.addItemVenta(item106);
		venSucu104.addEmpleado(empleados.get(0));
		venSucu104.addEmpleado(empleados.get(2));
		VentaSucursal1.add(venSucu104);

		Venta venSucu105 = new Venta(105, LocalDate.now(), "Efectivo", suc1, clientes.get(0));
		venSucu105.addItemVenta(item106);
		venSucu105.addItemVenta(item107);
		venSucu105.addEmpleado(empleados.get(0));
		venSucu105.addEmpleado(empleados.get(2));
		VentaSucursal1.add(venSucu105);

		Venta venSucu106 = new Venta(106, LocalDate.now(), "Tarjeta de Credito", suc1, clientes.get(2));
		venSucu106.addItemVenta(item105);
		venSucu106.addItemVenta(item100);
		venSucu106.addEmpleado(empleados.get(0));
		venSucu106.addEmpleado(empleados.get(2));
		VentaSucursal1.add(venSucu106);

		Venta venSucu107 = new Venta(107, LocalDate.now(), "Efectivo", suc1, clientes.get(3));
		venSucu107.addItemVenta(item107);
		venSucu107.addItemVenta(item100);
		venSucu107.addEmpleado(empleados.get(0));
		venSucu107.addEmpleado(empleados.get(2));
		VentaSucursal1.add(venSucu101);

		Venta venSucu108 = new Venta(108, LocalDate.now(), "Efectivo", suc1, clientes.get(0));
		venSucu108.addItemVenta(item103);
		venSucu108.addItemVenta(item101);
		venSucu108.addEmpleado(empleados.get(0));
		venSucu108.addEmpleado(empleados.get(1));
		VentaSucursal1.add(venSucu108);

		Venta venSucu109 = new Venta(109, LocalDate.now(), "Efectivo", suc1, clientes.get(1));
		venSucu109.addItemVenta(item1);
		venSucu109.addItemVenta(item103);
		venSucu109.addEmpleado(empleados.get(0));
		venSucu109.addEmpleado(empleados.get(1));
		VentaSucursal1.add(venSucu109);

		Venta venSucu110 = new Venta(110, LocalDate.now(), "Tarjeta de Credito", suc1, clientes.get(8));
		venSucu110.addItemVenta(item106);
		venSucu110.addItemVenta(item100);
		venSucu110.addEmpleado(empleados.get(0));
		venSucu110.addEmpleado(empleados.get(2));
		VentaSucursal1.add(venSucu110);

		Venta venSucu111 = new Venta(111, LocalDate.now(), "Efectivo", suc1, clientes.get(6));
		venSucu111.addItemVenta(item102);
		venSucu111.addItemVenta(item103);
		venSucu111.addEmpleado(empleados.get(0));
		venSucu111.addEmpleado(empleados.get(1));
		VentaSucursal1.add(venSucu111);

		Venta venSucu112 = new Venta(112, LocalDate.now(), "Efectivo", suc1, clientes.get(7));
		venSucu112.addItemVenta(item106);
		venSucu112.addItemVenta(item101);
		venSucu112.addEmpleado(empleados.get(0));
		venSucu112.addEmpleado(empleados.get(1));
		VentaSucursal1.add(venSucu112);

		Venta venSucu113 = new Venta(113, LocalDate.now(), "Tarjeta de Credito", suc1, clientes.get(6));
		venSucu113.addItemVenta(item105);
		venSucu113.addItemVenta(item106);
		venSucu113.addEmpleado(empleados.get(0));
		venSucu113.addEmpleado(empleados.get(2));
		VentaSucursal1.add(venSucu113);

		Venta venSucu114 = new Venta(114, LocalDate.now(), "Efectivo", suc1, clientes.get(5));
		venSucu114.addItemVenta(item100);
		venSucu114.addItemVenta(item106);
		venSucu114.addEmpleado(empleados.get(0));
		venSucu114.addEmpleado(empleados.get(1));
		VentaSucursal1.add(venSucu114);

		Venta venSucu115 = new Venta(115, LocalDate.now(), "Efectivo", suc1, clientes.get(4));
		venSucu115.addItemVenta(item107);
		venSucu115.addItemVenta(item104);
		venSucu115.addEmpleado(empleados.get(0));
		venSucu115.addEmpleado(empleados.get(1));
		VentaSucursal1.add(venSucu115);

		Venta venSucu116 = new Venta(116, LocalDate.now(), "Efectivo", suc1, clientes.get(5));
		venSucu116.addItemVenta(item100);
		venSucu116.addItemVenta(item101);
		venSucu116.addEmpleado(empleados.get(0));
		venSucu116.addEmpleado(empleados.get(2));
		VentaSucursal1.add(venSucu116);

		Venta venSucu117 = new Venta(117, LocalDate.now(), "Efectivo", suc1, clientes.get(3));
		venSucu117.addItemVenta(item1);
		venSucu117.addItemVenta(item105);
		venSucu117.addEmpleado(empleados.get(0));
		venSucu117.addEmpleado(empleados.get(2));
		VentaSucursal1.add(venSucu117);

		Venta venSucu118 = new Venta(118, LocalDate.now(), "Efectivo", suc1, clientes.get(6));
		venSucu117.addItemVenta(item106);
		venSucu117.addItemVenta(item102);

		venSucu117.addEmpleado(empleados.get(0));
		venSucu117.addEmpleado(empleados.get(1));
		VentaSucursal1.add(venSucu118);

		Venta venSucu119 = new Venta(119, LocalDate.now(), "Efectivo", suc1, clientes.get(2));
		venSucu119.addItemVenta(item1);
		venSucu119.addItemVenta(item100);
		venSucu119.addEmpleado(empleados.get(0));
		venSucu119.addEmpleado(empleados.get(2));
		VentaSucursal1.add(venSucu119);

		Venta venSucu120 = new Venta(120, LocalDate.now(), "Tarjeta de Credito", suc1, clientes.get(1));
		venSucu120.addItemVenta(item1);
		venSucu120.addItemVenta(item103);
		venSucu120.addEmpleado(empleados.get(0));
		venSucu120.addEmpleado(empleados.get(1));
		VentaSucursal1.add(venSucu120);

		Venta venSucu121 = new Venta(121, LocalDate.now(), "Efectivo", suc1, clientes.get(8));
		venSucu121.addItemVenta(item1);
		venSucu121.addItemVenta(item108);
		venSucu121.addEmpleado(empleados.get(0));
		venSucu121.addEmpleado(empleados.get(1));
		VentaSucursal1.add(venSucu121);

		Venta venSucu122 = new Venta(122, LocalDate.now(), "Efectivo", suc1, clientes.get(6));
		venSucu122.addItemVenta(item100);
		venSucu122.addItemVenta(item103);
		venSucu122.addEmpleado(empleados.get(0));
		venSucu122.addEmpleado(empleados.get(2));
		VentaSucursal1.add(venSucu122);

		Venta venSucu123 = new Venta(123, LocalDate.now(), "Efectivo", suc1, clientes.get(7));
		venSucu123.addItemVenta(item105);
		venSucu123.addItemVenta(item100);
		venSucu123.addEmpleado(empleados.get(0));
		venSucu123.addEmpleado(empleados.get(2));
		VentaSucursal1.add(venSucu123);

		Venta venSucu124 = new Venta(124, LocalDate.now(), "Efectivo", suc1, clientes.get(4));
		venSucu124.addItemVenta(item103);
		venSucu124.addItemVenta(item108);
		venSucu124.addEmpleado(empleados.get(0));
		venSucu124.addEmpleado(empleados.get(1));
		VentaSucursal1.add(venSucu124);

		Venta venSucu125 = new Venta(125, LocalDate.now(), "Efectivo", suc1, clientes.get(0));
		venSucu125.addItemVenta(item106);
		venSucu125.addItemVenta(item101);
		venSucu125.addEmpleado(empleados.get(0));
		venSucu125.addEmpleado(empleados.get(2));
		VentaSucursal1.add(venSucu125);

		Venta venSucu126 = new Venta(126, LocalDate.now(), "Efectivo", suc1, clientes.get(4));
		venSucu126.addItemVenta(item106);
		venSucu126.addItemVenta(item107);
		venSucu126.addEmpleado(empleados.get(0));
		venSucu126.addEmpleado(empleados.get(1));
		VentaSucursal1.add(venSucu126);

		Venta venSucu127 = new Venta(127, LocalDate.now(), "Tarjeta de Credito", suc1, clientes.get(8));
		venSucu127.addItemVenta(item1);
		venSucu127.addItemVenta(item100);
		venSucu127.addEmpleado(empleados.get(0));
		venSucu127.addEmpleado(empleados.get(1));
		VentaSucursal1.add(venSucu127);

		Venta venSucu128 = new Venta(128, LocalDate.now(), "Efectivo", suc1, clientes.get(1));
		venSucu128.addItemVenta(item100);
		venSucu128.addItemVenta(item104);
		venSucu128.addEmpleado(empleados.get(0));
		venSucu128.addEmpleado(empleados.get(2));
		VentaSucursal1.add(venSucu128);

		Venta venSucu129 = new Venta(129, LocalDate.now(), "Efectivo", suc1, clientes.get(2));
		venSucu129.addItemVenta(item101);
		venSucu129.addItemVenta(item103);
		venSucu129.addEmpleado(empleados.get(0));
		venSucu129.addEmpleado(empleados.get(1));
		VentaSucursal1.add(venSucu129);

		// se crean 30 ventas por sucursal dos

		ArrayList<Venta> ventasSuc2 = new ArrayList<Venta>();
		Venta ven = new Venta(1, LocalDate.now(), "Efectivo", suc2, clientes.get(0));
		ven.addItemVenta(new ItemVenta(1, pro1));
		ven.addItemVenta(new ItemVenta(2, pro3));
		ven.addEmpleado(empleados.get(3));
		ven.addEmpleado(empleados.get(4));
		ventasSuc2.add(ven);

		ven = new Venta(2, LocalDate.now(), "Efectivo", suc2, clientes.get(1));
		ven.addItemVenta(new ItemVenta(2, pro2));
		ven.addItemVenta(new ItemVenta(1, pro4));
		ven.addItemVenta(new ItemVenta(2, pro7));
		ven.addEmpleado(empleados.get(3));
		ven.addEmpleado(empleados.get(4));
		ventasSuc2.add(ven);

		ven = new Venta(3, LocalDate.now(), "Efectivo", suc2, clientes.get(2));
		ven.addItemVenta(new ItemVenta(2, pro7));
		ven.addEmpleado(empleados.get(3));
		ven.addEmpleado(empleados.get(4));
		ventasSuc2.add(ven);

		ven = new Venta(4, LocalDate.now(), "Tarjeta de Credito", suc2, clientes.get(3));
		ven.addItemVenta(new ItemVenta(3, pro6));
		ven.addItemVenta(new ItemVenta(2, pro8));
		ven.addItemVenta(new ItemVenta(1, pro9));
		ven.addEmpleado(empleados.get(3));
		ven.addEmpleado(empleados.get(5));
		ventasSuc2.add(ven);

		ven = new Venta(5, LocalDate.now(), "Tarjeta de Credito", suc2, clientes.get(4));
		ven.addItemVenta(new ItemVenta(3, pro1));
		ven.addItemVenta(new ItemVenta(2, pro9));
		ven.addEmpleado(empleados.get(3));
		ven.addEmpleado(empleados.get(5));
		ventasSuc2.add(ven);

		ven = new Venta(6, LocalDate.now(), "Tarjeta de Credito", suc2, clientes.get(5));
		ven.addItemVenta(new ItemVenta(1, pro2));
		ven.addItemVenta(new ItemVenta(2, pro8));
		ven.addItemVenta(new ItemVenta(2, pro10));
		ven.addEmpleado(empleados.get(3));
		ven.addEmpleado(empleados.get(5));
		ventasSuc2.add(ven);

		ven = new Venta(7, LocalDate.now(), "Tarjeta de Debito", suc2, clientes.get(6));
		ven.addItemVenta(new ItemVenta(3, pro3));
		ven.addItemVenta(new ItemVenta(1, pro5));
		ven.addEmpleado(empleados.get(3));
		ven.addEmpleado(empleados.get(4));
		ventasSuc2.add(ven);

		ven = new Venta(8, LocalDate.now(), "Tarjeta de Debito", suc2, clientes.get(7));
		ven.addItemVenta(new ItemVenta(2, pro1));
		ven.addItemVenta(new ItemVenta(1, pro4));
		ven.addItemVenta(new ItemVenta(2, pro6));
		ven.addEmpleado(empleados.get(3));
		ven.addEmpleado(empleados.get(4));
		ventasSuc2.add(ven);

		ven = new Venta(9, LocalDate.now(), "Tarjeta de Debito", suc2, clientes.get(8));
		ven.addItemVenta(new ItemVenta(1, pro7));
		ven.addItemVenta(new ItemVenta(2, pro9));
		ven.addEmpleado(empleados.get(3));
		ven.addEmpleado(empleados.get(5));
		ventasSuc2.add(ven);

		ven = new Venta(10, LocalDate.now(), "Efectivo", suc2, clientes.get(9));
		ven.addItemVenta(new ItemVenta(1, pro8));
		ven.addItemVenta(new ItemVenta(2, pro9));
		ven.addItemVenta(new ItemVenta(2, pro10));
		ven.addEmpleado(empleados.get(3));
		ven.addEmpleado(empleados.get(5));
		ventasSuc2.add(ven);

		ven = new Venta(11, LocalDate.now(), "Efectivo", suc2, clientes.get(8));
		ven.addItemVenta(new ItemVenta(2, pro1));
		ven.addItemVenta(new ItemVenta(2, pro4));
		ven.addItemVenta(new ItemVenta(2, pro10));
		ven.addEmpleado(empleados.get(3));
		ven.addEmpleado(empleados.get(4));
		ventasSuc2.add(ven);

		ven = new Venta(12, LocalDate.now(), "Tarjeta de Credito", suc2, clientes.get(7));
		ven.addItemVenta(new ItemVenta(1, pro2));
		ven.addItemVenta(new ItemVenta(2, pro3));
		ven.addEmpleado(empleados.get(3));
		ven.addEmpleado(empleados.get(4));
		ventasSuc2.add(ven);

		ven = new Venta(13, LocalDate.now(), "Tarjeta de Credito", suc2, clientes.get(6));
		ven.addItemVenta(new ItemVenta(2, pro8));
		ven.addEmpleado(empleados.get(3));
		ven.addEmpleado(empleados.get(4));
		ventasSuc2.add(ven);

		ven = new Venta(14, LocalDate.now(), "Tarjeta de Debito", suc2, clientes.get(5));
		ven.addItemVenta(new ItemVenta(2, pro5));
		ven.addItemVenta(new ItemVenta(1, pro6));
		ven.addItemVenta(new ItemVenta(2, pro7));
		ven.addEmpleado(empleados.get(3));
		ven.addEmpleado(empleados.get(5));
		ventasSuc2.add(ven);

		ven = new Venta(15, LocalDate.now(), "Tarjeta de Debito", suc2, clientes.get(4));
		ven.addItemVenta(new ItemVenta(3, pro1));
		ven.addItemVenta(new ItemVenta(2, pro10));
		ven.addEmpleado(empleados.get(3));
		ven.addEmpleado(empleados.get(5));
		ventasSuc2.add(ven);

		ven = new Venta(16, LocalDate.now(), "Efectivo", suc2, clientes.get(3));
		ven.addItemVenta(new ItemVenta(1, pro2));
		ven.addItemVenta(new ItemVenta(2, pro7));
		ven.addItemVenta(new ItemVenta(2, pro9));
		ven.addEmpleado(empleados.get(3));
		ven.addEmpleado(empleados.get(5));
		ventasSuc2.add(ven);

		ven = new Venta(17, LocalDate.now(), "Tarjeta de Credito", suc2, clientes.get(2));
		ven.addItemVenta(new ItemVenta(1, pro3));
		ven.addItemVenta(new ItemVenta(2, pro8));
		ven.addEmpleado(empleados.get(3));
		ven.addEmpleado(empleados.get(5));
		ventasSuc2.add(ven);

		ven = new Venta(18, LocalDate.now(), "Tarjeta de Debito", suc2, clientes.get(1));
		ven.addItemVenta(new ItemVenta(3, pro4));
		ven.addItemVenta(new ItemVenta(2, pro7));
		ven.addEmpleado(empleados.get(3));
		ven.addEmpleado(empleados.get(4));
		ventasSuc2.add(ven);

		ven = new Venta(19, LocalDate.now(), "Efectivo", suc2, clientes.get(0));
		ven.addItemVenta(new ItemVenta(1, pro5));
		ven.addItemVenta(new ItemVenta(3, pro6));
		ven.addEmpleado(empleados.get(3));
		ven.addEmpleado(empleados.get(5));
		ventasSuc2.add(ven);

		ven = new Venta(20, LocalDate.now(), "Tarjeta de Credito", suc2, clientes.get(2));
		ven.addItemVenta(new ItemVenta(1, pro1));
		ven.addItemVenta(new ItemVenta(3, pro5));
		ven.addItemVenta(new ItemVenta(2, pro6));
		ven.addEmpleado(empleados.get(3));
		ven.addEmpleado(empleados.get(4));
		ventasSuc2.add(ven);

		ven = new Venta(21, LocalDate.now(), "Tarjeta de Debito", suc2, clientes.get(4));
		ven.addItemVenta(new ItemVenta(1, pro2));
		ven.addEmpleado(empleados.get(3));
		ven.addEmpleado(empleados.get(5));
		ventasSuc2.add(ven);

		ven = new Venta(22, LocalDate.now(), "Efectivo", suc2, clientes.get(6));
		ven.addItemVenta(new ItemVenta(3, pro3));
		ven.addItemVenta(new ItemVenta(1, pro5));
		ven.addItemVenta(new ItemVenta(2, pro10));
		ven.addEmpleado(empleados.get(3));
		ven.addEmpleado(empleados.get(4));
		ventasSuc2.add(ven);

		ven = new Venta(23, LocalDate.now(), "Tarjeta de Credito", suc2, clientes.get(8));
		ven.addItemVenta(new ItemVenta(1, pro5));
		ven.addItemVenta(new ItemVenta(2, pro9));
		ven.addEmpleado(empleados.get(3));
		ven.addEmpleado(empleados.get(5));
		ventasSuc2.add(ven);

		ven = new Venta(24, LocalDate.now(), "Tarjeta de Debito", suc2, clientes.get(1));
		ven.addItemVenta(new ItemVenta(2, pro10));
		ven.addEmpleado(empleados.get(3));
		ven.addEmpleado(empleados.get(4));
		ventasSuc2.add(ven);

		ven = new Venta(25, LocalDate.now(), "Efectivo", suc2, clientes.get(3));
		ven.addItemVenta(new ItemVenta(2, pro4));
		ven.addItemVenta(new ItemVenta(1, pro7));
		ven.addItemVenta(new ItemVenta(2, pro10));
		ven.addEmpleado(empleados.get(3));
		ven.addEmpleado(empleados.get(4));
		ventasSuc2.add(ven);

		ven = new Venta(26, LocalDate.now(), "Tarjeta de Credito", suc2, clientes.get(5));
		ven.addItemVenta(new ItemVenta(1, pro2));
		ven.addItemVenta(new ItemVenta(2, pro6));
		ven.addEmpleado(empleados.get(3));
		ven.addEmpleado(empleados.get(5));
		ventasSuc2.add(ven);

		ven = new Venta(27, LocalDate.now(), "Tarjeta de Debito", suc2, clientes.get(7));
		ven.addItemVenta(new ItemVenta(1, pro4));
		ven.addItemVenta(new ItemVenta(2, pro8));
		ven.addEmpleado(empleados.get(3));
		ven.addEmpleado(empleados.get(5));
		ventasSuc2.add(ven);

		ven = new Venta(28, LocalDate.now(), "Efectivo", suc2, clientes.get(9));
		ven.addItemVenta(new ItemVenta(1, pro1));
		ven.addItemVenta(new ItemVenta(1, pro4));
		ven.addItemVenta(new ItemVenta(2, pro5));
		ven.addEmpleado(empleados.get(3));
		ven.addEmpleado(empleados.get(5));
		ventasSuc2.add(ven);

		ven = new Venta(29, LocalDate.now(), "Tarjeta de Credito", suc2, clientes.get(3));
		ven.addItemVenta(new ItemVenta(1, pro2));
		ven.addItemVenta(new ItemVenta(1, pro4));
		ven.addItemVenta(new ItemVenta(2, pro5));
		ven.addItemVenta(new ItemVenta(2, pro6));
		ven.addEmpleado(empleados.get(3));
		ven.addEmpleado(empleados.get(5));
		ventasSuc2.add(ven);

		ven = new Venta(30, LocalDate.now(), "Tarjeta de Debito", suc2, clientes.get(0));
		ven.addItemVenta(new ItemVenta(3, pro4));
		ven.addItemVenta(new ItemVenta(2, pro7));
		ven.addEmpleado(empleados.get(3));
		ven.addEmpleado(empleados.get(4));
		ventasSuc2.add(ven);

		// Se agregan ventas a la sucursal 3

		ArrayList<Venta> ventasSuc3 = new ArrayList<Venta>();
		ven = new Venta(200, LocalDate.now(), "Efectivo", suc3, clientes.get(0));
		ven.addItemVenta(new ItemVenta(2, pro3));
		ven.addEmpleado(empleados.get(6));
		ven.addEmpleado(empleados.get(7));
		ventasSuc3.add(ven);

		ven = new Venta(201, LocalDate.now(), "Efectivo", suc3, clientes.get(1));
		ven.addItemVenta(new ItemVenta(2, pro4));
		ven.addEmpleado(empleados.get(6));
		ven.addEmpleado(empleados.get(7));
		ventasSuc3.add(ven);

		ven = new Venta(202, LocalDate.now(), "Efectivo", suc3, clientes.get(2));
		ven.addItemVenta(new ItemVenta(3, pro5));
		ven.addItemVenta(new ItemVenta(2, pro6));
		ven.addEmpleado(empleados.get(6));
		ven.addEmpleado(empleados.get(7));
		ventasSuc3.add(ven);

		ven = new Venta(203, LocalDate.now(), "Efectivo", suc3, clientes.get(3));
		ven.addItemVenta(new ItemVenta(1, pro5));
		ven.addItemVenta(new ItemVenta(2, pro7));
		ven.addEmpleado(empleados.get(6));
		ven.addEmpleado(empleados.get(7));
		ventasSuc3.add(ven);

		ven = new Venta(204, LocalDate.now(), "Tarjeta de Credito", suc3, clientes.get(4));
		ven.addItemVenta(new ItemVenta(6, pro5));
		ven.addItemVenta(new ItemVenta(3, pro2));
		ven.addEmpleado(empleados.get(6));
		ven.addEmpleado(empleados.get(8));
		ventasSuc3.add(ven);

		ven = new Venta(205, LocalDate.now(), "Efectivo", suc3, clientes.get(5));
		ven.addItemVenta(new ItemVenta(3, pro1));
		ven.addEmpleado(empleados.get(6));
		ven.addEmpleado(empleados.get(8));
		ventasSuc3.add(ven);

		ven = new Venta(206, LocalDate.now(), "Efectivo", suc3, clientes.get(6));
		ven.addItemVenta(new ItemVenta(1, pro7));
		ven.addEmpleado(empleados.get(6));
		ven.addEmpleado(empleados.get(8));
		ventasSuc3.add(ven);

		ven = new Venta(207, LocalDate.now(), "Efectivo", suc3, clientes.get(7));
		ven.addItemVenta(new ItemVenta(1, pro1));
		ven.addItemVenta(new ItemVenta(1, pro2));
		ven.addItemVenta(new ItemVenta(1, pro3));
		ven.addItemVenta(new ItemVenta(1, pro4));
		ven.addEmpleado(empleados.get(6));
		ven.addEmpleado(empleados.get(8));
		ventasSuc3.add(ven);

		ven = new Venta(208, LocalDate.now(), "Efectivo", suc3, clientes.get(8));
		ven.addItemVenta(new ItemVenta(2, pro1));
		ven.addItemVenta(new ItemVenta(1, pro2));
		ven.addEmpleado(empleados.get(6));
		ven.addEmpleado(empleados.get(7));
		ventasSuc3.add(ven);

		ven = new Venta(209, LocalDate.now(), "Efectivo", suc3, clientes.get(9));
		ven.addItemVenta(new ItemVenta(1, pro2));
		ven.addItemVenta(new ItemVenta(1, pro3));
		ven.addEmpleado(empleados.get(6));
		ven.addEmpleado(empleados.get(7));
		ventasSuc3.add(ven);

		ven = new Venta(210, LocalDate.now(), "Efectivo", suc3, clientes.get(0));
		ven.addItemVenta(new ItemVenta(1, pro3));
		ven.addItemVenta(new ItemVenta(1, pro6));
		ven.addEmpleado(empleados.get(6));
		ven.addEmpleado(empleados.get(8));
		ventasSuc3.add(ven);

		ven = new Venta(210, LocalDate.now(), "Tarjeta de Credito", suc3, clientes.get(0));
		ven.addItemVenta(new ItemVenta(2, pro3));
		ven.addEmpleado(empleados.get(6));
		ven.addEmpleado(empleados.get(7));
		ventasSuc3.add(ven);

		ven = new Venta(211, LocalDate.now(), "Efectivo", suc3, clientes.get(1));
		ven.addItemVenta(new ItemVenta(2, pro4));
		ven.addEmpleado(empleados.get(6));
		ven.addEmpleado(empleados.get(7));
		ventasSuc3.add(ven);

		ven = new Venta(212, LocalDate.now(), "Efectivo", suc3, clientes.get(2));
		ven.addItemVenta(new ItemVenta(3, pro5));
		ven.addItemVenta(new ItemVenta(2, pro6));
		ven.addEmpleado(empleados.get(6));
		ven.addEmpleado(empleados.get(7));
		ventasSuc3.add(ven);

		ven = new Venta(213, LocalDate.now(), "Tarjeta de Debito", suc3, clientes.get(3));
		ven.addItemVenta(new ItemVenta(1, pro5));
		ven.addItemVenta(new ItemVenta(2, pro7));
		ven.addEmpleado(empleados.get(6));
		ven.addEmpleado(empleados.get(7));
		ventasSuc3.add(ven);

		ven = new Venta(214, LocalDate.now(), "Efectivo", suc3, clientes.get(4));
		ven.addItemVenta(new ItemVenta(6, pro5));
		ven.addItemVenta(new ItemVenta(5, pro6));
		ven.addItemVenta(new ItemVenta(1, pro3));
		ven.addEmpleado(empleados.get(6));
		ven.addEmpleado(empleados.get(8));
		ventasSuc3.add(ven);

		ven = new Venta(215, LocalDate.now(), "Efectivo", suc3, clientes.get(5));
		ven.addItemVenta(new ItemVenta(4, pro1));
		ven.addEmpleado(empleados.get(6));
		ven.addEmpleado(empleados.get(8));
		ventasSuc3.add(ven);

		ven = new Venta(216, LocalDate.now(), "Efectivo", suc3, clientes.get(6));
		ven.addItemVenta(new ItemVenta(1, pro7));
		ven.addEmpleado(empleados.get(6));
		ven.addEmpleado(empleados.get(8));
		ventasSuc3.add(ven);

		ven = new Venta(217, LocalDate.now(), "Efectivo", suc3, clientes.get(7));
		ven.addItemVenta(new ItemVenta(1, pro1));
		ven.addEmpleado(empleados.get(6));
		ven.addEmpleado(empleados.get(8));
		ventasSuc3.add(ven);

		ven = new Venta(218, LocalDate.now(), "Efectivo", suc3, clientes.get(8));
		ven.addItemVenta(new ItemVenta(2, pro1));
		ven.addItemVenta(new ItemVenta(1, pro2));
		ven.addEmpleado(empleados.get(6));
		ven.addEmpleado(empleados.get(7));
		ventasSuc3.add(ven);

		ven = new Venta(219, LocalDate.now(), "Efectivo", suc3, clientes.get(9));
		ven.addItemVenta(new ItemVenta(1, pro2));
		ven.addItemVenta(new ItemVenta(1, pro3));
		ven.addEmpleado(empleados.get(6));
		ven.addEmpleado(empleados.get(7));
		ventasSuc3.add(ven);

		ven = new Venta(220, LocalDate.now(), "Efectivo", suc3, clientes.get(0));
		ven.addItemVenta(new ItemVenta(1, pro3));
		ven.addItemVenta(new ItemVenta(1, pro6));
		ven.addEmpleado(empleados.get(6));
		ven.addEmpleado(empleados.get(8));
		ventasSuc3.add(ven);

		ven = new Venta(221, LocalDate.now(), "Efectivo", suc3, clientes.get(1));
		ven.addItemVenta(new ItemVenta(2, pro4));
		ven.addEmpleado(empleados.get(6));
		ven.addEmpleado(empleados.get(7));
		ventasSuc3.add(ven);

		ven = new Venta(222, LocalDate.now(), "Efectivo", suc3, clientes.get(2));
		ven.addItemVenta(new ItemVenta(3, pro5));
		ven.addItemVenta(new ItemVenta(2, pro6));
		ven.addEmpleado(empleados.get(6));
		ven.addEmpleado(empleados.get(7));
		ventasSuc3.add(ven);

		ven = new Venta(223, LocalDate.now(), "Tarjeta de Debito", suc3, clientes.get(3));
		ven.addItemVenta(new ItemVenta(1, pro5));
		ven.addItemVenta(new ItemVenta(2, pro7));
		ven.addEmpleado(empleados.get(6));
		ven.addEmpleado(empleados.get(7));
		ventasSuc3.add(ven);

		ven = new Venta(224, LocalDate.now(), "Tarjeta de Credito", suc3, clientes.get(4));
		ven.addItemVenta(new ItemVenta(6, pro5));
		ven.addItemVenta(new ItemVenta(5, pro7));
		ven.addItemVenta(new ItemVenta(1, pro3));
		ven.addItemVenta(new ItemVenta(1, pro4));
		ven.addItemVenta(new ItemVenta(1, pro6));
		ven.addEmpleado(empleados.get(6));
		ven.addEmpleado(empleados.get(7));
		ventasSuc3.add(ven);

		ven = new Venta(225, LocalDate.now(), "Efectivo", suc3, clientes.get(5));
		ven.addItemVenta(new ItemVenta(4, pro1));
		ven.addEmpleado(empleados.get(6));
		ven.addEmpleado(empleados.get(7));
		ventasSuc3.add(ven);

		ven = new Venta(226, LocalDate.now(), "Efectivo", suc3, clientes.get(6));
		ven.addItemVenta(new ItemVenta(1, pro7));
		ven.addEmpleado(empleados.get(6));
		ven.addEmpleado(empleados.get(8));
		ventasSuc3.add(ven);

		ven = new Venta(227, LocalDate.now(), "Efectivo", suc3, clientes.get(7));
		ven.addItemVenta(new ItemVenta(1, pro5));
		ven.addEmpleado(empleados.get(6));
		ven.addEmpleado(empleados.get(8));
		ventasSuc3.add(ven);

		ven = new Venta(228, LocalDate.now(), "Efectivo", suc3, clientes.get(8));
		ven.addItemVenta(new ItemVenta(2, pro1));
		ven.addItemVenta(new ItemVenta(1, pro5));
		ven.addEmpleado(empleados.get(6));
		ven.addEmpleado(empleados.get(7));
		ventasSuc3.add(ven);

		ven = new Venta(229, LocalDate.now(), "Efectivo", suc3, clientes.get(9));
		ven.addItemVenta(new ItemVenta(1, pro2));
		ven.addItemVenta(new ItemVenta(1, pro5));
		ven.addEmpleado(empleados.get(6));
		ven.addEmpleado(empleados.get(7));
		ventasSuc3.add(ven);

		ven = new Venta(230, LocalDate.now(), "Efectivo", suc3, clientes.get(0));
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

		ArrayList<String> jsonVentaSucursal1 = new ArrayList<String>();

		for (Venta venSuc1 : VentaSucursal1) {
			jsonVentaSucursal1.add(gson.toJson((venSuc1)));

		}
		mc.addDocumentsToCollection("venta", jsonVentaSucursal1);

		ArrayList<String> jsonVentaSucursal2 = new ArrayList<String>();

		for (Venta venSuc2 : ventasSuc2) {
			jsonVentaSucursal2.add(gson.toJson((venSuc2)));

		}

		mc.addDocumentsToCollection("venta", jsonVentaSucursal2);

		ArrayList<String> jsonsVentas = new ArrayList<String>();
		for (Venta cl : ventasSuc3) {
			jsonsVentas.add(gson.toJson(cl));
		}
		mc.addDocumentsToCollection("venta", jsonsVentas);

		// Listar todos las collections y documentos

		mc.listAllCollectionsWithDocuments();
	}
}