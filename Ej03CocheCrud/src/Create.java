import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * CREATE TABLE `concesionario` (
  `id` int(11) NOT NULL,
  `marca` varchar(45) DEFAULT NULL,
  `modelo` varchar(45) DEFAULT NULL,
  `numeroKm` int(6) DEFAULT NULL
)
 */
public class Create {

	public static void main(String[] args) {
		String cadenaConexion = "jdbc:mysql://localhost:3306/bbdd";
		String user = "root";
		String pass = "";
		
		try (Connection con = DriverManager.getConnection(cadenaConexion, user, pass)){
			String sql = "INSERT INTO CONCESIONARIO (ID,MARCA,MODELO,NUMEROKM) VALUES(?,?,?,?)";
			
			int id = 1;
			String marca = "ford";
			String modelo = "mustang";
			int numeroKm = 100000;
			
			PreparedStatement sentencia = con.prepareStatement(sql);
			sentencia.setInt(1,id);
			sentencia.setString(2, marca);
			sentencia.setString(3, modelo);
			sentencia.setInt(4, numeroKm);
			
			int afectados = sentencia.executeUpdate();
			System.out.println("Afectados: " + afectados);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
