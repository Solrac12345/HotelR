package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Factory.ConnectionFactory;

public class Usuarios {
	private String usuario;
	private String contrasena;
	
	public Usuarios(String usuario, String contrasena) {
		this.usuario = usuario;
		this.contrasena = contrasena;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public static boolean validarUsuario(String usuario, String contrasena) {
		ConnectionFactory con =  new ConnectionFactory();
		Connection connec = null;
		PreparedStatement state = null;
		ResultSet result = null;
		try {
			connec = con.recuperaConexion();
			state = connec.prepareStatement("SELECT * FROM usuarios WHERE usuario=? AND contrasena=?");
			state.setString(1, usuario);
			state.setString(2, contrasena);
			result = state.executeQuery();
			return result.next();
		
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if(result != null) {
					result.close();
				}
				if(state != null) {
					state.close();
				}
				if(connec != null) {
					connec.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
