import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Read {

	public static void main(String[] args) {
		String cadenaConexion = "jdbc:mysql://localhost:3306/bbdd";
		String user = "root";
		String pass = "";
		
		try (Connection con = DriverManager.getConnection(cadenaConexion, user, pass)){
			String sql = "SELECT * FROM CONCESIONARIO";
			PreparedStatement sentencia = con.prepareStatement(sql);
			
			ResultSet rs = sentencia.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getInt("ID"));
				System.out.print(" - "); 
				System.out.print(rs.getString("MARCA"));
				System.out.print(" - "); 
				System.out.print(rs.getString("MODELO"));
				System.out.print(" - "); 
				System.out.print(rs.getInt("NUMEROKM"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}

}
