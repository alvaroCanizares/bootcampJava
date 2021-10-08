package armas;

import personajes.Atributo;

public class Espada extends Arma{
	
	public Espada(double danio) {
		this.setDanio(danio);
		this.setAtributo(Atributo.FUERZA);
		this.setCritico(1.3);
		this.setProbCritico(0.4);
	}
	public double usar() {
		double danio = this.getDanio();
		double herir = (Math.random() * ((danio + margen) - danio)) + danio;
		
		System.out.println("Swangggg!");
		return herir;
	}

}
