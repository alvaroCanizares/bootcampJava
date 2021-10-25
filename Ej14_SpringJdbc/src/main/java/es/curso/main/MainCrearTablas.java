package es.curso.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.curso.config.Configuracion;
import es.curso.modelo.persistencia.DaoClienteJdbcTemplate;
import es.curso.modelo.persistencia.DaoPedidoJdbcTemplate;

public class MainCrearTablas {
	private static ApplicationContext context;
	
	static {
		context = new AnnotationConfigApplicationContext(Configuracion.class);
	}
	public static void main(String[] args) {
		DaoClienteJdbcTemplate daoCliente = context.getBean("daoClienteJdbcTemplate",DaoClienteJdbcTemplate.class);
		daoCliente.crearTablaClientes();
		System.out.println("Tabla Clientes creada");
		
		DaoPedidoJdbcTemplate daoPedido = context.getBean("daoPedidoJdbcTemplate",DaoPedidoJdbcTemplate.class);
		daoPedido.crearTablaPedidos();
		System.out.println("Tabla Pedidos creada");
	}

}
