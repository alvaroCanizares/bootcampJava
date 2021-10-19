

public class Placabase {
	private double precio;
	private String marca;
	private String modelo;
	
	public Placabase(double precio, String marca, String modelo) {
		super();
		this.precio = precio;
		this.marca = marca;
		this.modelo = modelo;
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
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
}
