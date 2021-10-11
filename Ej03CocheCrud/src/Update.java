import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
	public static void main(String[] args) {
			String cadenaConexion = "jdbc:mysql://localhost:3306/bbdd";
			String user = "root";
			String pass = "";
				
			try (Connection con = DriverManager.getConnection(cadenaConexion, user, pass);){
				String sql = "UPDATE CONCESIONARIO SET ID=?, MARCA=?, MODELO=?, NUMEROKM=?";
				
				int id = 1;
				String marca = "Shelby";
				String modelo = "GT500";
				int numeroKm = 90000;
				
				PreparedStatement sentencia = con.prepareStatement(sql);
				sentencia.setInt(1,id);
				sentencia.setString(2, marca);
				sentencia.setString(3, modelo);
				sentencia.setInt(4, numeroKm);
				
				int afectados = sentencia.executeUpdate();
				System.out.println("Afectados: " + afectados);
			} catch (SQLException e) {
				System.out.println("Error al añadir nuevo cliente");
				System.out.println(e.getMessage());
			}	
	}
}

