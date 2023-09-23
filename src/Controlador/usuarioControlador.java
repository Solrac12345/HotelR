package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.Usuarios;
import views.Login;
import views.MenuUsuario;

public class usuarioControlador  implements ActionListener{
	private Login vista;
	
	public usuarioControlador(Login vista) {
		this.vista = vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String usuario = vista.getUsuario();
		String contrasena = vista.getContrasena();
	if (Usuarios.validarUsuario(usuario, contrasena)) {
			MenuUsuario menu= new MenuUsuario();
			menu.setVisible(true);
			vista.dispose();
		}else {
			JOptionPane.showMessageDialog(vista, "Usuario y contrasena no validos");
		}
	
	}
	
}
