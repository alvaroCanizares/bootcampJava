package personajes;

import armas.Arma;

public abstract class Personaje {
	private String nombre;
	private double vida;
	private Arma arma;
	private Atributo atributo;
	private double valorAtributo;

	
	public Personaje() {}
	
	public double atacar() {

		double daniar = arma.usar();
		
		if(arma.getAtributo() == atributo) {
			daniar += valorAtributo;
		}
		if(Math.random()<arma.getProbCritico()) {
			daniar *= arma.getCritico();
			System.out.println(nombre.toUpperCase() + " HIZO " + String.format("%.2f", daniar) + " DE DAÑO CRÍTICO\n");
		}else {
			System.out.println(nombre + " hizo " + String.format("%.2f", daniar) + " de daño\n");
		}
		
		return daniar;
	}
	
	public void recibirDanio(double danio) {
		vida -= danio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}

	public Atributo getAtributo() {
		return atributo;
	}

	public void setAtributo(Atributo atributo) {
		this.atributo = atributo;
	}

	public double getVida() {
		return vida;
	}

	public void setVida(double vida) {
		this.vida = vida;
	}

	public double getValorAtributo() {
		return valorAtributo;
	}

	public void setValorAtributo(double valorAtributo) {
		this.valorAtributo = valorAtributo;
	}

	@Override
	public String toString() {
		return nombre + ": " + String.format("%.2f", vida) + " HP";
	}
	
	

	
}

	
