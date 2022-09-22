package model.dto;


public class Vendedor extends Persona{
	private Ruta ruta;

	public Vendedor(String DNI, String nombre, Ruta ruta) {
		super(DNI, nombre);
		this.ruta = ruta;
	}

	private Ruta getRuta() {
		return ruta;
	}

	private void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}
	
	

}
