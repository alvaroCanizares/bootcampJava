package videoJuego;

public class Main {

	public static void main(String[] args) {
		Guerrero g1 = new Guerrero();
		g1.setNombre("Conan");
		
		Espada espada = new Espada();
		g1.setArma(espada);
		
		
		g1.atacar();
	}

}
