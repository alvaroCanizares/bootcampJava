package es.curso.cfg;

import java.util.ArrayList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import es.curso.entidad.Periferico;
import es.curso.entidad.Ram;
import es.curso.entidad.TarjetaGrafica;
import es.curso.entidad.TipoPeriferico;
import es.curso.util.MarcaAleatoria;
import es.curso.util.NumeroAleatorio;



@Configuration
@ComponentScan(basePackages = {"es.curso"})

public class ConfiguracionSpring {

	@Bean
	public NumeroAleatorio numeroAleatorio() {
		NumeroAleatorio numeroAleatorio = new NumeroAleatorio();
		return numeroAleatorio;
	}
	@Bean
	public MarcaAleatoria marcaAleatoria() {
		MarcaAleatoria marcaAleatoria = new MarcaAleatoria();
		return marcaAleatoria;
	}
	@Bean
	public Ram ram1() {
		Ram ram = new Ram();
		ram.setPrecio(numeroAleatorio().generarNumero(500, 24));
		ram.setHz(3200);
		ram.setGeneracion("DDR4");
		return ram;
	}
	@Bean
	public Ram ram2() {
		Ram ram = new Ram();
		ram.setPrecio(numeroAleatorio().generarNumero(500, 24));
		ram.setHz(4000);
		ram.setGeneracion("DDR4");
		return ram;
	}
	@Bean
	public Ram ramGraficaIntegrada() {
		Ram ram = new Ram();
		ram.setPrecio(numeroAleatorio().generarNumero(500, 24));
		ram.setHz(3200);
		ram.setGeneracion("DDR4");
		return ram;
	}
	@Bean
	public Ram ramGrafica() {
		Ram ram = new Ram();
		ram.setPrecio(numeroAleatorio().generarNumero(500, 24));
		ram.setHz(4000);
		ram.setGeneracion("DDR4");
		return ram;
	}
	@Bean
	public ArrayList<Ram> listaRam() {
		ArrayList<Ram> listaRam = new ArrayList<Ram>();
		listaRam.add(ram1());
		listaRam.add(ram2());
		return listaRam;
	}
	
	@Bean
	public TarjetaGrafica tarjetaGraficaIntegrada() {
		TarjetaGrafica tarjeta = new TarjetaGrafica();
		tarjeta.setPrecio(numeroAleatorio().generarNumero(500, 24));
		tarjeta.setMarca(marcaAleatoria().generarMarca());
		tarjeta.setModelo("GTX3090");
		tarjeta.setRam(ramGraficaIntegrada());
		return tarjeta;
	}
	@Bean
	public TarjetaGrafica tarjetaGrafica1() {
		TarjetaGrafica tarjeta = new TarjetaGrafica();
		tarjeta.setPrecio(numeroAleatorio().generarNumero(500, 24));
		tarjeta.setMarca(marcaAleatoria().generarMarca());
		tarjeta.setModelo("GTX3070");
		tarjeta.setRam(ramGrafica());
		return tarjeta;
	}
	@Bean 
	public ArrayList<TarjetaGrafica> listaTarjetasGraficas(){
		ArrayList<TarjetaGrafica> lista = new ArrayList<TarjetaGrafica>();
		lista.add(tarjetaGrafica1());
		lista.add(tarjetaGraficaIntegrada());
		return lista;
	}
	@Bean
	public Periferico periferico1() {
		Periferico p =  new Periferico();
		p.setPrecio(numeroAleatorio().generarNumero(500, 24));
		p.setMarca(marcaAleatoria().generarMarca());
		p.setTipo(TipoPeriferico.RATON);
		return p;
	}
	@Bean
	public Periferico periferico2() {
		Periferico p =  new Periferico();
		p.setPrecio(numeroAleatorio().generarNumero(500, 24));
		p.setMarca(marcaAleatoria().generarMarca());
		p.setTipo(TipoPeriferico.TECLADO);
		return p;
	}
	@Bean
	public Periferico periferico3() {
		Periferico p =  new Periferico();
		p.setPrecio(numeroAleatorio().generarNumero(500, 24));
		p.setMarca(marcaAleatoria().generarMarca());
		p.setTipo(TipoPeriferico.RATON);
		return p;
	}
	
	@Bean 
	public ArrayList<Periferico> listaPerifericos(){
		ArrayList<Periferico> lista = new ArrayList<Periferico>();
		lista.add(periferico1());
		lista.add(periferico2());
		lista.add(periferico3());
		return lista;
	}
	
}
