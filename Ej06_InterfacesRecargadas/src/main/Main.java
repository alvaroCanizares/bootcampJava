package main;

import java.util.ArrayList;

import vehiculos.Avion;
import vehiculos.Barco;
import vehiculos.Coche;
import vehiculos.Moto;
import vehiculos.Vehiculo;


public class Main {

	public static void main(String[] args) {
		
		ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
		Avion avion = new Avion ("avion",1000,"avioncito");
		Barco barco = new Barco("barco", 750, "barquito");
		Coche coche = new Coche("coche", 500, "cochecito");
		Moto moto = new Moto("moto", 300, "motito");
		
		vehiculos.add(avion);
		vehiculos.add(barco);
		vehiculos.add(coche);
		vehiculos.add(moto);
		
		for (Vehiculo vehiculo : vehiculos) {
			vehiculo.mover(vehiculo, 50);
		}
		
		}

}
