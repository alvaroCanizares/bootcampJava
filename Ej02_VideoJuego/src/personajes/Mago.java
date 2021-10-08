package personajes;

import armas.Arma;

public class Mago extends Personaje{
	
	public Mago(String nombre, double vida, Arma arma, double valorAtributo) {
		this.setNombre(nombre);
		this.setVida(vida);
		this.setArma(arma);
		this.setAtributo(Atributo.INTELIGENCIA);
		this.setValorAtributo(valorAtributo);
	}
}
