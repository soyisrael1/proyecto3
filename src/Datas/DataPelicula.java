package Datas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidades.Pelicula;

public class DataPelicula {


		Connection cx;

		public static void main(String[] ola) {
			DataPelicula da = new DataPelicula();
			da.conectar();
		}

		public DataPelicula() {
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

		public boolean insertarPelicula(Pelicula a) {
			PreparedStatement ps;
			try {
				ps = conectar().prepareStatement("INSERT INTO pelicula VALUES(null,?,?,?)");
				ps.setString(1, a.getNombre());
				ps.setString(2, a.getCategoria());
				ps.setString(3, a.getRangoEdad());
			
				ps.execute();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}

		}
		public ArrayList<Pelicula> SelectPelicula() {
			ArrayList<Pelicula> ListaUsuario = new ArrayList<Pelicula>();
			try {
				PreparedStatement ps = conectar().prepareStatement("SELECT * FROM pelicula");
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Pelicula x = new Pelicula();
					x.setIdPeli(rs.getInt(1));
					x.setNombre(rs.getString(2));
					x.setCategoria(rs.getString(3));
					x.setRangoEdad(rs.getString(4));
					
					ListaUsuario.add(x);
				}
			} catch (SQLException e) {
				e.printStackTrace();

			}
			return ListaUsuario;
		}
		public boolean EliminarPelicula(int IDPeli) {
			PreparedStatement ps;
			try {
				ps = conectar().prepareStatement("DELETE FROM pelicula WHERE idPeli=?");
				ps.setInt(1, IDPeli);
				System.out.println(ps.toString());
				ps.execute();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}

		}

		public boolean actualizarPelicula(Pelicula a) {
			PreparedStatement ps;
			try {
				ps = conectar().prepareStatement(
						"UPDATE pelicula SET Nombre=?,Categoria=?,RangoEdad=? WHERE idPeli=?");
				ps.setString(1, a.getNombre());
				ps.setString(2, a.getCategoria());
				ps.setString(3, a.getRangoEdad());
				
				ps.setInt(4, a.getIdPeli());
				ps.execute();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}

		



	}

		
	}