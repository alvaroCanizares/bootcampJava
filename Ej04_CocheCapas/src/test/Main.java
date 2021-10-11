package test;

import java.util.List;
import java.util.Scanner;

import entidad.Coche;
import negocio.GestorCoche;

public class Main {
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String respuesta ="";
		boolean fin = false;
		GestorCoche gestor = new GestorCoche();
		Coche c = null;
		
		do {
			System.out.println("BIENVENIDO AL CONCESIONARIO, ¿QUÉ DESEA?:\n");
			System.out.println("1:Dar de alta\n"
								+"2:Dar de baja\n"
								+"3:Modificar\n"
								+"4:Consultar\n"
								+"5:Listar\n"
								+"6:Salir\n");
			respuesta = sc.nextLine();
			
			switch (respuesta) {
			case "1":
				c = new Coche();
				c.setMatricula(pedirString("matricula"));
				c.setMarca(pedirString("marca"));
				c.setModelo(pedirString("modelo"));
				c.setNumeroKm(pedirInt());
				
				comprobar(gestor.alta(c));
				break;
			case "2":
				comprobar(gestor.baja(pedirString("matricula")));
				break;
			case "3":
				c = new Coche();
				c.setMatricula(pedirString("matricula"));
				c.setMarca(pedirString("marca"));
				c.setModelo(pedirString("modelo"));
				c.setNumeroKm(pedirInt());
				
				comprobar(gestor.modificar(c));
				break;
			case "4":
				c = gestor.obtener(pedirString("matricula"));
				System.out.println(c);
				break;
			case "5":
				List<Coche> lista = gestor.listar();
				for (Coche coche : lista) {
					System.out.println(coche);
				}
				break;
			case "6":
				fin = true;
				break;

			default:
				System.out.println("Error introduzca el numero indicado");
				break;
			}
			
		}while(!fin);
		System.out.println("ADIOS");
	}
	
	public static String pedirString(String cadena) {
		System.out.println("Introduzca "+cadena);
		String respuesta = sc.nextLine();
		return respuesta;
	}
	
	public static int pedirInt() {
		System.out.println("Introduzca el nº de km");
		int respuesta = sc.nextInt();
		return respuesta;
	}
	public static void comprobar(boolean b) {
		if(b) {
			System.out.println("éxito");
		}else {
			System.out.println("Error");
		}
	}

}
