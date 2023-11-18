package Entidades;

import Datas.DataTicket;

public class Ticket {

	int IdTi;
	int idSala;
	int idPeli;
	String fecha;
	int costo;
	String tipo;
	int cantidad;
	
	DataTicket dh=new DataTicket();
	public Ticket() {}

	public boolean insertarTicket() {
		if(dh.insertarTicket(this)) {
			return true;
		}else {
			return false;
		}
	}
	public boolean EliminarTicket() {
		if(dh.EliminarTicket(this.getIdTi())) {
			return true;
		}else {
			return false;
		}
	}
	public boolean actualizarTicket() {
		if(dh.actualizarTicket(this)) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
	



	public int getIdTi() {
		return IdTi;
	}



	public void setIdTi(int idTi) {
		IdTi = idTi;
	}



	public int getIdSala() {
		return idSala;
	}



	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}



	public int getIdPeli() {
		return idPeli;
	}



	public void setIdPelicula(int idPeli) {
		this.idPeli = idPeli;
	}



	public String getFecha() {
		return fecha;
	}



	public void setFecha(String fecha) {
		this.fecha = fecha;
	}



	public int getCosto() {
		return costo;
	}



	public void setCosto(int costo) {
		this.costo = costo;
	}



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	

}
