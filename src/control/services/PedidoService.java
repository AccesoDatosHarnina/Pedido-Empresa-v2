package control.services;

import java.time.LocalDate;

import model.dto.Cliente;
import model.repositorio.PedidoRepositorio;

public class PedidoService {
	
	private PedidoRepositorio pedidoRepositorio;
	
	public PedidoService(PedidoRepositorio pedidoRepositorio) {
		super();
		this.pedidoRepositorio = pedidoRepositorio;
	}

	public int getAmountPedidosBetweenTwoDates(Cliente cliente,LocalDate initialDate,LocalDate endingDate) {
		return pedidoRepositorio.findPedidosFromClienteBetweenIncialAndEndingDates(cliente,initialDate,endingDate).size();
	}
}
