package modelo;



public class ItemVenta {

	private int cantidad;
	private double precioUnitario;
	private Producto producto;
	
	public ItemVenta(int cantidad, Producto producto) {
		this.cantidad = cantidad;
		this.producto = producto;
		this.setPrecioUnitario();
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

	public void setPrecioUnitario() {
		this.precioUnitario = this.producto.getPrecio();
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
	
}