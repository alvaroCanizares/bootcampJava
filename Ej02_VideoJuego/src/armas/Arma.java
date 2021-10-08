package armas;

import personajes.Atributo;

public  abstract class Arma {
	private String nombre;
	private double danio;
	public double margen = 10;
	private Atributo atributo;
	private double critico;
	private double probCritico;
	
	public abstract double usar();
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getDanio() {
		return danio;
	}

	public void setDanio(double danio) {
		this.danio = danio;
	}


	public Atributo getAtributo() {
		return atributo;
	}


	public void setAtributo(Atributo atributo) {
		this.atributo = atributo;
	}


	public double getCritico() {
		return critico;
	}


	public void setCritico(double critico) {
		this.critico = critico;
	}


	public double getProbCritico() {
		return probCritico;
	}


	public void setProbCritico(double probCritico) {
		this.probCritico = probCritico;
	}
}
