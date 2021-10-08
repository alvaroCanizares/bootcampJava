package videoJuego;

import java.util.Scanner;

import personajes.Personaje;

public class Arena {
	private Personaje p1;
	private Personaje p2;
	
	public Arena (Personaje a, Personaje b) {
		// ORDEN ALEATORIO DE COMBATE
		if(Math.random()< 0.5) {
			this.p1 = a;
			this.p2 = b;
		}else {
			this.p1 = b;
			this.p2 = a;
		}
		
	}
	
	public void combate() {
		Scanner sc = new Scanner(System.in);
		int contador= 1;
		String pausa ="";
		boolean fin = false;
		
		
		System.out.println("COMIENZA EL COMBATE "+p1.getNombre().toUpperCase()
				+" VS " +p2.getNombre().toUpperCase()+"\n");
		
		afinidad();
			
		while(!fin) {
			System.out.println("--------- RONDA" +contador +" ---------");
			p2.recibirDanio(p1.atacar());
			p1.recibirDanio(p2.atacar());
			
			if(p1.getVida() > 0 && p2.getVida() > 0) {
				System.out.println("--------- ESTADO ---------");
				System.out.println(p1);
				System.out.println(p2);
				
				contador++;
				System.out.println("--------- ENTER ---------");
				pausa = sc.nextLine();
			}else {
				fin = true;
			}
		}
		
		ganador();
	}

	private void afinidad() {
		String afinidad ="";
		Personaje personajes [] = {p1,p2};
		
		System.out.println("--------- AFINIDAD ---------");
		
		for (Personaje personaje : personajes) {
			if(personaje.getAtributo()==personaje.getArma().getAtributo()) {
				afinidad = personaje.getNombre()+" SI\n";
			}else {
				afinidad = personaje.getNombre()+" NO\n";
			}
			System.out.println(afinidad);
		}
		
		
	}

	private void ganador() {
		String ganador;
		if(p1.getVida()>0) {
			ganador = p1.getNombre();
		}else {
			ganador = p2.getNombre();
		}
		System.out.println(ganador.toUpperCase() + " ES EL GANADOR");
	}

}
