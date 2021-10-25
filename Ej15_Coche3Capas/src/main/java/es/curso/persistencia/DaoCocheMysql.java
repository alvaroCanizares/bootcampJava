package es.curso.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.curso.entidad.Coche;
import es.curso.persistencia.interfaces.DaoCoche;

public class DaoCocheMysql implements DaoCoche {
	private Connection conexion;

	public boolean abrirConexion() {
		String url = "jdbc:mysql://localhost:3306/bbdd";
		String usuario = "root";
		String password = "";
		try {
			conexion = DriverManager.getConnection(url,usuario,password);
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean cerrarConexion(){
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean alta(Coche c) {
		if(!abrirConexion()) {
			return false;
		}
		boolean alta = true;

		String query = "INSERT INTO CONCESIONARIO (MATRICULA,MARCA,MODELO,NUMEROKM) VALUES (?,?,?,?)";

		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, c.getMatricula());
			ps.setString(2,c.getMarca());
			ps.setString(3,c.getModelo());
			ps.setInt(4, c.getNumeroKm());

			int afectados = ps.executeUpdate();
			if(afectados == 0) {
				alta = false;
			}

		} catch (SQLException e) {
			System.out.println("alta -> Error al insertar: " + c);
			alta = false;
			e.printStackTrace();
		}finally {
			cerrarConexion();
		}
		return alta;
	}

	@Override
	public boolean baja(String matricula) {
		if(!abrirConexion()) {
			return false;
		}

		boolean baja = true;

		String query ="DELETE FROM CONCESIONARIO WHERE MATRICULA = ?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1,matricula);
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0)
				baja = false;

		} catch (SQLException e) {
			System.out.println("baja -> Error al borrar: " + matricula);
			baja = false;
			e.printStackTrace();
		}finally {
			cerrarConexion();
		}

		return baja;
	}

	@Override
	public boolean modificar(Coche c) {
		if(!abrirConexion()){
			return false;
		}
		boolean modificado = true;
		String query = "UPDATE CONCESIONARIO SET  MARCA=?, MODELO=?, NUMEROKM=? WHERE MATRICULA=?";

		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1,c.getMarca());
			ps.setString(2,c.getModelo());
			ps.setInt(3, c.getNumeroKm());
			ps.setString(4, c.getMatricula());

			int afectados = ps.executeUpdate();
			if(afectados == 0) {
				modificado = false;
			}

		} catch (SQLException e) {
			System.out.println("modificar -> Error al modificar: " + c);
			modificado = false;
			e.printStackTrace();
		}finally {
			cerrarConexion();
		}
		return modificado;
	}

	@Override
	public Coche obtener(String matricula) {
		if(!abrirConexion()){
			return null;
		}
		Coche c = null;
		String query = "SELECT * FROM CONCESIONARIO WHERE MATRICULA =?";

		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, matricula);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				 c = new Coche();
				 c.setMatricula(rs.getString(1));
				 c.setMarca(rs.getString(2));
				 c.setModelo(rs.getString(3));
				 c.setNumeroKm(rs.getInt(4));

			}

		} catch (SQLException e) {
			System.out.println("obtener -> Error al obtener: " + matricula);
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public List<Coche> listar() {
		if(!abrirConexion()){
			return null;
		}
		List <Coche> listaCoches = new ArrayList<>();

		Coche c = null;
		String query = "SELECT * FROM CONCESIONARIO";

		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				 c = new Coche();
				 c.setMatricula(rs.getString(1));
				 c.setMarca(rs.getString(2));
				 c.setModelo(rs.getString(3));
				 c.setNumeroKm(rs.getInt(4));
				listaCoches.add(c);
			}

		} catch (SQLException e) {
			System.out.println("listar -> Error al obtener: lista de personas");
			e.printStackTrace();
		}
		return listaCoches;
	}


}
