package modelo;

import org.bson.types.ObjectId;

public class Cliente {
	private String _id;
	private String apellido;
	private String nombre;
	private int dni;
	private int numeroAfiliado;
	private String obraSocial;
	private Domicilio domicilio;
	
	public Cliente() {}
	
	public Cliente(String apellido, String nombre, int dni, String obraSocial, int numeroAfiliado, Domicilio domicilio) {
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
		this.obraSocial = obraSocial;
		this.numeroAfiliado = numeroAfiliado;
		this.domicilio = domicilio;
		this.setId();
	}

	
	public String getId() {
		return _id;
	}
	public void setId() {
		this._id = new ObjectId().toString();
	}
	
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getObraSocial() {
		return obraSocial;
	}

	public void setObraSocial(String obraSocial) {
		this.obraSocial = obraSocial;
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
	
	

	
	

}
