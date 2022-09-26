package control.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import model.dto.Articulo;
import model.dto.Cliente;
import model.dto.LineaPedido;
import model.repositorio.ArticuloRepositorio;
import model.repositorio.PedidoRepositorio;

public class PedidoService {

	private PedidoRepositorio pedidoRepositorio;
	private ArticuloRepositorio articuloRepositorio;

	public PedidoService(PedidoRepositorio pedidoRepositorio, ArticuloRepositorio articuloRepositorio) {
		super();
		this.pedidoRepositorio = pedidoRepositorio;
		this.articuloRepositorio = articuloRepositorio;
	}

	public int getAmountPedidosBetweenTwoDates(Cliente cliente, LocalDate initialDate, LocalDate endingDate) {
		return pedidoRepositorio.findPedidosFromClienteBetweenIncialAndEndingDates(cliente, initialDate, endingDate)
				.size();
	}

	public List<Articulo> getThreeBestSellersArticulo() {
		List<LineaPedido> lineasContabilidad = generateList();
		pedidoRepositorio.findAll().forEach((pedido) -> {
			Arrays.asList(pedido.getLineasPedido()).forEach((linea) -> {
				lineasContabilidad.get(lineasContabilidad.indexOf(linea.getArticulo()))
						.incCantidad(linea.getCantidad());
			});
		});
		
		int maxSize = 3;
		Stream<LineaPedido> limit = lineasContabilidad.stream().sorted((a,b)->{
			return a.getCantidad()-b.getCantidad();
		}).limit(maxSize);
		ArrayList<Articulo> articulos=new ArrayList<>();
		limit.forEach((a)->{
			articulos.add(a.getArticulo());
		});
		return articulos;
	}

	private List<LineaPedido> generateList() {
		List<Articulo> allArticulos = articuloRepositorio.findAll();
		ArrayList<LineaPedido> lineas = new ArrayList();
		allArticulos.forEach((articulo) -> {
			lineas.add(new LineaPedido(articulo, 0));
		});
		return lineas;
	}
}
