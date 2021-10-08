package personajes;

import armas.Arma;

public class Curandero extends Personaje {
	public Curandero(String nombre, double vida, Arma arma, double valorAtributo) {
		this.setNombre(nombre);
		this.setVida(vida);
		this.setArma(arma);
		this.setAtributo(Atributo.SABIDURIA);
		this.setValorAtributo(valorAtributo);
	}
}


