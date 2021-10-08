package armas;

import personajes.Atributo;

public class Hechizo extends Arma{
	
	public Hechizo(double danio) {
		this.setDanio(danio);
		this.setAtributo(Atributo.INTELIGENCIA);
		this.setCritico(2.2);
		this.setProbCritico(0.3);
	}
	public double usar() {
		double danio = this.getDanio();
		double herir = (Math.random() * ((danio + margen) - danio)) + danio;
		
		System.out.println("Abrabracadra");
		return herir;
	}

}

