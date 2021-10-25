package es.curso.main;
import es.curso.config.Configuracion;
import es.curso.modelo.entidades.Cliente;
import es.curso.modelo.entidades.Pedido;
import es.curso.modelo.negocio.GestorCliente;
import es.curso.modelo.negocio.GestorPedido;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

//	Tendremos un menu que haga lo siguinte:
//
//	1. Alta cliente
//	2. Borra cliente
//	3. Modificar cliente
//	4. buscar cliente por nombre
//	5. Buscar cliente por id
//	6. Añadir pedido a cliente por id
//	7. listar pedidos de cliente por id
//
//
	private static ApplicationContext context= new AnnotationConfigApplicationContext(Configuracion.class);
	private static Scanner sc = new Scanner(System.in);
	private static GestorCliente gc = context.getBean("gestorCliente",GestorCliente.class);
	private static GestorPedido gp = context.getBean("gestorPedido",GestorPedido.class);
	
	private static Cliente c = context.getBean("cliente",Cliente.class);
	private static Pedido p = context.getBean("pedido",Pedido.class);
		
	public static void main(String[] args) {		
		
		Boolean fin = false;
		String respuesta ="";
		
		do {
			System.out.println("BIENVENIDO AL CONCESIONARIO, ¿QUÉ DESEA?:\n");
			System.out.println("1:Dar de alta cliente\n"
								+"2:Dar de baja cliente\n"
								+"3:Modificar cliente\n"
								+"4:Consultar cliente por nombre\n"
								+"5:Consultar cliente por id\n"
								+"6:Añadir pedido a cliente por id\n"
								+"7:Listar pedidos de cliente por id\n"
								+"8:Salir\n");
			respuesta = sc.nextLine();
			
			switch (respuesta) {
			case "1":
				altaCli();
				break;
			case "2":
				bajaCli();
				break;
			case "3":
				modificarCli();
				break;
			case "4":
				buscarCliNombre();
				
				break;
			case "5":
				buscarCliId();
				break;
			case "6":
				aniadirPedido();
				break;
			case "7":
				listarPedido();
				break;
			case "8":
				fin = true;
				break;

			default:
				System.out.println("Error introduzca el numero indicado");
				break;
			}
			
		}while(!fin);
		System.out.println("ADIOS");
	}

	private static void listarPedido() {
		System.out.println("Introduzca id");
		ArrayList<Pedido> listaPedidos = gp.listar(Integer.parseInt(sc.nextLine()));
		for (Pedido pedido : listaPedidos) {
			System.out.println(pedido);
		}
	}

	private static void aniadirPedido() {
		System.out.println("Introduzca id");
		int id = Integer.parseInt(sc.nextLine());
		System.out.println("Introduzca importe");
		double importe = Double.parseDouble(sc.nextLine());
		
		p.setId(id);
		p.setImporte(importe);
		p.setFecha(ZonedDateTime.now().toString());
		
		gp.insertar(p);
		System.out.println("Dado de alta " + p);
		
	}

	private static void buscarCliId() {
		System.out.println("Introduzca id");
		c = gc.buscar(Integer.parseInt(sc.nextLine()));
		System.out.println("Encontrado " + c);
	}
	
	private static void buscarCliNombre() {
		System.out.println("Introduzca nombre");
		c = gc.buscar(sc.next());
		System.out.println("Encontrado " + c);
	}

	private static void modificarCli() {
		System.out.println("Introduzca id");
		int id = Integer.parseInt(sc.nextLine());
		System.out.println("Introduzca nombre");
		String nombre = sc.nextLine();
		System.out.println("Introduzca edad");
		int edad = Integer.parseInt(sc.nextLine());
		
		c.setId(id);
		c.setEdad(edad);
		c.setNombre(nombre);
		
		gc.modificar(c);
		System.out.println("Modificado " +c);
		
	}

	private static void bajaCli() {
		System.out.println("Introduzca id");
		gc.borrar(Integer.parseInt(sc.nextLine()));
		System.out.println("Dado de baja");
	}

	private static void altaCli() {
		System.out.println("Introduzca id");
		int id = Integer.parseInt(sc.nextLine());
		System.out.println("Introduzca nombre");
		String nombre = sc.nextLine();
		System.out.println("Introduzca edad");
		int edad = Integer.parseInt(sc.nextLine());
		
		c.setId(id);
		c.setEdad(edad);
		c.setNombre(nombre);
		
		gc.insertar(c);
		System.out.println("Dado de alta " + c);
	}
		
	

}
