package pe.edu.vallegrande_AS222_T13.Prueba;

import java.sql.Connection;
import java.sql.SQLException;

import pe.edu.vallegrande_AS222_T13.db.AccesoDB;

public class Prueba01 {
 
	public static void main(String[] args) {
		try {
			Connection cn = AccesoDB.getConnection();
			System.out.println("Conexión ok.");
			cn.close();
		} catch (SQLException e) {
			System.err.println("Error");
			// TODO: handle exception
		}
	}
}
