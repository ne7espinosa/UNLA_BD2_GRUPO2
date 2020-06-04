package modelo;

import org.bson.Document;

public class Empleado {
	
	private String apellido;
	private String nombre;
	private int dni;
	private int cuil;
	private String obraSocial;
	private int numeroAfiliado;
	private Domicilio domicilio;
	private String funcion;
	private String puesto;
	private Sucursal sucursal;
	
	public Empleado(String apellido, String nombre, int dni, int cuil, String obraSocial, int numeroAfiliado,
			Domicilio domicilio, String funcion, String puesto, Sucursal sucursal) {
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
		this.cuil = cuil;
		this.obraSocial = obraSocial;
		this.numeroAfiliado = numeroAfiliado;
		this.domicilio = domicilio;
		this.funcion = funcion;
		this.puesto = puesto;
		this.sucursal = sucursal;
	}
	
	public Document toDocumentEmpleado() {
		Document documento =  new Document("apellido", this.apellido)
				.append("nombre", this.nombre)
				.append("dni", this.dni)
				.append("cuil", this.cuil)
				.append("obraSocial", this.obraSocial)
				.append("numeroAfiliado", this.numeroAfiliado)
				.append("domicilio", this.domicilio.toDocumentDomicilio())
				.append("funcion", this.funcion)
				.append("puesto", this.puesto)
				.append("sucursal", this.sucursal.toDocumentSucursal());
		return documento;
	}
	
	
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public int getCuil() {
		return cuil;
	}
	public void setCuil(int cuil) {
		this.cuil = cuil;
	}
	public String getObraSocial() {
		return obraSocial;
	}
	public void setObraSocial(String obraSocial) {
		this.obraSocial = obraSocial;
	}
	public int getNumeroAfiliado() {
		return numeroAfiliado;
	}
	public void setNumeroAfiliado(int numeroAfiliado) {
		this.numeroAfiliado = numeroAfiliado;
	}
	public Domicilio getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}
	public String getFuncion() {
		return funcion;
	}
	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public Sucursal getSucursal() {
		return sucursal;
	}
	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}
	
	

}
