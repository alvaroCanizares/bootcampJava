package tiendaOrdenadores;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		String marca = "Intell";
		
		Ram rgraf = new Ram(50, 3000, "DDR6");
		Ram ram = new Ram(100,4000,"DDR6");
		List <Ram> listaRam = List.of(ram,ram);
		
		TarjetaGrafica grafica3 = new TarjetaGrafica(200, "Intell", rgraf, "520");
		Procesador procesador = new Procesador(300, 4.5, "Intell", grafica3);
		
		TarjetaGrafica grafica1 = new TarjetaGrafica(750, "Nvidia", rgraf, "Asus");
		TarjetaGrafica grafica2 = new TarjetaGrafica(750, "Nvidia", rgraf, "Asus");
		List <TarjetaGrafica> listaGraficas = List.of(grafica1,grafica2);
		
		Periferico teclado = new Periferico(TipoPeriferico.TECLADO, 45, "IBM");
		Periferico pantalla = new Periferico(TipoPeriferico.PANTALLA,200,"Samsung");
		List <Periferico> listaPerifericos = List.of(teclado,pantalla);
		
		Placabase placa1 = new Placabase(30,"asus","DDR5");
		
		Ordenador pc = new Ordenador("Hp", listaRam, procesador, listaGraficas, listaPerifericos, placa1);
		
		 System.out.println(pc);
		 System.out.println(pc.calcularPrecioComponentes());
		
		
		
		
	}

}
