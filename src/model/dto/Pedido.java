package model.dto;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

public class Pedido {
	//propiedades
	private int numeroDeSerie;
	private LocalDate fecha;
	private Cliente cliente;

	//	private float cuantiaTotal;
	private Set<LineaPedido> lineas;
	private float cuantia = 0;
	
	//Setters and Getters
	public Pedido(int numeroDeSerie, Cliente cliente) {
		super();
		this.numeroDeSerie = numeroDeSerie;
		this.cliente = cliente;
		this.fecha=LocalDate.now();
		lineas=new HashSet<LineaPedido>();
	}
	
	//metodos
	public boolean addArticulo(Articulo articulo, Integer cantidad) {
		// assert
		return lineas.add(new LineaPedido(articulo, cantidad));
	}
		
	public float getCuantiaTotalLambda() {
		this.cuantia=0;
		lineas.forEach((linea)->{
			cuantia+=linea.getCuantiaParcial();
		});
		return cuantia-cuantia*this.cliente.getDescuento();
	}
	
	public float getCuantiaTotal() {
		float cuantia = 0;
		Iterator<LineaPedido> iterator = lineas.iterator();
		while (iterator.hasNext()) {
			LineaPedido next = iterator.next();
			cuantia+=next.getCuantiaParcial();
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
	
	public Cliente getCliente() {
		return cliente;
	}

	private void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public LineaPedido[] getLineasPedido() {
		return (LineaPedido[]) lineas.toArray();
		
	}

	

	
	
	
	
	
	
	
	
	
}
