package Controlador;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

import DAO.HuespedesDAO;
import Factory.ConnectionFactory;
import modelo.Huespedes;

public class HuespedesControlador {

	private HuespedesDAO huespedesD;
	
	public HuespedesControlador() {
		Connection con = new ConnectionFactory().recuperaConexion();
		this.huespedesD = new HuespedesDAO(con);
	}
	
	public void guardar(Huespedes huespedes) {
		this.huespedesD.guardar(huespedes);;
	}
	
	public List<Huespedes> mostrar(){
		return this.huespedesD.mostrar();
	}
	
	public List<Huespedes> buscar(String id){
		return this.huespedesD.buscarId(id);
	}
	
	public void actualizar(String nombre, String apellido, LocalDate fechaNacimiento, String nacionalidad, String telefono,
			Integer idReserva, Integer id){
		this.huespedesD.Actualizar(nombre, apellido, fechaNacimiento, nacionalidad, telefono, idReserva, id);
	}
	
	public void eliminar(Integer id){
		this.huespedesD.Eliminar(id);
	}
}
