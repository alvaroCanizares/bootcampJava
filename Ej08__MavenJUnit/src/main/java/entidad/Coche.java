package entidad;

public class Coche {
	
	private String matricula;
	private String marca;
	private String modelo;
	private int numeroKm;
	
	public Coche(String matricula, String marca, String modelo, int numeroKm) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.numeroKm = numeroKm;
	}
	
	public Coche() {
	}

	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
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
	public int getNumeroKm() {
		return numeroKm;
	}
	public void setNumeroKm(int numeroKm) {
		this.numeroKm = numeroKm;
	}
	@Override
	public String toString() {
		return "Coche [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", numeroKm=" + numeroKm
				+ "]";
	}
	
}
