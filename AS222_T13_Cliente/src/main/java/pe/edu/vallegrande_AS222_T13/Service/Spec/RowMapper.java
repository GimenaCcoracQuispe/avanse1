package pe.edu.vallegrande_AS222_T13.Service.Spec;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T> {
	T mapRow(ResultSet rs) throws SQLException;
}
