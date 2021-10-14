package thread;

import java.util.Scanner;

public class MainThread {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean salir = false;
		String respuesta ="";
		
		do {
			System.out.println("INTRODUZCA NÚMERO");
			respuesta = sc.nextLine();
			NumeroThread n = new NumeroThread(Integer.parseInt(respuesta));
			Thread hilo = new Thread(n.runnable);
			hilo.start();
			System.out.println("QUIERE SALIR? Y/N");
			respuesta = sc.nextLine();
			
			if(respuesta.toLowerCase().contentEquals("y")) {
				salir = true;
			}
			
		}while(!salir);
		
		
			System.out.println("FIN");
			
		}

	

}
