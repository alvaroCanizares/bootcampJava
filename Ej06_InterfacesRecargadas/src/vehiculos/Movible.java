package vehiculos;

public interface Movible {
	final int POTENCIA_AVION =3;
	final int POTENCIA_BARCO =2;
	
	default void mover(Object vehiculo,int distancia) {
		
		if(vehiculo instanceof Avion ){
			Avion avion = (Avion) vehiculo;
			System.out.println(avion.getNombre() + " se ha movido por el aire " + (distancia+avion.getPotencia()*POTENCIA_AVION) + " metros");
		
		}else if (vehiculo instanceof Barco) {
			Barco barco = (Barco) vehiculo;
			System.out.println(barco.getNombre() +" se ha movido por el agua " + (distancia+barco.getPotencia()*POTENCIA_BARCO) + " metros");
			
		}else if (vehiculo instanceof Moto) {
			Moto Moto = (Moto) vehiculo;
			System.out.println(Moto.getNombre() +" se ha movido por la carretera " + distancia+ " metros");
		}else {
			Coche coche = (Coche) vehiculo;
			System.out.println(coche.getNombre() +" se ha movido por la carretera " + distancia+ " metros");
		}
	}
}
	

