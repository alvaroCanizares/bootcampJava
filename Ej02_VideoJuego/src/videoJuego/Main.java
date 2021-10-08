package videoJuego;

import armas.*;
import personajes.*;

public class Main {

	public static void main(String[] args) {
		Espada espada = new Espada(10);
		Guerrero conan = new Guerrero("Conan", 200, espada, 6);
		
		Hechizo hechizo = new Hechizo(15);
		Mago harry = new Mago("Harry", 140, hechizo, 12);
		
		Arena arena = new Arena(conan, harry);
		arena.combate();
		
	}

}
