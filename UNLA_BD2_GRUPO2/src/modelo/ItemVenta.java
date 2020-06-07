package modelo;



public class ItemVenta {

	private int cantidad;
	private double precioUnitario;
	private Producto producto;
	
	public ItemVenta(int cantidad, double precioUnitario, Producto producto) {
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
	
}