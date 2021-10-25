package es.curso.modelo.persistencia;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import es.curso.modelo.entidades.Pedido;

@Repository
public class DaoPedidoJdbcTemplate implements DaoPedido {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private DaoPedidoRowMapper daoPedidoRowMapper;
	
	public int insertar(Pedido p) {
		String query ="insert into pedidos(ID,IMPORTE,FECHA) values(?,?,?)";
		int id = jdbcTemplate.update(query, p.getId(),p.getImporte(),p.getFecha());
		
		return id;
	}

	public ArrayList<Pedido> listar(int id) {
		String query = "select * from pedidos where id=" + id;
		
		return (ArrayList<Pedido>) jdbcTemplate.query(query, daoPedidoRowMapper);		
	}
	public void crearTablaPedidos() {
		jdbcTemplate.execute("CREATE TABLE PEDIDOS "
				+ "(ID INT NOT NULL,"
				+ "IMPORTE DOUBLE(6,2),"
				+ "FECHA VARCHAR(255);");
	}

}
