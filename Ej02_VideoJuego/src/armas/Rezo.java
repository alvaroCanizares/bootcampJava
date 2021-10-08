package armas;

import personajes.Atributo;

public class Rezo extends Arma{
	
	public Rezo(double danio) {
		this.setDanio(danio);
		this.setAtributo(Atributo.SABIDURIA);
		this.setCritico(2.2);
		this.setProbCritico(0.2);
	}
	public double usar() {
		double danio = this.getDanio();
		double herir = (Math.random() * ((danio + margen) - danio)) + danio;
		
		System.out.println("Wololooo");
		return herir;
	}

}

