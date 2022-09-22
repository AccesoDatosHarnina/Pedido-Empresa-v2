package model.dto;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

public class Pedido {
	//propiedades
	private int numeroDeSerie;
	private LocalDate fecha;
	private Cliente cliente;

	//	private float cuantiaTotal;
	private Map<Articulo,Integer> lineas;
	
	//Setters and Getters
	public Pedido(int numeroDeSerie, Cliente cliente) {
		super();
		this.numeroDeSerie = numeroDeSerie;
		this.cliente = cliente;
		this.fecha=LocalDate.now();
		lineas=new HashMap<Articulo,Integer>();
	}
	
	//metodos
	public boolean addArticulo(Articulo articulo, Integer cantidad) {
		// assert
		if (!lineas.containsKey(articulo)) {
			lineas.put(articulo, cantidad);
			return true;
		}
		return false;
	}
	
	public float getCuantiaTotal() {
		float cuantia = 0;
		Iterator<Entry<Articulo, Integer>> iterator = lineas.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Articulo, Integer> next = iterator.next();
			cuantia+=getPrecio(next.getKey())*next.getValue();
		}
		return cuantia=cuantia-cuantia*this.cliente.getDescuento();
	}
	
	

	public boolean equalsCliente(Cliente cliente) {
		return this.cliente.equals(cliente);
	}
	@Override
	public int hashCode() {
		return Objects.hash(cliente, fecha, lineas, numeroDeSerie);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(fecha, other.fecha)
				&& Objects.equals(lineas, other.lineas) && numeroDeSerie == other.numeroDeSerie;
	}

	public float getPrecio(Articulo articulo) {
		return articulo.getPrecio();
	}
	public Cliente getCliente() {
		return cliente;
	}

	private void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
	
	
	
	
	
	
	
	
}
