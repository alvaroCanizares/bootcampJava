package Runnable;

import java.util.Scanner;



public class MainRunnable {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean salir = false;
		String respuesta ="";
		
		do {
			System.out.println("INTRODUZCA NÚMERO");
			respuesta = sc.nextLine();
			Numero n = new Numero(Integer.parseInt(respuesta));
			Thread t = new Thread(n);
			
			t.start();
			System.out.println("QUIERE SALIR? Y/N");
			respuesta = sc.nextLine();
			
			if(respuesta.toLowerCase().contentEquals("y")) {
				salir = true;
			}
			
		}while(!salir);
		
		
			System.out.println("FIN");	
		}

	

}
