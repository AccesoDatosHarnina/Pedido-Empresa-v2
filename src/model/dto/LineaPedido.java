package model.dto;

import java.util.Objects;

public class LineaPedido {

	private Articulo articulo;
	private int cantidad;

	public LineaPedido(Articulo articulo, int cantidad) {
		super();
		this.articulo = articulo;
		this.cantidad = cantidad;
	}


	@Override
	public int hashCode() {
		return Objects.hash(articulo);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LineaPedido other = (LineaPedido) obj;
		return Objects.equals(articulo, other.articulo);
	}


	public int getCantidad() {
		return cantidad;
	}
	
	public void incCantidad(int cantidad) {
		this.cantidad+=cantidad;
	}
	
	private void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getCuantiaParcial() {
		return getPrecio()*getCantidad();
	}

	public float getPrecio() {
		return this.articulo.getPrecio();
	}


	public Articulo getArticulo() {
		return articulo;
	}

}
