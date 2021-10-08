package videoJuego;

public  abstract class Arma {
	private String nombre;
	
	public abstract void usar();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
