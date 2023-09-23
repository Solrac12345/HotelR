package Controlador;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

import DAO.ReservaDAO;
import Factory.ConnectionFactory;
import modelo.Reserva;

public class ReservaControlador {
	private ReservaDAO reservaD;

	public ReservaControlador() {
		Connection con = new ConnectionFactory().recuperaConexion();
		this.reservaD = new ReservaDAO(con);
	}
	
	public void guardar(Reserva reserva) {
		this.reservaD.guardar(reserva);;
	}
	
	public List<Reserva> mostrar(){
		return this.reservaD.mostrar();
	}
	
	public List<Reserva> buscar(String id){
		return this.reservaD.buscarId(id);
	}
	
	public void actualizarReserva(LocalDate dateE,LocalDate dateS,String valor,String formaPago,Integer id) {
		this.reservaD.Actualizar(dateE, dateS, valor, formaPago,id);
	}
	
	public void eliminar(Integer id){
		this.reservaD.Eliminar(id);
	}
	
}
