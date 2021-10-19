

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static ApplicationContext context = new ClassPathXmlApplicationContext("ordenadores.xml");
	public static void main(String[] args) {
	
		
		Ordenador pc = context.getBean("pc", Ordenador.class);
		
		 System.out.println(pc);
		 System.out.println(pc.calcularPrecioComponentes());
		
	}

}
