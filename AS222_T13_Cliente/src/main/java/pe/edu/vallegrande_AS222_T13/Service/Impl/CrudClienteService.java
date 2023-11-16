package pe.edu.vallegrande_AS222_T13.Service.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pe.edu.vallegrande_AS222_T13.Model.ClienteModel;
import pe.edu.vallegrande_AS222_T13.Service.Spec.CrudServiceSpec;
import pe.edu.vallegrande_AS222_T13.db.AccesoDB;

public class CrudClienteService implements CrudServiceSpec<ClienteModel> {
	@Override
	public List<ClienteModel> getAll() {
		List<ClienteModel> lista = new ArrayList<>();
		Connection cn = null;
		ClienteModel rec = null;
		try {
			cn = AccesoDB.getConnection();
			String sql ="select id, name, last_names, type_document, number_document, cellphone, email, birthday from client ";
;
			PreparedStatement pstm = cn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				rec = new ClienteModel();
				rec.setId(rs.getInt("id"));
				rec.setName(rs.getString("name"));
				rec.setLast_names(rs.getString("last_names"));
				rec.setType_document(rs.getString("type_document"));
				rec.setNumber_document(rs.getString("number_document"));
				rec.setCellphone(rs.getString("cellphone"));
				rec.setEmail(rs.getString("email"));
				rec.setBirthday(rs.getString("birthday"));
				lista.add(rec);
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
		return lista;
	}

	
	@Override
	public List<ClienteModel> get(ClienteModel bean) {
		// Preparando los datos
		String name = "%" + bean.getName().trim() + "%";
		String last_names = "%" + bean.getLast_names().trim() + "%";
		String number_document = "%" + bean.getNumber_document().trim() + "%";
		List<ClienteModel> lista =  new ArrayList<>();
		Connection cn = null;
		ClienteModel rec = null;
		// Proceso
		try {
			cn = AccesoDB.getConnection();
			String sql = "select id, name, last_names, type_document, number_document, cellphone, email, birthday from client ";
			sql += "where name like ? and last_names like ? and number_document like ?";
			PreparedStatement pstm = cn.prepareStatement(sql);
			pstm.setString(1, name);
			pstm.setString(2, last_names);
			pstm.setString(3, number_document);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				rec = new ClienteModel();
				rec.setId(rs.getInt("id"));
				rec.setName(rs.getString("name"));
				rec.setLast_names(rs.getString("last_names"));
				rec.setType_document(rs.getString("type_document"));
				rec.setNumber_document(rs.getString("number_document"));
				rec.setCellphone(rs.getString("cellphone"));
				rec.setEmail(rs.getString("email"));
				rec.setBirthday(rs.getString("birthday"));
				lista.add(rec);
			}
			rs.close();
			pstm.close();
		} catch (SQLException e) {
			throw  new RuntimeException(e.getMessage());
		} catch (Exception e) {
			throw  new RuntimeException("Error en el proceso");
		}finally{
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return lista;
	}
	
	

	@Override
	public ClienteModel getById(Integer id) {
		// Preparando los datos
				Connection cn = null;
				ClienteModel bean = null;
				// Proceso
				try {
					cn = AccesoDB.getConnection();
					String sql = "select id, name, last_names, type_document, number_document, cellphone, email, birthday from client  ";
					sql += "where estado='A' and id = ?";
					PreparedStatement pstm = cn.prepareStatement(sql);
					pstm.setInt(1, id);
					ResultSet rs = pstm.executeQuery();
					if (rs.next()) {
						bean = new ClienteModel();
						bean.setId(rs.getInt("id"));
						bean.setName(rs.getString("name"));
						bean.setLast_names(rs.getString("last_names"));
						bean.setType_document(rs.getString("type_document"));
						bean.setNumber_document(rs.getString("number_document"));
						bean.setCellphone(rs.getString("cellphone"));
						bean.setEmail(rs.getString("email"));
						bean.setBirthday(rs.getString("birthday"));
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

	@Override
	public ClienteModel insert(ClienteModel bean) {
		// Variables
				Integer id;
				Connection cn = null;
				PreparedStatement pstm;
				ResultSet rs;
				String sql;
				// Proceso
				try {
					// Inicio de la TX
					cn = AccesoDB.getConnection();
					cn.setAutoCommit(false);
					// Insertar registro
					sql = "INSERT INTO cliente(name, last_names, type_document, number_document, cellphone, email, birthday) VALUES(?,?,?,?)";
					pstm = cn.prepareStatement(sql);
					pstm.setString(1, bean.getName());
					pstm.setString(2, bean.getLast_names());
					pstm.setString(3, bean.getType_document());
					pstm.setString(4, bean.getNumber_document());
					pstm.setString(4, bean.getCellphone());
					pstm.setString(4, bean.getEmail());
					pstm.setString(4, bean.getBirthday());
					pstm.executeUpdate();
					// Onteniendo el id
					sql = "SELECT @@IDENTITY id";
					pstm = cn.prepareStatement(sql);
					rs = pstm.executeQuery();
					rs.next();
					id = rs.getInt("id");
					bean.setId(id);
					// Fun de la TX
					cn.commit();
				} catch (SQLException e) {
					try {
						cn.rollback();
					} catch (Exception e2) {
					}
					throw new RuntimeException(e.getMessage());
				} catch (Exception e) {
					try {
						cn.rollback();
					} catch (Exception e2) {
					}
					throw new RuntimeException("Error en el proceso");
				} finally {
					try {
						cn.close();
					} catch (Exception e) {
					}
				}
				// Reporte
		return null;
	}

	@Override
	public ClienteModel update(ClienteModel bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// Variables
				Connection cn = null;
				PreparedStatement pstm;
				ResultSet rs;
				String sql;
				int filas;
				// Proceso
				try {
					// Inicio de la TX
					cn = AccesoDB.getConnection();
					cn.setAutoCommit(false);
					// Insertar registro
					sql = "UPDATE client SET status='I' WHERE id=?";
					pstm = cn.prepareStatement(sql);
					pstm.setInt(1, id);
					filas = pstm.executeUpdate();
					pstm.close();
					if(filas==0) {
						throw new SQLException("ID no existe");
					}
					// Fun de la TX
					cn.commit();
				} catch (SQLException e) {
					try {
						cn.rollback();
					} catch (Exception e2) {
					}
					throw new RuntimeException(e.getMessage());
				} catch (Exception e) {
					try {
						cn.rollback();
					} catch (Exception e2) {
					}
					throw new RuntimeException("Error en el proceso");
				} finally {
					try {
						cn.close();
					} catch (Exception e) {
					}
				}
			}
		
}

