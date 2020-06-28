package modelo;

import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;  

public class Venta {
	
	private String _id;
	private String fecha;
	private double totalVenta;
	private String formaDePago;
	private Sucursal sucursal;
	private Cliente cliente;
	private ArrayList<ItemVenta> listaItemVenta;
	private ArrayList<Empleado> listaEmpleados;
	
	public Venta(int numeroVenta, LocalDateTime fecha, String formaDePago,
			Sucursal sucursal, Cliente cliente) {
	
		this.setFecha(fecha);
		this.totalVenta = 0;
		this.formaDePago = formaDePago;
		this.sucursal = sucursal;
		this.cliente = cliente;
		this.listaItemVenta = new ArrayList<ItemVenta>();
		this.listaEmpleados = new ArrayList<Empleado>();
		this.setId(numeroVenta);
	}

	public String getId() {
		return _id;
	}

	public void setId(int numeroVenta) {
		this._id = this.sucursal.getId() + "-" + numeroVenta;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		this.fecha = dtf.format(fecha);
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
		this.totalVenta = this.totalVenta + (item.getCantidad() * item.getPrecioUnitario());
		this.listaItemVenta.add(item);
	}
	
	public void addEmpleado(Empleado emp) {
		this.listaEmpleados.add(emp);
	}
}
