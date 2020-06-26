package modelo;



public class Sucursal {

	
	private Domicilio domicilio;
	private int _id;

	public Sucursal(Domicilio domicilio, int nroSucursal) {
		this.domicilio = domicilio;
		this._id = nroSucursal;
	}
	public Domicilio getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}
	public int getId() {
		return _id;
	}
	public void setId(int nroSucursal) {
		this._id = nroSucursal;
	}

}