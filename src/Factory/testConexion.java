package Factory;

import java.sql.Connection;
import java.sql.SQLException;

public class testConexion {

	public static void main(String[] args) throws SQLException {

		  ConnectionFactory factory = new ConnectionFactory();
	      Connection con = factory.recuperaConexion();

	      System.out.println("Inicio conexion");
	      con.close();
	      System.out.println("Fin conexion");
	}

}
