package model.dto;

public class Articulo {
	private String referencia;
	private String descripcion;
	private float precio;
	public Articulo(String referencia, String descripcion, float precio) {
		super();
		this.referencia = referencia;
		this.descripcion = descripcion;
		this.precio = precio;
	}
	private String getReferencia() {
		return referencia;
	}
	private void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	private String getDescripcion() {
		return descripcion;
	}
	private void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	float getPrecio() {
		return precio;
	}
	private void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
}
