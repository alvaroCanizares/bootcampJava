

import java.util.List;

public class Ordenador {
	private double precio;
	private String marca;
	private List <Ram> listaRam;
	private Procesador procesador;
	private List <TarjetaGrafica> listaTarjetaGrafica;
	private List <Periferico> listaPerifericos;
	private Placabase placabase;
	
	public Ordenador(String marca, List<Ram> listaRam, Procesador procesador,
			List<TarjetaGrafica> listaTarjetaGrafica, List<Periferico> listaPerifericos, Placabase placabase) {
		super();
		this.marca = marca;
		this.listaRam = listaRam;
		this.procesador = procesador;
		this.listaTarjetaGrafica = listaTarjetaGrafica;
		this.listaPerifericos = listaPerifericos;
		this.placabase = placabase;
		precio = calcularPrecioComponentes();
	}
	
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public List<Ram> getListaRam() {
		return listaRam;
	}

	public void setListaRam(List<Ram> listaRam) {
		this.listaRam = listaRam;
	}

	public Procesador getProcesador() {
		return procesador;
	}

	public void setProcesador(Procesador procesador) {
		this.procesador = procesador;
	}

	public List<TarjetaGrafica> getListaTarjetaGrafica() {
		return listaTarjetaGrafica;
	}

	public void setListaTarjetaGrafica(List<TarjetaGrafica> listaTarjetaGrafica) {
		this.listaTarjetaGrafica = listaTarjetaGrafica;
	}

	public List<Periferico> getListaPerifericos() {
		return listaPerifericos;
	}

	public void setListaPerifericos(List<Periferico> listaPerifericos) {
		this.listaPerifericos = listaPerifericos;
	}

	public Placabase getPlacabase() {
		return placabase;
	}

	public void setPlacabase(Placabase placabase) {
		this.placabase = placabase;
	}
	
	public double calcularPrecioComponentes() {
		double total;
		double totalRam = 0;
		double totalGrafica = 0;
		double totalPeriferico = 0;
		
		for (Ram ram : listaRam) {
			totalRam += ram.getPrecio();
		}
		
		for (TarjetaGrafica grafica : listaTarjetaGrafica) {
			totalGrafica += grafica.getPrecio();
		}
		
		for(Periferico periferico : listaPerifericos) {
			totalPeriferico += periferico.getPrecio();
		}
		total = totalRam + procesador.getPrecio() + totalGrafica + totalPeriferico + placabase.getPrecio();
		
	return total;	
	}

	@Override
	public String toString() {
		return "Ordenador [precio=" + precio + ", marca=" + marca + ", listaRam=" + listaRam + ", procesador="
				+ procesador + ", listaTarjetaGrafica=" + listaTarjetaGrafica + ", listaPerifericos=" + listaPerifericos
				+ ", placabase=" + placabase + "]";
	}

	
	
}
