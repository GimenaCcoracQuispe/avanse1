package pe.edu.vallegrande_AS222_T13.Service.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pe.edu.vallegrande_AS222_T13.Model.SellerModel;
import pe.edu.vallegrande_AS222_T13.Service.Spec.SeguridadServiceSpec;
import pe.edu.vallegrande_AS222_T13.db.AccesoDB;

public class SeguridadService implements SeguridadServiceSpec {

	@Override
	public SellerModel validar(String usuario, String password) {
		// Preparando los datos
				Connection cn = null;
				SellerModel bean = null;
				// Proceso
				try {
					cn = AccesoDB.getConnection();
					String sql = "select id, last_name, name, address, ";
					sql += "email, usuario, '*****' password ";
					sql += "from seller where usuario=? and password=? ";
					PreparedStatement pstm = cn.prepareStatement(sql);
					pstm.setString(1,usuario);
					pstm.setString(2,password);
					
					ResultSet rs = pstm.executeQuery();
					if (rs.next()) {
						bean = new SellerModel();
						bean.setId(rs.getInt("id"));
						bean.setLast_name(rs.getString("last_name"));
						bean.setName(rs.getString("name"));
						bean.setAddress(rs.getString("address"));
						bean.setEmail(rs.getString("email"));
						bean.setUsuario(rs.getString("usuario"));
						bean.setPassword(rs.getString("password"));
					}
					rs.close();
					pstm.close();
				} catch (SQLException e) {
					throw new RuntimeException(e.getMessage());
				} catch (Exception e) {
					throw new RuntimeException("Error en el proceso");
				} finally {
					try {
						cn.close();
					} catch (Exception e) {
					}
				}
				return bean;
	}

}
