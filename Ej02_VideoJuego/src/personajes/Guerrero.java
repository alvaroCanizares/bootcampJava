package personajes;

import armas.Arma;

public class Guerrero extends Personaje {
	
	public Guerrero(String nombre, double vida, Arma arma, double valorAtributo) {
		this.setNombre(nombre);
		this.setVida(vida);
		this.setArma(arma);
		this.setAtributo(Atributo.FUERZA);
		this.setValorAtributo(valorAtributo);
	}
}
