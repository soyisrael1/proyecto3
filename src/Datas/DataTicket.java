package Datas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidades.Ticket;

public class DataTicket {

	Connection cx;

	public static void main(String[] ola) {
		DataTicket da = new DataTicket();
		da.conectar();
	}

	public DataTicket() {
	}

	public Connection conectar() {
		try {
			cx = DriverManager.getConnection("jdbc:mysql://localhost:3306/cine", "root", "");
			System.out.println("CONEXION EXITOSA");
		} catch (SQLException e) {
			System.out.println("FALLO CONEXION");
			e.printStackTrace();
		}
		return cx;
	}

	public boolean insertarTicket(Ticket p) {
		PreparedStatement ps;
		try {
			ps = conectar().prepareStatement("INSERT INTO tickets1 VALUES(null,?,?,?,?,?,?)");
			ps.setInt(1, p.getIdSala());
			ps.setInt(2, p.getIdPeli());
			ps.setString(3, p.getFecha());
			ps.setInt(4, p.getCosto());
			ps.setString(5, p.getTipo());
			ps.setInt(6, p.getCantidad());
			
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public ArrayList<Ticket> SelectTicket() {
		ArrayList<Ticket> ListaTickets = new ArrayList<Ticket>();
		try {
			PreparedStatement ps = conectar().prepareStatement("SELECT * FROM tickets1");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Ticket x = new Ticket();
				x.setIdTi(rs.getInt(1));
				x.setIdSala(rs.getInt(2));
				x.setIdPelicula(rs.getInt(3));
				x.setFecha(rs.getString(4));
				x.setCosto(rs.getInt(5));
				x.setTipo(rs.getString(6));
				x.setCantidad(rs.getInt(7));
				
				ListaTickets.add(x);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return ListaTickets;
	}
	public boolean EliminarTicket(int idTi) {
		PreparedStatement ps;
		try {
			ps = conectar().prepareStatement("DELETE FROM tickets1 WHERE IdTi=?");
			ps.setInt(1, idTi);
			System.out.println(ps.toString());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}
	public boolean actualizarTicket(Ticket a) {
		PreparedStatement ps;
		try {
			ps = conectar().prepareStatement("UPDATE tickets1 SET idSala=?,idPeli=?,fecha=?,costo=?,tipo=?,cantidad=? WHERE idTi=?");
			ps.setInt(1, a.getIdSala());
			ps.setInt(2, a.getIdPeli());
			ps.setString(3, a.getFecha());
			ps.setInt(4, a.getCosto());
			ps.setString(5, a.getTipo());
			ps.setInt(6, a.getCantidad());
			ps.setInt(7, a.getIdTi());
			
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

}