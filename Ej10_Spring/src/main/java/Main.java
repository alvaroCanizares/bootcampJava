

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static ApplicationContext context = new ClassPathXmlApplicationContext("ordenadores.xml");
	
	public static void main(String[] args) {
	
		
		Ordenador pc = context.getBean("pc", Ordenador.class);
		List <Ram> lista =  (List<Ram>) context.getBean("listaRams", java.util.ArrayList.class);
		System.out.println(lista);
		 System.out.println(pc);
		 System.out.println(pc.calcularPrecioComponentes());
	
		
	}

}
