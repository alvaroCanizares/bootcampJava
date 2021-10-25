package es.curso.modelo.persistencia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import es.curso.modelo.entidades.Cliente;

@Repository
public class DaoClienteJdbcTemplate implements DaoCliente {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private DaoClienteRowMapper clienteRowMapper;
	
	public int insertar(Cliente c) {
		String query = "insert into clientes(ID,NOMBRE,EDAD) values (?,?,?)";
		int id = jdbcTemplate.update(query,c.getId(), c.getNombre(),c.getEdad());
		
		return id;
	}

	public int modificar(Cliente c) {
		String query = "update clientes SET ID=?,NOMBRE=?,EDAD=?";
		int id = jdbcTemplate.update(query,c.getId(), c.getNombre(),c.getEdad());
		
		return id;
	}

	public int borrar(int id) {
		String query ="delete from clientes where id=?";
		return jdbcTemplate.update(query,id);
	}

	public Cliente buscar(int id) {
		String query = "select * from clientes where id=?";
		Cliente c = null;
		
		try {
			c = jdbcTemplate.queryForObject(query, clienteRowMapper,id);
		}catch(EmptyResultDataAccessException e) {
			System.out.println("No existe ese cliente");
		}
		
		return c;
	}
	

	

	public void crearTablaClientes() {
		jdbcTemplate.execute("CREATE TABLE CLIENTES "
				+ "(ID INT NOT NULL AUTO_INCREMENT,"
				+ "NOMBRE VARCHAR(255),"
				+ "EDAD INT,"
				+ "PRIMARY KEY(ID));");
		
	}

	public Cliente buscar(String nombre) {
		String query = "SELECT * FROM `clientes` WHERE `NOMBRE` =?";
		Cliente c = null;
		
		try {
			c = jdbcTemplate.queryForObject(query, clienteRowMapper,nombre);
		}catch(EmptyResultDataAccessException e) {
			System.out.println("No existe ese cliente");
		}
		
		return c;
	}

}
