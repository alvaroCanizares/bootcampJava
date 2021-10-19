
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static ApplicationContext context = new ClassPathXmlApplicationContext("superHeroes.xml");
	private static Scanner sc = new Scanner(System.in);
	private static List<SuperHeroe> listaSuperheroes = context.getBean("listaSuperHeroes", List.class);
	private static List<SuperHeroe> listaSuperheroesPw100 = context.getBean("listaSuperHeroesPw100", List.class);
	private static List<SuperHeroe> listaSuperheroesVolar = context.getBean("listaSuperHeroesVolar", List.class);
	
	public static void main(String[] args) {
		  
		
		SuperHeroe superMan = context.getBean("SuperMan",SuperHeroe.class);
		SuperHeroe spiderman = context.getBean("SpiderMan",SuperHeroe.class);
		SuperHeroe batMan = context.getBean("Batman",SuperHeroe.class);
		
		SuperHeroe aspirante1 = context.getBean("SuperHeroePw100",SuperHeroe.class);
		aspirante1.setId("4");
		aspirante1.setNombre("aspirante1");
		aspirante1.setNombreSuperHeroe("SuperAspiranteVolador");
		aspirante1.setSuperPoder("Nadar");
		
		SuperHeroe aspirante2 = context.getBean("SuperHeroeVolar",SuperHeroe.class);
		aspirante2.setId("5");
		aspirante2.setNombre("aspirante2");
		aspirante2.setNombreSuperHeroe("SuperAspirante2");
		aspirante2.setPoder(1);
		
	
		
		listaSuperheroes.add(superMan);
		listaSuperheroes.add(spiderman);
		listaSuperheroes.add(batMan);
		listaSuperheroes.add(aspirante1);
		listaSuperheroes.add(aspirante2);
		
		String respuesta ="";
		boolean fin = false;
		
		do {
			System.out.println("¿QUÉ DESEA?:\n");
			System.out.println("1:Listar\n"
								+"2:Añadir Superheroe con potencia 100\n"
								+"3:Añadir Superheroe Volador\n"
								+"4:Listar Superheroes con potencia >100\n"
								+"5:Listar Superherores voladores\n"
								+"6:Salir\n"
								);
			respuesta = sc.nextLine();
			
			switch (respuesta) {
			case "1":
				listar(0);
				break;
			case "2":
				aniadir("potencia");
				break;
			case "3":
				aniadir("");
				break;
			case "4":
				listar(1);
				break;
			case "5":
				listar(2);
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

	private static void listar(int i) {
		switch (i) {
		case 0:
			for (SuperHeroe superHeroe : listaSuperheroes) {
				System.out.println(superHeroe.toString());
			}
			break;
		case 1:
			for (SuperHeroe superHeroe : listaSuperheroesPw100) {
				System.out.println(superHeroe.toString());
			}
			break;
		case 2:
			for (SuperHeroe superHeroe : listaSuperheroesVolar) {
				System.out.println(superHeroe.toString());
			}
			break;
		default:
			break;
		}
		
	}

	private static void aniadir(String string) {
		SuperHeroe heroeAux = null;
		
		System.out.println("Introduzca su nombre");
		String nombre = sc.nextLine();
		
		System.out.println("Introduzca su nombre de SuperHeroe");
		String nombreSuper = sc.nextLine();
		
		if(string.contentEquals("potencia")) {
			System.out.println("Introduzca su superPoder");
			String superPoder = sc.nextLine();
			heroeAux = context.getBean("SuperHeroePw100",SuperHeroe.class);
			
			heroeAux.setId(String.valueOf(listaSuperheroes.size()+1));
			heroeAux.setNombre(nombre);
			heroeAux.setNombreSuperHeroe(nombreSuper);
			heroeAux.setSuperPoder(superPoder);
			listaSuperheroesPw100.add(heroeAux);
		}else {
			System.out.println("Introduzca su potencia");
			String potencia = sc.nextLine();
			heroeAux = context.getBean("SuperHeroeVolar",SuperHeroe.class);
			
			heroeAux.setId(String.valueOf(listaSuperheroes.size()+1));
			heroeAux.setNombre(nombre);
			heroeAux.setNombreSuperHeroe(nombreSuper);
			heroeAux.setPoder(Integer.parseInt(potencia));
			listaSuperheroesVolar.add(heroeAux);
		}
		
		
				
	}
	
	

	

}
