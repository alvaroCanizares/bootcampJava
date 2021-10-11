import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {

	public static void main(String[] args) {
		String cadenaConexion = "jdbc:mysql://localhost:3306/bbdd";
		String user = "root";
		String pass = "";
			
		try (Connection con = DriverManager.getConnection(cadenaConexion, user, pass);){
			String sql = "DELETE FROM CONCESIONARIO WHERE ID=?";
			
			int id = 1;
			
			PreparedStatement sentencia = con.prepareStatement(sql);
			sentencia.setInt(1,id);
			
			int afectados = sentencia.executeUpdate();
			System.out.println("Afectados: " + afectados);
		} catch (SQLException e) {
			System.out.println("Error al añadir nuevo cliente");
			System.out.println(e.getMessage());
		}	
}

}
