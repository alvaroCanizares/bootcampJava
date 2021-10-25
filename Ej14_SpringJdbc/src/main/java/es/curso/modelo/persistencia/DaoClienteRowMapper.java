package es.curso.modelo.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import es.curso.modelo.entidades.Cliente;

@Component
public class DaoClienteRowMapper implements RowMapper<Cliente>{
	
	public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cliente c = new Cliente();
		DaoPedidoJdbcTemplate daoPedido = new DaoPedidoJdbcTemplate();
		c.setId(rs.getInt("ID"));
		c.setEdad(rs.getInt("EDAD"));
		c.setNombre(rs.getString("NOMBRE"));
		c.setListaPedidos(daoPedido.listar(c.getId()));
		return c;
	}

}
