package es.curso;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import es.curso.entidad.Coche;
import es.curso.negocio.GestorCoche;

@SpringBootApplication
public class Application implements CommandLineRunner{
	
private static Scanner sc = new Scanner(System.in);

	@Autowired	
	public GestorCoche gestor;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {	
		
		
		String respuesta ="";
		boolean fin = false;

		Coche c = new Coche();
		String mensaje = "";
		do {
			System.out.println("BIENVENIDO AL CONCESIONARIO, �QU� DESEA?:\n");
			System.out.println("1:Dar de alta\n"
								+"2:Dar de baja\n"
								+"3:Modificar\n"
								+"4:Consultar\n"
								+"5:Listar\n"
								+"6:Salir\n");
			respuesta = sc.nextLine();

			switch (respuesta) {
			case "1":
				c.setMatricula(pedirString("matricula"));
				c.setMarca(pedirString("marca"));
				c.setModelo(pedirString("modelo"));
				c.setNumeroKm(pedirInt());

				mensaje = "Dado de alta: " + gestor.alta(c);
				break;
			case "2":
				mensaje = "Dado de Baja " + gestor.baja(pedirString("matricula"));
				break;
			case "3":
				c = new Coche();
				c.setMatricula(pedirString("matricula"));
				c.setMarca(pedirString("marca"));
				c.setModelo(pedirString("modelo"));
				c.setNumeroKm(pedirInt());

				mensaje = "Dado de alta: " + gestor.modificar(c);
				break;
			case "4":
				c = gestor.obtener(pedirString("matricula"));
				System.out.println("Obtenido : " + c);
				break;
			case "5":
				List<Coche> lista = gestor.listar();
				System.out.println("LISTADO");
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
			
			System.out.println(mensaje);

		}while(!fin);
		System.out.println("ADIOS");
		
	}
	

	public static String pedirString(String cadena) {
		System.out.println("Introduzca "+cadena);
		String respuesta = sc.nextLine();
		return respuesta;
	}

	public static int pedirInt() {
		System.out.println("Introduzca el n� de km");
		int respuesta = sc.nextInt();
		return respuesta;
	}
	

}
