package tiendaOrdenadores;

public class Periferico {
	private TipoPeriferico nombre;
	private double precio;
	private String marca;
	
	public Periferico(TipoPeriferico nombre, double precio, String marca) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.marca = marca;
	}
	
	public TipoPeriferico getNombre() {
		return nombre;
	}
	public void setNombre(TipoPeriferico nombre) {
		this.nombre = nombre;
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
	
}

