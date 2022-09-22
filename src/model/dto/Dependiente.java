package model.dto;


public class Dependiente extends Persona {

	private int mostrador;

	public Dependiente(String DNI, String nombre, int mostrador) {
		super(DNI, nombre);
		this.mostrador = mostrador;
	}

	private int getMostrador() {
		return mostrador;
	}

	private void setMostrador(int mostrador) {
		this.mostrador = mostrador;
	}
	
	
	
}
