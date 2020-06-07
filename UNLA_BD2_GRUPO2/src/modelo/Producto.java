package modelo;



public class Producto {

	private String descripcion;
	private int codigo;
	private double precio;
	private String tipoProducto;
	private String laboratorio;
	
	public Producto(String descripcion, int codigo, double precio, String tipoProducto, String laboratorio) {
		this.descripcion = descripcion;
		this.codigo = codigo;
		this.precio = precio;
		this.tipoProducto = tipoProducto;
		this.laboratorio = laboratorio;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public String getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}
	
	
	
}