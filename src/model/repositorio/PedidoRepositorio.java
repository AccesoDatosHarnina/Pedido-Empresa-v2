package model.repositorio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.dto.Cliente;
import model.dto.Pedido;
import model.objectmother.PedidoOM;

public class PedidoRepositorio {
	private List<Pedido> pedidos;
	

	public PedidoRepositorio() {
		super();
		pedidos=PedidoOM.getPedidos();
	}


	public List<Pedido> findAll(){
		return pedidos;
	}
	
	public List<Pedido> findPedidosFromClienteBetweenIncialAndEndingDates(Cliente cliente, LocalDate initialDate, LocalDate endingDate) {
		List<Pedido> listPedido=new ArrayList<>();
		for (Pedido pedido : pedidos) {
			LocalDate fecha = pedido.getFecha();
			if(
					pedido.equalsCliente(cliente)
					&&initialDate.isBefore(fecha)
					&&endingDate.isAfter(fecha)
					||initialDate.isEqual(fecha)
					||endingDate.isEqual(fecha)) {
				listPedido.add(pedido);
			};
		}
		return listPedido;
	}
	
	
	
}
