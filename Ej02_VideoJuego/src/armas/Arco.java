package armas;

import personajes.Atributo;

public class Arco extends Arma{
	
	public Arco(double danio) {
		this.setDanio(danio);
		this.setAtributo(Atributo.FUERZA);
		this.setCritico(1.8);
		this.setProbCritico(0.3);
	}
	public double usar() {
		double danio = this.getDanio();
		double herir = (Math.random() * ((danio + margen) - danio)) + danio;
		
		System.out.println("Fiuuuuuu");
		return herir;
	}

}
