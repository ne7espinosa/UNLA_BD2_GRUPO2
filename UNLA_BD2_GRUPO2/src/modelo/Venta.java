package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Venta {
	
	private String idTicket;
	private LocalDate fecha;
	private double totalVenta;
	private String formaDePago;
	private Sucursal sucursal;
	private Cliente cliente;
	private ArrayList<ItemVenta> listaItemVenta;
	private ArrayList<Empleado> listaEmpleados;
	
	public Venta(int numeroVenta, LocalDate fecha, double totalVenta, String formaDePago,
			Sucursal sucursal, Cliente cliente) {
	
		this.fecha = fecha;
		this.totalVenta = totalVenta;
		this.formaDePago = formaDePago;
		this.sucursal = sucursal;
		this.cliente = cliente;
		this.listaItemVenta = new ArrayList<ItemVenta>();
		this.listaEmpleados = new ArrayList<Empleado>();
		this.setIdTicket(numeroVenta);
	}

	public String getIdTicket() {
		return idTicket;
	}

	public void setIdTicket(int numeroVenta) {
		this.idTicket = this.sucursal.getNroSucursal() + "-" + numeroVenta;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public double getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(double totalVenta) {
		this.totalVenta = totalVenta;
	}

	public String getFormaDePago() {
		return formaDePago;
	}

	public void setFormaDePago(String formaDePago) {
		this.formaDePago = formaDePago;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemVenta> getListaItemVenta() {
		return listaItemVenta;
	}

	public void setListaItemVenta(ArrayList<ItemVenta> listaItemVenta) {
		this.listaItemVenta = listaItemVenta;
	}

	public List<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}
	
	public void addItemVenta(ItemVenta item) {
		this.listaItemVenta.add(item);
	}
	
	public void addEmpleado(Empleado emp) {
		this.listaEmpleados.add(emp);
	}
	
	public void agregarItemVenta (ItemVenta item) {
		listaItemVenta.add(item);
	}
	
	public void agregarEmpleado (Empleado emp) {
		listaEmpleados.add(emp);
	}
}
